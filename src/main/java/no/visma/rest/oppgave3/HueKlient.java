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
import java.io.BufferedReader;
import java.io.StringReader;

public class HueKlient {
    private final Client client;
    private final String hueUri = "http://192.168.1.104/api/westerdahls/";

    public static void main(String[] args) {
        HueKlient klient = new HueKlient();
        klient.otherCoolThings();
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

    //3.1
    private void lightOneUp() {
        JsonObject build = Json.createObjectBuilder().add("on", true).add("hue", 46920).build();
        UriBuilder uriBuilder = UriBuilder.fromUri(hueUri).path("lights").path(String.valueOf(3)).path("state");
        client.target(uriBuilder).request().put(Entity.json(build.toString()));
    }

    //3.2
    private void lightThemAll() {
        for (int i = 1; i < 4; i++) {
            JsonObject build = Json.createObjectBuilder().add("on", true).add("hue",20000).build();
            UriBuilder uriBuilder = UriBuilder.fromUri(hueUri).path("lights").path(String.valueOf(i)).path("state");
            System.out.println("uriBuilder.build() = " + uriBuilder.build());
            client.target(uriBuilder.build()).request().put(Entity.json(build.toString()));
        }
    }

    //3.3
    private void blueToRedToGreen() {
        for (int i = 1; i < 4; i++) {
            JsonObject blue = Json.createObjectBuilder().add("on", true).add("hue", 46920).add("transitiontime", 10).build();
            JsonObject red = Json.createObjectBuilder().add("on", true).add("hue", 65535).add("transitiontime", 10).build();
            JsonObject green = Json.createObjectBuilder().add("on", true).add("hue", 25500).add("transitiontime", 10).build();
            UriBuilder uriBuilder = UriBuilder.fromUri(hueUri).path("lights").path(String.valueOf(i)).path("state");
            client.target(uriBuilder.build()).request().put(Entity.json(blue.toString()));
            client.target(uriBuilder.build()).request().put(Entity.json(red.toString()));
            client.target(uriBuilder.build()).request().put(Entity.json(green.toString()));
        }
    }

    //3.4
    private void otherCoolThings() {
        for (int i = 1; i < 4; i++) {
            JsonObject blue = Json.createObjectBuilder().add("effect", "colorloop").add("transitiontime", 10).build();
            JsonObject red = Json.createObjectBuilder().add("effect", "colorloop").add("transitiontime", 30).build();
            JsonObject green = Json.createObjectBuilder().add("effect", "colorloop").add("transitiontime", 40).build();
            UriBuilder uriBuilder = UriBuilder.fromUri(hueUri).path("lights").path(String.valueOf(i)).path("state");
            client.target(uriBuilder.build()).request().put(Entity.json(blue.toString()));
            client.target(uriBuilder.build()).request().put(Entity.json(red.toString()));
            client.target(uriBuilder.build()).request().put(Entity.json(green.toString()));
        }
    }







}
