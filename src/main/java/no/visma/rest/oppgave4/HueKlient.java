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

public class HueKlient {
    private final Client client;
    private final String hueUri = "http://10.21.11.103/api/westerdals/";

    public static void main(String[] args) {
        HueKlient klient = new HueKlient();
        klient.toggleAllLights();
    }

    public HueKlient() {
        // Opprett jersey-klient
        // JacksonFeature parser JSON.
        client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();
    }

    private void toggleAllLights() {
        for (int i = 1; i < 4; i++) {
            Response response = client.target(UriBuilder.fromUri(hueUri).path("lights").path(String.valueOf(i))).request(MediaType.APPLICATION_JSON_TYPE).get();
            String entity = response.readEntity(String.class);
            JsonReader reader = Json.createReader(new StringReader(entity));
            JsonObject currentState = reader.readObject().getJsonObject("state");
            boolean on = currentState.getBoolean("on");

            JsonObject build = Json.createObjectBuilder().add("on", !on).build();
            UriBuilder uriBuilder = UriBuilder.fromUri(hueUri).path("lights").path(String.valueOf(i)).path("state");
            System.out.println("uriBuilder.build() = " + uriBuilder.build());
            client.target(uriBuilder.build()).request().put(Entity.json(build.toString()));
        }
    }
}
