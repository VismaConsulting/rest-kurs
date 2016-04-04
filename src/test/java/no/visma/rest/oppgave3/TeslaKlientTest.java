package no.visma.rest.oppgave3;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

public class TeslaKlientTest {

    private static final String VEHICLE_ID = "8849594508698153748";
    private TeslaKlient teslaKlient;

    @Before
    public void beforeClass() {
        teslaKlient = new TeslaKlient();
    }

    @Test
    public void hentAlleKjoretoySkalReturnereEttKjoretoy() {
        Vehicle[] allekjoretoy = teslaKlient.hentAllekjoretoy();

        assertThat(allekjoretoy.length, is(1));
    }

    @Test
    public void hentVehicleState() {
        VehicleState vehicleState = teslaKlient.hentVehicleState(VEHICLE_ID);

        assertThat(vehicleState, is(not(nullValue())));
        assertThat(vehicleState.getSun_roof_installed(), is(false));
    }

    @Test
    public void blinkMedLysene() {
        boolean blinket = teslaKlient.blinkMedLysene(VEHICLE_ID);

        assertThat(blinket, is(true));
    }
}