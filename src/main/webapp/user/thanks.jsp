<jsp:include page="/assets/includes/header.jsp" />
<jsp:include page="/assets/includes/column_left_all.jsp" />

<section>
    
<h1>Thanks for joining our user list</h1>
<p>Here is the information that you entered:</p>

<label  class="no_pad_top">Email</label>
<span>${user.email}</span><br>
<label class="no_pad_top">Username</label>
<span>${user.username}</span><br>
<label class="no_pad_top">Password</label>
<span>${user.password}</span><br>

</section>

<jsp:include page="/assets/includes/column_right_news.jsp" />
<jsp:include page="/assets/includes/footer.jsp" />