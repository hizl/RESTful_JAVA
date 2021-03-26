package application.testDAO;

import application.model.CityModel;
import application.service.CityDAO;
import application.service.CityDAOImpl;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TestingRawResponseFromDatabase {
    public static void main(String[] args) {
        //findAllCities();
        //deleteById(1);
        //System.out.println(findById(3));
        saveNewCity(44,"Fool",-444D,444.55);
    }

    @Test
    public static void findAllCities() {
        CityDAO FIND = new CityDAOImpl();
        List<CityModel> findAll = FIND.findAllCity();
        findAll.forEach(System.out::println);
    }


    public static void deleteById(Integer id) {
        CityDAO DELETE = new CityDAOImpl();
        DELETE.deleteCity(id);

    }


    public static CityModel findById(Integer id) {
        CityDAOImpl cityDAO = new CityDAOImpl();
        return cityDAO.findById(id);

    }


    public static void saveNewCity(int id, String name, Double latitude, Double longitude) {
        CityDAOImpl cityDAO = new CityDAOImpl();
        cityDAO.saveNewCity(id, name, latitude, longitude);

    }


}


