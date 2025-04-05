<%-- 
    Document   : Update Records
    Created on : 03 Dec, 2017, 05:00:32 PM
    Author     : Swapril Tyagi
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="lawForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function update()
	{
		mscConfirm("Have checked all details before updating record?",
				function (){
		  	document.getElementById('updatelawForm').submit();
		});
	}
</script>

<c:if test="${not empty msg}">
	<div id="myModal" class="modal" style="display: block;">
  		<div class="modal-content">
    		<div class="modal-header" style="background-color: #387403;">
      			<span class="close" onclick="document.getElementById('myModal').style.display='none'" style="color: #FFFFFF;">&times;</span>
      			<p style="text-align: center; color: #FFFFFF;" class="h3">${msg}</p>
    		</div>
  		</div>
	</div>
</c:if>

<p class="h1" style="font-family: cambria; text-align: center; color: #387403;">Law</p>
<div class="container">
	<lawForm:form action="updateLaw" id="updatelawForm" enctype="multipart/form-data" method="POST" modelAttribute="lawForm">
        <table class="table">
            <tr>
            
            <td>
                   	<label style="color: black; font-family: cambria;" for="department"><h4><b>Department:</b></h4></label><br>
                   	<lawForm:input style="width: 235px; height: 35px;" path="department" readonly="true"/>
                </td>
            	<td>
                   	<label style="color: black; font-family: cambria;" for="courtName"><h4><b>Court Name:</b></h4></label><br>
                   	<lawForm:input style="width: 235px; height: 35px;" path="courtName" readonly="true"/>
                </td>
                <td>
                    <label style="color: black; font-family: cambria;" for="writPatitionNumber"><h4><b>Writ Patition Number:</b></h4></label><br>
                    <lawForm:input style="width: 235px; height: 35px;" path="writPatitionNumber" readonly="true" required="true"/>
                </td>
                <td>
                   	<label style="color: black; font-family: cambria;" for="year"><h4><b>Year:</b></h4></label><br>
                   	<lawForm:input style="width: 235px; height: 35px;" path="year" required="true"/>
                </td>
            </tr>
            <tr>
                
                <td>
                  	<label style="color: black; font-family: cambria;" for="Subject"><h4><b>Subject:</b></h4></label><br>
                   	<lawForm:input style="width: 235px; height: 35px;" path="Subject" required="true"/>
                </td>
                <td>
                  	<label style="color: black; font-family: cambria;" for="advocateName"><h4><b>Advocate Name:</b></h4></label><br>
                   	<lawForm:input style="width: 235px; height: 35px;" path="advocateName" required="true"/>
                </td>
                <td>
                   	<label style="color: black; font-family: cambria;" for="relatedDepartment"><h4><b>Related Department:</b></h4></label><br>
                   	<lawForm:input style="width: 235px; height: 35px;" path="relatedDepartment" required="true"/>
                </td>
            </tr>
            <tr>
            	<td>
                   	<label style="color: black; font-family: cambria;" for="sector"><h4><b>Sector:</b></h4></label><br>
                   	<lawForm:input style="width: 235px; height: 35px;" path="sector" required="true"/>
                </td>
                <td>
                   	<label style="color: black; font-family: cambria;" for="opaFTS"><h4><b>OPA_FTS:</b></h4></label><br>
                   	<lawForm:input style="width: 235px; height: 35px;" path="opaFTS" required="true"/>
                </td>
                <td>
                   	<label style="color: black; font-family: cambria;" for="File"><h4><b>Choose NoteSheet Pages:</b></h4></label><br>
                   	<input style="width: 235px; height: 35px; margin-top: 7px;" type="file" name="noteSheet"/>
                </td>
                <td>
                   	<label style="color: black; font-family: cambria;" for="File"><h4><b>Choose Correspondence Page:</b></h4></label><br>
                   	<input style="width: 235px; height: 35px; margin-top: 7px;" type="file" name="correspondence"/>
                </td>
            </tr>
            <tr><td><lawForm:hidden path="sno"/></td><td colspan="2"><lawForm:hidden path="location"/>
            
            <lawForm:hidden path="noOfNoteeing"/><lawForm:hidden path="noOfCoss"/><lawForm:hidden path="totalPages"/>
            
            </td></tr>
            <tr><td colspan="3" align="center"><br><input class="btn btn-primary" style="background-color: #2D6419; color: #ffffff;" value="Update It" onclick="update();"></td></tr>
        </table>
    </lawForm:form>
</div>