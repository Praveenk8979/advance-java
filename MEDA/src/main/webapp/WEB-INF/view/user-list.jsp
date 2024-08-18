<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="USER_ROLE.jsp"%>

<div class="row">
	<div class="col-12 text-center h1">User List</div>
</div>

<div class="row m-3">
	<div class="col-2 offset-5">
		<label for="">Select User : </label> <select name="username"
			onchange="userDetails()" class="form-control" id="userSelect">
			<c:forEach items="${ userList}" var="u">
				<option value="${u.username }"
					${u.username eq users.username?'selected':'' }>${u.username.concat(' (
					').concat(u.mobileNo).concat(' ) ') }</option>
			</c:forEach>
		</select>
	</div>

	<c:if
		test="${isAdmin and param.username!=null and !param.username.equals(username)}">
		<div class="col">
			<button type="button" class="btn-sm btn-danger float-end"
				data-bs-toggle="modal" data-bs-target="#removeUserModal">Remove</button>
		</div>
	</c:if>
	<!-- Modal -->
	<div class="modal fade" id="removeUserModal" tabindex="-1"
		aria-labelledby="removeUserModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="removeUserModalLabel">Delete User</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					Do you want to delete user with username : <span class="fw-bold">${param.username}
						?</span>
				</div>
				<div class="modal-footer">
					<form action="deleteUser" method="POST">
						<input type="hidden" name="deleteUsername"
							value="${param.username}">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Delete It</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="card m-2 p-3">
	<c:if test="${not empty message}">
		<div class="alert alert-warning text-center" role="alert">${message}</div>
	</c:if>
	<form:form
		action="${pageContext.request.contextPath}/admin/update-user"
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
				<label class="form-label"> Select Role</label>
				<form:select class="form-control" name="roleName" id="roleName"
					path="roles.name">
					<form:option value="ADMIN">ADMIN</form:option>
					<form:option value="USER">USER</form:option>
				</form:select>
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

		

					
					

			<div class="row">
				<div class="col-1">
					<label class="form-label"> Enable </label>
					<form:checkbox path="enable" />
				</div>
			</div>

			<div class="col-12 text-center my-4">
				<input type="submit" class="btn btn-success" value="Update">
			</div>

		</div>
	</form:form>
</div>

<script type="text/javascript">
	$(document).ready(()=> {
		$('#confirmPassword').val($('#password').val());
	    var username = $('#userSelect option:selected').val();
	});

	function validateForm() {
        var firstName = document.getElementById("firstName").value;
        var lastName = document.getElementById("lastName").value;
        var mobileNo = document.getElementById("mobileNo").value;
        var roleName = document.getElementById("roleName").value;
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirmPassword").value;

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
            alert("Please select a Role.");
            return false;
        }

        if (password.trim() === "") {
            alert("Please enter a Password.");
            return false;
        }

        if (confirmPassword.trim() === "") {
            alert("Please enter confirm your Password.");
            return false;
        }

        if (password !== confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }

        return true;
    }
	
	function userDetails()
	{
		var username=$('#userSelect').val();
		window.location.href="user-list?username="+username;
	}

	
</script>