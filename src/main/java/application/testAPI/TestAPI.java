package application.testAPI;

import application.model.CityModel;
import application.service.CityDAOImpl;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class TestAPI {

   /* @Test
    public void testCustomerResource() throws Exception {
        System.out.println("*** Create a new City ***");
        CityModel cityModel = new CityModel();

        cityModel.setId(1);
        cityModel.setName("British");
        cityModel.setLatitude(-888D);
        cityModel.setLongitude(4444D);

        Response response =
                client.target("http://localhost:8080/services/customers")
                        .request().post(Entity.json(cityModel));
        if (response.getStatus() != 201)
            throw new RuntimeException("Failed to create");


    }*/
}
