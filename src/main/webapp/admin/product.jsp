<jsp:include page="/assets/includes/header.jsp" />
<jsp:include page="/assets/includes/column_left_admin.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- begin middle column -->

<section id="admin">

    <h1>Your Product</h1>

    <c:if test="${product == null}">
        <p>There are no product to show.</p>
    </c:if>

    <c:if test="${product != null}">
        <table>
            <tr>
                <td><b>Product Name</b></td>
                <td><b>Product Category</b></td>
            </tr>

            <tr>
                <td>${product.productName}</td>
                <td>${product.categories}</td>
            </tr>
        </table>
    </c:if>

    <form action="<c:url value='/admin'/>" method="post">
        <input type=submit value="Go Back to Menu">
    </form>

</section>

<!-- end middle column -->

<jsp:include page="/assets/includes/footer.jsp" />