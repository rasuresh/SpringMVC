<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
Spring MVC internationalization example

Language : <a href="?lang=en">English</a>|
<a href="?lang=zh_CN">Chinese</a>


welcome.springmvc : <spring:message code="welcome.springmvc" text="default text" />



Current Locale : ${pageContext.response.locale}

</body>
</html>