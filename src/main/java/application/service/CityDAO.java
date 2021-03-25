package application.service;

import application.model.CityModel;

import java.util.List;

public interface CityDAO {

    List<CityModel> findAllCity();

    boolean deleteCity(Integer id);

    CityModel findById(Integer id);

    void saveNewCity(int id, String name, Double latitude, Double longitude);


}
