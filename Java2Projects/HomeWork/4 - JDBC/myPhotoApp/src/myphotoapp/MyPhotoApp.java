package myphotoapp;

public class MyPhotoApp {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {System.out.println(ex.getMessage());}
        
        MySQL.putPhoto("mail.png", "C:\\Users\\allex\\Downloads\\mail.png");
        
        
        
    }
    
}
