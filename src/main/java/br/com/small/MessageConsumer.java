package br.com.small;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageConsumer {

    @Incoming("my-incoming-stream")
    public void consume(String message) {
        System.out.println(">> Mensagem recebida do RabbitMQ: " + message);
    }
    
}
