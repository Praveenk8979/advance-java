<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row m-3">
	<div class="col-12 text-center">
		<h2>Current User : ${username }</h2>
	</div>
</div>

<div class="card m-3 p-3" style="border-radius: 10px">
	<c:if test="${not empty message}">
		<div class="alert alert-warning text-center" role="alert">${message}</div>
	</c:if>
	<form:form
		action="${pageContext.request.contextPath}/user/update-current-user"
		onsubmit="return validateForm()" class="form-group" method="POST"
		modelAttribute="users">

		<div class="row">
			<div class="col-12 col-md-6 col-lg-4 my-2">
				<form:label class="form-label" path="username"> Username</form:label>
				<form:input path="username" class="form-control" readonly="true" />
			</div>
			<div class="col-12 col-md-6 col-lg-4 my-2">

				<form:label class="form-label" path="firstName"> First-Name</form:label>
				<form:input path="firstName" class="form-control" />

			</div>
			<div class="col-12 col-md-6 col-lg-4 my-2">
				<form:label class="form-label" path="lastName"> Last-Name</form:label>
				<form:input path="lastName" class="form-control" />
			</div>

			<div class="col-12 col-md-6 col-lg-4 my-2">
				<form:label class="form-label" path="mobileNo"> Mobile No.</form:label>
				<form:input path="mobileNo" class="form-control" />
			</div>

			<div class="col-12 col-md-6 col-lg-4 my-2">
				<form:label class="form-label" path="password"> Password</form:label>
				<form:input type="password" path="password" id="password"
					class="form-control" />
			</div>

			<div class="col-12 col-md-6 col-lg-4 my-2">
				<span><label class="form-label"> Confirm-Password </label> </span> <input
					type="password" name="confirmPassword" id="confirmPassword"
					class="form-control" />
			</div>

			<%-- <div class="col-12 col-md-6 col-lg-4 my-2">
				<span><label class="form-label">Select District </label> </span> <select
					class="form-select" multiple="multiple" id="districtList"
					disabled="disabled">
					<c:forEach items="${userDistrict }" var="district">
						<option value="${district.districtID }" selected>${district.districtName }</option>
					</c:forEach>
				</select>

			</div> --%>

			<div class="col-12 text-center my-4">
				<input type="submit" class="btn btn-success" value="Update">
			</div>

		</div>
	</form:form>
</div>
<script type="text/javascript">
			$(document).ready(() => {
				$('#confirmPassword').val($('#password').val());			
			});

			function validateForm() {

				var firstName = document.getElementById("firstName").value;
				var lastName = document.getElementById("lastName").value;
				var mobileNo = document.getElementById("mobileNo").value;
				var password = $('#password').val();
				var confirmPassword = $('#confirmPassword').val();

				if (firstName.trim() === "") {
					alert("Please enter your First Name.");
					return false;
				}

				if (lastName.trim() === "") {
					alert("Please enter your Last Name.");
					return false;
				}

				if (mobileNo.trim() === "") {
					alert("Please enter your Mobile Number.");
					return false;
				}

				if (password.trim() === "") {
					alert("Please enter a Password.");
					return false;
				}

				if (password !== confirmPassword) {
					alert("Passwords do not match.");
					return false;
				}
				return true;
			}
</script>