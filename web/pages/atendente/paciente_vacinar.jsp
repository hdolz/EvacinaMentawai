<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<mtw:requiresAuthentication />

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" href="../resources/img/logo-p.png">
        <title>E-Vacinas</title>

        <!--CSS PATH INICIO -->
        <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="../resources/css/style.css" rel="stylesheet">
        <link href="../resources/css/upload-img-exibir.css" rel="stylesheet">
        <!--CSS PATH FIM -->

    </head>

    <body>

        <nav class="navbar navbar-expand-lg navbar-white bg-primary">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>


            <a class="navbar-brand" href="/">
                <img src="../resources/img/logo-topo.png"  alt="">
            </a>


            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <h4 class="text-light">
                        Console de Vacinação
                    </h4>
                </ul>
            </div>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">

                    <li class="nav-item">
                        <a href="#" title="Usuário">
                            <button class="btn btn-outline-light my-2 my-sm-0">
                                <i class="far fa-user-circle"></i>
                                <i> Nome Usuário </i>
                            </button>
                        </a>
                    </li>

                    <li>&nbsp</li>

                    <li class="nav-item">
                        <a href="<mtw:contextPath/>/home.mtw" title="Sair">
                            <button class="btn btn-outline-light my-2 my-sm-0">
                                <i class="fas fa-sign-out-alt"></i>
                            </button>
                        </a>
                    </li>

                </ul>
            </div>

        </nav>

        <!--MENU LATERAL INICIO -->
        <div class="container-fluid">
            <div class="row">
                <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                    <div class="sidebar-sticky">

                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link active text-secondary" href="<mtw:contextPath/>/atendente.mtw">
                                    <i class="fas fa-home"></i>
                                    &nbspInício <span class="sr-only">(current)</span>
                                </a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link text-secondary" href="<mtw:contextPath/>/home.mtw">
                                    <i class="fas fa-sign-out-alt"></i>
                                    Sair
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <!--MENU LATERAL FIM -->

                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">Vacinar Paciente</h1>
                        <div class="btn-toolbar mb-2 mb-md-0">
                        </div>
                    </div>

                    <div>
                        
                        <mtw:form action="atendente/paciente.vacinar.mtw" method="post">
                            <div class="form-group">
                                <label>Nome do Paciente</label>
                                <mtw:input type="text" name="nomePaciente" size="30" maxlength="30"/>
                            </div>
                            
                            <div class="form-group">
                                <label>Nome da Vacina</label>
                                <nav class="navbar">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Selecionar Vacina</button>
                                        <div class="dropdown-menu">
                                            <mtw:list value="listaVacinas">
                                            <mtw:isEmpty>
                                                Você não possui pacientes na sua lista!
                                            </mtw:isEmpty>
                                            <mtw:loop var="v">
                                                <a href="#" onclick="getVacina('<mtw:out value="v.nome"/>')" class="dropdown-item"><mtw:out value="v.nome"/></a>
                                            </mtw:loop>

                                        </mtw:list>
                                        </div>
                                        <span>&nbsp</span><span>&nbsp</span><span>&nbsp</span>
                                        <mtw:input id="campoVacina" type="text" name="vacina" size="30" maxlength="30" />
                                    </div>
                                </nav>
                            </div>
                            
                            <div class="form-group">
                                <label>Dose</label>
                                <nav class="navbar">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Selecionar Dose</button>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item" onclick="getDose('Dose Única')" href="#">Dose Única</a>
                                            <a class="dropdown-item" onclick="getDose('1º Dose')" href="#">1º Dose</a>
                                            <a class="dropdown-item" onclick="getDose('2º Dose')" href="#">2º Dose</a>
                                            <a class="dropdown-item" onclick="getDose('3º Dose')" href="#">3º Dose</a>
                                            <a class="dropdown-item" onclick="getDose('1º Reforço')" href="#">1º Reforço</a>
                                            <a class="dropdown-item" onclick="getDose('2º Reforço')" href="#">2º Reforço</a>
                                        </div>
                                        <span>&nbsp</span><span>&nbsp</span><span>&nbsp</span>
                                        <mtw:input id="campoDose" type="text" name="dose" size="30" maxlength="30" />
                                    </div>
                                </nav>
                            </div>
                            <button type="submit" class="btn btn-outline-primary">Confirmar Vacina</button>
                        </mtw:form>

                    </div>
                </main>

            </div>
        </div>


        <!--JAVASCRIPT PATH INICIO -->
        <script src="../resources/js/jquery.js"></script>
        <script src="../resources/js/bootstrap.min.js"></script>
        <script src="../resources/js/funcoes.js"></script>
        <script src="../resources/js/upload-img-exibir.js"></script>
        <script defer src="../resources/js/fontawesome-all.js"></script>
        <!--JAVASCRIPT PATH FIM -->


    </body>
</html>
