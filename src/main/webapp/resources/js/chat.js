

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

var text = document.getElementById("txtChat");
var btn = document.getElementById("btnSubmit");

function addText() {
    database.ref("/messages").update({
        "text": text.value
    });
}
const messages = document.querySelectorAll("tinnhan");
database.ref("/messages/text").on("value", function (snapshot) {
    var chat = snapshot.val();
    const chatItem = document.createElement("li");
    chatItem.innerHTML = chat;
    messages.appendChild(chatItem);
    text.value = "";
});