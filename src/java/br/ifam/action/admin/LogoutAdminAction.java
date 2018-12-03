/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.action.admin;

import org.mentawai.core.BaseAction;
import org.mentawai.filter.AuthenticationFree;

/**
 *
 * @author hdolz
 */
public class LogoutAdminAction extends BaseAction implements AuthenticationFree{

    protected void logout() {
        session.reset();
    }
     
    @Override
    public String execute() throws Exception {
        logout();
        return SUCCESS;
    }
     
    @Override
    public boolean bypassAuthentication(String innerAction) {
        
       return true;
    }
    
}
