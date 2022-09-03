<%-- 
    Document   : provision
    Created on : Aug 30, 2022, 8:43:00 PM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Provision</h1>
<div>
    <P> <b>Điều khoản rành buộc người dùng:</b> người dùng không được phép:
        (a)    	tải lên, đăng, truyền tải hoặc bằng cách khác công khai bất cứ Nội Dung nào trái pháp luật, có hại, đe dọa, lạm dụng, quấy rối, gây hoang mang, lo lắng, xuyên tạc, phỉ báng, xúc phạm, khiêu dâm, bôi nhọ, xâm phạm quyền riêng tư của người khác, gây căm phẫn, hoặc phân biệt chủng tộc, dân tộc hoặc bất kỳ nội dung không đúng đắn nào khác;
        (b)    	vi phạm pháp luật, quyền lợi của bên thứ ba hoặc Chính Sách Cấm/Hạn Chế Sản Phẩm của ShipNow;
        (c)    	đăng tải, truyền tin, hoặc bằng bất kỳ hình thức nào khác hiển thị bất kỳ Nội dung nào có sự xuất hiện của người chưa thành niên hoặc sử dụng Dịch vụ gây tổn hại cho người chưa thành niên dưới bất kỳ hình thức nào;
        (d)    	sử dụng Dịch Vụ hoặc đăng tải Nội Dung để mạo danh bất kỳ cá nhân hoặc tổ chức nào, hoặc bằng cách nào khác xuyên tạc cá nhân hoặc tổ chức;
        (e)    	giả mạo các tiêu đề hoặc bằng cách khác ngụy tạo các định dạng nhằm che giấu nguồn gốc của bất kỳ Nội Dung nào được truyền tải thông qua Dịch Vụ;
        (f)    	gỡ bỏ bất kỳ thông báo độc quyền nào từ Trang ShipNow;
        (g)    	gây ra, chấp nhận hoặc ủy quyền cho việc sửa đổi, cấu thành các sản phẩm phái sinh, hoặc chuyển thể của Dịch Vụ mà không được sự cho phép rõ ràng của ShipNow;
        (h)    	sử dụng Dịch Vụ phục vụ lợi ích của bất kỳ bên thứ ba nào hoặc bất kỳ hành vi nào không được chấp nhận theo Điều Khoản Dịch Vụ này;
    </P> 
    <P> <b>Điều khoản rành buộc shipper:</b>	tải lên, gửi thư điện tử, đăng, chuyển tải hoặc bằng cách khác công khai bất kỳ Nội Dung nào mà bạn không được cho phép theo bất kỳ luật hoặc quan hệ hợp đồng hoặc tín thác nào (chẳng hạn thông tin nội bộ, thông tin độc quyền và thông tin mật được biết hoặc tiết lộ như một phần của quan hệ lao động hoặc theo các thỏa thuận bảo mật);
        (q)    	tải lên, gửi thư điện tử, đăng, chuyển tải hoặc bằng cách khác công khai bất kỳ Nội Dung nào dẫn đến trường hợp vi phạm các quyền về sáng chế, thương hiệu, bí quyết kinh doanh, bản quyền hoặc bất cứ đặc quyền nào của bất cứ bên nào;
        (r)    	tải lên, gửi thư điện tử, đăng, chuyển tải hoặc bằng cách khác công khai bất kỳ quảng cáo, các tài liệu khuyến mại, “thư quấy rối”, “thư rác”, “chuỗi ký tự” không được phép hoặc không hợp pháp, hoặc bất kỳ hình thức lôi kéo không được phép nào khác;
        (s)    	tải lên, gửi thư điện tử, đăng, chuyển tải hoặc bằng cách khác công khai bất cứ tài liệu chứa các loại vi-rút, worm, trojan hoặc bất kỳ các mã, tập tin hoặc chương trình máy tính được thiết kế để trực tiếp hoặc gián tiếp gây cản trở, điều khiển, gián đoạn, phá hỏng hoặc hạn chế các chức năng hoặc tổng thể của bất kỳ phần mềm hoặc phần cứng hoặc dữ liệu hoặc thiết bị viễn thông của máy tính;
        (t)     	làm gián đoạn các dòng tương tác thông thường, đẩy nhanh tốc độ “lướt (scroll)” màn hình hơn những người dùng khác có thể đối với Dịch Vụ, hoặc bằng cách khác thực hiện thao tác gây ảnh hưởng tiêu cực đến khả năng tham gia giao dịch thực của những người dùng khác,    
    </P> 
    <input type="checkbox" id="vehicle1" name="vehicle1"><span>Tôi đồng ý với tất cả điều khoản trên</span>
    <br>
    <span><a href="<c:url value="/registershipper"/>">Đăng ký shipper</a></span>
    <span><a href="<c:url value="/registercustomer"/>">Đăng ký Customer</a></span>
</div>

