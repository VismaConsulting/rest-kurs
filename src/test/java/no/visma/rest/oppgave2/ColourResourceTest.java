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

public class ColourResourceTest {

    private static final ColourResource COLOUR_RESOURCE = new ColourResource();

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(COLOUR_RESOURCE)
            .build();

    @Test
    public void legg_inn_farge() {
        Response response = resources.client().target("/farge").queryParam("farge", "gul").request().post(null);
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void hent_ut_farge_paa_id() {
        String farge = "brun";
        Integer opprettetId = opprettFarge(farge);

        Response response = resources.client().target("/farge").path(String.valueOf(opprettetId)).request().get();
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.readEntity(String.class)).isEqualTo(farge);
    }

    @Test
    public void oppdater_part() {
        String farge = "blå";
        Integer opprettetId = opprettFarge(farge);
        String nyFarge = "rød";
        resources.client().target("/farge")
                .path(String.valueOf(opprettetId))
                .queryParam("farge", nyFarge)
                .request()
                .put(Entity.entity(nyFarge, MediaType.TEXT_PLAIN_TYPE));
        String oppdatertFarge = resources.client().target("/farge").path(String.valueOf(opprettetId)).request().get(String.class);
        assertThat(oppdatertFarge).isEqualTo(nyFarge);
    }

    @Test
    public void hent_alle_farger() throws Exception {
        opprettFarge("oransje");
        opprettFarge("blå");

        List<String> strings = resources.client()
                .target("/farge")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<String>>() {
                });

        assertThat(strings.contains("oransje"));
        assertThat(strings.contains("blå"));
    }

    private Integer opprettFarge(String farge) {
        Response leggTilFargeRespons = resources.client()
                .target("/farge")
                .queryParam("farge", farge)
                .request()
                .post(null);
        return leggTilFargeRespons.readEntity(Integer.class);
    }
}