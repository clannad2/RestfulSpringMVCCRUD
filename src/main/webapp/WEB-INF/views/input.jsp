<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.lang.reflect.GenericArrayType" %><%--
  Created by IntelliJ IDEA.
  User: liuxiaoming
  Date: 20/9/29
  Time: 下午8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="emp" method="post">
        <%--path对应html表单的name属性值      --%>
        Last Name:<form:input path="lastName"/>
        <br>
        email:<form:input path="email"/>
        <br>
        <%
            Map<String,String> genders = new HashMap<>();
            genders.put("1","Male");
            genders.put("0","Female");
            request.setAttribute("genders",genders);
        %>
        Gender:<form:radiobuttons path="gender" items="${genders}"></form:radiobuttons>
        Department:<form:select path="department" items="${deparments}" itemLabel="id" itemValue="departmentName"></form:select>
        <input type="submit" value="submit">
    </form:form>

</body>
</html>
