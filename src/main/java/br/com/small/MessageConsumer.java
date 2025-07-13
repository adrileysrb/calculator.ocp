package br.com.small;

import org.bson.Document;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MessageConsumer {

    @Inject
    MongoClient mongoClient;

    @Incoming("set_data_queue")
    public void consume(byte[] messageBytes) {
        String message = new String(messageBytes); // converte para String
        System.out.println(">> Mensagem recebida do RabbitMQ: " + message);
        Document document = Document.parse(message);
        getCollection().insertOne(document);
    }

    private MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("holderdatabase").getCollection("messages");
    }

}
