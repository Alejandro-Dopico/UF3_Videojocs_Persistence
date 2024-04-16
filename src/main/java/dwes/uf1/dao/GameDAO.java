/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dwes.uf1.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import dwes.uf1.db.DBConnection;
import dwes.uf1.modelo.Game;

/**
 *
 * @author alumne_2n
 */
public class GameDAO {
    
    private DBConnection dBConnection;
    private Connection connection;
    

    public DBConnection getDBConnection() {
        return this.dBConnection;
    }
    
    public GameDAO() {
        this.dBConnection = new DBConnection("db-test.properties");
    }
    
    public GameDAO(DBConnection dBConnection) {
        this.dBConnection = dBConnection;
    }

    public List<Game> findAllGames() {
        String qry = "select id, name, developer, price, year from games";
        List<Game> games = executeQuery(qry);
        return games;
    }

    public Game findUserByDeveloper(String gameDeveloper) throws Exception {
        String qry = "select * from games where developer ='" + gameDeveloper + "'";
        return findUniqueResult(qry);
    }

    public Game findGameById(int id) throws Exception {
        String qry = "select * from games where id ='" + id + "'";
        return findUniqueResult(qry);
    }

    private Game buildGameFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String developer = rs.getString("developer");
        float price = rs.getInt("price");
        int year = rs.getInt("year");
        Game game = new Game(id, name, developer, price, year);
        return game;
    }

    private Game findUniqueResult(String query) throws Exception {
        List<Game> games = executeQuery(query);
        if (games.isEmpty()) {
            return null;
        }
        if (games.size() > 1) {
            throw new Exception("Only one result expected");
        }
        return games.get(0);
    }

    private List<Game> executeQuery(String query) {
        List<Game> games = new ArrayList<>();

        if (getConnection() == null) {
            try {
                setConnection(dBConnection.getConnection());
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        try (
            Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Game game = buildGameFromResultSet(rs);
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    private int executeUpdateQuery(String query) {
        int result = 0;
        if (getConnection() == null) {
            try {
                setConnection(dBConnection.getConnection());
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        try (
            Statement stmt = getConnection().createStatement()) {
            result = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Game createGame(String name, String developer, float price, int year) throws Exception {
      String qry = "INSERT INTO games (name, developer, price, year) VALUES ('"
        + name + "', '"
        + developer + "', '"
        + price + "', '"
        + year + "'"
        + ");";
        executeUpdateQuery(qry);
        return null;
    }
    /* Aquí hago una sobrecarga de metodo createGame, para facilitar la creacion con y sin el ID. */
    public Game createGame(int id, String name, String developer, float price, int year) throws Exception {
      String qry = "INSERT INTO games (id, name, developer, price, year) VALUES ('"
        + id + "', '"
        + name + "', '"
        + developer + "', '"
        + price + "', '"
        + year + "'"
        + ");";
        executeUpdateQuery(qry);
        return null;
    }
    
    public Game updateGame(int id, String name, String developer, float price, int year) throws Exception {
        String qry = "UPDATE games SET name = '" + name + "', developer = '" + developer + 
                     "', price = " + price + ", year = " + year + " WHERE id = " + id + ";";
        return createOrUpdateUser(id, qry);
    }
    
    private Game createOrUpdateUser(int id, String query) throws Exception {
        int result = executeUpdateQuery(query);
              if (result == 0) {
                      throw new Exception("Error creating user");
              } 
            
        return findGameById(id);
    }
    
    public void deleteGame(int id) throws Exception {
        String query = "DELETE FROM games WHERE id = '" + id + "' ";
        createOrUpdateUser(id, query);
    }

}
