<jsp:include page="/assets/includes/header.jsp" />
<jsp:include page="/assets/includes/column_left_admin.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- start the middle column -->

<section>

    <h1>Add Product</h1>

<%--    <p>Before you can download and listen to these sound files,--%>
<%--        you must register with us by entering your name and email--%>
<%--        address below.</p>--%>

    <!-- Use the JSTL url tag to encode the URL -->
    <form action="<c:url value='/adminController/addProduct'/>" method="post">

        <label for="category">Choose a category:</label>
        <select name="categoryId" id="category">
            <c:forEach var="category" items="${categories}">
                <option value="${category.categoryId}">${category.categoryName}</option>
            </c:forEach>
        </select><br>

        <label>Product Name</label>
        <input type="text" name="productName" required><br>
        <label>&nbsp;</label>
        <input type="submit" value="AddProduct" id="submit">
    </form>

    <form action="<c:url value='/admin'/>" method="post">
        <input type=submit value="Go Back to Menu">
    </form>

</section>

<!-- end the middle column -->

<jsp:include page="/assets/includes/footer.jsp" />