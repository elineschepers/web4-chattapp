var webSocket;
window.addEventListener("load",openSocket(),false)
function openSocket()
{
    webSocket = new WebSocket("ws://localhost:8080/comment")
    webSocket.onopen=function(event) //roept method van ChatServer aan
    {
        writeResponse("connection opened")
    }

    webSocket.onmessage=function(event) //roept method van ChatServer aan
    {
        writeResponse(event.data);
    }
    webSocket.onclose = function(event) //roept method van ChatServer aan
    {
        writeResponse("oonnection closed")
    }


}


function send(number)
{
    console.log(number)

    var text = "{\"comment\":\""+document.getElementById("comment"+number).value+"\", \"user\":\""+ document.getElementById("user"+number).value+"\", \"rating\":\""+ document.getElementById("rating"+number).value+"\", \"number\":\""+number+"\"}";
    console.log(text);
    webSocket.send(text)

}
function closedSocket()
{
    webSocket.close();
}

function writeResponse(text) {

    var tekst = JSON.parse(text);
    console.log("reaction"+tekst.number)
    if(tekst.rating<0 || tekst.rating>10){ throw "nummer klopt niet" }
    document.getElementById("reaction"+tekst.number).innerHTML+="<br/>"+tekst.user +": "+tekst.comment+" "+tekst.rating;
}