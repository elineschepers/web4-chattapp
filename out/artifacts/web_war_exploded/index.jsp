<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
	<body>
	<jsp:include page="header.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
	<main>
<c:if test="${errors.size()>0 }">
	<div class="danger">
		<ul>
			<c:forEach var="error" items="${errors }">
				<li>${error }</li>
			</c:forEach>
		</ul>
	</div>
</c:if> <c:choose>
	<c:when test="${user!=null}">
		<p>Welcome ${user.getFirstName()}!</p>

		<p>There is/are <span id="amountOfFriends"></span> friend(s) online</p>
		<form method="post" action="Controller?action=LogOut">
			<p>
				<input type="submit" id="logoutbutton" value="Log Out" >
			</p>
		</form>
	</c:when>
	<c:otherwise>
		<form method="post" action="Controller?action=LogIn">
			<p>
				<label for="email">Your email </label>
				<input type="text" id="email" name="email" value="jan@ucll.be">
			</p>
			<p>
				<label for="password">Your password</label>
				<input type="password" id="password" name="password" value="t">
			</p>
			<p>
				<input type="submit" id="loginbutton" value="Log in">
			</p>
		</form>
	</c:otherwise>
</c:choose> </main>

	<div id="topics">

		<div class="topic1">
			<p id="question1"> Was het een interessante projectweek?</p>
			<div id="reaction1">


			</div>
			<label for="comment1">your comment</label>
			<input type="text" id="comment1" value="comment"><br>
			<label for="user1">your name</label>
			<input type="text" id="user1" value="name"><br>
			<label for="rating1">your rating</label>
			<input type="number" id="rating1" value="0" min="0" max="10"><br>
			<input type="submit" id="commentbutton1" onclick="send(1);" value="comment" class="button button-primary"><br>
		</div>

		<div class="topic2">
			<p id="question2"> Wat ben je van plan te doen vandaag?</p>
			<div id="reaction2">

			</div>
			<label for="comment2">your comment</label>
			<input type="text" id="comment2" value="comment"><br>
			<label for="user2">your name</label>
			<input type="text" id="user2" value="name"><br>
			<label for="rating2">your rating</label>
			<input type="number" id="rating2" value="0" min="0" max="10"><br>
			<input type="submit" id="commentbutton2" onclick="send(2);" value="comment" class="button button-primary"><br>
		</div>
		<div class="topic3">
			<p id="question3"> Naar welke muziek ben jij momenteel aan het luisteren?</p>
			<div id="reaction3">

			</div>
			<label for="comment3">your comment</label>
			<input type="text" id="comment3" value="comment"><br>
			<label for="user3">your name</label>
			<input type="text" id="user3" value="name"><br>
			<label for="rating3">your rating</label>
			<input type="number" id="rating3" value="0" min="0" max="10"><br>
			<input type="submit" id="commentbutton3" onclick="send(3);" value="comment" class="button button-primary"><br>
		</div>
		<div class="topic4">
			<p id="question4"> Wat zijn de examenvragen voor het vak Web4?</p>
			<div id="reaction4">

			</div>
			<label for="comment4">your comment</label>
			<input type="text" id="comment4" value="comment"><br>
			<label for="user4">your name</label>
			<input type="text" id="user4" value="name"><br>
			<label for="rating4">your rating</label>
			<input type="number"  id="rating4" value="0" min="0" max="10"><br>
			<input type="submit" id="commentbutton4" onclick="send(4);" value="comment" class="button button-primary"><br>
		</div>
	</div>



	<jsp:include page="footer.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
    <script type="text/javascript" src="js/getChatInfo.js"></script>
	<script type="text/javascript" src="js/blog.js"></script>
</body>
</html>