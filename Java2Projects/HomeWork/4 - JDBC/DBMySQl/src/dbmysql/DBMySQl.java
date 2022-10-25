package dbmysql;

public class DBMySQl {
    
    static String DRV_NAME = "com.mysql.cj.jdbc.Driver";
    static String CONN_STRING = "jdbc:mysql://localhost:3306/?user=root&password=root";
    static String DBName = "DemoDB2";
    static String TableName = "DemoTable2";
    
    public static void main(String[] args) {

        DoMySQl dm = new DoMySQl(DRV_NAME, CONN_STRING);

        dm.createDatabase(DBName);
        dm.getCatalogList();
        dm.createTable(DBName, TableName);
        dm.insertIntoDB(DBName, TableName, "Name325", 20);
        dm.insertIntoDB(DBName, TableName, "Name123", 20);
        dm.insertIntoDB(DBName, TableName, "Name000", 37);
        dm.insertIntoDB(DBName, TableName, "Name333", 33);
        dm.returnAllDataNameOrdered(DBName,TableName);
        dm.returnOfData(DBName,TableName,20);
    }
    
}
