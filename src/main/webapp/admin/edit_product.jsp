<jsp:include page="/assets/includes/header.jsp" />
<jsp:include page="/assets/includes/column_left_admin.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- start the middle column -->

<section id="admin">

    <h1>Edit Product</h1>

    <%--    <p>Before you can download and listen to these sound files,--%>
    <%--        you must register with us by entering your name and email--%>
    <%--        address below.</p>--%>

    <!-- Use the JSTL url tag to encode the URL -->
    <form action="<c:url value='/adminController/editProduct'/>" method="post">

        <label for="category_select">Choose a category:</label>
        <select name="categoryId" id="category_select">
            <c:forEach var="lCategory" items="${categories}">
                <c:choose>
                    <c:when test="${lCategory.categoryName eq categoryName}">
                        <option value="${lCategory.categoryId}" selected>${lCategory.categoryName}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${lCategory.categoryId}">${lCategory.categoryName}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select><br>

        <label>Product name:</label>
        <input type="text" name="productName" value="${product.productName}" required><br>
        <label>&nbsp;</label>
        <input type="submit" value="EditProduct" id="submit">
    </form>

    <form action="<c:url value='/admin'/>" method="post">
        <input type=submit value="Go Back to Menu">
    </form>

</section>

<!-- end the middle column -->

<jsp:include page="/assets/includes/footer.jsp" />