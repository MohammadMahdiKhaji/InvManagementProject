<jsp:include page="/assets/includes/header.jsp" />
<jsp:include page="/assets/includes/column_left_admin.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- begin middle column -->

<section id="admin">

  <h1>Admin Menu</h1>

  <!-- these Form tags don't force a secure connection -->
<%--  <form action="<c:url value='/AdminController/displayInvoices'/>" method="post">--%>
<%--    <input type="submit" value="Process Invoices" class="left_margin">--%>
<%--  </form>--%>
  <form action="<c:url value='/adminController/displayProducts'/>" method="post">
    <input type="submit" value="Show Products" class="left_margin">
  </form>
  <form action="<c:url value='/adminController/loadAddProduct'/>" >
    <input type="submit" value="Add Product" class="left_margin">
  </form>
<%--  <form action="reports.jsp" method="post">--%>
<%--    <input type="submit" value="Display Reports" class="left_margin">--%>
<%--  </form>--%>

</section>

<!-- end middle column -->

<jsp:include page="/assets/includes/footer.jsp" />