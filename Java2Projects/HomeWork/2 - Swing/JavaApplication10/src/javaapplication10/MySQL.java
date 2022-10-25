package javaapplication10;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//  Create Table dbo.pictures(
//	id    int   NOT NULL,
//	photo image NOT NULL,
//	name  nvarchar(50) NULL,
//  Constraint PK_pictures primary key clustered (id ASC) )

public class MySQL {
    static String url;
    static{
         url="jdbc:mysql://localhost:3306/?user=root&password=root";
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
         }catch(ClassNotFoundException ex) { 
             System.err.println(ex.getMessage()); }
    }
    public static void putPhoto(String name, String path){
       try(Connection con=DriverManager.getConnection(url)){
           
         File file=new File(path); 
         if (!file.exists()) return;
         int  size=(int)file.length();
         
         BufferedInputStream fis=new BufferedInputStream(
                                new FileInputStream(file));
         
         String sql="Insert into db.pictures (name,photo) Values(?,?)";
         PreparedStatement pst=con.prepareStatement(sql);
         pst.setString(1, name);
         pst.setBinaryStream(2, fis, size);
         pst.executeUpdate();
       }
       catch(SQLException | IOException ex) { 
           System.err.println(ex.getMessage()); } 
    }
    public static String[] getPhotos() {
        ArrayList<String> list=null;
            // получить из базы id и name всех изображений
        try {
            Connection con = DriverManager.getConnection(url);
            String sql = "SELECT id, name FROM db.pictures";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<>();
            while(rs.next()) list.add(rs.getString("id") + " " + rs.getString("name"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        // вернуть результат запроса в виде массива строк
        return list.toArray(new String[]{});
    }
    public static InputStream getPhoto(int id){
        InputStream in=null;
        
        try(Connection con=DriverManager.
                        getConnection(url,"root","root")){
    
            String sql="Select photo from db.Pictures where id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs=pst.executeQuery();
            rs.next();
            in=rs.getBinaryStream(1); 
        }
        catch(SQLException ex) { System.err.println(ex.getMessage()); } 
        
        return in; 
    }
}
