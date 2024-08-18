<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <section class="m-3">
        <c:if test="${not empty message}">
            <div class="alert alert-success text-center" role="alert">${message}</div>
        </c:if>
        <div class="row">
            <div class="col-12 text-center">
                <h2>Upload <c:out value="${dept}" /> Form</h2>
            </div>
        </div>
    
        <div class="row mt-4">
            <div class="col-12">
                <h5 class="font-weight-bold">User Details</h5>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/fileUpload/uploadForm/${dept}" modelAttribute="${formHandle}" method="post" enctype="multipart/form-data"
              style="border: 1px solid #ddd; padding: 20px; border-radius: 8px; background-color: #f9f9f9;">
            <div class="row">
                <div class="col-lg-4 col-md-5 col-6">
                    <label for="fileId">File Id</label>
                    <input id="fileId" name="fileId" class="form-control" required type="text">
                </div>

				<div class="col-12 col-md-6">
								<label class="form-label" for="folder">Select PDF Files :</label> <input
									type="file" multiple="multiple" name="folder" id="folder"
									accept=".pdf" class="form-control">
							</div>

            </div>

            <div class="row mt-4">
                <div class="col-12">
                    <h5 class="font-weight-bold">Details</h5>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-3 col-md-4 col-6">
                    <label for="volumeNo">Volume No</label>
                    <input id="volumeNo" name="volumeNo" class="form-control" required type="text">
                </div>

                <div class="col-lg-3 col-md-4 col-6">
                    <label for="BookNo">Book No</label>
                    <input id="BookNo" name="BookNo" class="form-control" required type="text">
                </div>

                <div class="col-lg-3 col-md-4 col-6">
                    <label for="PageFrom">Page From</label>
                    <input id="PageFrom" name="PageFrom" class="form-control" required type="text">
                </div>

                <div class="col-lg-3 col-md-4 col-6">
                    <label for="PageTo">Page To</label>
                    <input id="PageTo" name="PageTo" class="form-control" required type="text">
                </div>

                <input type="text" name="department" value="${dept}" hidden>

                <div class="col-lg-3 col-md-4 col-6">
                    <label for="dateOfRegistration">Date of Registration</label>
                    <input id="dateOfRegistration" name="dateOfRegistration" type="date" class="form-control" required>
                </div>

                <div class="col-lg-3 col-md-4 col-6">
                    <label for="documentType">Document Type</label>
                    <input id="documentType" name="documentType" type="text" class="form-control" required>
                </div>

                <div class="col-lg-3 col-md-4 col-6">
                    <label for="registrationDistrict">Registration District</label>
                    <input id="registrationDistrict" name="registrationDistrict" type="text" class="form-control" required>
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-12 text-center">
                    <button type="submit" class="btn btn-primary">Upload</button>
                </div>
            </div>
        </form>
    </section>
</body>
</html>
