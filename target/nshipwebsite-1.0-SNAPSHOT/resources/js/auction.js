function deleteAuction(auctionId) {
    fetch("/nshipwebsite/api/myauction/" + auctionId, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Something wrong!!!");
        if (res.status == 204) {
            alert("Xoá đấu giá thành công");
            setTimeout(function () {
                location.reload();
            }, 300);
        }
    }).catch(function (err) {
        console.error(err);
    });
}

function addAuction(productId) {
    fetch("/nshipwebsite/api/add-auction", {
        method: 'post',
        body: JSON.stringify({
            "price": document.getElementById("price" + productId).value,
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
        document.getElementById("price" + productId).value = "";
        window.alert("Đấu giá thành công");
    })

}