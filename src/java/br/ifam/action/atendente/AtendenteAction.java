/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifam.action.atendente;

import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Local;
import br.ifam.modelo.Paciente;
import br.ifam.modelo.Vacina;
import br.ifam.modelo.Vacinacao;
import java.util.List;
import org.mentawai.core.BaseAction;

/**
 *
 * @author hdolz
 */
public class AtendenteAction extends BaseAction {
    @Override
    public String execute(){
        output.setValue("listaPacientes", getPacientes());
        output.setValue("listaLocais", getLocais());
        return SUCCESS;
    }
    
    public String vacinar_form(){
        long id = input.getLong("id");
        GenericoDAO<Paciente> dao = new GenericoDAO<>();
        Paciente paciente = dao.findById(Paciente.class, id);
        
        //retornar lista de vacina existentes
        GenericoDAO<Vacina> daoVacina = new GenericoDAO<>();
        List<Vacina> vacinas = daoVacina.findAll(Vacina.class);
        output.setValue("listaVacinas", vacinas);
        
        //retorna nome do paciente para pagina de vacinação
        output.setValue("nomePaciente", paciente.getNome());
        return SUCCESS;
    }
    
    public String vacinar(){
        Long id = input.getLong("id");
        String nomePaciente = input.getString("nomePaciente");
        String vacinaNome = input.getString("vacina");
        String dose = input.getString("dose");
        
        System.out.println("ID :  "+id);
        System.out.println("Vacina :  "+vacinaNome);
        System.out.println("Dose :  "+dose);
        
        GenericoDAO<Paciente> daoPaciente = new GenericoDAO<>();
        List<Paciente> pacientes = daoPaciente.findByNome(Paciente.class,nomePaciente,"nome");
        
        //pegar objeto vacina
        GenericoDAO<Vacina> daoVacina = new GenericoDAO<>();
        List<Vacina> vacinas = daoVacina.findByNome(Vacina.class,vacinaNome,"nome");
        vacinas.forEach(elem -> {
            System.out.println("Vacina: ----->> "+elem.getNome()
            +" index: "+elem.getId());
        });
        //data, dose, paciente, vacina
        
        //adicionar vacinação no banco
        Vacinacao vac = new Vacinacao("01/01/2018",dose, vacinas.get(0),pacientes.get(0));
        GenericoDAO<Vacinacao> daoVacinacao = new GenericoDAO<>();
        daoVacinacao.save(vac);
        
        
        output.setValue("listaPacientes", getPacientes());
        output.setValue("listaLocais", getLocais());
        
        return SUCCESS;
    }
    
    public String consultar(){
        Long id = input.getLong("id");
        GenericoDAO<Paciente> daoPaciente = new GenericoDAO<>();
        Paciente paciente = daoPaciente.findById(Paciente.class, id);
        
        output.setValue("nome", paciente.getNome());
        output.setValue("sus", paciente.getSus());
        output.setValue("sexo", paciente.getSexo());
        output.setValue("nascimento", paciente.getNascimento());
        
        GenericoDAO<Vacinacao> daoVacinacao = new GenericoDAO<>();
        List<Vacinacao> listaVacinacoes = daoVacinacao.findByNome(Vacinacao.class, String.valueOf(id), "paciente_sus");
        
        output.setValue("listaVacinacoes",listaVacinacoes);
        
        return SUCCESS;
    }
    
    
    public List<Paciente> getPacientes(){
        GenericoDAO<Paciente> dao = new GenericoDAO<>();
        List<Paciente> pacientes = dao.findAll(Paciente.class);
        pacientes.forEach(elem -> {
            System.out.println("Nome: "+elem.getNome());
        });
        return pacientes;
    }
    
    public List<Local> getLocais(){
        GenericoDAO<Local> dao = new GenericoDAO<>();
        List<Local> locais = dao.findAll(Local.class);
        return locais;
    }
}
