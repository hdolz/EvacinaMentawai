/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.action.admin;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Local;
import br.ifam.modelo.Paciente;
import br.ifam.modelo.Vacina;
import java.util.List;
import static org.mentawai.core.Action.SUCCESS;
import org.mentawai.core.BaseAction;

/**
 *
 * @author hdolz
 */
public class AdminVacinaAction extends BaseAction {
    
    //exibir pacientes do banco
    public String exibir() {
        output.setValue("listaVacinas", getVacinas());
        return SUCCESS;
    }
    
    public List<Vacina> getVacinas(){
        GenericoDAO<Vacina> dao = new GenericoDAO<>();
        List<Vacina> vacinas = dao.findAll(Vacina.class);
        return vacinas;
    }

    public String cadastrar() {
        return SUCCESS;
    }
    
    public String inserir() {
        //recebe valores do formulario
        String nome = input.getString("nome");
        String descricao = input.getString("descricao");
        String lote = input.getString("lote");

        //salvar no banco usando generic DAO
        GenericoDAO<Vacina> dao = new GenericoDAO<>();
        Vacina vacina = new Vacina(nome, descricao,lote);
        dao.save(vacina);

        //passar nova lista para a view redirecionada
        output.setValue("listaVacinas", getVacinas());

        return SUCCESS;
    }
    
    public String editar_form(){
        Long id = input.getLong("id");
        GenericoDAO<Vacina> dao = new GenericoDAO<>();
        Vacina vacina = dao.findById(Vacina.class,id);
        output.setValue("id", vacina.getId());
        output.setValue("nome", vacina.getNome());
        output.setValue("descricao", vacina.getDescricao());
        output.setValue("lote", vacina.getLote());
        return SUCCESS;
    }
    
    public String editar(){
        //recebe valores do formulario
        Long id = input.getLong("id");
        String nome = input.getString("nome");
        String descricao = input.getString("descricao");
        String lote = input.getString("lote");

        //salvar no banco usando generic DAO
        GenericoDAO<Vacina> dao = new GenericoDAO<>();
        Vacina vacina = new Vacina(id, nome, descricao,lote);
        dao.update(vacina);

        //passar nova lista para a view redirecionada
        output.setValue("listaVacinas", getVacinas());
        
        return SUCCESS;
    }
    
    public String deletar(){
        Long id = input.getLong("id");
        GenericoDAO<Vacina> dao = new GenericoDAO<>();
        dao.remove(Vacina.class,id);
        output.setValue("listaVacinas", getVacinas());
        return SUCCESS;
    }
    
}
