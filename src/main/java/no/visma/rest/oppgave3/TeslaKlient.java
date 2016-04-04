package no.visma.rest.oppgave3;

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

public class TeslaKlient {
    private final Client client;
    private final String teslaUri = "https://owner-api.teslamotors.com/api/1/";
    private final String vehicleId = "<Finn i oppgave 1>";
    private final String bearerToken = "<Står på tavla>";

    public static void main(String[] args) {
        TeslaKlient klient = new TeslaKlient();
    }

    public TeslaKlient() {
        // Opprett jersey-klient
        // JacksonFeature parser JSON.
        client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
    }

}
