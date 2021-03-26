package application.service;

import application.model.CityModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CityDAOImpl implements CityDAO {
    Connection con = null;
    PreparedStatement pst;
    ResultSet rs = null;


    @Override
    public List<CityModel> findAllCity() {
        final String selectQuery = "SELECT ID, Name, Latitude,Longitude FROM City";
        List<CityModel> cityModelList = new ArrayList<>();


        try {
            con = DBConnector.getConnection();
            pst = con.prepareStatement(selectQuery);
            try {
                rs = pst.executeQuery();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println(pst.toString());
                e.printStackTrace();
            }

            try {
                while (rs.next()) {
                    CityModel cityModel = new CityModel();
                    Integer id = rs.getInt(1);
                    String city = rs.getString(2);
                    Double latitude = rs.getDouble(3);
                    Double longitude = rs.getDouble(4);


                    cityModel.setId(id);
                    cityModel.setName(city);
                    cityModel.setLatitude(latitude);
                    cityModel.setLongitude(longitude);


                    cityModelList.add(cityModel);
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnector.closeConnectionAll(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return cityModelList;
    }


    @Override
    public boolean deleteCity(Integer id) {
        final String insertQuery = "DELETE from City WHERE id=?;";


        try {
            con = DBConnector.getConnection();
            pst = con.prepareStatement(insertQuery);


            pst.setInt(1, id);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnector.closeConnectionAll(con, pst, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public CityModel findById(Integer id) {
        final String selectQuery = "SELECT id, Name, Latitude,Longitude FROM City WHERE ID=" + id;
        CityModel cityModel = new CityModel();
        try {

            con = DBConnector.getConnection();
            pst = con.prepareStatement(selectQuery);


            rs = pst.executeQuery();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(pst.toString());
            e.printStackTrace();

        }

        try {
            while (rs.next()) {


                cityModel.setId(id);
                cityModel.setName(rs.getString(2));
                cityModel.setLatitude(rs.getDouble(3));
                cityModel.setLongitude(rs.getDouble(4));

            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                DBConnector.closeConnectionAll(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cityModel;
    }


    @Override
    public void saveNewCity(int id, String name, Double latitude, Double longitude) {

        String insertQuery = "Insert into City (id,Name,Latitude,Longitude) "
                + "values (?,?,?,?)";

        try {

            con = DBConnector.getConnection();
            pst = con.prepareStatement(insertQuery);

            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setDouble(3, latitude);
            pst.setDouble(4, longitude);


            pst.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnector.closeConnectionAll(con, pst, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private static CityDAOImpl instance;

    public static CityDAOImpl getInstance() {
        if (instance == null) {
            instance = new CityDAOImpl();
        }
        return instance;
    }

}
