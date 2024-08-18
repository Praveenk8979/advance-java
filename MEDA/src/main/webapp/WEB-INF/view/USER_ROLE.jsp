<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="isAdmin" value="false" />
<c:set var="isUser" value="false" />
<c:if test="${pageContext['request'].userPrincipal != null}">
	<c:forEach var="authority"
		items="${pageContext['request'].userPrincipal.principal.authorities}">
		<c:if test="${authority.authority eq 'ADMIN'}">
			<c:set var="isAdmin" value="true" />
		</c:if>
		<c:if test="${authority.authority eq 'USER'}">
			<c:set var="isUser" value="true" />
		</c:if>
	</c:forEach>
</c:if>