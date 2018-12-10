<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<mtw:requiresAuthentication />

<%--<%@taglib prefix="s" uri="/struts-tags" %>--%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" href="resources/img/logo-p.png">
        <title>E-Vacina</title>

        <!--CSS PATH INICIO -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/css/style.css" rel="stylesheet">
        <link href="resources/css/upload-img-exibir.css.css" rel="stylesheet">
        <!--CSS PATH FIM -->

    </head>
    <body>


        <nav class="navbar navbar-expand-lg navbar-white bg-primary">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>



            <a class="navbar-brand" href="/">
                <img src="resources/static/img/logo-topo.png"  alt="">
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
                        <a href="home.mtw" title="Sair">
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
                                <a class="nav-link text-secondary" href="home.mtw">
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
                        <h1 class="h2">Local de Vacina</h1>

                    </div>
                    <div>

                        <nav class="navbar">
                            <div class="btn-group">
                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Selecionar Local</button>
                                <div class="dropdown-menu">
                                    <mtw:list value="listaLocais">
                                            <mtw:isEmpty>
                                                Você não possui pacientes na sua lista!
                                            </mtw:isEmpty>
                                            <mtw:loop var="l">
                                                <a onclick="getLocal('<mtw:out value="l.nome"/>')" class="dropdown-item" href="#"><mtw:out value="l.nome"/> - <mtw:out value="l.cidade"/> - <mtw:out value="l.uf"/></a>
                                            </mtw:loop>

                                        </mtw:list>
                                </div>
                                <span>&nbsp</span><span>&nbsp</span><span>&nbsp</span>
                                <input id="campoLocal" class="form-control mr-sm-2" type="search" size="100" placeholder="Local (READ ONLY)" aria-label="Search"  maxlength="120">
                                <span>&nbsp</span>
                                <a class="btn btn-sm btn-outline-primary" href="#">Confirmar Local</a>
                            </div>
                        </nav>





                        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                            <h1 class="h2">Pacientes</h1>
                            <div class="btn-toolbar mb-2 mb-md-0">
                                <div class="btn-group mr-2">



                                    <input class="form-control mr-sm-2" type="search" size="50" placeholder="Pesquisar Nome de Pacientes" aria-label="Search" autofocus maxlength="120">
                                    <button class="btn my-2 btn-outline-secondary my-sm-0" type="submit"><i class="fas fa-search"></i></button>
                                    <span>&nbsp</span>

                                    <a class="btn btn-sm btn-outline-secondary" href="adm-postagens-cadastrar.html">Novo Paciente</a>

                                </div>
                            </div>
                        </div>
                        <div>

                            <div class="table-responsive">
                                <table class="table table-striped table-sm">
                                    <thead>
                                        <tr>
                                            <th>Nº do SUS</th>
                                            <th>Nome do Paciente</th>
                                            <th>Sexo</th>
                                            <th>Data de Nascimento</th>
                                            <th>Funções</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <!-- LISTAR AQUI! -->
                                        <mtw:list value="listaPacientes">
                                            <mtw:isEmpty>
                                                Você não possui pacientes na sua lista!
                                            </mtw:isEmpty>
                                            <mtw:loop var="p">
                                                <tr>
                                                    <td><mtw:out value="p.sus"/></td>
                                                    <td><mtw:out value="p.nome"/></td>
                                                    <td><mtw:out value="p.sexo"/></td>
                                                    <td><mtw:out value="p.nascimento"/></td>
                                                    <td>
                                                        <a type="button" class="btn btn-outline-info btn-sm" href="<mtw:contextPath/>/atendente/paciente.vacinar_form.mtw?id=<mtw:out value="p.sus"/>"><i class="fas fa-syringe"></i></a>
                                                        <a type="button" class="btn btn-outline-danger btn-sm" href="<mtw:contextPath/>/atendente/paciente.consultar.mtw?id=<mtw:out value="p.sus"/>"><i class="fas fa-eye"></i></a>
                                                    </td>
                                                </tr>
                                            </mtw:loop>

                                        </mtw:list>
                                    </tbody>
                                </table>
                            </div>

                        </div>

                </main>

            </div>
        </div>

        <!--JAVASCRIPT PATH INICIO -->
        <script src="resources/js/jquery.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/funcoes.js"></script>
        <script src="/resources/js/upload-img-exibir.js"></script>
        <script defer src="resources/js/fontawesome-all.js"></script>
        <!--JAVASCRIPT PATH FIM -->

</html>
