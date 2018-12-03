<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib prefix="s" uri="/struts-tags" %>--%>

<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" href="../resources/img/logo-p.png">
        <title>E-Vacina</title>

        <!--CSS PATH INICIO -->
        <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="../resources/css/style.css" rel="stylesheet">
        <link href="../resources/css/modal.css" rel="stylesheet">
        <!--CSS PATH FIM -->

    </head>



    <body>
        <!--TOPO INICIO -->
        <nav class="navbar navbar-expand-lg navbar-primary bg-white">

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>


            <a class="navbar-brand" href="/">
                <img src="../resources/img/logo-topo2.png" alt="">
            </a>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.html">Início
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">E-Vacina</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/consulta">Consulta</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Campanhas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Calendário</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">FAQ </a>
                    </li>
                </ul>
            </div>


            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <a href="/login"><button class="btn btn-outline-primary my-2 my-sm-0" type="submit">
                            <i class="fas fa-user-circle"></i> Login
                        </button></a>
                </ul>
            </div>

        </nav>
        <!--TOPO FIM -->


        <mtw:form action="admin.inserirPaciente.mtw" method="post">
            Inserir Paciente<br/>
            SUS: 
            <mtw:input type="text" name="sus" size="30" maxlength="30" /><br/>
            NOME: 
            <mtw:input type="text" name="nome" size="30" maxlength="30" /><br/>
            SEXO: 
            <mtw:input type="text" name="sexo" size="30" maxlength="30" /><br/>
            NASCIMENTO: 
            <mtw:input type="text" name="nascimento" size="30" maxlength="30" /><br/>
            <input type="submit" value="Inserir" />
        </mtw:form>



        <!--JAVASCRIPT PATH INICIO -->
        <script src="../resources/js/jquery.js"></script>
        <script src="../resources/js/bootstrap.min.js"></script>
        <script defer src="../resources/js/fontawesome-all.js"></script>
        <!--JAVASCRIPT PATH FIM -->

    </body>
</html>
</html>
