package biblioteca.rabbit;

import biblioteca.model.Livro;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LivroProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queuelivro")
    @Autowired
    private Queue queue;

    public void send(final Livro livro){
        rabbitTemplate.convertAndSend(this.queue.getName(), livro);
    }
}