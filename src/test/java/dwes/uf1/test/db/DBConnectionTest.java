package dwes.uf1.test.db;

import dwes.uf1.db.DBConnection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {

    DBConnection dBConnection;
    Connection connection;
   
    @After
    public void cleanUp() throws SQLException {
      if(connection != null){
        connection.close();
      }
    }
    
    @Test
    public void connectarAmbLaBaseDeDades() throws IOException, SQLException {
        if(connection != null){
            connection.close();
        }
        dBConnection = new DBConnection("db-test.properties");
        connection = dBConnection.getConnection();
        System.out.println(connection);
        Assert.assertEquals("H2 JDBC Driver", connection.getMetaData().getDriverName());
        Assert.assertEquals("SOCIOC_DB", connection.getCatalog());
    }

}