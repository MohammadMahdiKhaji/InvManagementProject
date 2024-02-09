<jsp:include page="/assets/includes/header.jsp" />
<jsp:include page="/assets/includes/column_left_all.jsp" />

<!-- start the middle column -->

<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>

    <h1>Java Error</h1>
    <p>Sorry, Java has thrown an exception.</p>
    <p>To continue, click the back button or select a link from this page.</p>

    <!-- NOTE: When you're done with testing, you can disable 
    any of the following details about the exception. -->      
    <h2>Details</h2>
    <code>
    ${pageContext.errorData.servletName} threw a <br>
    ${pageContext.exception}<br>
    <c:forEach var="line" items="${pageContext.errorData.throwable.stackTrace}">
        &nbsp;&nbsp;&nbsp;&nbsp;at ${line}<br>
    </c:forEach>
    </code>

</section>

<!-- end the middle column -->

<jsp:include page="/assets/includes/footer.jsp" />