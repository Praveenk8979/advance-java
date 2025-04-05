<%-- 
    Document   : Update Records
    Created on : 03 Dec, 2017, 05:00:32 PM
    Author     : Swapril Tyagi
--%>

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="HRForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function update() {
		mscConfirm("Have checked all details before updating record?",
				function() {
					document.getElementById('updateHRForm').submit();
				});
	}
</script>

<c:if test="${not empty msg}">
	<div id="myModal" class="modal" style="display: block;">
		<div class="modal-content">
			<div class="modal-header" style="background-color: #387403;">
				<span class="close"
					onclick="document.getElementById('myModal').style.display='none'"
					style="color: #FFFFFF;">&times;</span>
				<p style="text-align: center; color: #FFFFFF;" class="h3">${msg}</p>
			</div>
		</div>
	</div>
</c:if>

<p class="h1"
	style="font-family: cambria; text-align: center; color: #387403;">HR
	Update</p>
<div class="container">
	<HRForm:form action="updateHR" id="updateHRForm"
		enctype="multipart/form-data" method="post" modelAttribute="HRForm">

		<table class="table">
			<tr>
				<td><HRForm:hidden path="sno" /></td>
				<td><HRForm:hidden path="location" /></td>
				<td><HRForm:hidden path="noOfNoteeing" /></td>
				<td><HRForm:hidden path="noOfCoss" /></td>
				<td><HRForm:hidden path="totalPages" /></td>
			</tr>
			<tr>
				<td><label style="color: black; font-family: cambria;"
					for="fileNo"> <b>File No:</b>
				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="fileNo" readonly="true" /></td>
				<td>
				<td><label style="color: black; font-family: cambria;"
					for="fileCode"> <b>File Code:</b>
				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="fileCode" /></td>
				<td><label style="color: black; font-family: cambria;"
					for="opaFts"> <b>File Subject:</b>
				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="fileSubject" /></td>
			</tr>

			<tr>
				<td><label style="color: black; font-family: cambria;"
					for="fileNo"> <b>Date:</b>
				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="date" /></td>
				<td>
				<td><label style="color: black; font-family: cambria;"
					for="fileCode"> <b>Year</b>

				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="year" /></td>

				<td><label style="color: black; font-family: cambria;"
					for="opaFts"> <b>Opa/Fts No.:</b>
				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="opaFts" /></td>
			</tr>

			<tr>
				<td><label style="color: black; font-family: cambria;"
					for="employeeCode"> <b>Employee Code:</b>
				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="employeeCode" /></td>
				<td>
				<td><label style="color: black; font-family: cambria;"
					for="employeeName"> <b>Employee Name</b>
				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="employeeName" /></td>

				<td><label style="color: black; font-family: cambria;"
					for="employeeCategory"> <b>Employees Category:</b>
				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="employeeCategory" /></td>
			</tr>

			<tr>
				<td><label style="color: black; font-family: cambria;"
					for="employeeDesignation"> <b>Employee Designation:</b>
				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="employeeDesignation" /></td>
				<td>
				<td><label style="color: black; font-family: cambria;"
					for="employeeDob"> <b>Employee DOB: </b>
				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="employeeDob" /></td>

				<td><label style="color: black; font-family: cambria;"
					for="employeeDoj"> <b>Employee DOJ:</b>
				</label><br> <HRForm:input style="width: 235px; height: 35px;"
						path="employeeDoj" /></td>
			</tr>

			<tr>
				<td><label style="color: black; font-family: cambria;"
					for="File"> <b>Choose NoteSheet Pages:</b>
				</label><br> <input
					style="width: 235px; height: 35px; margin-top: 7px;" type="file"
					name="noteSheet" /></td>

				<td><label style="color: black; font-family: cambria;"
					for="File"> <b>Choose Correspondence Page:</b>
				</label><br> <input
					style="width: 235px; height: 35px; margin-top: 7px;" type="file"
					name="correspondence" /></td>
			</tr>

			<tr>
				<td colspan="3" align="center"><br> <input
					class="btn btn-primary"
					style="background-color: #2D6419; color: #ffffff;"
					value="Update It" onclick="update();"></td>
			</tr>
		</table>


	</HRForm:form>
</div>