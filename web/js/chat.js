function startconvo(userid)
{
    alert(userid)
    $("#friendname").text(userid);
    $.post("Controller?action=StartConversation&friend="+encodeURIComponent(userid))
    alert("post verstuurd")
    //trigger getmessages
    getmessages(userid)
    //getAmountSend(userid)

}

function sendMessage()
{
    var id =$("#friendname").text();
    var message =$("#message").val();
    alert(message)
    $("#message").text("")
    $.post("Controller?action=AddMessage&userId="+encodeURIComponent(id)+"&message="+message);

    //getAmountSend(id)
    //getmessages(id)

}

function getAmountSend(userid)
{
    $.ajax({type:"GET", url:"Controller?action=GetAmountOfMessages&userId="+userid,dataType:"json",
        success: function(json)
        {
                $("#amountOfMessages").text("amount of messages sent: "+json);
                setTimeout(getAmountSend,10000)

        }, error: function()
        {
            alert("something went wrong while retrieving your messages")
        }


    });
}

function getmessages(userid)
{
    $.ajax({type:"GET", url:"Controller?action=GetMessages&userId="+userid,dataType:"json",
        success: function(json)
    {
        alert("test")
        $(json).each(function(index,message)
        {

            $("#messages").append($('<p />').text(message.sender.firstName+": "+message.message));

        });
        setTimeout(function () {
            getmessages(userid);
        },10000);
    }, error: function()
        {
            alert("something went wrong while retrieving your messages")
        }


    });

}