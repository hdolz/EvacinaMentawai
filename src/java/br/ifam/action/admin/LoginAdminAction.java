/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.action.admin;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Administrador;
import java.util.List;
import org.mentawai.action.BaseLoginAction;

/**
 *
 * @author hdolz
 */
public class LoginAdminAction extends BaseLoginAction {
    @Override
    public String execute() throws Exception {
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
            output.setValue("userEmail", email);
            return SUCCESS;
        }
    }
}

