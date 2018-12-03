package br.ifam.manager;

import br.ifam.action.InserirAction;
import org.mentawai.core.ApplicationManager;

public class AppManager extends ApplicationManager {

    @Override
    public void loadActions() {

        action("/admin", InserirAction.class, "inserirPaciente")
                .on(SUCCESS, fwd("/admin/admin.jsp"));

    }

}
