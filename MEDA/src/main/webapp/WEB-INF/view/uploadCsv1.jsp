<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="m-3">
    <!-- Display message if available -->
    <c:if test="${not empty message}">
        <div class="alert alert-warning text-center" role="alert">${message}</div>
    </c:if>

    <div class="row">
        <div class="col-12 text-center">
            <h2>Bulk Upload</h2>
        </div>
    </div>
	
	<div class="row mb-3">
				           <!-- Download button positioned at the top -->
				           <div class="col-12 text-left">
				               <a href="${pageContext.request.contextPath}/api/csvTemplate_upload" 
				                  class="btn btn-secondary mb-3" role="button">
				                   Download CSV Template
				               </a>
				           </div>
				       </div>

    <form action="${pageContext.request.contextPath}/uploadCsv1"
          method="POST" class="mx-1 mx-md-4" enctype="multipart/form-data">

       

        <div class="row">
			
            <!-- Department dropdown and file input aligned side by side -->
            <div class="col-12 col-md-6">
                <div class="form-group">
                    <label for="departmentSelect">Select Department:</label>
                    <select id="departmentSelect" name="department" class="form-control">
                        <option value="IT">IT Department</option>
                        <option value="Sales">Sales Department</option>
                        <option value="HR">HR Department</option>
                        <option value="Finance">Finance Department</option>
                         Add more options here as needed 
                    </select>
                </div>
            </div>

            <div class="col-10 col-md-6">
                <div class="form-group">
                    <label class="form-label" for="csv">Select CSV File:</label>
                    <input type="file" name="file" id="csv" accept=".csv" class="form-control" required>
                </div>
            </div>
        </div>

        <div class="row m-3">
            <div class="col-12 text-center">
                <button class="btn btn-primary">Upload</button>
            </div>
        </div>
    </form>

    <!-- Display error message and download link if applicable -->
    <c:if test="${err eq '1'}">
        <div class="row">
            <div class="col-12 text-center">
                <h4 class="text-danger">${msg}</h4>
                <a href="${pageContext.request.contextPath}/downloadError1" 
                   class="btn btn-danger">
                    Download Error File
                </a>
            </div>
        </div>
    </c:if>

	    
</section>
<script>
	            
	        </script>

