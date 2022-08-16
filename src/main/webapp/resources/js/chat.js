

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
const messages = document.getElementById("tinnhan");

function addText() {
    database.ref("/messages").update({
        "text": text.value
    });
   
}

database.ref("/messages/text").on("value", function (snapshot) {
      var chatItem = document.createElement("li");
      messages.appendChild(chatItem);
     text.value = "";
    var chat = snapshot.val();
    
     chatItem.innerHTML = chat;
   
 
});