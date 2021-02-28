package projectFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private Connection connection;
//	Username of the DB
	private String userName = "root";

//	Password of the DB
	private String password = "";

//	Specify the URL
	private String urlToConnect = "jdbc:mysql://localhost:3306/project";
    
    public DBConnection() throws ClassNotFoundException, SQLException{
            
    		Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(urlToConnect, userName, password);
    }
    
    public Connection getConnection(){
            return this.connection;
    }
    
    public void closeConnection() throws SQLException {
            if (this.connection != null)
                    this.connection.close();
    }

}
