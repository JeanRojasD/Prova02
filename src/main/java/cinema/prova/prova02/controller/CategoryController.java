package cinema.prova.prova02.controller;

import cinema.prova.prova02.persistence.dao.CategoryDao;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/category")
public class CategoryController {

    @POST
    @Path("new")
    @Produces("application/json")
    public Response newTable(){
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.createCategoryTable();

        return Response.ok(new Gson().toJson("Tabela Criada!")).build();
    }

    @GET
    @Path("list")
    @Produces("application/json")
    public Response list(){
        CategoryDao categoryDao = new CategoryDao();

        return Response.ok(new Gson().toJson(categoryDao.listCategory())).build();
    }
}
