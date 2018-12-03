/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.action.admin;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Administrador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.mentawai.core.Action.ERROR;
import static org.mentawai.core.Action.SUCCESS;
import org.mentawai.core.BaseAction;
import org.mentawai.filter.AuthenticationFree;

/**
 *
 * @author hdolz
 */
public class AuthAction extends BaseAction implements AuthenticationFree {
    
    @Override
    public String execute(){
        String result = ERROR;
        try {
            result = logout();
        } catch (Exception ex) {
            Logger.getLogger(AuthAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public String login() throws Exception {
        String email = input.getString("email");
        String senha = input.getString("senha");
         
        if (email == null || email.trim().equals("")) {
            return ERROR;
        }
         
        if (senha == null || senha.trim().equals("")) {
            return ERROR;
        }
        
        //consulta no banco
        
        GenericoDAO<Administrador> dao = new GenericoDAO<>();
        List<Administrador> result = dao.autenticar(Administrador.class, "email", email, "senha", senha);
        if(result.isEmpty()){
            System.out.println("USUARIO NAAAAOOOO  ENCONTRADO *******************");
            return ERROR;
        } else {
            System.out.println("USUARIO ENCONTRADO COM SUCESSO *******************");
            //define usuario na sessão
            setSessionObj(email);
            return SUCCESS;
        }
    }
    
    public String logout() throws Exception {
        session.reset();
        return SUCCESS;
    }
    
    @Override
    public boolean bypassAuthentication(String string) {
        return true;
    }
    
}
