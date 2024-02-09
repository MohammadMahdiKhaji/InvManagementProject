<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/assets/includes/header.jsp" />
<jsp:include page="/assets/includes/column_left_product.jsp" />

<!-- start the middle column -->

<!-- If necessary, this page could be generated from the database. -->

<section>
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
        </tr>
      </c:forEach>
    </table>
  </c:if>
</section>

<!-- end the middle column -->

<jsp:include page="/assets/includes/column_right_news.jsp" flush="true" />
<jsp:include page="/assets/includes/footer.jsp" />