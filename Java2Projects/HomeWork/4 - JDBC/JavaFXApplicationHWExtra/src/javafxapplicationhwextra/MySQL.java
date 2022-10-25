package javafxapplicationhwextra;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class MySQL{
    
    static String url = "jdbc:mysql://localhost:3306/?user=root&password=root";
    static String DBName = "DemoDB12";
    static String TableName = "DemoPictures12";
    static{
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
         }catch(ClassNotFoundException ex) { System.out.println(ex.getMessage()); }
    }
    
    static void upload(File file){
        try(Connection con=DriverManager.getConnection(url)){
       
        if (!file.exists()) return;
        String name = file.getName();
        int  size=(int)file.length();        
        BufferedInputStream fis=new BufferedInputStream( new FileInputStream(file));
         
        Statement st = con.createStatement();
        st.executeUpdate("USE " + DBName);
        PreparedStatement ps=con.prepareStatement("Insert into " + TableName + " (name,photo) Values(?,?)");
        ps.setString(1, name);
        ps.setBinaryStream(2, fis, size);
        ps.executeUpdate();
        } catch(SQLException | IOException ex) { System.err.println(ex.getMessage()); } 
        getItemsFromDB();
    }  
    
    static void getItemsFromDB(){
        
        JavaFXApplicationHWExtra.items.clear();
        
        try(Connection con=DriverManager.getConnection(url)){
            
            Statement st = con.createStatement();
 
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DBName);
            st.executeUpdate("USE " + DBName);          
            st.executeUpdate("CREATE TABLE IF NOT EXISTS " + TableName + "(id int(4) not null primary key auto_increment, photo blob NOT NULL, name  varchar(50) NULL)");
            
            ResultSet rs = st.executeQuery("SELECT id, name FROM " + TableName + " ORDER BY name");
            List<String> list = new LinkedList<>();
            while(rs.next()) list.add(rs.getString("id") + " " + rs.getString("name"));
            JavaFXApplicationHWExtra.items.addAll(list);
            
        } catch(SQLException ex) { System.err.println(ex.getMessage());}
    }   

    static InputStream getPhoto(String item){
        
        StringTokenizer strt=new StringTokenizer(item);
        int id = Integer.parseInt(strt.nextToken());
        
        InputStream is=null;      
        try(Connection con=DriverManager.getConnection(url)){
            con.createStatement().executeUpdate("USE " + DBName);
            PreparedStatement ps=con.prepareStatement("Select photo from " + TableName + " where id=?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            rs.next();
            is=rs.getBinaryStream(1); 
        } catch(SQLException ex) { System.err.println(ex.getMessage());}
            
        return is;
    } 
}
