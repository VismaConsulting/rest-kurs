package no.visma.rest.oppgave2;

import com.google.common.collect.Lists;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Path("/navn")

@Produces(MediaType.APPLICATION_JSON)
public class NameResource {

    private final AtomicInteger counter = new AtomicInteger();

    Map<Integer, String> nameMap = new LinkedHashMap<>();

    @POST
    public int leggTilNavn(@QueryParam("navn") String navn) {
        int id = counter.incrementAndGet();
        nameMap.put(id, navn);
        return id;
    }

    @Path("{id}")
    @GET
    public String hentNavn(@PathParam("id") Integer id) {
        return nameMap.get(id);
    }

    @PUT
    @Path("{id}")
    public void oppdaterNavn(@PathParam("id") Integer id, String nyttNavn) {
        nameMap.put(id, nyttNavn);
    }

    @GET
    public List<String> hentAlleNavn() {

        return Lists.newArrayList(nameMap.values());
    }

}
