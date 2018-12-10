package br.ifam.manager;

import br.ifam.action.admin.AdminAction;
import br.ifam.action.admin.AdminAtendenteAction;
import br.ifam.action.admin.AdminLocalAction;
import br.ifam.action.admin.LoginAdminAction;
import br.ifam.action.admin.LogoutAdminAction;
import br.ifam.action.admin.AdminPacienteAction;
import br.ifam.action.admin.AdminVacinaAction;
import br.ifam.action.atendente.AtendenteAction;
import br.ifam.action.atendente.LoginAtendenteAction;
import org.mentawai.core.ApplicationManager;
import org.mentawai.filter.AuthenticationFilter;

//gerenciador da aplicação
public class AppManager extends ApplicationManager {

    @Override
    public void loadFilters() {
        //define filtro global para autenticação de usuario
        filter(new AuthenticationFilter());
        on(LOGIN, fwd("pages/login.jsp"));
    }

    @Override
    public void loadActions() {

        action("/", AdminAction.class)
                .on(SUCCESS, fwd("pages/home.jsp"));

        //leva para a página home do admin
        action("/admin", AdminAction.class)
                .filter(new AuthenticationFilter())//
                .on(LOGIN, fwd("pages/admin/login.jsp"))
                .on(SUCCESS, fwd("pages/admin/admin.jsp"))
                .on(ERROR, fwd("pages/admin/login.jsp"));
        
        //leva para a pagina home do atendente
        action("/atendente", AtendenteAction.class)
                .comeBackAfterLogin()
                .on(SUCCESS, fwd("pages/atendente/atendente.jsp"))
                .on(ERROR, fwd("pages/login.jsp"));

        //login do atendente
        action("/login", LoginAtendenteAction.class)
                .on(SUCCESS, fwd("/pages/atendente/atendente.jsp"))
                .on(ERROR, fwd("pages/login.jsp"));
        
        //login do admin
        action("/login", LoginAdminAction.class,"admin")
                .on(SUCCESS, fwd("/pages/admin/admin.jsp"))
                .on(ERROR, fwd("pages/admin/login.jsp"));

        //logout do admin
        action("/home", LogoutAdminAction.class)
                .on(SUCCESS, fwd("pages/home.jsp"));
        
        //****************************************************************************
        //links para as páginas de listagem das informações da referida funcionalidade
        //pagina principal para exibir paciente  - modulo admin
        action("/admin/paciente", AdminPacienteAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/paciente/exibir_paciente.jsp"));
        
        //pagina principal para exibir atendente  - modulo admin
        action("/admin/atendente", AdminAtendenteAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/atendente/exibir_atendente.jsp"));
        
        //pagina principal para exibir vacina  - modulo admin
        action("/admin/vacina", AdminVacinaAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/vacina/exibir_vacina.jsp"));
        
        //pagina principal para exibir local  - modulo admin
        action("/admin/local", AdminLocalAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/local/exibir_local.jsp"));
        
        //****************************************************************************
        //links para a pagina com formulario de cadastro
        //pagina cadastrar paciente - modulo admin
        action("/admin/paciente", AdminPacienteAction.class,"cadastrar")
                .on(SUCCESS, fwd("pages/admin/paciente/cadastrar_paciente.jsp"));
        
        //pagina cadastrar atendente - modulo admin
        action("/admin/atendente", AdminAtendenteAction.class,"cadastrar")
                .on(SUCCESS, fwd("pages/admin/atendente/cadastrar_atendente.jsp"));
        
        //pagina cadastrar paciente - modulo admin
        action("/admin/vacina", AdminVacinaAction.class,"cadastrar")
                .on(SUCCESS, fwd("pages/admin/vacina/cadastrar_vacina.jsp"));
        
        //pagina cadastrar local - modulo admin
        action("/admin/local", AdminLocalAction.class,"cadastrar")
                .on(SUCCESS, fwd("pages/admin/local/cadastrar_local.jsp"));
        
        
        //****************************************************************************
        //link para efetivar a captura dos dados dos formularios de cadastro
        //form cadastrar paciente - modulo admin
        action("/admin/paciente", AdminPacienteAction.class,"inserir")
                .on(SUCCESS, fwd("pages/admin/paciente/exibir_paciente.jsp"));
        
        action("/admin/atendente", AdminAtendenteAction.class,"inserir")
                .on(SUCCESS, fwd("pages/admin/atendente/exibir_atendente.jsp"));
        
        action("/admin/vacina", AdminVacinaAction.class,"inserir")
                .on(SUCCESS, fwd("pages/admin/vacina/exibir_vacina.jsp"));
        
        action("/admin/local", AdminLocalAction.class,"inserir")
                .on(SUCCESS, fwd("pages/admin/local/exibir_local.jsp"));
        
        //****************************************************************************
        //links para deletar - modulo Admin
        action("/admin/paciente", AdminPacienteAction.class,"deletar")
                .on(SUCCESS, fwd("pages/admin/paciente/exibir_paciente.jsp"));
        
        action("/admin/atendente", AdminAtendenteAction.class,"deletar")
                .on(SUCCESS, fwd("pages/admin/atendente/exibir_atendente.jsp"));
        
        action("/admin/vacina", AdminVacinaAction.class,"deletar")
                .on(SUCCESS, fwd("pages/admin/vacina/exibir_vacina.jsp"));
        
        action("/admin/local", AdminLocalAction.class,"deletar")
                .on(SUCCESS, fwd("pages/admin/local/exibir_local.jsp"));
        //****************************************************************************
        //links para formularios de edição - modulo Admin
        action("/admin/paciente", AdminPacienteAction.class,"editar_form")
                .on(SUCCESS, fwd("pages/admin/paciente/editar_paciente.jsp"));
        
        //pagina editar atendente - modulo admin
        action("/admin/atendente", AdminAtendenteAction.class,"editar_form")
                .on(SUCCESS, fwd("pages/admin/atendente/editar_atendente.jsp"));
        
        //pagina editar paciente - modulo admin
        action("/admin/vacina", AdminVacinaAction.class,"editar_form")
                .on(SUCCESS, fwd("pages/admin/vacina/editar_vacina.jsp"));
        
        //pagina editar local - modulo admin
        action("/admin/local", AdminLocalAction.class,"editar_form")
                .on(SUCCESS, fwd("pages/admin/local/editar_local.jsp"));
        //***************************************************************************
        //links para edição - modulo Admin
        action("/admin/paciente", AdminPacienteAction.class,"editar")
                .on(SUCCESS, fwd("pages/admin/paciente/exibir_paciente.jsp"));
        
        action("/admin/atendente", AdminAtendenteAction.class,"editar")
                .on(SUCCESS, fwd("pages/admin/atendente/exibir_atendente.jsp"));
        
        action("/admin/vacina", AdminVacinaAction.class,"editar")
                .on(SUCCESS, fwd("pages/admin/vacina/exibir_vacina.jsp"));
        
        action("/admin/local", AdminLocalAction.class,"editar")
                .on(SUCCESS, fwd("pages/admin/local/exibir_local.jsp"));
        
        //**************************************************************************
        action("/atendente/paciente", AtendenteAction.class,"vacinar_form")
                .on(SUCCESS, fwd("pages/atendente/paciente_vacinar.jsp"));
        
        action("/atendente/paciente", AtendenteAction.class,"vacinar")
                .on(SUCCESS, fwd("pages/atendente/atendente.jsp"));
        
        action("/atendente/paciente", AtendenteAction.class,"consultar")
                .on(SUCCESS, fwd("pages/atendente/paciente_consultar.jsp"));
        
    }

}
