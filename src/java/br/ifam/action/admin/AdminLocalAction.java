/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.action.admin;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Local;
import java.util.List;
import static org.mentawai.core.Action.SUCCESS;
import org.mentawai.core.BaseAction;

/**
 *
 * @author hdolz
 */
public class AdminLocalAction extends BaseAction{
    //exibir pacientes do banco
    public String exibir() {
        output.setValue("listaLocais", getLocais());
        return SUCCESS;
    }
    
    public List<Local> getLocais(){
        GenericoDAO<Local> dao = new GenericoDAO<>();
        List<Local> locais = dao.findAll(Local.class);
        return locais;
    }

    public String cadastrar() {
        return SUCCESS;
    }
    
    public String inserir() {
        //recebe valores do formulario
        String nome = input.getString("nome");
        String cidade = input.getString("cidade");
        String uf = input.getString("uf");

        //salvar no banco usando generic DAO
        GenericoDAO<Local> dao = new GenericoDAO<>();
        Local local = new Local(nome, cidade,uf);
        dao.save(local);

        //passar nova lista para a view redirecionada
        output.setValue("listaLocais", getLocais());

        return SUCCESS;
    }
    
    public String editar_form(){
        Long id = input.getLong("id");
        GenericoDAO<Local> dao = new GenericoDAO<>();
        Local local = dao.findById(Local.class,id);
        output.setValue("id", local.getId());
        output.setValue("nome", local.getNome());
        output.setValue("cidade", local.getCidade());
        output.setValue("uf", local.getUf());
        return SUCCESS;
    }
    
    public String editar(){
        //recebe valores do formulario
        Long id = input.getLong("id");
        String nome = input.getString("nome");
        String cidade = input.getString("cidade");
        String uf = input.getString("uf");

        //salvar no banco usando generic DAO
        GenericoDAO<Local> dao = new GenericoDAO<>();
        Local local = new Local(id, nome, cidade,uf);
        dao.update(local);

        //passar nova lista para a view redirecionada
        output.setValue("listaLocais", getLocais());
        
        return SUCCESS;
    }
    
    public String deletar(){
        Long id = input.getLong("id");
        GenericoDAO<Local> dao = new GenericoDAO<>();
        dao.remove(Local.class,id);
        output.setValue("listaLocais", getLocais());
        return SUCCESS;
    }
}
