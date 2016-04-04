package no.visma.rest.oppgave3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehiclesResponse {

    private Vehicle[] response;
    private String count;

    public Vehicle[] getResponse() {
        return response;
    }

    public void setResponse(Vehicle[] response) {
        this.response = response;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
