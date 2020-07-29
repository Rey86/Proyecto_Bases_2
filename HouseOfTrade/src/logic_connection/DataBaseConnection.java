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
    public static void insertCanton(String pcCantonName, Integer pnIdProvince) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.insertCanton(?,?)}");
        
        stmt.setString(1, pcCantonName);
        stmt.setInt(2, pnIdProvince);
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
        CallableStatement stmt = con.prepareCall("{ call pl.getCommunity(?)}");

        stmt.setInt(1, pnIdCommunity);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a community of the system
    public static void setCommunity(Integer pnIdCommunity, String pcCommunityName, Integer pnIdCanton) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.setCommunity(?,?,?)}");
        
        stmt.setInt(1, pnIdCommunity);
        stmt.setString(2, pcCommunityName);
        stmt.setInt(3, pnIdCanton);
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
    public static void insertCommunity(String pcCommunityName, Integer pnIdCanton) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call pl.insertCommunity(?,?)}");
        
        stmt.setString(1, pcCommunityName);
        stmt.setInt(2, pnIdCanton);
        stmt.execute();
    }
    
    // Category
    // Function to get all categories of the system
    public static ResultSet getCategories() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getCategory(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a category of the system
    public static ResultSet getCategory(Integer pnIdCategory) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getCategory(?)}");
        
        stmt.setInt(1, pnIdCategory);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a category of the system
    public static void setCategory(Integer pnIdCategory, String pcCategoryName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.setCategory(?,?)}");
        
        stmt.setInt(1, pnIdCategory);
        stmt.setString(2, pcCategoryName);
        stmt.execute();
    }
    
    // Function to delete a category of the system
    public static void deleteCategory(Integer pnIdCategory) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.deleteCategory(?)}");
        
        stmt.setInt(1, pnIdCategory);
        stmt.execute();
    }
    
    // Procedure to insert a category in the system
    public static void insertCategory(String pcCategoryName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.insertCategory(?)}");
        
        stmt.setString(1, pcCategoryName);
        stmt.execute();
    }
    
    // DeliveryType
    // Function to get all delivery types of the system
    public static ResultSet getDeliveryTypes() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getDeliveryType(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a delivery type of the system
    public static ResultSet getDeliveryType(Integer pnIdDeliveryType) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getDeliveryType(?)}");
        
        stmt.setInt(1, pnIdDeliveryType);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a delivery type of the system
    public static void setDeliveryType(Integer pnIdDeliveryType, String pcDeliveryTypeName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.setDeliveryType(?,?)}");
        
        stmt.setInt(1, pnIdDeliveryType);
        stmt.setString(2, pcDeliveryTypeName);
        stmt.execute();
    }
    
    // Function to delete a delivery type of the system
    public static void deleteDeliveryType(Integer pnIdDeliveryType) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.deleteDeliveryType(?)}");
        
        stmt.setInt(1, pnIdDeliveryType);
        stmt.execute();
    }
    
    // Procedure to insert a delivery type in the system
    public static void insertDeliveryType(String pcDeliveryTypeName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.insertDeliveryType(?)}");
        
        stmt.setString(1, pcDeliveryTypeName);
        stmt.execute();
    }
    
    // PaymentMethod
    // Function to get all payment methods of the system
    public static ResultSet getPaymentMethods() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getPaymentMethod(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a payment method of the system
    public static ResultSet getPaymentMethod(Integer pnIdPaymentMethod) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getPaymentMethod(?)}");
        
        stmt.setInt(1, pnIdPaymentMethod);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a payment method of system
    public static void setPaymentMethod(Integer pnIdPaymentMethod, String pcPaymentMethodName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.setPaymentMethod(?,?)}");
        
        stmt.setInt(1, pnIdPaymentMethod);
        stmt.setString(2, pcPaymentMethodName);
        stmt.execute();
    }
    
    // Function to delete a payment method of the system
    public static void deletePaymentMethod(Integer pnIdPaymentMethod) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.deletePaymentMethod(?)}");
        
        stmt.setInt(1, pnIdPaymentMethod);
        stmt.execute();
    }
    
    // Procedure to insert a payment method in the system
    public static void insertPaymentMethod(String pcPaymentMethodName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.insertPaymentMethod(?)}");
        
        stmt.setString(1, pcPaymentMethodName);
        stmt.execute();
    }
    
    // Purchase
    // Function to get all purchases of the system
    public static ResultSet getPurchases() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getPurchase(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a purchase of the system
    public static ResultSet getPurchase(Integer pnIdPurchase) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getPurchase(?)}");
        
        stmt.setInt(1, pnIdPurchase);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a total of a purchase of the system
    public static ResultSet getPurchaseTotal(Integer pnIdPurchase) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getPurchaseTotal(?)}");
        
        stmt.setInt(1, pnIdPurchase);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a purchase of the system
    public static void setPurchase(Integer pnIdPurchase, String pcPurchaseDate, String pcUsernameCustomer,
            Integer pnIdPaymentMethod) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.setPurchase(?,?,?,?)}");
        
        stmt.setInt(1, pnIdPurchase);
        stmt.setString(2, pcPurchaseDate);
        stmt.setString(3, pcUsernameCustomer);
        stmt.setInt(4, pnIdPaymentMethod);
        stmt.execute();
    }
    
    // Function to delete a purchase of the system
    public static void deletePurchase(Integer pnIdPurchase) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.deletePurchase(?)}");
        
        stmt.setInt(1, pnIdPurchase);
        stmt.execute();
    }
    
    // Procedure to insert a purchase in the system
    public static void insertPurchase(String pcPurchaseDate, String pcUsernameCustomer, 
            Integer pnIdPaymentMethod) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.insertPurchase(?,?,?)}");
        
        stmt.setString(1, pcPurchaseDate);
        stmt.setString(2, pcUsernameCustomer);
        stmt.setInt(3, pnIdPaymentMethod);
        stmt.execute();
    }
    
    // Product
    // Function to get all products of the system
    public static ResultSet getProducts() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getProduct(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a product of the system
    public static ResultSet getProduct(Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getProduct(?)}");
        
        stmt.setInt(1, pnIdProduct);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a product of the system
    public static void setProduct(Integer pnIdProduct, String pcProductName, Integer pnSold,
            String pcDescription, Integer pnQuantity, String pcUsernameSalesman, Integer pnIdCategory,
            Integer pnIdDeliveryType) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.setProduct(?,?,?,?,?,?,?,?)}");
        
        stmt.setInt(1, pnIdProduct);
        stmt.setString(2, pcProductName);
        stmt.setInt(3, pnSold);
        stmt.setString(4, pcDescription);
        stmt.setInt(5, pnQuantity);
        stmt.setString(6, pcUsernameSalesman);
        stmt.setInt(7, pnIdCategory);
        stmt.setInt(8, pnIdDeliveryType);
        stmt.execute();
    }
    
    // Function to set a product price of the system
    public static void setProductPrice(Integer pnIdProduct, Integer pnPrice) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.setProductPrice(?,?)}");
        
        stmt.setInt(1, pnIdProduct);
        stmt.setInt(2, pnPrice);
        stmt.execute();
    }
    
    // Function to delete a product of the system
    public static void deleteProduct(Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.deleteProduct(?)}");
        
        stmt.setInt(1, pnIdProduct);
        stmt.execute();
    }
    
    // Procedure to insert a product in the system
    public static void insertProduct(String pcProductName, Integer pnPrice, Integer pnSold,
            String pcDescription, Integer pnQuantity, String pcUsernameSalesman, Integer pnIdCategory,
            Integer pnIdDeliveryType) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.insertProduct(?,?,?,?,?,?,?,?)}");
        
        stmt.setString(1, pcProductName);
        stmt.setInt(2, pnPrice);
        stmt.setInt(3, pnSold);
        stmt.setString(4, pcDescription);
        stmt.setInt(5, pnQuantity);
        stmt.setString(6, pcUsernameSalesman);
        stmt.setInt(7, pnIdCategory);
        stmt.setInt(8, pnIdDeliveryType);
        stmt.execute();
    }
    
    // Review
    // Function to get all reviews of the system
    public static ResultSet getReviews() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getReview(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a review of the system
    public static ResultSet getReview(Integer pnIdReview) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getReview(?)}");
        
        stmt.setInt(1, pnIdReview);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a review of the system
    public static void setReview(Integer pnIdReview, Integer pnStars, String pcComment, 
            Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.setReview(?,?,?,?)}");
        
        stmt.setInt(1, pnIdReview);
        stmt.setInt(2, pnStars);
        stmt.setString(3, pcComment);
        stmt.setInt(4, pnIdProduct);
        stmt.execute();
    }
    
    // Function to delete a review of the system
    public static void deleteReview(Integer pnIdReview) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.deleteReview(?)}");
        
        stmt.setInt(1, pnIdReview);
        stmt.execute();
    }
    
    // Procedure to insert a review in the system
    public static void insertReview(Integer pnStars, String pcComment, Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.insertReview(?,?,?)}");
        
        stmt.setInt(1, pnStars);
        stmt.setString(2, pcComment);
        stmt.setInt(3, pnIdProduct);
        stmt.execute();
    }
    
    // Photo
    // Function to get all photos of the system
    public static ResultSet getPhotos() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getPhoto(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a photo of the system
    public static ResultSet getPhoto(Integer pnIdPhoto) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getPhoto(?)}");
        
        stmt.setInt(1, pnIdPhoto);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a photo of the system
    public static void setPhoto(Integer pnIdPhoto, Integer pnIdProduct, String pcDescription, 
            String pcDirection) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.setPhoto(?,?,?,?)}");
        
        stmt.setInt(1, pnIdPhoto);
        stmt.setInt(2, pnIdProduct);
        stmt.setString(3, pcDescription);
        stmt.setString(4, pcDirection);
        stmt.execute();
    }
    
    // Function to delete a photo of the system
    public static void deletePhoto(Integer pnIdPhoto) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.deletePhoto(?)}");
        
        stmt.setInt(1, pnIdPhoto);
        stmt.execute();
    }
    
    // Procedure to insert a photo in the system
    public static void insertPhoto(Integer pnIdProduct, String pcDescription, String pcDirection) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.insertPhoto(?,?,?)}");
        
        stmt.setInt(1, pnIdProduct);
        stmt.setString(2, pcDescription);
        stmt.setString(3, pcDirection);
        stmt.execute();
    }
    
    // ProductxPurchase
    // Function to get a productxpurchase of the system
    public static ResultSet getProductxPurchase(Integer pnIdPurchase, Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getProductxPurchase(?,?)}");
        
        stmt.setInt(1, pnIdPurchase);
        stmt.setInt(2, pnIdProduct);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a productxpurchase of the system
    public static void setProductxPurchase(Integer pnIdPurchase, Integer pnIdProduct, Integer pnQuantity) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.setProductxPurchase(?,?,?)}");
        
        stmt.setInt(1, pnIdPurchase);
        stmt.setInt(2, pnIdProduct);
        stmt.setInt(3, pnQuantity);
        stmt.execute();
    }
    
    // Function to delete a productxpurchase of the system
    public static void deleteProductxPurchase(Integer pnIdPurchase, Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.deleteProductxPurchase(?,?)}");
        
        stmt.setInt(1, pnIdPurchase);
        stmt.setInt(2, pnIdProduct);
        stmt.execute();
    }
    
    // Procedure to insert a productxpurchase in the system
    public static void insertProductxPurchase(Integer pnIdPurchase, Integer pnIdProduct, Integer pnQuantity) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.insertProductxPurchase(?,?,?)}");
        
        stmt.setInt(1, pnIdPurchase);
        stmt.setInt(2, pnIdProduct);
        stmt.setInt(3, pnQuantity);
        stmt.execute();
    }
    
    // Gender
    // Function to get all genders of the system
    public static ResultSet getGenders() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getGender(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a gender of the system
    public static ResultSet getGender(Integer pnIdGender) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getGender(?)}");
        
        stmt.setInt(1, pnIdGender);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a gender of the system
    public static void setGender(Integer pnIdGender, String pcGenderName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.setGender(?,?)}");
        
        stmt.setInt(1, pnIdGender);
        stmt.setString(2, pcGenderName);
        stmt.execute();
    }
    
    // Function to delete a gender of the system
    public static void deleteGender(Integer pnIdGender) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.deleteGender(?)}");
        
        stmt.setInt(1, pnIdGender);
        stmt.execute();
    }
    
    // Procedure to insert a gender in the system
    public static void insertGender(String pcGenderName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.insertGender(?)}");
        
        stmt.setString(1, pcGenderName);
        stmt.execute();
    }
    
    // UserType
    // Function to get all user types of the system
    public static ResultSet getUserTypes() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getUserType(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a user type of the system
    public static ResultSet getUserType(Integer pnIdUserType) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getUserType(?)}");
        
        stmt.setInt(1, pnIdUserType);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a user type of the system
    public static void setUserType(Integer pnIdUserType, String pcUserTypeName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.setUserType(?,?)}");
        
        stmt.setInt(1, pnIdUserType);
        stmt.setString(2, pcUserTypeName);
        stmt.execute();
    }
    
    // Function to delete a user type of the system
    public static void deleteUserType(Integer pnIdUserType) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.deleteUserType(?)}");
        
        stmt.setInt(1, pnIdUserType);
        stmt.execute();
    }
    
    // Procedure to insert a user type in the system
    public static void insertUserType(String pcUserTypeName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.insertUserType(?)}");
        
        stmt.setString(1, pcUserTypeName);
        stmt.execute();
    }
    
    // Nationality
    // Function to get all nationalities of the system
    public static ResultSet getNationalities() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getNationality(?)}");
        
        stmt.setNull(1, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a nationality of the system
    public static ResultSet getNationality(Integer pnIdNationality) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getNationality(?)}");
        
        stmt.setInt(1, pnIdNationality);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a nationality of the system
    public static void setNationality(Integer pnIdNationality, String pcNationalityName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.setNationality(?,?)}");
        
        stmt.setInt(1, pnIdNationality);
        stmt.setString(2, pcNationalityName);
        stmt.execute();
    }
    
    // Function to delete a nationality of the system
    public static void deleteNationality(Integer pnIdNationality) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.deleteNationality(?)}");
        
        stmt.setInt(1, pnIdNationality);
        stmt.execute();
    }
    
    // Procedure to insert a nationality in the system
    public static void insertNationality(String pcNationalityName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.insertNationality(?)}");
        
        stmt.setString(1, pcNationalityName);
        stmt.execute();
    }
    
    // User
    // Function to get all users of the system
    public static ResultSet getUsers() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getUser(?)}");
        
        stmt.setNull(1, Types.VARCHAR);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a user of the system
    public static ResultSet getUser(String pcUsername) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getUser(?)}");
        
        stmt.setString(1, pcUsername);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a user salesman average of the system
    public static ResultSet getUserSalesmanAverage(String pcUsername) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getUserSalesmanAverage(?)}");
        
        stmt.setString(1, pcUsername);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to get a user customer average of the system
    public static ResultSet getUserCustomerAverage(String pcUsername) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getUserCustomerAverage(?)}");
        
        stmt.setString(1, pcUsername);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getUserPassword(String pcUserName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getUserPassword(?)}");
        
        stmt.setString(1, pcUserName);
        stmt.executeQuery();
        ResultSet password = (ResultSet) stmt.executeQuery();
        return password;
    }
    
    public static ResultSet getCurrentUserType(String pcUserName) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getCurrentUserType(?)}");
        
        stmt.setString(1, pcUserName);
        ResultSet usertype_name = (ResultSet) stmt.executeQuery();
        return usertype_name;
    }
    
    // Function to set a user of the system
    public static void setUser(String pcUsername, String pcEmail, String pdBirthdate, String pcFirstName, 
            String pcFirstLastName, String pcSecondLastName, String pcPassword, String pnIdUser, String pcPhotoDirection, 
            Integer pnIdCommunity, Integer pnIdUserType, Integer pnIdGender) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.setUser(?,?,?,?,?,?,?,?,?,?,?,?)}");
        
        stmt.setString(1, pcUsername);
        stmt.setString(2, pcEmail);
        stmt.setString(3, pdBirthdate);
        stmt.setString(4, pcFirstName);
        stmt.setString(5, pcFirstLastName);
        stmt.setString(6, pcSecondLastName);
        stmt.setString(7, pcPassword);
        stmt.setString(8, pnIdUser);
        stmt.setString(9, pcPhotoDirection);
        stmt.setInt(10, pnIdCommunity);
        stmt.setInt(11, pnIdUserType);
        stmt.setInt(12, pnIdGender);
        stmt.execute();
    }
    
    // Function to delete a user of the system
    public static void deleteUser(String pcUsername) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.deleteUser(?)}");
        
        stmt.setString(1, pcUsername);
        stmt.execute();
    }
    
    // Procedure to insert a user in the system
    public static void insertUser(String pcUsername, String pcEmail, String pdBirthdate, String pcFirstName, 
            String pcFirstLastName, String pcSecondLastName, String pcPassword, String pnIdUser, String pcPhotoDirection, 
            Integer pnIdCommunity, Integer pnIdUserType, Integer pnIdGender) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.insertUser(?,?,?,?,?,?,?,?,?,?,?,?)}");
        
        stmt.setString(1, pcUsername);
        stmt.setString(2, pcEmail);
        stmt.setString(3, pdBirthdate);
        stmt.setString(4, pcFirstName);
        stmt.setString(5, pcFirstLastName);
        stmt.setString(6, pcSecondLastName);
        stmt.setString(7, pcPassword);
        stmt.setString(8, pnIdUser);
        stmt.setString(9, pcPhotoDirection);
        stmt.setInt(10, pnIdCommunity);
        stmt.setInt(11, pnIdUserType);
        stmt.setInt(12, pnIdGender);
        stmt.execute();
    }
    
    // UserReview 
    // Function to get a user review of the system
    public static ResultSet getUserReview(String pcUsernameReviewer, String pcUsernameReviewee) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getUserReview(?,?)}");
        
        stmt.setString(1, pcUsernameReviewer);
        stmt.setString(2, pcUsernameReviewee);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a user review of the system
    public static void setUserReview(String pcUsernameReviewer, String pcUsernameReviewee, Integer pnCustomer,
            String pcComment, Integer pnStars) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.setUserReview(?,?,?,?,?)}");
        
        stmt.setString(1, pcUsernameReviewer);
        stmt.setString(2, pcUsernameReviewee);
        stmt.setInt(3, pnCustomer);
        stmt.setString(4, pcComment);
        stmt.setInt(5, pnStars);
        stmt.execute();
    }
    
    // Function to delete a user review of the system
    public static void deleteUserReview(String pcUsernameReviewer, String pcUsernameReviewee) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.deleteUserReview(?,?)}");
        
        stmt.setString(1, pcUsernameReviewer);
        stmt.setString(2, pcUsernameReviewee);
        stmt.execute();
    }
    
    // Procedure to insert a user review in the system
    public static void insertUserReview(String pcUsernameReviewer, String pcUsernameReviewee, Integer pnCustomer,
            String pcComment, Integer pnStars) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.insertUserReview(?,?,?,?,?)}");
        
        stmt.setString(1, pcUsernameReviewer);
        stmt.setString(2, pcUsernameReviewee);
        stmt.setInt(3, pnCustomer);
        stmt.setString(4, pcComment);
        stmt.setInt(5, pnStars);
        stmt.execute();
    }
    
    // ReceiverxSender
    // Function to get a receiverxsender of the system
    public static ResultSet getReceiverxSender(String pcUsernameSender, String pcUsernameReceiver) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getReceiverxSender(?,?)}");
        
        stmt.setString(1, pcUsernameSender);
        stmt.setString(2, pcUsernameReceiver);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to set a receiverxsender of the system
    public static void setReceiverxSender(String pcUsernameSender, String pcUsernameReceiver, String pcMessageContent,
            String pdtTime) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.setReceiverxSender(?,?,?,?}");
        
        stmt.setString(1, pcUsernameSender);
        stmt.setString(2, pcUsernameReceiver);
        stmt.setString(3, pcMessageContent);
        stmt.setString(4, pdtTime);
        stmt.execute();
    }
    
    // Function to delete a receiverxsender of the system
    public static void deleteReceiverxSender(String pcUsernameSender, String pcUsernameReceiver) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.deleteReceiverxSender(?,?)}");
        
        stmt.setString(1, pcUsernameSender);
        stmt.setString(2, pcUsernameReceiver);
        stmt.execute();
    }
    
    // Procedure to insert a receiverxsender in the system
    public static void insertReceiverxSender(String pcUsernameSender, String pcUsernameReceiver, String pcMessageContent,
            String pdtTime) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.insertReceiverxSender(?,?,?,?)}");
        
        stmt.setString(1, pcUsernameSender);
        stmt.setString(2, pcUsernameReceiver);
        stmt.setString(3, pcMessageContent);
        stmt.setString(4, pdtTime);
        stmt.execute();
    }
    
    // UserWishesProduct
    // Function to delete a userwhishesproduct of the system
    public static void deleteUserWishesProduct(String pcUsername, Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.deleteUserWishesProduct(?,?)}");
        
        stmt.setString(1, pcUsername);
        stmt.setInt(2, pnIdProduct);
        stmt.execute();
    }
    
    // Procedure to insert a userwhishesproduct in the system
    public static void insertUserWishesProduct(String pcUsername, Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.insertUserWishesProduct(?,?)}");
        
        stmt.setString(1, pcUsername);
        stmt.setInt(2, pnIdProduct);
        stmt.execute();
    }
    
    // UserViewsProduct
    // Function to delete a userviewsproduct of the system
    public static void deleteUserViewsProduct(String pcUsername, Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.deleteUserViewsProduct(?,?)}");
        
        stmt.setString(1, pcUsername);
        stmt.setInt(2, pnIdProduct);
        stmt.execute();
    }
    
    // Procedure to insert a userviewsproduct in the system
    public static void insertUserViewsProduct(String pcUsername, Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.insertUserViewsProduct(?,?)}");
        
        stmt.setString(1, pcUsername);
        stmt.setInt(2, pnIdProduct);
        stmt.execute();
    }
    
    // UserxNationality
    // Function to get a userxnationality of the system
    public static ResultSet getUserxNationalities(String pcUsername) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getUserxNationality(?,?)}");
        
        stmt.setString(1, pcUsername);
        stmt.setNull(2, Types.INTEGER);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    // Function to delete a userxnationality of the system
    public static void deleteUserxNationality(String pcUsername, Integer pnIdNationality) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.deleteUserxNationality(?,?)}");
        
        stmt.setString(1, pcUsername);
        stmt.setInt(2, pnIdNationality);
        stmt.execute();
    }
    
    // Procedure to insert a userxnationality in the system
    public static void insertUserxNationality(String pcUsername, Integer pnIdNationality) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.insertUserxNationality(?,?)}");
        
        stmt.setString(1, pcUsername);
        stmt.setInt(2, pnIdNationality);
        stmt.execute();
    }
    
    // PhoneNumber
    // Function to delete a phone number of the system
    public static void deletePhoneNumber(Integer pnPhoneNumber, String pcUsername) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.deletePhoneNumber(?,?)}");
        
        stmt.setInt(1, pnPhoneNumber);
        stmt.setString(2, pcUsername);
        stmt.execute();
    }
    
    // Procedure to insert a phone number in the system
    public static void insertPhoneNumber(Integer pnPhoneNumber, String pcUsername) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.insertPhoneNumber(?,?)}");
        
        stmt.setInt(1, pnPhoneNumber);
        stmt.setString(2, pcUsername);
        stmt.execute();
    }
    
    // UserWantsProduct
    // Function to delete a userwantsproduct of the system
    public static void deleteUserWantsProduct(String pcUsername, Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.deleteUserWantsProduct(?,?)}");
        
        stmt.setString(1, pcUsername);
        stmt.setInt(2, pnIdProduct);
        stmt.execute();
    }
    
    // Procedure to insert a userwantsproduct in the system
    public static void insertUserWantsProduct(String pcUsername, Integer pnIdProduct) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.insertUserWantsProduct(?,?)}");
        
        stmt.setString(1, pcUsername);
        stmt.setInt(2, pnIdProduct);
        stmt.execute();
    }
    
    public static ResultSet getTopUserSales(Integer n) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getTopUserSales(?)}");
        
        stmt.setInt(1,n);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getTopUserPurchases(Integer n) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getTopUserPurchases(?)}");
        
        stmt.setInt(1,n);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getBestReviewedUsers(Integer n) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getBestReviewedUsers(?)}");

        stmt.setInt(1,n);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getWorstReviewedUsers(Integer n) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getWorstReviewedUsers()}");

        stmt.setInt(1,n);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getTopPricesPerCategory(Integer n, Integer pnID_Category) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getTopPricesPerCategory(?, ?)}");

        stmt.setInt(1, n);
        stmt.setInt(2, pnID_Category);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getMaxMinPurchaseAmountPerCategory() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getMaxMinPurchaseAmountPerCategory()}");

        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getSearchedProducts(String psSearchWord) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getSearchedProducts(?)}");

        stmt.setString(1, psSearchWord);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getViewsHistory(String psUsername) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getViewsHistory(?)}");

        stmt.setString(1, psUsername);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getSoldProducts(String psUsername) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getSoldProduct(?)}");

        stmt.setString(1, psUsername);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getPurchasesOver1000PerCategory(String psUsername, Integer pnID_Category) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getPurchasesOver1000PerCategory(?, ?)}");

        stmt.setString(1, psUsername);
        stmt.setInt(2, pnID_Category);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getPurchaseHistory(String psUsername, Integer month) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getPurhaseHistory(?, ?)}");

        stmt.setString(1, psUsername);
        stmt.setInt(2, month);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getUserAgeRangePerGender(Integer pnID_Gender) throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call us.getUserAgeRangePerGender(?)}");

        stmt.setInt(1, pnID_Gender);
        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getProductPercentagePerCategory() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getProductPercentagePerCategory()}");

        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getSalesPercentagePerGender() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getSalesPercentagePerGender()}");

        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
    
    public static ResultSet getPurchaseAmountPercentagePerGender() throws SQLException{
        Connection con = getConnectionDataBase();
        CallableStatement stmt = con.prepareCall("{ call sh.getPurchaseAmountPercentagePerGender()}");

        ResultSet r = (ResultSet) stmt.executeQuery();
        return r;
    }
}
