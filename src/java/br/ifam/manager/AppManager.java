package br.ifam.manager;

import br.ifam.action.admin.AdminAction;
import br.ifam.action.admin.AtendenteAction;
import br.ifam.action.admin.LocalAction;
import br.ifam.action.admin.LoginAdminAction;
import br.ifam.action.admin.LogoutAdminAction;
import br.ifam.action.admin.PacienteAction;
import br.ifam.action.admin.VacinaAction;
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
                .comeBackAfterLogin()
                .on(SUCCESS, fwd("pages/admin/admin.jsp"))
                .on(ERROR, fwd("pages/login.jsp"));

        //login do admin
        action("/login", LoginAdminAction.class)
                .on(SUCCESS, fwd("/pages/admin.jsp"))
                .on(ERROR, fwd("pages/login.jsp"));

        //logout do admin
        action("/home", LogoutAdminAction.class)
                .on(SUCCESS, fwd("pages/home.jsp"));
        
        //****************************************************************************
        //links para as páginas de listagem das informações da referida funcionalidade
        //pagina principal para exibir paciente  - modulo admin
        action("/admin/paciente", PacienteAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/paciente/exibir_paciente.jsp"));
        
        //pagina principal para exibir atendente  - modulo admin
        action("/admin/atendente", AtendenteAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/atendente/exibir_atendente.jsp"));
        
        //pagina principal para exibir vacina  - modulo admin
        action("/admin/vacina", VacinaAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/vacina/exibir_vacina.jsp"));
        
        //pagina principal para exibir local  - modulo admin
        action("/admin/local", LocalAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/local/exibir_local.jsp"));
        
        //****************************************************************************
        //links para a pagina com formulario de cadastro
        //pagina cadastrar paciente - modulo admin
        action("/admin/paciente", PacienteAction.class,"cadastrar")
                .on(SUCCESS, fwd("pages/admin/paciente/cadastrar_paciente.jsp"));
        
        //pagina cadastrar atendente - modulo admin
        action("/admin/atendente", AtendenteAction.class,"cadastrar")
                .on(SUCCESS, fwd("pages/admin/atendente/cadastrar_atendente.jsp"));
        
        //pagina cadastrar paciente - modulo admin
        action("/admin/vacina", VacinaAction.class,"cadastrar")
                .on(SUCCESS, fwd("pages/admin/vacina/cadastrar_vacina.jsp"));
        
        //pagina cadastrar local - modulo admin
        action("/admin/local", LocalAction.class,"cadastrar")
                .on(SUCCESS, fwd("pages/admin/local/cadastrar_local.jsp"));
        
        
        //****************************************************************************
        //link para efetivar a captura dos dados dos formularios de cadastro
        //form cadastrar paciente - modulo admin
        action("/admin/paciente", PacienteAction.class,"inserir")
                .on(SUCCESS, fwd("pages/admin/paciente/exibir_paciente.jsp"));
        
        action("/admin/atendente", AtendenteAction.class,"inserir")
                .on(SUCCESS, fwd("pages/admin/atendente/exibir_atendente.jsp"));
        
        action("/admin/vacina", VacinaAction.class,"inserir")
                .on(SUCCESS, fwd("pages/admin/vacina/exibir_vacina.jsp"));
        
        action("/admin/local", LocalAction.class,"inserir")
                .on(SUCCESS, fwd("pages/admin/local/exibir_local.jsp"));
        
        //****************************************************************************
        //links para deletar - modulo Admin
        action("/admin/paciente", PacienteAction.class,"deletar")
                .on(SUCCESS, fwd("pages/admin/paciente/exibir_paciente.jsp"));
        
        action("/admin/atendente", AtendenteAction.class,"deletar")
                .on(SUCCESS, fwd("pages/admin/atendente/exibir_atendente.jsp"));
        
        action("/admin/vacina", VacinaAction.class,"deletar")
                .on(SUCCESS, fwd("pages/admin/vacina/exibir_vacina.jsp"));
        
        action("/admin/local", LocalAction.class,"deletar")
                .on(SUCCESS, fwd("pages/admin/local/exibir_local.jsp"));
        //****************************************************************************
        //links para formularios de edição - modulo Admin
        action("/admin/paciente", PacienteAction.class,"editar_form")
                .on(SUCCESS, fwd("pages/admin/paciente/editar_paciente.jsp"));
        
        //pagina editar atendente - modulo admin
        action("/admin/atendente", AtendenteAction.class,"editar_form")
                .on(SUCCESS, fwd("pages/admin/atendente/editar_atendente.jsp"));
        
        //pagina editar paciente - modulo admin
        action("/admin/vacina", VacinaAction.class,"editar_form")
                .on(SUCCESS, fwd("pages/admin/vacina/editar_vacina.jsp"));
        
        //pagina editar local - modulo admin
        action("/admin/local", LocalAction.class,"editar_form")
                .on(SUCCESS, fwd("pages/admin/local/editar_local.jsp"));
        //***************************************************************************
        //links para edição - modulo Admin
        action("/admin/paciente", PacienteAction.class,"editar")
                .on(SUCCESS, fwd("pages/admin/paciente/exibir_paciente.jsp"));
        
        action("/admin/atendente", AtendenteAction.class,"editar")
                .on(SUCCESS, fwd("pages/admin/atendente/exibir_atendente.jsp"));
        
        action("/admin/vacina", VacinaAction.class,"editar")
                .on(SUCCESS, fwd("pages/admin/vacina/exibir_vacina.jsp"));
        
        action("/admin/local", LocalAction.class,"editar")
                .on(SUCCESS, fwd("pages/admin/local/exibir_local.jsp"));
        
    }

}
