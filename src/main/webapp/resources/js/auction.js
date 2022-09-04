

function addAuction(productId) {
    fetch("/nshipwebsite/api/add-auction", {
        method: 'post',
        body: JSON.stringify({
            "price": document.getElementById("price"+productId).value,
            "productId": productId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res)
        return res.json();
    }).then(function (data) {
        console.info(data);
       document.getElementById("price"+productId).value="";
       window.alert("Đấu giá thành công");
    })
    
}