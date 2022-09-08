/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndn.controllers;

import static com.ndn.googleservice.GetToken.getToken;
import static com.ndn.googleservice.GetToken.getUserInfo;
import com.ndn.googleservice.UserGoogleDto;
import com.ndn.pojos.Customer;
import com.ndn.pojos.Shipper;
import com.ndn.pojos.User;
import com.ndn.service.CustomerService;
import com.ndn.service.EmailService;
import com.ndn.service.ShipperService;
import com.ndn.service.UserService;
import java.io.IOException;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nguyen Dinh Nam
 */
@Controller
@ControllerAdvice
public class UserController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private UserService userDetailsService;

    @ModelAttribute
    public void commonAttr(Model model, String mess) {
        model.addAttribute("mess", mess);
    }

    @GetMapping("/updateprofilecustomer")
    public String updateprofilecustomer() {
        return "updateprofilecustomer";
    }

    @PostMapping("/updateprofilecustomer")
    public String updateprofilecustomer(Model model,
            @ModelAttribute(value = "currentcustomer") @Valid Customer customer,
            BindingResult result) {
        if (!result.hasErrors()) {
            if (customer != null) {
                if (this.customerService.updateCustomer(customer)) {
                    model.addAttribute("update", "Update Success");
                } else {
                    model.addAttribute("update", "Update Fail");
                }
            }
        }
        return "updateprofilecustomer";
    }

    @GetMapping("/updateprofile")
    public String updateprofile() {
        return "updateprofile";
    }

    @PostMapping("/updateprofile")
    public String updateprofile(Model model,
            @ModelAttribute(value = "currentshipper") @Valid Shipper shipper,
            BindingResult result) {
        if (!result.hasErrors()) {
            if (shipper != null) {
                if (this.shipperService.updateShipper(shipper)) {
                    model.addAttribute("update", "Update Success");
                } else {
                    model.addAttribute("update", "Update Fail");
                }
            }
        }
        return "updateprofile";
    }

    @GetMapping("/forgotpassword")
    public String forgotpassword() {
        return "forgotpassword";
    }
    int code;
    int useridtemp;

    @PostMapping("/forgotpassword")
    public String forgot(Model model, @RequestParam(value = "username", required = false) String username) {

        String errMsg = null;
        try {
            User user = this.userDetailsService.getUserByUsername(username);
            useridtemp = user.getId();
            errMsg = "1";
            commonAttr(model, errMsg);
            Random rand = new Random();
            code = rand.nextInt(100000);
            try {
                Shipper s = this.shipperService.getShipperByUserName(username);
                this.emailService.sendSimpleMessage(s.getEmail(), "Khôi phục mật khẩu", "Mã khôi phục là: " + code);
                return "redirect:/completepassword";
            } catch (Exception e) {
                Customer c = this.customerService.getCustomerByUserName(username);
                this.emailService.sendSimpleMessage(c.getEmail(), "Khôi phục mật khẩu", "Mã khôi phục là: " + code);
                return "redirect:/completepassword";
            }
        } catch (Exception e) {
            errMsg = "Username không tồn tại";
            model.addAttribute("errMsg", errMsg);
        }

        return "forgotpassword";
    }

    @GetMapping("/completepassword")
    public String completepassword() {
        return "completepassword";
    }

    @PostMapping("/completepassword")
    public String complete(Model model,
            @RequestParam(value = "newpassword", required = false) String newpassword,
            @RequestParam(value = "confirmpassword", required = false) String confirmpassword,
            @RequestParam(value = "code", required = false) int codetemp) {
        String errMsg = null;
        if (newpassword.equals(confirmpassword) == true && codetemp == code) {
            this.userService.updatePassword(this.passwordEncoder.encode(newpassword), useridtemp);
            String success = "1";
            commonAttr(model, success);
            return "redirect:/login";
        } else {
            errMsg = "Mật khẩu không trùng khớp hoặc mã xác nhận không đúng";
            model.addAttribute("errMsg", errMsg);
        }
        return "completepassword";
    }
    Shipper ggshiper;
    Customer ggcustomer;
    UserGoogleDto usergg;
    HttpServletRequest req;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");

        if (code != null) {
            String accessToken = String.valueOf(getToken(code));
            usergg = getUserInfo(accessToken);
            req = request;
            String id = usergg.getId().substring(0, 6);
            try {
                if (this.userService.getUserByUsername(usergg.getName() + id) != null) {
                    UserDetails userDetail = this.userDetailsService.loadUserByUsername(usergg.getName() + id);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                            userDetail.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    return "redirect:/";
                }
            } catch (Exception e) {
                ggshiper = new Shipper();
                ggshiper.setLastname(usergg.getName());
                ggshiper.setEmail(usergg.getEmail());
                ggshiper.setAvatar(usergg.getPicture());

                ggcustomer = new Customer();
                ggcustomer.setLastname(usergg.getName());
                ggcustomer.setEmail(usergg.getEmail());
                ggcustomer.setAvatar(usergg.getPicture());
                return "redirect:/ggprovision";
            }
        }
        return "login";
    }

    @ModelAttribute
    public void commonUserGG(Model model) {
        if (ggshiper != null) {
            model.addAttribute("ggshiper", ggshiper);
        }
        if (ggcustomer != null) {
            model.addAttribute("ggcustomer", ggcustomer);
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    String regisuser;

    @PostMapping("/register")
    public String addUser(Model model, @ModelAttribute(value = "user") @Valid User user, BindingResult result) {
        regisuser = user.getUsername();
        if (!result.hasErrors()) {
            if (user.getPassword().equals(user.getConfirmPassword())) {
                try {
                    if (this.userDetailsService.addUser(user)) {
                        return "redirect:/provision";
                    }
                } catch (Exception e) {
                    model.addAttribute("erruser", "1");
                }

            } else {
                String errMsg = "Mật khẩu không khớp";
                model.addAttribute("errMsg", errMsg);
            }
        }

        return "register";
    }

    @GetMapping("/registershipper")
    public String registerShipper(Model model) {
        model.addAttribute("shipper", new Shipper());
        return "registerShipper";
    }

    @PostMapping("/registershipper")
    public String addShipper(Model model, @ModelAttribute(value = "shipper") @Valid Shipper shipper, BindingResult result) {
        try {
            if (!result.hasErrors()) {
                User u = this.userService.getUserByUsername(regisuser);
                this.userService.updateRole("ROLE_SHIPPER", u.getId());
                shipper.setUser(u);
                if (this.shipperService.addShipper(shipper)) {
                    regisuser = null;
                    commonAttr(model, "201");
                    return "redirect:/";
                }
            }
        } catch (Exception e) {
            model.addAttribute("notusermsg", "Hãy đăng ký tài khoản trước khi đăng kí thông tin");
        }

        return "registerShipper";
    }

    @GetMapping("/registercustomer")
    public String registerCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "registerCustomer";
    }

    @PostMapping("/registercustomer")
    public String addCustomer(Model model, @ModelAttribute(value = "customer") @Valid Customer customer, BindingResult result) {
        try {
            if (!result.hasErrors()) {
                User u = this.userService.getUserByUsername(regisuser);
                customer.setUserId(u);
                if (this.customerService.addCustomer(customer)) {
                    regisuser = null;
                    commonAttr(model, "201");
                    return "redirect:/";
                }
            }
        } catch (Exception e) {
            model.addAttribute("notusermsg", "Hãy đăng ký tài khoản trước khi đăng kí thông tin");
        }

        return "registerCustomer";
    }

    @GetMapping("/registerggcustomer")
    public String registerggcustomer() {
        return "registerggcustomer";
    }

    @PostMapping("/registerggcustomer")
    public String addggcustomer(Model model, @ModelAttribute(value = "ggcustomer") Customer customer) {
        try {
            String id = usergg.getId().substring(0, 6);
            User newuser = new User();
            newuser.setUsername(usergg.getName() + id);
            newuser.setPassword("123456");
            this.userService.addUser(newuser);
            User temp = this.userService.getUserByUsername(usergg.getName() + id);

            UserDetails userDetail = this.userDetailsService.loadUserByUsername(usergg.getName() + id);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                    userDetail.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            customer.setUserId(temp);
            if (customer != null) {
                if (this.customerService.addGgCustomer(customer)) {
                    return "redirect:/";
                }
            }
        } catch (Exception e) {

        }
        return "registerggcustomer";
    }

    @GetMapping("/registerggshipper")
    public String registerggshipper() {
        return "registerggshipper";
    }

    @PostMapping("/registerggshipper")
    public String addggshipper(Model model, @ModelAttribute(value = "ggshiper") Shipper shipper) {
        try {
            String id = usergg.getId().substring(0, 6);
            User newuser = new User();
            newuser.setUsername(usergg.getName() + id);
            newuser.setPassword("123456");
            this.userService.addUserRoleShipper(newuser);
            User temp = this.userService.getUserByUsername(usergg.getName() + id);

            UserDetails userDetail = this.userDetailsService.loadUserByUsername(usergg.getName() + id);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
                    userDetail.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            shipper.setUser(temp);
            if (shipper != null) {
                if (this.shipperService.addGgShipper(shipper)) {
                    return "redirect:/";
                }
            }
        } catch (Exception e) {
        }
        return "registerggshipper";
    }

    @GetMapping("/provision")
    public String provision() {

        return "provision";
    }

    @GetMapping("/ggprovision")
    public String ggprovision() throws IOException {

        return "ggprovision";
    }
}
