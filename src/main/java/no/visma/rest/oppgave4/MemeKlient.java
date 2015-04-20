package no.visma.rest.oppgave4;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.StringReader;

public class MemeKlient {
    private final Client client;

    public static void main(String[] args) {
        MemeKlient klient = new MemeKlient();
    }

    public MemeKlient() {
        // Opprett jersey-klient
        // JacksonFeature parser JSON.
        client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
    }
}
