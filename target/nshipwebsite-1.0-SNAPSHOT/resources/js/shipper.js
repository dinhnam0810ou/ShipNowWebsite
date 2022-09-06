function deleteShipper(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let load = document.getElementById(`load${id}`);
    load.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Something wrong!!!");
        load.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        load.style.display = "none";
    });
}
function getShippers(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myShipper");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].phone}</td>
                    <td>${data[i].identification}</td>
                    <td>${data[i].firstname}</td>
                    <td>${data[i].lastname}</td>
                    <td><img src="${data[i].avatar}"  class="card-img-top  rounded-circle" width="80" height="80"/></td>         
                    <td>${data[i].email}</td>                   
                    <td>${data[i].active}</td>  
                    <td>
                        <div class="spinner-border text-info" style="display:none" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteShipper('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Delete</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger" type="button"><a href="/nshipwebsite/admin/shippers/${data[i].id}" style="text-decoration: none;color: white;">Edit</a></button> 
                    </td>
                </tr>
            `
            d.innerHTML = h;
        }

        let d2 = document.getElementById("mySpinner");
        d2.style.display = "none";
    }).catch(function (err) {
        console.error(err);
    });
}
