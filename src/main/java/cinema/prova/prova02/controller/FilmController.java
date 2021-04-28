package cinema.prova.prova02.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/film")
public class FilmController {

    @GET
    @Path("list")
    @Produces("application/json")
    public String list(){
        return "Hello World";
    }

}
