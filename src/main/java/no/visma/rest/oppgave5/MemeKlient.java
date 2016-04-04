package no.visma.rest.oppgave5;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

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
