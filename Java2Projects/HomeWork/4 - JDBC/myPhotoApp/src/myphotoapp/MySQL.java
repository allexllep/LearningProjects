package myphotoapp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
    static String url = "jdbc:mysql://localhost:3306/?user=root&password=root";
    
    static void putPhoto(String name, String path){
        try ( Connection con = DriverManager.getConnection(url);){
            Statement st = con.createStatement();
            st.executeUpdate("USE db");
//            st.executeUpdate("Create Table pictures(id int(4) not null primary key auto_increment, photo blob NOT NULL, name  varchar(50) NULL)");
            File file = new File(path);
            if(!file.exists()) return;
            int size = (int) file.length();
            BufferedInputStream fis=new BufferedInputStream(new FileInputStream(file));
            String sql = "Insert into pictures (name,photo) Values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setBinaryStream(2, fis, size);
            ps.executeUpdate();
            
//            ResultSet rs = st.executeQuery("select * from pictures ORDER BY name");
//            while(rs.next()) System.out.println(rs.getString("id") + " " + rs.getString("name"));

            
            
            
        } catch (SQLException | FileNotFoundException ex) {System.out.println(ex.getMessage());}


    }
}
