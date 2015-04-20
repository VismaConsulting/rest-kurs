package no.visma.rest.oppgave1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;

    public String getName() {
        return name;
    }
}