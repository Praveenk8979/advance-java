<%-- 
    Document   : Create Records
    Created on : 22 June, 2020, 01:00:32 PM
    Author     : Preeti Rani
--%>

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="HealthForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet"
	href="<c:url value='staticResources/styleSheets/tableManager.css'/>" />
<script type="text/javascript"
	src="<c:url value='/staticResources/scripts/retrieval.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/staticResources/scripts/table.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/staticResources/scripts/table.min.js'/>"></script>

<div id="ftsNo" style="display: none">${param.opa_fts}</div>
<script type="text/javascript">
	var request,fileId,noteCount,corrCount,currentNote,currentCorr,currentSno,currentAlloteeName,printLr,sno,bankName;
	$(document).ready(function() 
	{
    	$('#fileTable').DataTable({
        	"pagingType":"full_numbers"
    	});
	});
	$(document).on('keydown', function(e) {
	    if(e.ctrlKey && (e.key == "p" || e.charCode == 16 || e.charCode == 112 || e.keyCode == 80) ){
	        e.cancelBubble = true;
	        e.preventDefault();
	        e.stopImmediatePropagation();
	    }  
	});
	function retrieveFiles()
	{
		var fileNo=document.getElementById('fileNo').value;
		var opa_fts=document.getElementById('opa_fts').value;
		var workName=document.getElementById('workName').value;
		var department=document.getElementById('department').value;
		var sector=document.getElementById('sector').value;
		var contrName=document.getElementById('contrName').value;
		//var No_Of_NoteSheet=document.getElementById('no_Of_NoteSheet').value;
		if(fileNo=='' && opa_fts=='' &&  workName=='' && department=='' && sector=='' && contrName=='' 
		//	 && No_Of_NoteSheet==''
				 )
			setContent('Sorry Empty Parameters!');
		else
			document.getElementById('HealthForm').submit();
	}
	function deleteFile()
	{
		window.location="delView?department=Health";
	}
	function viewFile(pos,sno,right,name)
	{
		currentSno=sno;currentAlloteeName=name;
		if(right==1)
		{
			var url="viewFile?id="+pos+"&sno="+sno+"&department=Health&prFlage=null&name="+name;
			if(window.XMLHttpRequest)  
				request=new XMLHttpRequest();  
			else if(window.ActiveXObject)  
				request=new ActiveXObject("Microsoft.XMLHTTP");
			document.getElementById('id01').style.display='block';
			document.getElementById('noteDiv').innerHTML='<p style="margin-top: 5%; font-size: 22px; font-family: cambria; text-align: center;">Opening Notesheet...</p>';
			document.getElementById('corrDiv').innerHTML='<p style="margin-top: 5%; font-size: 22px; font-family: cambria; text-align: center;">Opening Correspondence...</p>';
			try
			{
				request.onreadystatechange=setFile;
				request.open("GET",url,true);  
				request.send();
			}
			catch(e)
			{}
		}
	}
	function setFile()
	{
		if(request.readyState==4)
		{
			var data=request.responseText.split('<@>');
			fileId=data[0];noteCount=data[1];corrCount=data[2];
			var notePage=document.getElementById('notePage');
			var corrPage=document.getElementById('corrPage');
			for(var i=0;i<noteCount;i++)
			{
				if(i==0)
					notePage.innerHTML='<option value="Select">Select</option>';
				else
					notePage.innerHTML=notePage.innerHTML+'<option value="'+i+'">'+i+'</option>'
			}
			for(var i=0;i<corrCount;i++)
			{
				if(i==0)
					corrPage.innerHTML='<option value="Select">Select</option>';
				else
					corrPage.innerHTML=corrPage.innerHTML+'<option value="'+i+'">'+i+'</option>'
			}
			var pages='<p style="text-align: center; font-family: cambria; font-size: 14px; color: #ffffff;">Go To Page:</p><select style="width: 50px; height: 15px;" name="notePage"><option value="Select">Select</option></select>';
			currentNote=1;currentCorr=1;
			getPage('noteDiv',1);getPage('corrDiv',1);
		}
	}
	function nexPre(type,opr)
	{
		if(type=='noteDiv')
		{
			if(opr=='pre' && currentNote!=1)
				currentNote=currentNote-1;
			if(opr=='nex' && currentNote<(noteCount-1))
				currentNote=currentNote+1;
			getPage(type,currentNote);
		}
		else
		{
			if(opr=='pre' && currentCorr!=1)
				currentCorr=currentCorr-1;
			if(opr=='nex' && currentCorr<(corrCount-1))
				currentCorr=currentCorr+1;
			getPage(type,currentCorr);
		}
		setPageList();
	}
	function getPage(type,page)
	{
		var div=document.getElementById(type);
		if(page=='self')
		{
			page=parseInt(document.getElementById(type).value);
			if(type=='notePage')
				div=document.getElementById('noteDiv');
			else
				div=document.getElementById('corrDiv');
		}
		var ftsNumber =document.getElementById('ftsNo').innerHTML;
		if(type=='noteDiv' || type=='notePage')
		{
			currentNote=page;
			div.innerHTML='<object oncontextmenu="return false" style="height: 100%; width: 100%;" data="staticResources/pdfs/'+ftsNumber+'L@'+page+'L.pdf#toolbar=0"></object>';
		}
		else
		{
			currentCorr=page;
			div.innerHTML='<object oncontextmenu="return false" style="height: 100%; width: 100%;" data="staticResources/pdfs/'+ftsNumber+'R@'+page+'R.pdf#toolbar=0"></object>';
		}
		}
	function setPageList()
	{
		var notePage=document.getElementById('notePage');
		var corrPage=document.getElementById('corrPage');
		for(var i=0;i<noteCount;i++)
		{
			if(i==0)
				notePage.innerHTML='<option value="Select">Select</option>';
			else
				notePage.innerHTML=notePage.innerHTML+'<option value="'+i+'">'+i+'</option>'
		}
		for(var i=0;i<corrCount;i++)
		{
			if(i==0)
				corrPage.innerHTML='<option value="Select">Select</option>';
			else
				corrPage.innerHTML=corrPage.innerHTML+'<option value="'+i+'">'+i+'</option>'
		}
	}
	function downloadFile(pos,sno,right)
	{
		if(right==1)
			window.location="downloadFile?id="+pos+"&sno="+sno+"&department=Health";
	}
	function updateFile(sno,right)
	{
		if(right==1)
			window.location="updateFile?sno="+sno+"&department=Health";
	}
	function report(sno,right,flage)
	{
		if(right==1)
			document.getElementById('reportForm').submit();
	}
	function printConf(type)
	{
		printLr=type;
		document.getElementById('printConfModal').style.display='block';
	}
	function printFile(printType)
	{
		if(printType=='single')
		{
			if(printLr=='L')
				singlePrint('note');
			else
				singlePrint('corr');
		}
		else
			printOut(fileId,currentSno,printLr,currentAlloteeName);
	}
	function printOut(fileId,currentSno,printLr,currentAlloteeName)
	{
		
			var url="viewFile?id="+fileId+"&sno="+currentSno+"&department=Health&prFlage=print&name="+currentAlloteeName+"&lr="+printLr;
			setContent('Processing...');
			if(window.XMLHttpRequest)  
				request=new XMLHttpRequest();  
			else if(window.ActiveXObject)  
				request=new ActiveXObject("Microsoft.XMLHTTP");
			try
			{
				request.onreadystatechange=setPrint;
				request.open("GET",url,true);  
				request.send();
			}
			catch(e)
			{}
		
	}
	function setPrint()
	{
		if(request.readyState==4)
		{
			var id=request.responseText;
			document.getElementById('printDiv').innerHTML='<iframe id="pdf" src="staticResources/pdfs/'+id+'.pdf"></iframe>';
			var ifr=document.getElementById('pdf');
			document.getElementById('authModal').style.display='none';
			ifr.contentWindow.print();
		}
	}
	function singlePrint(type)
	{
		var contentDiv=document.getElementById('singlePrintDiv');
		if(type=='note')
			contentDiv.innerHTML='<iframe id="singlePdf" src="staticResources/pdfs/'+fileId+'L@'+currentNote+'L@print.pdf"></iframe>';
		else
			contentDiv.innerHTML='<iframe id="singlePdf" src="staticResources/pdfs/'+fileId+'R@'+currentCorr+'R@print.pdf"></iframe>';
		document.getElementById('singlePdf').contentWindow.print();
		}
	function firLas(type,page)
	{
		if(type=='noteDiv')
		{
			if(page=='fir')
				getPage(type,1);
			else
				getPage(type,noteCount-1);
		}
		else
		{
			if(page=='fir')
				getPage(type,1);
			else
				getPage(type,corrCount-1);
		}
	}
	function setContent(content)
	{
		document.getElementById('authContentPara').innerHTML=content;
		document.getElementById('authModal').style.display='block';
	}
</script>

<div id="id01" class="base-modal"
	style="display: none; z-index: 99999; margin: 0px; padding: 0px;">
	<a href="" style="font-size: 26px;"><span onclick="deleteFile();"
		style="float: right; color: red;"><b>&times;</b></span></a>
	<table style="width: 100%;">
		<tr>

			<td>
				<p
					style="margin-left: 42%; font-family: cambria; font-size: 18px; color: #ffffff;">Go
					To Page:</p>
				<button style="margin-left: 20%;" class="btn btn-primary"
					id="preButNote" onclick="firLas('noteDiv','fir');">First</button>
				<button class="btn btn-primary" id="preButNote"
					onclick="nexPre('noteDiv','pre');">Previous</button> <select
				style="width: 70px; height: 25px;" id="notePage"
				onchange="getPage('notePage','self');"></select>
				<button class="btn btn-primary" id="nexButNote"
					onclick="nexPre('noteDiv','nex');">Next</button>
				<button class="btn btn-primary" id="preButNote"
					onclick="firLas('noteDiv','las');">Last</button> <c:if
					test="${print=='1'}">
					<button class="btn btn-primary" style="margin-left: 20%;"
						onclick="printConf('L');">Print It</button>
				</c:if>
			</td>
			<td>
				<p
					style="margin-left: 42%; font-family: cambria; font-size: 18px; color: #ffffff;">Go
					To Page:</p>
				<button style="margin-left: 20%;" class="btn btn-primary"
					id="preButNote" onclick="firLas('corrDiv','fir');">First</button>
				<button class="btn btn-primary" id="preButCorr"
					onclick="nexPre('corrDiv','pre')">Previous</button> <select
				style="width: 70px; height: 25px;" id="corrPage"
				onchange="getPage('corrPage','self');"></select>
				<button class="btn btn-primary" onclick="nexPre('corrDiv','nex')"
					id="nexButCorr">Next</button>
				<button class="btn btn-primary" id="preButNote"
					onclick="firLas('corrDiv','las');">Last</button> <c:if
					test="${print=='1'}">
					<button class="btn btn-primary" style="margin-left: 20%;"
						onclick="printConf('R');">Print It</button>
				</c:if>
			</td>
		</tr>
	</table>
	<div id="noteDiv"
		class="base-modal-content base-card-8 base-animate-zoom"
		style="float: left; width: 50%; height: 90%;"></div>
	<div id="corrDiv"
		class="base-modal-content base-card-8 base-animate-zoom"
		style="float: left; width: 50%; height: 90%;"></div>
</div>

<div id="printModel" class="base-modal"
	style="display: none; z-index: 99999;">
	<a href="#"
		style="text-decoration: none; color: red; font-family: cambria; font-size: 20px;"><span
		onclick="deleteFile();"
		class="base-closebtn base-hover-red base-display-topright">Close
	</span></a>
	<div id="printDiv"
		class="base-modal-content base-card-8 base-animate-zoom"
		style="float: left; width: 50%; height: 99%;"></div>
</div>

<div id="singlePrintModal" class="modal"
	style="display: none; z-index: 100000;">
	<div class="modal-content">
		<div class="modal-header" style="background-color: #387403;"
			id="singlePrintDiv"></div>
	</div>
</div>

<div id="authModal" class="modal" style="display: none;">
	<div class="modal-content">
		<div class="modal-header" style="background-color: #387403;">
			<span class="close"
				onclick="document.getElementById('authModal').style.display='none'"
				style="color: #FFFFFF;">&times;</span>
			<p style="text-align: center; color: #ffffff;" class="h3"
				id="authContentPara"></p>
		</div>
	</div>
</div>

<div id="printConfModal" class="modal" style="display: none; z-index: 1000000;">
  	<div class="modal-content" style="width: 20%;">
    	<div class="modal-header" style="background-color: #387403;">
    		<span class="close" onclick="document.getElementById('printConfModal').style.display='none'" style="color: #FFFFFF;">&times;</span>
    		<table style="width: 100%;">
    			<tr><td colspan="2" align="center"><p style="text-align: center; color: #FFFFFF; margin-top: 0px; padding-top: 0px;" class="h3" id="printPara">Noting Print</p></td></tr>
    			<tr>
    				<td align="center"><button class="base-button base-round-large" style="background-color: #ffffff;" onclick="printFile('single')">Current Page</button></td>
    				<td align="center"><button class="base-button base-round-large" style="background-color: #ffffff;" onclick="printFile('cust')">Customize</button></td>
    			</tr>
    		</table>
    	</div>
  	</div>
</div>
<c:if test="${not empty msg}">
	<div id="modal" class="modal" style="display: block;">
		<div class="modal-content">
			<div class="modal-header" style="background-color: #387403;">
				<span class="close"
					onclick="document.getElementById('modal').style.display='none'"
					style="color: #FFFFFF;">&times;</span>
				<p style="text-align: center; color: #ffffff;" class="h3"
					id="contentPara">${msg}</p>
			</div>
		</div>
	</div>
</c:if>

<p class="h1"
	style="font-family: cambria; text-align: center; color: #387403;">Health</p>
<div style="margin-bottom: 0px; padding-bottom: 0px; margin-left: 1%;">
	<HealthForm:form action="retrieveHealth" id="HealthForm" method="get"
		modelAttribute="HealthForm">
		<table
			style="border-spacing: 20px; border-top: 0px; border-collapse: separate;">
			<tr>
				<td><label style="font-family: cambria;" for="Court Name"><h4>
							<b>File No:</b>
						</h4></label><br> <HealthForm:input style="width: 230px; height: 35px;"
						path="fileNo" id="fileNo" list="courtNameHelp"
						onkeyup="getHelp('courtName');" /> <datalist id="courtNameHelp"></datalist>
				</td>
				<td><label style="font-family: cambria;" for="WritPatitionNumber"><h4>
							<b>OPA FTS:</b>
						</h4></label><br> <HealthForm:input style="width: 230px; height: 35px;"
						id="opa_fts" path="opa_fts" list="writPatitionNumberHelp"
						onkeyup="getHelp('writPatitionNumber');" /> <datalist id="writPatitionNumberHelp"></datalist>
				</td>
				<td><label style="font-family: cambria;" for="Subject"><h4>
							<b>Work Name:</b>
						</h4></label><br> <HealthForm:input style="width: 230px; height: 35px;"
						id="workName" path="workName" list="subjectHelp"
						onkeyup="getHelp('subject');" /> <datalist id="subjectHelp"></datalist>
				</td>
				<td><label style="font-family: cambria;"
					for="Petitioner's Advocate"><h4>
							<b>Department:</b>
						</h4></label><br> <HealthForm:input style="width: 230px; height: 35px;"
						path="department" id="department" list="advocateNameHelp"
						onkeyup="getHelp('advocateName');" /> <datalist
						id="advocateNameHelp"></datalist></td>
				<td><label style="font-family: cambria;"
					for="Respondent's Advocate"><h4>
							<b>Sector:</b>
						</h4></label><br> <HealthForm:input style="width: 230px; height: 35px;"
						path="sector" id="sector" list="respondentAdvocateHelp"
						onkeyup="getHelp('respondentAdvocate');" /> <datalist
						id="respondentAdvocateHelp"></datalist></td>
			</tr>
			<tr>
				<td><label style="font-family: cambria;" for="Year"><h4>
							<b>Contr Name:</b>
						</h4></label><br> <HealthForm:input style="width: 230px; height: 35px;"
						id="contrName" path="contrName" list="yearHelp"
						onkeyup="getHelp('year');" /> <datalist id="yearHelp"></datalist>
				</td>
				<%-- <td>
            		<label style="font-family: cambria;" for="department"><h4><b>No_Of_Note_Sheet:</b></h4></label><br>
            		<HealthForm:input style="width: 230px; height: 35px;" id="no_Of_NoteSheet" path="no_Of_NoteSheet" list="relateddepartmentHelp" onkeyup="getHelp('relateddepartment');"/>
            		<datalist id="relateddepartmentHelp"></datalist>
            	</td> --%>
			</tr>
			<tr>
				<td><br> <br> <input class="btn btn-primary"
					style="background-color: #1B3AD1; color: #ffffff; font-size: 14px;"
					type="button" value="Retrieve Files" onclick="retrieveFiles();"></td>
			</tr>
		</table>
	</HealthForm:form>
</div>
<br>
<c:if test="${not empty records}">
	<form action="generateReport" id="reportForm" method="post">
		<input type="hidden" name="department" value="Health">
		<table id="fileTable" class="table display"
			style="margin-left: 1%; width: 99%;">
			<thead>
				<tr>
					<th></th>
					<th>SNo.</th>

					<th>Work Name</th>


					<th>File No</th>
					<th>Department</th>
					<th>Sector</th>
					<th>Contr Name</th>
					<th>FTS/OPA No</th>


					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${records}" var="record">
					<tr>
						<td><input type="checkbox" name="snos" value="${record.sno}"></td>
						<td>${record.sno}</td>
						<td><a href="#"
							onclick="updateFile('${record.sno}','${update}')"
							style="text-decoration: none;">${record.workName}</a></td>
						<%-- <td>${record.workName}</td>	 --%>

						<td>${record.fileNo}</td>
						<td>${record.department}</td>
						<td>${record.sector}</td>
						<td>${record.contrName}</td>
						<td>${record.opa_fts}</td>

						<%-- <td>${record.no_Of_NoteSheet}</td> --%>
						<%-- 	<td>${record.No_Of_Cros}</td> --%>
						<%-- <td>${record.Total_No_Of_Pages}</td> --%>
						<td><a href="#"
							onclick="viewFile('${record.opa_fts}','${record.sno}','${view}','${record.opa_fts}')"
							style="text-decoration: none;">View</a>&nbsp;&nbsp; <c:if
								test="${download=='1'}">
								<a href="#"
									onclick="downloadFile('${record.opa_fts}','${record.sno}','${download}');"
									style="text-decoration: none;">Download</a>&nbsp;&nbsp;</c:if> <c:if
								test="${print=='1'}">
								<a href="#"
									onclick="printOut('${record.opa_fts}','${record.sno}','${print}','${record.opa_fts}');"
									style="text-decoration: none;">Print</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input class="btn btn-primary"
			style="margin-left: 45%; margin-top: 5px; background-color: #1B3AD1; color: #ffffff;"
			type="button" onclick="report('','${report}','1')"
			value="Generate Report">
	</form>
</c:if>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
