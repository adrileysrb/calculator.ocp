package br.com.small;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/send")
public class MessageResource {

    // @Inject
    // @Channel("my-outgoing-stream")
    // Emitter<String> emitter;

    @Inject
    @Channel("set_data_queue")
    Emitter<String> emitter;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void send(String message) {
        emitter.send(message);
    }
    
}
