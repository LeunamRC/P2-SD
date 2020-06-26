package biblioteca.rabbit;


import biblioteca.model.Livro;
import biblioteca.service.LivroService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class LivroConsumer {

    @Autowired
    private LivroService livroService;

    @RabbitListener(queues = {"${queue.livro.name}"})
    public void receive (@Payload Livro livro){
        System.out.println("Id: "+ livro.getId() + "\nNome: " + livro.getNome() + "\nEdição: " + livro.getEdicao() +
                "\nEditora: " + livro.getEditora() + "\nAutor: " + livro.getAutor()+ "\nAno de Publicação: " + livro.getAno_pub() +
                "\nNumero de Paginas: " + livro.getN_pag());
        //Inserir dado no Mongo
        livroService.save(livro);
    }
}