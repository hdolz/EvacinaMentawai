<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib prefix="s" uri="/struts-tags" %>--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" href="resources/img/logo-p.png">
        <title>E-Vacina</title>

        <!--CSS PATH INICIO -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/css/style.css" rel="stylesheet">
        <link href="resources/css/modal.css" rel="stylesheet">
        <!--CSS PATH FIM -->
    </head>
    <body>
        
        <!-- Form de Login -->
        <h2>LOGIN</h2>
    <mtw:form action="login.mtw" method="post">
        <div class="form-group">
            <label>Email</label>
            <mtw:input type="text" name="email" size="30" maxlength="30" />
        </div>
        <div class="form-group">
            <label>Senha</label>
            <mtw:input type="text" name="senha" size="30" maxlength="30" />
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </mtw:form>



        
        <!--JAVASCRIPT PATH INICIO -->
        <script src="resources/js/jquery.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script defer src="resources/js/fontawesome-all.js"></script>
        <!--JAVASCRIPT PATH FIM -->

    </body>
</html>
</html>
