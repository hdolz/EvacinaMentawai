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
        
        //pagina principal para exibir paciente  - modulo admin
        action("/admin/paciente", PacienteAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/paciente/exibir_paciente.jsp"));
        
        //pagina principal para exibir paciente  - modulo admin
        action("/admin/local", LocalAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/local/exibir_local.jsp"));
        
        //pagina principal para exibir paciente  - modulo admin
        action("/admin/vacina", VacinaAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/vacina/exibir_vacina.jsp"));
        
        //pagina principal para exibir paciente  - modulo admin
        action("/admin/atendente", AtendenteAction.class,"exibir")
                .on(SUCCESS, fwd("pages/admin/atendente/exibir_atendente.jsp"));
        
        
    }

}
