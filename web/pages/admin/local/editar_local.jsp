<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<mtw:requiresAuthentication />


<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" href="../resources/img/logo-p.png">
        <!-- Bootstrap css link externo -->
        <!--
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        -->

        <title>E-Vacina</title>

        <!--CSS PATH INICIO -->
        <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="../resources/css/style.css" rel="stylesheet">
        <link href="../resources/css/upload-img-exibir.css.css" rel="stylesheet">
        <!--CSS PATH FIM -->

        <!--  -->


    </head>

    <body>

        <nav class="navbar navbar-expand-lg navbar-white bg-primary">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>


            <a class="navbar-brand" href="<mtw:contextPath/>/">
                <img src="../resources/img/logo-topo.png"  alt="">
            </a>

            <div class="collapse navbar-collapse" id="">
                <ul class="navbar-nav ml-auto">
                    <h4 class="text-light">
                        Console de Administração
                    </h4>
                </ul>
            </div>



            <div class="collapse navbar-collapse" id="">
                <ul class="navbar-nav ml-auto">

                    <li class="nav-item">
                        <a href="#" title="Usuário">
                            <button class="btn btn-outline-light my-2 my-sm-0">
                                <i class="far fa-user-circle"></i>
                                <i> <mtw:out value="userEmail" /> </i>
                            </button>
                        </a>
                    </li>

                    <li>&nbsp</li>

                    <li class="nav-item">
                        <a href="home.mtw">
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
                                <a class="nav-link active text-secondary" href="<mtw:contextPath/>/admin.mtw">
                                    <i class="fas fa-home"></i>
                                    &nbspInício <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-secondary" href="<mtw:contextPath/>/admin/paciente.exibir.mtw">
                                    <i class="fas fa-users"></i>
                                    Pacientes
                                </a>
                            <li class="nav-item">
                                <a class="nav-link text-secondary" href="<mtw:contextPath/>/admin/vacina.exibir.mtw">
                                    <i class="fas fa-syringe"></i>
                                    &nbspVacinas
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-secondary" href="<mtw:contextPath/>/admin/local.exibir.mtw">
                                    <i class="far fa-hospital"></i>
                                    &nbspLocais de Vacina
                                </a>
                            </li>
                            <%--<li class="nav-item">--%>
                            <%--<a class="nav-link text-secondary" href="#">--%>
                            <%--<i class="fas fa-chart-line"></i>--%>
                            <%--Estatísticas--%>
                            <%--</a>--%>
                            <%--</li>--%>
                            <li class="nav-item">
                                <a class="nav-link text-secondary" href="<mtw:contextPath/>/admin/atendente.exibir.mtw">
                                    <i class="fas fa-user-circle"></i>
                                    Atendente
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
                        <h1 class="h2">Locais</h1>
                        <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="btn-group mr-2">


                                <form action="/pesquisaPaciente" method="get" class="form-inline">
                                    <input class="form-control mr-sm-2" type="search" size="50" name="tfPesquisar" placeholder="Pesquisar locais" aria-label="Search" autofocus maxlength="120">
                                    <button class="btn my-2 btn-outline-secondary my-sm-0" type="submit"><i class="fas fa-search"></i></button>

                                </form>
                                <span>&nbsp</span>
                                <a class="btn btn-sm btn-outline-secondary" href="<mtw:contextPath/>/admin/local.cadastrar.mtw">Novo Local</a>

                            </div>
                        </div>
                    </div>
                    <div>
                        <mtw:form action="admin/local.editar.mtw" method="post">
                            <div class="form-group">
                                <label>ID</label>
                                <mtw:input type="text" name="id" size="30" maxlength="30" />
                            </div>
                            <div class="form-group">
                                <label>Nome do Local</label>
                                <mtw:input type="text" name="nome" size="30" maxlength="30" />
                            </div>
                            <div class="form-group">
                                <label>Cidade</label>
                                <mtw:input type="text" name="cidade" size="30" maxlength="30" />
                            </div>
                            <div class="form-group">
                                <label>UF</label>
                                <mtw:input type="text" name="uf" size="30" maxlength="30" />
                            </div>

                            <button type="submit" class="btn btn-primary">Salvar</button>
                        </mtw:form>
                    </div>
                </main>



                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h2">Bem Vindo !!</h1>
                    <div class="btn-toolbar mb-2 mb-md-0">
                        <div class="btn-group mr-2">
                        </div>
                    </div>
                </div>
                

                <!--JAVASCRIPT PATH INICIO -->
                <script src="../resources/js/jquery.js"></script>
                <script src="../resources/js/bootstrap.min.js"></script>
                <script src="../resources/js/upload-img-exibir.js"></script>
                <script defer src="../resources/js/fontawesome-all.js"></script>
                <!--JAVASCRIPT PATH FIM -->

                <!-- Bootstrap js link externo -->
                <!--
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
                -->

                </body>

                </html>
