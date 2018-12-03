package br.ifam.action;
 
//import connection.ConnectionFactory;
//import javax.persistence.EntityManager;
import br.ifam.dao.GenericoDAO;
import br.ifam.modelo.Paciente;
import org.mentawai.core.BaseAction;
 
public class InserirAction extends BaseAction {
    
    public String inserirPaciente() {
        //recebe valores do formulario
        Long sus = input.getLong("sus");
        String nome = input.getString("nome");
        String sexo = input.getString("sexo");
        String nascimento = input.getString("nascimento");
        
//        if (isEmpty(sus)) {
//            msg = "Why you did not type anything?";
//        }

        //envia valores para pagina de redirecionamento
        output.setValue("sus", sus);
        output.setValue("nome", nome);
        output.setValue("sexo", sexo);
        output.setValue("nascimento", nascimento);
        
        //teste de conexão com banco usando generic DAO
        GenericoDAO<Paciente> dao = new GenericoDAO<>();
        Paciente paciente = new Paciente(sus,nome,sexo,nascimento);
        dao.save(paciente);
        System.out.println("Paciente: "+paciente.getNome()+" salvo!!!");
        
        return SUCCESS;
    }
}