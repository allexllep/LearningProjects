package dbmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoMySQl {

    private String driver;
    private String url;

    public DoMySQl(String driver, String url) {
        this.driver = driver;
        this.url = url;
        this.addDriver(driver);
    }
    
   private void addDriver(String DriverName){
        try {     
            Class.forName(DriverName);
        } catch (ClassNotFoundException ex) {
            System.out.println("No MySQL driver found!");
            return;
        }
    }
    
    public void getCatalogList(){
        try {
           Connection conn = DriverManager.getConnection(url);
            ResultSet rs = conn.getMetaData().getCatalogs();
            while(rs.next()){
                System.out.println(rs.getString("TABLE_CAT"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
    public void createDatabase(String NameOfDB){
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            st.executeUpdate("CREATE DATABASE " + NameOfDB);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void createTable(String DBName, String NameOfNewTable){
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            st.executeUpdate("CREATE TABLE " + DBName + "." + NameOfNewTable + " (id int(4) not null primary key auto_increment, name varchar(64), age int(4))");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void insertIntoDB(String DBName, String NameOfTable, String Name, int Age){
        try {
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + DBName + "." + NameOfTable + "(name, age) VALUES (?, ?)");
            ps.setString(1, Name);
            ps.setInt(2, Age);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void returnOfData(String DBName, String NameOfTable, int Age){
        try {
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + DBName + "." + NameOfTable + " WHERE age=?");
            ps.setInt(1, Age);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) System.out.println(rs.getString("name"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void returnAllDataNameOrdered(String DBName, String NameOfTable){
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM " + DBName + "." + NameOfTable + " ORDER BY name");
            while(rs.next()) System.out.println(rs.getString("id") + " " + rs.getString("name") + " " + rs.getString("age"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
}
