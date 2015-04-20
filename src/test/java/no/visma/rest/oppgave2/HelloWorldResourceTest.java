package no.visma.rest.oppgave2;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;
import javax.ws.rs.client.WebTarget;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class HelloWorldResourceTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HelloWorldResource())
            .build();

    @Test
    public void hello_world_svarer_med_positivt_heltall() throws Exception {
        final WebTarget resource = resources.client().target("/hello-world");

        final Integer svar = resource.request().get(Integer.class);

        assertThat(svar).isGreaterThanOrEqualTo(1);
    }
}
