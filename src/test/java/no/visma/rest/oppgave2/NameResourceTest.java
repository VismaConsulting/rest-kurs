package no.visma.rest.oppgave2;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NameResourceTest {

    private static final NameResource nameResource = new NameResource();

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(nameResource)
            .build();

    @Test
    public void legg_inn_navn() {
        Response response = resources.client().target("/navn").queryParam("navn", "per").request().post(null);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void hent_ut_navn_paa_id() {
        String navn = "arne";
        Integer opprettetId = opprettNavn(navn);

        Response response = resources.client().target("/navn").path(String.valueOf(opprettetId)).request().get();
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.readEntity(String.class)).isEqualTo(navn);
    }

    private Integer opprettNavn(String navn) {
        Response leggTilNavnRespons = resources.client()
                .target("/navn")
                .queryParam("navn", navn)
                .request()
                .post(null);
        return leggTilNavnRespons.readEntity(Integer.class);
    }

    @Test
    public void oppdater_part() {
        String navn = "per";
        Integer opprettetId = opprettNavn(navn);
        String nyttNavn = "pål";
        resources.client().target("/navn")
                .path(String.valueOf(opprettetId))
                .queryParam("navn", nyttNavn)
                .request()
                .put(Entity.entity(nyttNavn, MediaType.TEXT_PLAIN_TYPE));
        String oppdatertNavn = resources.client().target("/navn").path(String.valueOf(opprettetId)).request().get(String.class);
        assertThat(oppdatertNavn).isEqualTo(nyttNavn);
    }

    @Test
    public void hent_alle_navn() throws Exception {
        opprettNavn("henrik");

        List<String> strings = resources.client()
                .target("/navn")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<String>>() {
                });

        assertThat(strings.contains("henrik"));
    }
}