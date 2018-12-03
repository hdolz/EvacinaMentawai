<%@page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h3>Paciente inserido!</h3><br>
        <mtw:out value="sus" />
        <mtw:out value="nome" />
        <mtw:out value="sexo" />
        <mtw:out value="nascimento" />
        
    </body>
</html>
