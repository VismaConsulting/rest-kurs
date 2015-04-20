package no.visma.rest.oppgave1;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import java.util.List;

public class TwitterKlient {

    private static final String FRIENDS_TIMELINE_URI = "https://api.twitter.com/1.1/statuses/home_timeline.json";

    public static void main(String[] args) {
        TwitterKlient klient = new TwitterKlient();
        klient.hentTweets();
    }

    private void hentTweets() {
        TwitterAuthentication twitterAutentisering = new TwitterAuthentication();
        Feature twitterAuthentication = twitterAutentisering.loadAuthentication();

        // Opprett jersey-klient og legg på oauth for autentisering mot twitter.
        // JacksonFeature parser JSON.
        final Client client = ClientBuilder.newBuilder()
                .register(twitterAuthentication)
                .register(JacksonFeature.class)
                .build();

        // Gjør request
        final Response response = client.target(FRIENDS_TIMELINE_URI).request().get();
        if (response.getStatus() != 200) {
            String errorEntity = null;
            if (response.hasEntity()) {
                errorEntity = response.readEntity(String.class);
            }
            throw new RuntimeException("Request to Twitter was not successful. Response code: "
                    + response.getStatus() + ", reason: " + response.getStatusInfo().getReasonPhrase()
                    + ", entity: " + errorEntity);
        }

        // Lagrer autentiseringsdetaljer for å slippe å skrive dem inn hver gang
        twitterAutentisering.storeSettings();

        final List<Tweet> tweets = response.readEntity(new GenericType<List<Tweet>>() {
        });

        System.out.println("Tweets:\n");
        for (final Tweet t : tweets) {
            System.out.println(t.getUser().getName() + "\t -> " + t.getText());
        }
    }
}
