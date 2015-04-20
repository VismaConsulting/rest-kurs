package no.visma.rest.oppgave1;

import org.glassfish.jersey.client.oauth1.AccessToken;
import org.glassfish.jersey.client.oauth1.ConsumerCredentials;
import org.glassfish.jersey.client.oauth1.OAuth1AuthorizationFlow;
import org.glassfish.jersey.client.oauth1.OAuth1ClientSupport;

import javax.ws.rs.core.Feature;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Denne klassen legger på OAuth-headere.
 */
public class TwitterAuthentication {

    private static final String PROPERTIES_FILE_NAME = "twitterclient.properties";
    private static final String PROPERTY_CONSUMER_KEY = "consumerKey";
    private static final String PROPERTY_CONSUMER_SECRET = "consumerSecret";
    private static final String PROPERTY_TOKEN = "token";
    private static final String PROPERTY_TOKEN_SECRET = "tokenSecret";

    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    private final Properties properties = new Properties();

    public Feature loadAuthentication() {

        // retrieve consumer key/secret and token/secret from the property file
        // or system properties
        loadSettings();

        final ConsumerCredentials consumerCredentials = new ConsumerCredentials(
                properties.getProperty(PROPERTY_CONSUMER_KEY),
                properties.getProperty(PROPERTY_CONSUMER_SECRET));

        if (properties.getProperty(PROPERTY_TOKEN) == null) {

            // we do not have Access Token yet. Let's perfom the Authorization Flow first,
            // let the user approve our app and get Access Token.
            final OAuth1AuthorizationFlow authFlow = OAuth1ClientSupport.builder(consumerCredentials)
                    .authorizationFlow(
                            "https://api.twitter.com/oauth/request_token",
                            "https://api.twitter.com/oauth/access_token",
                            "https://api.twitter.com/oauth/authorize")
                    .build();
            final String authorizationUri = authFlow.start();

            System.out.println("Enter the following URI into a web browser and authorize me:");
            System.out.println(authorizationUri);
            System.out.print("Enter the authorization code: ");
            final String verifier;
            try {
                verifier = inputReader.readLine();
            } catch (final IOException ex) {
                throw new RuntimeException(ex);
            }
            final AccessToken accessToken = authFlow.finish(verifier);

            // store access token for next application execution
            properties.setProperty(PROPERTY_TOKEN, accessToken.getToken());
            properties.setProperty(PROPERTY_TOKEN_SECRET, accessToken.getAccessTokenSecret());

            // get the feature that will configure the client with consumer credentials and
            // received access token
            return authFlow.getOAuth1Feature();
        } else {
            final AccessToken storedToken = new AccessToken(properties.getProperty(PROPERTY_TOKEN),
                    properties.getProperty(PROPERTY_TOKEN_SECRET));
            // build a new feature from the stored consumer credentials and access token
            return OAuth1ClientSupport.builder(consumerCredentials).feature()
                    .accessToken(storedToken).build();
        }
    }

    private void loadSettings() {
        try (FileInputStream st = new FileInputStream(PROPERTIES_FILE_NAME)) {
            properties.load(st);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] propertyNames = {PROPERTY_CONSUMER_KEY, PROPERTY_CONSUMER_SECRET, PROPERTY_TOKEN, PROPERTY_TOKEN_SECRET};

        for (final String name : propertyNames) {
            final String value = System.getProperty(name);
            if (value != null) {
                this.properties.setProperty(name, value);
            }
        }

        if (this.properties.getProperty(PROPERTY_CONSUMER_KEY) == null
                || this.properties.getProperty(PROPERTY_CONSUMER_SECRET) == null) {
            System.out.println("No consumerKey and/or consumerSecret found in twitterclient.properties file. "
                    + "You have to provide these as system properties.");
            System.exit(1);
        }
    }

    public void storeSettings() {
        try (FileOutputStream st =  new FileOutputStream(PROPERTIES_FILE_NAME)) {
            properties.store(st, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
