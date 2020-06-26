package biblioteca.rabbit;


import biblioteca.model.Funcionario;
import biblioteca.service.FuncionarioService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioConsumer {

    @Autowired
    private FuncionarioService funcionarioService;

    @RabbitListener(queues = {"${queue.funcionario.name}"})
    public void receive (@Payload Funcionario funcionario){
        System.out.println("Id: "+ funcionario.getId() + "\nNome: " + funcionario.getNome() + "\nTelefone: " + funcionario.getTelefone() + "\nCPF: " + funcionario.getCpf());
        //Inserir dado no Mongo
        funcionarioService.save(funcionario);
    }
}