<jsp:include page="/assets/includes/header.jsp" />
<jsp:include page="/assets/includes/column_left_admin.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- begin middle column -->

<section id="admin">

    <h1>Products to be processed:</h1>

    <c:if test="${products == null}">
        <p>There are no products to show.</p>
    </c:if>


    <c:if test="${products != null}">
        <table>
            <tr>
                <td><b>Product Name</b></td>
                <td><b>Product Category</b></td>
            </tr>


            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.productName}</td>
                    <td>${product.categories}</td>
                    <td>
                        <%--                /displayProduct won't work            --%>
                        <a href="displayProduct?productNumber=${product.productId}">View</a>
                        <a href="loadEditProduct?productNumber=${product.productId}">Edit</a>
                        <a href="deleteProduct?productNumber=${product.productId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <form action="<c:url value='/admin'/>" method="post">
        <input type=submit value="Go Back to Menu">
    </form>

</section>

<!-- end middle column -->

<jsp:include page="/assets/includes/footer.jsp" />