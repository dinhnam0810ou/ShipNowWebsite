function addComment(shipperId) {
    fetch("/nshipwebsite/api/add-comment", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "shipperId": shipperId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res)
        return res.json();
    }).then(function (data) {
        console.info(data);
        setTimeout(function(){
            location.reload();
        },800);
        
    })
    
}

