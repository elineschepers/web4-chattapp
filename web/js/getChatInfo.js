

var xHRObject = new XMLHttpRequest();
var xhrStatus=new XMLHttpRequest();
var xhrOnlineFriends=new XMLHttpRequest();

window.onload =function() {

    getFriends();
    getStatus();
    getFriendsOnline();

}
document.getElementById("friendshideshow").addEventListener("click",hideShowfriends,false);
function hideShowfriends()
{
    $(document).ready(function()
    {
        $("#friendstable").slideToggle();
    })
}
function getFriendsOnline()
{
    xhrOnlineFriends.open("GET","Controller?action=GetAmountOfFriendsOnline",true)
    xhrOnlineFriends.onreadystatechange=getOnlineFriendsData;
    xhrOnlineFriends.send(null)
}
function getFriends() {

    xHRObject.open("GET","Controller?action=GetFriends",true)
    xHRObject.onreadystatechange=getData;
    xHRObject.send(null);

}
function getStatus() {
    xhrStatus.open("GET","Controller?action=GetStatus",true)
    xhrStatus.onreadystatechange=getDataStatus;
    xhrStatus.send(null);

}
function getOnlineFriendsData()
{
    if(xhrOnlineFriends.status==200)
    {
        if(xhrOnlineFriends.readyState==4)
        {
            let serverResponse = xhrOnlineFriends.responseText;
            let span = document.getElementById("amountOfFriends");
            span.innerHTML="";
            span.appendChild(document.createTextNode(serverResponse));
            //console.log(serverResponse);
            setTimeout("getFriendsOnline()",10000)
        }
    }
}
function getDataStatus()
{
    if(xhrStatus.status==200)
    {
        if(xhrStatus.readyState==4)
        {
            //let serverResponse = JSON.parse(xhrStatus.responseText); //want geen json voor status
            let serverResponse = xhrStatus.responseText;
            //console.log(serverResponse);
            //let status = serverResponse.status; // status property uit JSON

            let h3 = document.getElementById("status")
            h3.innerHTML="";
            h3.appendChild(document.createTextNode("Status: "+serverResponse));
            setTimeout("getStatus()", 10000);
        }


    }

}

function getData() {

    if(xHRObject.status==200)
    {
        if(xHRObject.readyState==4)
        {
            var serverResponse = JSON.parse(xHRObject.responseText); //hier zitten de vrienden
            //var user = serverResponse.user;

            var friendsDiv=document.getElementById("friendsList")
            var tbody = friendsDiv.lastElementChild;
            tbody.innerHTML="";
            for (var i = 0; i < serverResponse.length; i++) {
                    var tr = document.createElement('tr');
                    for (var j = 0; j < 3; j++) {

                        if (i === 10 && j === 1) {
                            break
                        } else if (j === 1) {
                            let td = document.createElement('td');

                            td.appendChild(document.createTextNode(serverResponse[i].status));

                            tr.appendChild(td);
                        } else if (j === 0) {
                            let td = document.createElement('td');
                            td.appendChild(document.createTextNode(serverResponse[i].userId));
                            tr.appendChild(td);
                            //friendlist.push(serverResponse[i].userId);
                        }
                        else if (j === 2) {
                            let td = document.createElement('td');
                            //let str = '<button id="' + serverResponse[i].userId + '" onclick="startconvo(\'' + serverResponse[i].userId + '\');">chat</button>'
                            var button = document.createElement("button");
                            button.id=serverResponse[i].userId;
                            button.innerText="chat";
                            button.addEventListener("click", function() {


                                startconvo(this.id);

                            });
                            td.appendChild(button);
                            //td.innerHTML = str;
                            tr.appendChild(td);

                        }

                    tbody.appendChild(tr);
                }

            }
            setTimeout("getFriends()", 2000);
        }

    }





}