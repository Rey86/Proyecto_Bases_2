package logic_connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class DataBaseConnection {
    // Function that returns a connection with the data base
    public static Connection getConnectionDataBase() throws SQLException{
        String host = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String uName = "root";
        String uPass = "Bases4301";

        Connection con = DriverManager.getConnection(host, uName, uPass);
        return con;
    }
    
    // Parameter
    // Function to get all parameters of the system
    public static ResultSet getParameters() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call adm.getParameter(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a parameter of the system
    public static ResultSet getParameter(Integer pnIdParameter) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call adm.getParameter(?)}");
        
        stmt.setInt(1, pnIdParameter);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a parameter of the system
    public static void setParameter(Integer pnIdParameter, String pcParameterName, Integer pnParameterValue) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call adm.setParameter(?,?,?)}");
        
        stmt.setInt(1, pnIdParameter);
        stmt.setString(2, pcParameterName);
        stmt.setInt(3, pnParameterValue);
        stmt.execute();
    }
    
    // Function to delete a parameter of the system
    public static void deleteParameter(Integer pnIdParameter) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call adm.deleteParameter(?)}");
        
        stmt.setInt(1, pnIdParameter);
        stmt.execute();
    }
    
    // Function to insert a parameter of the system
    public static void insertParameter(String pcParameterName, Integer pnParameterValue) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call adm.insertParameter(?,?)}");
        
        stmt.setString(1, pcParameterName);
        stmt.setInt(2, pnParameterValue);
        stmt.execute();
    }
    
    // Country
    // Function to get all countries of the system
    public static ResultSet getCountries() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.getCountry(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a country of the system
    public static ResultSet getCountry(Integer pnIdCountry) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.getCountry(?)}");
        
        stmt.setInt(1, pnIdCountry);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a country of the system
    public static void setCountry(Integer pnIdCountry, String pcCountryName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.setCountry(?,?)}");
        
        stmt.setInt(1, pnIdCountry);
        stmt.setString(2, pcCountryName);
        stmt.execute();
    }
    
    // Function to delete a country of the system
    public static void deleteCountry(Integer pnIdCountry) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.deleteCountry(?)}");
        
        stmt.setInt(1, pnIdCountry);
        stmt.execute();
    }
    
    // Procedure to insert a country in the system
    public static void insertCountry(String pcCountryName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.insertCountry(?)}");
        
        stmt.setString(1, pcCountryName);
        stmt.execute();
    }
    
    // Province
    // Function to get all provinces of the system
    public static ResultSet getProvinces() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.getProvince(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a province of the system
    public static ResultSet getProvince(Integer pnIdProvince) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.getProvince(?)}");
        
        stmt.setInt(1, pnIdProvince);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a province of the system
    public static void setProvince(Integer pnIdProvince, String pcProvinceName, Integer pnIdCountry) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.setProvince(?,?,?)}");
        
        stmt.setInt(1, pnIdProvince);
        stmt.setString(2, pcProvinceName);
        stmt.setInt(3, pnIdCountry);
        stmt.execute();
    }
    
    // Function to delete a province of the system
    public static void deleteProvince(Integer pnIdProvince) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.deleteProvince(?)}");
        
        stmt.setInt(1, pnIdProvince);
        stmt.execute();
    }
    
    // Procedure to insert a province in the system
    public static void insertProvince(String pcProvinceName, Integer pnIdCountry) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.insertProvince(?,?)}");
        
        stmt.setString(1, pcProvinceName);
        stmt.setInt(2, pnIdCountry);
        stmt.execute();
    }
    
    // Canton
    // Function to get all cantons of the system
    public static ResultSet getCantons() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.getCanton(?)}");

        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a canton of the system
    public static ResultSet getCanton(Integer pnIdCanton) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.getCanton(?)}");

        stmt.setInt(1, pnIdCanton);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a canton of the system
    public static void setCanton(Integer pnIdCanton, String pcCantonName, Integer pnIdProvince) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.setCanton(?,?,?)}");
        
        stmt.setInt(1, pnIdCanton);
        stmt.setString(2, pcCantonName);
        stmt.setInt(3, pnIdProvince);
        stmt.execute();
    }
    
    // Function to delete a district of the system
    public static void deleteCanton(Integer pnIdCanton) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.deleteCanton(?)}");
        
        stmt.setInt(1, pnIdCanton);
        stmt.execute();
    }
    
    // Procedure to insert a district in the system
    public static void insertCanton(String pcCantonName, Integer pnIdDistrict) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.insertCanton(?,?)}");
        
        stmt.setString(1, pcCantonName);
        stmt.setInt(2, pnIdDistrict);
        stmt.execute();
    }
    
    // Community
    // Function to get all communities of the system
    public static ResultSet getCommunities() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.getCommunity(?)}");

        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a community of the system
    public static ResultSet getCommunity(Integer pnIdCommunity) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{?= call pl.getCommunity(?)}");

        stmt.setInt(1, pnIdCommunity);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a community of the system
    public static void setCommunity(Integer pnIdCommunity, String pcCommunityName, Integer pnIdDistrict) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.setCommunity(?,?,?)}");
        
        stmt.setInt(1, pnIdCommunity);
        stmt.setString(2, pcCommunityName);
        stmt.setInt(3, pnIdDistrict);
        stmt.execute();
    }
    
    // Function to delete a community of the system
    public static void deleteCommunity(Integer pnIdCommunity) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.deleteCommunity(?)}");
        
        stmt.setInt(1, pnIdCommunity);
        stmt.execute();
    }
    
    // Procedure to insert a community in the system
    public static void insertCommunity(String pcCommunityName, Integer pnIdDistrict) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.insertCommunity(?,?)}");
        
        stmt.setString(1, pcCommunityName);
        stmt.setInt(2, pnIdDistrict);
        stmt.execute();
    }
}
