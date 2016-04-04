package no.visma.rest.oppgave3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TeslaKlient {

    public static final String BEARER_TOKEN = "Bearer <INSERT TOKEN HERE>";
    public static final String AUTHORIZATION = "Authorization";
    private final Client client;
    private final String teslaUri = "https://owner-api.teslamotors.com/api/1/";

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

    public Vehicle[] hentAllekjoretoy() {
        Response response = client.target(teslaUri + "vehicles")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(AUTHORIZATION, BEARER_TOKEN).get();
        VehiclesResponse vehiclesResponse = response.readEntity(VehiclesResponse.class);

        return vehiclesResponse.getResponse();
    }

    public VehicleState hentVehicleState(String vehicleId) {
        Response response = client.target(teslaUri + "vehicles/" + vehicleId + "/data_request/drive_state")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(AUTHORIZATION, BEARER_TOKEN).get();

        return response.readEntity(VehicleState.class);
    }

    public boolean blinkMedLysene(String vehicleId) {
        Response response = client.target(teslaUri + "vehicles/" + vehicleId + "/command/flash_lights")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(AUTHORIZATION, BEARER_TOKEN).post(null);

        ObjectNode objectNode = response.readEntity(ObjectNode.class);
        JsonNode jsonNode = objectNode.get("response");
        BooleanNode result = (BooleanNode) jsonNode.get("result");

        return result.asBoolean();
    }

    public boolean openLuggage(String vehicleId) {
        Response response = client.target(teslaUri + "vehicles/" + vehicleId + "/command/trunk_open")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(AUTHORIZATION, BEARER_TOKEN).post(null);

        // TODO: WHICH TRUNK????
        ObjectNode objectNode = response.readEntity(ObjectNode.class);
        JsonNode jsonNode = objectNode.get("response");
        BooleanNode result = (BooleanNode) jsonNode.get("result");

        return result.asBoolean();
    }
}
