package br.ifam.manager;

import br.ifam.action.admin.AdminAction;
import br.ifam.action.admin.AuthAction;
import br.ifam.action.admin.LoginAdminAction;
import br.ifam.action.admin.LogoutAdminAction;
import org.mentawai.core.ApplicationManager;
import org.mentawai.filter.AuthenticationFilter;

//gerenciador da aplicação
public class AppManager extends ApplicationManager {

    @Override
    public void loadFilters() {

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
                .on(SUCCESS, fwd("/pages/admin/admin.jsp"))
                .on(ERROR, fwd("pages/login.jsp"));

        //logout do admin
        action("/home", LogoutAdminAction.class)
                .on(SUCCESS, fwd("pages/home.jsp"));

    }

}
