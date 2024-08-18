<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link
	href="${pageContext.request.contextPath}/staticResources/styleSheets/login.css"
	rel="stylesheet">
	
	<!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
	crossorigin="anonymous">-->

<div class="wrapper">
	<div class="logo">
		<img
			src="${pageContext.request.contextPath}/staticResources/images/logo4.png"
			alt="">
	</div>
	<div class="text-center mt-4 name">Login</div>
	<form class="p-3 mt-3"
		action="${pageContext.request.contextPath}/login" method="POST">

		<c:if test="${param.error!=null}">
			<div class="alert alert-danger" role="alert">You entered wrong
				credentials!</div>
		</c:if>
		<c:if test="${param.logout!=null}">
			<div class="alert alert-success" role="alert">You're logout
				successfully!</div>
		</c:if>

		<div class="form-field d-flex align-items-center">
			<input type="text" name="username" id="username"
				placeholder="Username" autocapitalize="off" autocomplete="off">
		</div>
		<div class="form-field d-flex align-items-center">
			<input type="password" name="password" id="password"
				placeholder="Password">
		</div>
		<button class="btn btn-success mt-3">Login</button>
	</form>
</div>

<script>
$(document).ready(()=>{
    $('input').keyup(()=>{
    	$('.alert').addClass('d-none');
    });
});
</script>