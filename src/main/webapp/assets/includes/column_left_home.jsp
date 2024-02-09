<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside id="sidebarA">
    <nav>
      <ul>
          <li><a class="current" href="<c:url value='/' />">
                  Home</a></li>
          <li><a href="<c:url value='/productController/displayProducts' />">
                  Browse Products</a></li>
          <li><a href="<c:url value='/user' />">
                  Join Users</a></li>
          <li><a href="<c:url value='/customer_service' />">
                  Customer Service</a></li>
      </ul>
    </nav>
</aside>