package application.resources;


import application.model.CityModel;
import application.service.CityDAO;
import application.service.CityDAOImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/city")
public class CityResources {

    private CityDAOImpl cityDAOImpl = CityDAOImpl.getInstance();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityModel> list() {
        CityDAO find = new CityDAOImpl();
        List<CityModel> findAll = find.findAllCity();
        return findAll;
    }


    @DELETE
    @Path("{id}")
    public Response get(@PathParam("id") int id) {
        CityDAO delete = new CityDAOImpl();
        if (delete.deleteCity(id)) {
            return Response.ok().build();
        }
        return Response.notModified().build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        CityModel getByID = CityDAOImpl.getInstance().findById(id);
        if (getByID == null){
            return Response.ok(getByID, MediaType.APPLICATION_JSON).build();
        }else {
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    }
}
