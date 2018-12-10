/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.action.atendente;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Atendente;
import br.ifam.modelo.Paciente;
import java.util.List;
import org.mentawai.action.BaseLoginAction;
import static org.mentawai.core.Action.ERROR;
import static org.mentawai.core.Action.SUCCESS;

/**
 *
 * @author hdolz
 */
public class LoginAtendenteAction extends BaseLoginAction{
    
    @Override
    public String execute() throws Exception {
        String nome = input.getString("nome");
        String senha = input.getString("senha");
         
        if (nome == null || nome.trim().equals("")) {
            return ERROR;
        }
         
        if (senha == null || senha.trim().equals("")) {
            return ERROR;
        }
        
        //consulta no banco
        
        GenericoDAO<Atendente> dao = new GenericoDAO<>();
        
        List<Atendente> result = dao.autenticar(Atendente.class, "nome", nome, "senha", senha);
        if(result.isEmpty()){
            System.out.println("USUARIO NAAAAOOOO  ENCONTRADO *******************");
            return ERROR;
        } else {
            System.out.println("USUARIO ENCONTRADO COM SUCESSO *******************");
            //define usuario na sessão
            output.setValue("userEmail", nome);
            setSessionObj(nome);
            return SUCCESS;
        }
    }
    
}
