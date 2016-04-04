package no.visma.rest.oppgave2;

import com.google.common.collect.Lists;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/farge")
@Produces(MediaType.APPLICATION_JSON)
public class ColourResource {

    private final AtomicInteger counter = new AtomicInteger();

    Map<Integer, String> colourMap = new LinkedHashMap<>();

    @POST
    public int leggTilFarge(@QueryParam("farge") String farge) {
        int id = counter.incrementAndGet();
        colourMap.put(id, farge);
        return id;
    }

    @Path("{id}")
    @GET
    public String hentFarge(@PathParam("id") Integer id) {
        return colourMap.get(id);
    }

    @PUT
    @Path("{id}")
    public void oppdaterFarge(@PathParam("id") Integer id, String nyFarge) {
        colourMap.put(id, nyFarge);
    }

    @GET
    public List<String> hentAlleFarger() {

        return Lists.newArrayList(colourMap.values());
    }
}
