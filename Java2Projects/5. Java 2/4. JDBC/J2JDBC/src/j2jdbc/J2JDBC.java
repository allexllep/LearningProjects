package j2jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class J2JDBC {
    
    static String DRV_NAME = "com.mysql.cj.jdbc.Driver";
    static String CONN_STRING = "jdbc:mysql://localhost:3306/?user=root&password=root";
    
    public static void main(String[] args) {

             Enumeration<Driver> drivers = DriverManager.getDrivers();
             while(drivers.hasMoreElements()) System.out.println(drivers.nextElement()); // этот код нужен только для того, чтобы найти название драйвера и создать строку с этим названием.
        
        try {     
            Class.forName(DRV_NAME); // искуственная подгрузка драйвера в память нужна, чтобы проверить, правильно ли/без ошибок закачался драйвер. Если драйвер неправильно подгружен, то программа сообщит, что такого класса нет.
        } catch (ClassNotFoundException ex) {
            System.out.println("No MySQL driver found!");
            return;
        }
        Connection conn;
        
        try {
            conn = DriverManager.getConnection(CONN_STRING);
        } catch (SQLException ex) {
            System.out.println("Cannot open connection: " + ex.getMessage());
            return;
        }
        
        try {
            ResultSet rs = conn.getMetaData().getCatalogs();
            while(rs.next()){
                System.out.println(rs.getString("TABLE_CAT"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        try{
            Statement st = conn.createStatement();
            //st.executeUpdate("CREATE DATABASE db"); // метод, который меняет базу
            st.executeUpdate("USE db");
            //st.executeUpdate("CREATE TABLE persons (id int(4) not null primary key auto_increment, name varchar(64), age int(4))");
            // st.executeUpdate("INSERT INTO persons (name, age) VALUES ('Name325', 33)");
            ResultSet rs = st.executeQuery("SELECT * FROM persons ORDER BY name"); //Запрос, результат которого направлен в программу из базы (получим данные).
           
            while(rs.next()) System.out.println(rs.getString("id") + " " + rs.getString("name") + " " + rs.getString("age"));
            
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM persons WHERE age=?"); //подготовленный запрос. Он будет отправлен на сервер по частям, на сервере склеян и проверен на корректность (если пройдет проверку - будет исполнен). Если запрос передается на сервер полностью, происходит только проверка на синтаксис.
//            ps.setInt(1, 33);
//            rs = ps.executeQuery();
            while(rs.next()) System.out.println(rs.getString("name"));
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
