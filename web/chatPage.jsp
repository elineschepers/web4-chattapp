<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.12.4.js"></script>
    <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>





    <jsp:include page="head.jsp">
    <jsp:param name="title" value="chat" />
</jsp:include>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="chat" />
</jsp:include>

<main>


    <div>
        <h3 id="status">Status: </h3>
    </div>
    <div>
        <h3>Friends:</h3>
        <table id="friendsList">
            <thead>
            <th>UserId</th>
            <th>Status</th>

            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <div>
        <form action="Controller?action=ChangeStatus" method="post">
        <p>
            <label for="newStatus">Change status</label>
            <input type="text" id="newStatus" name="newStatus" placeholder="type a new status">
        </p>
        <p>
            <input type="submit" id="changeStatusbutton" value="change">
        </p>
        </form>
    </div>
    <form action="Controller?action=AddFriend" method="post">
        <p>
            <label for="friend">add friend </label>
            <input type="text" id="friend" name="friend" value="">
        <p>
            <input type="submit" id="AddFriend" value="add">
        </p>
        </p>
    </form>
</main>
<div>
    <p id="amountOfMessages">amount of messages send: </p>
    <div id="chatbox">
        <h2 id="friendname">chat</h2>
        <div id="messages">

        </div>
    </div>
    <div id="chatinput">
        <input type="text" value="type something" name="message" id="message" onclick="value='' ">
        <input value="send" type="submit" id="sendMessage" onclick="sendMessage()">
    </div>
</div>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
<script type="text/javascript" src="js/getChatInfo.js"></script>
<script type="text/javascript" src="js/chat.js"></script>
</html>
