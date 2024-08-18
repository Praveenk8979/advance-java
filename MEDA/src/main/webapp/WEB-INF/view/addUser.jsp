<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="m-3">
	<c:if test="${not empty message}">
		<div class="alert alert-warning text-center" role="alert">${message}</div>
	</c:if>
	<div class="row">
		<div class="col-12 text-center">
			<h2>Add User Form</h2>
		</div>
	</div>

	<form:form action="${pageContext.request.contextPath}/admin/add-user"
		method="POST" modelAttribute="users"
		onsubmit="return validateUserForm()" class="mx-1 mx-md-4">

		<div class="row">
			<div class="col-12 col-md-6 col-lg-4 my-2">
				<form:label class="form-label" path="username">Username : </form:label>
				<form:input type="text" path="username" name="username"
					class="form-control" />
			</div>

			<div class="col-12 col-md-6 col-lg-4 my-2">
				<form:label class="form-label" path="firstName">First Name : </form:label>
				<form:input type="text" path="firstName" name="firstName"
					class="form-control" />
			</div>

			<div class="col-12 col-md-6 col-lg-4 my-2">
				<form:label class="form-label" path="lastName">Last Name : </form:label>
				<form:input type="text" path="lastName" name="lastName"
					class="form-control" />
			</div>

			<div class="col-12 col-md-6 col-lg-4 my-2">
				<form:label class="form-label" path="mobileNo">Mobile No. : </form:label>
				<form:input type="text" path="mobileNo" name="mobileNo"
					class="form-control" />
			</div>

			<div class="col-12 col-md-6 col-lg-4 my-2">
				<label class="form-label" for="form3Example3c">Select User
					Role :</label>
				<form:select class="form-control" name="roleName" id="roleName"
					path="roles.name">
					<form:option value="ADMIN">ADMIN</form:option>
					<form:option value="USER">USER</form:option>
				</form:select>
			</div>

			<div class="col-12 col-md-6 col-lg-4 my-2">
				<form:label class="form-label" path="password">Password : </form:label>
				<form:input type="text" path="password" name="password"
					id="password" class="form-control" />
			</div>

			<div class="col-12 col-md-6 col-lg-4 my-2">
				<label class="form-label" for="form3Example4cd">Repeat your
					Password :</label> <input type="password" id="repeatPassword"
					class="form-control" />
			</div>

		<!--	<%-- <div class="col-12 col-md-6 col-lg-4 my-2">
				<span><label class="form-label">Select District </label> </span>
				<form:select path="districts" class="form-select"
					multiple="multiple" id="districtList">
					<c:forEach items="${userDistrict }" var="district">
						<option value="${district.districtID }">${district.districtName }</option>
					</c:forEach>
				</form:select>
			</div> --%>-->
		</div>
		<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
			<input type="submit" class="btn btn-primary btn-lg" value="Add" />
		</div>
	</form:form>
</section>
<script type="text/javascript">
	function validateUserForm() {
		var username = document.getElementById("username").value;
		var firstName = document.getElementById("firstName").value;
		var lastName = document.getElementById("lastName").value;
		var mobileNo = document.getElementById("mobileNo").value;
		var roleName = document.getElementById("roleName").value;
		var password = document.getElementById("password").value;
		var repeatPassword = document.getElementById("repeatPassword").value;

		if (username.trim() === "") {
			alert("Please enter the Username.");
			return false;
		}

		if (firstName.trim() === "") {
			alert("Please enter the First Name.");
			return false;
		}

		if (lastName.trim() === "") {
			alert("Please enter the Last Name.");
			return false;
		}

		if (mobileNo.trim() === "") {
			alert("Please enter the Mobile Number.");
			return false;
		}

		var mobileNoRegex = /^[0-9]{10}$/;
		if (!mobileNo.match(mobileNoRegex)) {
			alert("Please enter a valid 10-digit Mobile Number.");
			return false;
		}

		if (roleName.trim() === "") {
			alert("Please select a User Role.");
			return false;
		}

		if (password.trim() === "") {
			alert("Please enter a Password.");
			return false;
		}

		if (repeatPassword.trim() === "") {
			alert("Please repeat your Password.");
			return false;
		}

		if (password !== repeatPassword) {
			alert("Passwords do not match.");
			return false;
		}

		return true;
	}
</script>
