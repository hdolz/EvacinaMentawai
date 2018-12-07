/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.action.admin;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Paciente;
import java.util.List;
import org.mentawai.core.BaseAction;

/**
 *
 * @author hdolz
 */
public class PacienteAction extends BaseAction {

    //exibir pacientes do banco
    public String exibir() {
        output.setValue("listaPacientes", getPacientes());
        return SUCCESS;
    }
    
    public List<Paciente> getPacientes(){
        GenericoDAO<Paciente> dao = new GenericoDAO<>();
        List<Paciente> pacientes = dao.findAll(Paciente.class);
        return pacientes;
    }

    public String cadastrar() {
        return SUCCESS;
    }
    
    public String inserir() {
        //recebe valores do formulario
        Long sus = input.getLong("sus");
        String nome = input.getString("nome");
        String sexo = input.getString("sexo");
        String nascimento = input.getString("nascimento");

        //salvar no banco usando generic DAO
        GenericoDAO<Paciente> dao = new GenericoDAO<>();
        Paciente paciente = new Paciente(sus, nome, sexo, nascimento);
        dao.save(paciente);

        //passar nova lista para a view redirecionada
        output.setValue("listaPacientes", getPacientes());

        return SUCCESS;
    }
    
    
}