package no.visma.rest.oppgave2;

import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldApplicationTest {

    @ClassRule
    public static final DropwizardAppRule<HelloWorldConfiguration> RULE =
            new DropwizardAppRule<>(HelloWorldApplication.class, null);

    @Test
    public void server_svarer_200_ok() {

        WebTarget resource = ClientBuilder.newClient().target("http://localhost:" + RULE.getLocalPort() + "/hello-world");

        final Response response = resource.request().get();
        assertThat(response.getStatus()).isEqualTo(200);
    }

}
