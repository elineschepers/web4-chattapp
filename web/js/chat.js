function startconvo(userid)
{
    alert(userid)
    $("#friendname").text(userid);
    $.post("Controller?action=StartConversation&friend="+encodeURIComponent(userid))
    alert("post verstuurd")
    //trigger getmessages
}

function sendMessage()
{
    var id =$("#friendname").text();
    var message =$("#message").val();
    alert(message)
    $("#message").text("")
    $.post("Controller?action=AddMessage&userId="+encodeURIComponent(id)+"&message="+message);


}

function getmessages()
{
    //$.ajax gebruiken
}