/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.action.admin;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Atendente;
import java.util.List;
import static org.mentawai.core.Action.SUCCESS;
import org.mentawai.core.BaseAction;

/**
 *
 * @author hdolz
 */
public class AdminAtendenteAction extends BaseAction {
    //exibir pacientes do banco
    public String exibir() {
        output.setValue("listaAtendentes", getAtendentes());
        return SUCCESS;
    }
    
    public List<Atendente> getAtendentes(){
        GenericoDAO<Atendente> dao = new GenericoDAO<>();
        List<Atendente> atendentes = dao.findAll(Atendente.class);
        return atendentes;
    }

    public String cadastrar() {
        return SUCCESS;
    }
    
    public String inserir() {
        //recebe valores do formulario
        Long matricula = input.getLong("matricula");
        String nome = input.getString("nome");
        String senha = input.getString("senha");

        //salvar no banco usando generic DAO
        GenericoDAO<Atendente> dao = new GenericoDAO<>();
        Atendente atendente = new Atendente(matricula, nome, senha);
        dao.save(atendente);

        //passar nova lista para a view redirecionada
        output.setValue("listaAtendentes", getAtendentes());

        return SUCCESS;
    }
    
    public String editar_form(){
        Long id = input.getLong("id");
        GenericoDAO<Atendente> dao = new GenericoDAO<>();
        Atendente atendente = dao.findById(Atendente.class,id);
        output.setValue("id", atendente.getId());
        output.setValue("nome", atendente.getNome());
        output.setValue("senha", atendente.getSenha());
        return SUCCESS;
    }
    
    public String editar(){
        //recebe valores do formulario
        Long id = input.getLong("id");
        String nome = input.getString("nome");
        String senha = input.getString("senha");

        //salvar no banco usando generic DAO
        GenericoDAO<Atendente> dao = new GenericoDAO<>();
        Atendente atendente = new Atendente(id, nome, senha);
        dao.update(atendente);

        //passar nova lista para a view redirecionada
        output.setValue("listaAtendentes", getAtendentes());
        
        return SUCCESS;
    }
    
    public String deletar(){
        Long id = input.getLong("id");
        GenericoDAO<Atendente> dao = new GenericoDAO<>();
        dao.remove(Atendente.class,id);
        output.setValue("listaAtendentes", getAtendentes());
        return SUCCESS;
    }
}
