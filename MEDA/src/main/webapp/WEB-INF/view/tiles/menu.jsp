<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
nav ul li a:hover {
	background-color: #D7E5E5;
	border-radius: 10px
}

nav ul li a {
	font-weight: bold;
}
</style>

<%@ include file="../USER_ROLE.jsp"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="${pageContext.request.contextPath}/">Home</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Users </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item"
							href="${pageContext.request.contextPath}/user/current-user">Current
								Users</a></li>

						<c:if test="${isAdmin}">
							<li><a class="dropdown-item"
								href="${pageContext.request.contextPath}/admin/add-user">Add
									User</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item"
								href="${pageContext.request.contextPath}/admin/user-list">User
									List</a></li>
						</c:if>
					</ul></li>
				
				<!--<li class="nav-item"><a class="nav-link active"
					href="${pageContext.request.contextPath}/view-files">View</a></li>-->
					<li class="nav-item dropdown">
					    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
					        Upload File
					    </a>
					    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							
							<c:forEach items="${deptList}" var="dept">
								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/fileUpload/uploadForm/${dept}">${dept}</a></li>

							</c:forEach>
							<!--
					        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/fileUpload/uploadForm/${dept}">Finance And Account Department</a></li>
					        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/fileUpload/uploadForm/${dept}">Sales Department</a></li>
					        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/fileUpload/uploadForm/${dept}">HR Department</a></li>
					   --> </ul>
					</li>

						
				

				<%-- <li class="nav-item"><a class="nav-link active"
					href="${pageContext.request.contextPath}/generateValidationReport">Validation
						Report</a></li> --%>
				<li class="nav-item"><a class="nav-link active"
					href="${pageContext.request.contextPath}/uploadCsv1">Bulk Upload
						</a></li>

				<!-- <li class="nav-item dropdown"><a
					class="nav-link active dropdown-toggle" href="#"
					id="navbarDropdownDistrict" role="button" data-bs-toggle="dropdown"
					aria-expanded="false"> District </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdownDistrict"
						id="districtDropdown">
					</ul></li> -->
			</ul>
			<div class="d-flex">
				<a href="${pageContext.request.contextPath}/logout"
					class="btn btn-danger">Logout</a>
			</div>
		</div>
	</div>
</nav>
<!--<script>
	document
			.addEventListener(
					"DOMContentLoaded",
					function() {
						document
								.getElementById("navbarDropdownDistrict")
								.addEventListener(
										"click",
										function() {
											var xhr = new XMLHttpRequest();
											xhr.open("GET", "/api/districts",
													true);
											xhr.onreadystatechange = function() {
												if (xhr.readyState == 4
														&& xhr.status == 200) {
													var districts = JSON
															.parse(xhr.responseText);
													populateDropdown(districts);
												}
											};
											xhr.send();
										});

						function populateDropdown(districts) {
							var dropdownMenu = document
									.getElementById("districtDropdown");
							dropdownMenu.innerHTML = ""; // 
							districts
									.forEach(function(district) {
										var link = document.createElement("a");
										link.textContent = district;
										link.href = "${pageContext.request.contextPath}/files-receipt?districtName="
												+ encodeURIComponent(district);
										link.classList.add("dropdown-item");
										dropdownMenu.appendChild(link);
									});
						}
					});
</script>-->