<%@include file="/WEB-INF/tiles/includes.jsp" %>
<html>
<head>
    <title>Member Management</title>
    <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    #listOfMembers tr:first-child{
        font-weight: bold;
    }
    </style>
</head>
 
<body>
     
    <h2><spring:message code="lbl.page.list" text="lbl.page.list" /></h2>
    <br/>
     
    <table id="listOfMembers" border="1">
    <tr>
        <td>ID</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Email</td>
        <td>Category</td>
      </tr>
    <c:forEach items="${allMembers}" var="member">   
      <tr>
        <td>${member.id}</td>
        <td>${member.firstName}</td>
        <td>${member.lastName}</td>
        <td>${member.email}</td>
        <td>${member.category.name}</td>
      </tr>
    </c:forEach>
    </table>
 
    <h2><spring:message code="lbl.page" text="Add New Member" /></h2>
    <br/>
    <form:form method="post" modelAttribute="member">
        <table>
            <tr>
                <td><spring:message code="lbl.firstName" text="First Name" /></td>
                <td><form:input path="firstName" /></td>
                <td><form:errors path="firstName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.lastName" text="Last Name" /></td>
                <td><form:input path="lastName" /></td>
                <td><form:errors path="lastName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.email" text="Email Id" /></td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.category" text="Category" /></td>
                <td><form:select path="category" items="${allCategories}" itemValue="id" itemLabel="name" /></td>
                <td><form:errors path="category" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Add Member"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
