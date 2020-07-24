package logic_connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import oracle.jdbc.OracleTypes;

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
}
