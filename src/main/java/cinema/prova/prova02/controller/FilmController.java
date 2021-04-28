package cinema.prova.prova02.controller;

import cinema.prova.prova02.persistence.dao.FilmeDao;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/film")
public class FilmController {

    @POST
    @Path("new")
    @Produces("application/json")
    public Response newTable(){
        FilmeDao filmeDao = new FilmeDao();
        filmeDao.createFilmTable();

        return Response.ok(new Gson().toJson("Tabela Criada!")).build();
    }

    @GET
    @Path("list")
    @Produces("application/json")
    public Response list(){
        FilmeDao filmeDao = new FilmeDao();

        return Response.ok(new Gson().toJson(filmeDao.listFilms())).build();
    }

}
