/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */




const firebaseConfig = {
    apiKey: "AIzaSyB-O7P4TxczOhUWYnhVk6OVGJtqTlYmIsE",
    authDomain: "shipnowonline.firebaseapp.com",
    databaseURL: "https://shipnowonline-default-rtdb.firebaseio.com",
    projectId: "shipnowonline",
    storageBucket: "shipnowonline.appspot.com",
    messagingSenderId: "23721566479",
    appId: "1:23721566479:web:03fa2591cf52164a905e7a"
};
firebase.initializeApp(firebaseConfig);
var database = firebase.database();


function addText(name, hinh) {
    var username = name;
    var avatar = hinh;
    var today = new Date();
    var date =  today.getDate()+ '-' +(today.getMonth() + 1)  + '-' + today.getFullYear() + "     " + today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    var text = document.getElementById("txtChat").value;
    database.ref("messages").update({
        "text": text,
        "date": date,
        "name": username,
        "image": avatar
    });
}

database.ref("messages").on("value", function (snapshot) {
    var chat = snapshot.val().text;
    var date = snapshot.val().date;
    var avatar = snapshot.val().image;
    var name = snapshot.val().name;
    var item = document.createElement("li");
    var hinh = document.createElement("img");
    var ten = document.createElement("span");
    var time = document.createElement("i");
    ten.innerHTML = name+"     ";
    hinh.src = avatar;
    hinh.width = 20;
    hinh.height = 20;
    hinh.className = "rounded-circle";
    time.innerHTML =  date;
    item.textContent = chat;
    document.getElementById("tinnhan").appendChild(hinh);
    document.getElementById("tinnhan").appendChild(ten);
    document.getElementById("tinnhan").appendChild(time);
    document.getElementById("tinnhan").appendChild(item);
});


