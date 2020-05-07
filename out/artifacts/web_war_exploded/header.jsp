<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
<img alt="Books" src="images/books.jpg">
<h1><span>Chat App</span></h1>
<nav>
<ul>
<c:choose>
<c:when test="${param.title=='Home'}">
<li  id="actual"><a href="index.jsp">Home</a></li>
    <c:if test="${user!=null}">
    <li><a href="Controller?action=Chat">Chat</a></li>
    </c:if>
</c:when>
<c:otherwise>
    <li><a href="index.jsp">Home</a></li>
    <c:if test="${user!=null}">
        <li><a href="Controller?action=Chat">Chat</a></li>
</c:if>
</c:otherwise>
</c:choose>





</ul>
</nav>
<h2>
${param.title}
</h2>

</header>