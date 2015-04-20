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
    private static final String FRIENDSHIPS_CREATE = "https://api.twitter.com/1.1/friendships/create.json";
    private final Client client;

    public static void main(String[] args) {
        TwitterKlient klient = new TwitterKlient();
        klient.hentTweets();
    }

    public TwitterKlient() {
        TwitterAuthentication twitterAutentisering = new TwitterAuthentication();
        Feature twitterAuthentication = twitterAutentisering.loadAuthentication();

        // Lagrer autentiseringsdetaljer for å slippe å skrive dem inn hver gang
        twitterAutentisering.storeSettings();

        // Opprett jersey-klient og legg på oauth for autentisering mot twitter.
        // JacksonFeature parser JSON.
        client = ClientBuilder.newBuilder()
                .register(twitterAuthentication)
                .register(JacksonFeature.class)
                .build();
    }

    private void hentTweets() {
        // Gjør request
        final Response response = client.target(FRIENDS_TIMELINE_URI).request().get();
        verifiserResponseStatuskode(response, 200);

        final List<Tweet> tweets = response.readEntity(new GenericType<List<Tweet>>() {
        });

        System.out.println("Tweets:\n");
        for (final Tweet tweet : tweets) {
            System.out.println(tweet.getUser().getName() + "\t -> " + tweet.getText());
        }
    }

    private void verifiserResponseStatuskode(Response response, int statuskode) {
        if (response.getStatus() != statuskode) {
            String errorEntity = null;
            if (response.hasEntity()) {
                errorEntity = response.readEntity(String.class);
            }
            throw new RuntimeException("Request to Twitter was not successful. Response code: "
                    + response.getStatus() + ", reason: " + response.getStatusInfo().getReasonPhrase()
                    + ", entity: " + errorEntity);
        }
    }
}
