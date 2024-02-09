<jsp:include page="/assets/includes/header.jsp" />
<jsp:include page="/assets/includes/column_left_email.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    function checkCaptcha() {
        var captchaCode = document.getElementById("captchaCode").value;
        var captchaCodeInput = document.getElementById("captchaCodeInput").value;
        var submitButton = document.getElementById("submit");

        if (captchaCodeInput === captchaCode) {
            submitButton.type = "submit";
            // Enable the submit button or perform any other action here
        } else {
            alert("Captcha code is incorrect. Please try again.");
            // Clear the input field or perform any other action here
        }
    }
</script>

<section>
    <h1>Join our list</h1>
    <p>If you do, we'll send you announcements about new products.</p>

    <p><i>${message}</i></p>

    <form action="<c:url value='/userController/signupUser'/>" method="post">
        <label>Email:</label>
        <input type="email" name="email" required><br>
        <label>Username:</label>
        <input type="text" name="username" required><br>
        <label>Password:</label>
        <input type="password" name="password" required><br>

        <div>
            <label class="prompt">Retype the characters:</label>
            <jsp:useBean id="captcha" class="ir.resuinventory.model.utils.Captcha"/>
            <input id="captchaCode" type="text" name="captchaCode" value="${captcha.captcha}"
                   style="width: 65px;" disabled/>
            <input id="captchaCodeInput" type="text" name="captchaCodeInput"
                   style="width: 65px;" />
            <button id="checkCaptchaButton" type="button" onclick="checkCaptcha()">Check Captcha</button>
        </div><br>

        <label>&nbsp;</label>
        <input type="hidden" value="Join Now" id="submit">
    </form>

</section>

<jsp:include page="/assets/includes/column_right_news.jsp" />
<jsp:include page="/assets/includes/footer.jsp" />