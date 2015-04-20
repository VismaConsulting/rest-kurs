package no.visma.rest.oppgave2;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            args = new String[]{"server"};
        }
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(
            HelloWorldConfiguration configuration,
            Environment environment
    ) {
        final HelloWorldResource resource = new HelloWorldResource();
        environment.jersey().register(resource);
    }

}