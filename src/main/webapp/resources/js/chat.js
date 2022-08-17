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


function addText() {
    var today = new Date();
    var date = today.getDate() + '-' + (today.getMonth() + 1) + '-' + today.getFullYear() + "     " + today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    var text = document.getElementById("txtChat").value;
    database.ref("messages").update({
        "text": text,
        "date": date
    });
}

database.ref("messages").on("value", function (snapshot) {
    var chat = snapshot.val().text;
    var date = snapshot.val().date;
    var item = document.createElement("li");
    item.textContent = chat + "                    " +"("+ date +")";
    document.getElementById("tinnhan").appendChild(item);
});


