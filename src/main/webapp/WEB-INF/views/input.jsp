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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">
        <c:if test="${employee.id == null }">
            <!-- path 属性对应 html 表单标签的 name 属性值 -->
            LastName: <form:input path="lastName"/>
        </c:if>
        <c:if test="${employee.id != null }">
            <form:hidden path="id"/>
            <input type="hidden" name="_method" value="PUT"/>
            <%-- 对于 _method 不能使用 form:hidden 标签, 因为 modelAttribute 对应的 bean 中没有 _method 这个属性 --%>
            <%--
            <form:hidden path="_method" value="PUT"/>
            --%>
        </c:if>
        <br>
        email:<form:input path="email"/>
        <br>
        <%
            Map<String,String> genders = new HashMap<>();
            genders.put("1","Male");
            genders.put("0","Female");
            request.setAttribute("genders",genders);
        %>
        Gender:<form:radiobuttons path="gender" items="${genders}" delimiter="<br>"/>
        <br>
        Department:<form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id"/>
        <br>
        Birth:<form:input path="birth"/>
        <br>
        Salary:<form:input path="salary"/>
        <br>
        <input type="submit" value="Submit">
    </form:form>

</body>
</html>
