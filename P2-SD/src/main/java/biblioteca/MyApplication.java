package biblioteca;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApplication {

    @Value("${queue.funcionario.name}")
    private String funcionarioQueue;
    @Value("${queue.livro.name}")
    private String livroQueue;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public Queue queuefuncionario(){
        return new Queue(funcionarioQueue, true);
    }
   @Bean
    public Queue queuelivro(){
        return new Queue(livroQueue, true);
    }


}