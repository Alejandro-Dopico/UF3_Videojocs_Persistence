/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dwes.uf1.test.games;

import dwes.uf1.test.games.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import dwes.uf1.modelo.Game;
import dwes.uf1.dao.GameDAO;
import dwes.uf1.db.DBConnection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author alumne_2n
 */
public class GamesDAOTest {

    private DBConnection dBConnection;
    private String connectionProperties = "db-test.properties";

    GameDAO gamesDAO;
    
    @Before
    public void setUp() {
        dBConnection = new DBConnection(connectionProperties);
        gamesDAO = new GameDAO(dBConnection);
    }

    @After
    public void tearDown() throws IOException, SQLException {
        gamesDAO.getConnection().close();
    }
    
    @Test
    public void findAllGames() {
        List<Game> games = gamesDAO.findAllGames();
        Assert.assertEquals("Hauriem de tenir 2 usuaris a la base de dades", 2, games.size());
    }
    
    
    @Test
    public void findGameById() throws Exception {
        int existingId = 1;
        int unknownId = 10;

        Game game = gamesDAO.findGameById(existingId);
        Assert.assertNotNull(game);
        game = gamesDAO.findGameById(unknownId);
        Assert.assertNull(game);
    }
    
    @Test
    public void findUserByDeveloper() throws Exception {
        String existingDeveloper = "Capcom";
        String unknownDeveloper = "Alejandro";

        Game game = gamesDAO.findUserByDeveloper(existingDeveloper);
        Assert.assertNotNull(game);
        game = gamesDAO.findUserByDeveloper(unknownDeveloper);
        Assert.assertNull(game);
    }
    
    @Test
    public void createGame() throws Exception {
        int id = 100;
        String name = "Dino Crisis";
        String developer = "Capcom";
        float price = (float) 10.99;
        int year = 2003;
        gamesDAO.createGame(id, name, developer, price, year);
        Game createdGame = gamesDAO.findGameById(id);
        Assert.assertNotNull(createdGame);
        Assert.assertEquals(name, createdGame.getName());
        Assert.assertNotEquals(0, createdGame.getId());
    }

    
    @Test
    public void updateGame() throws Exception {
        int id = 100;
        String name = "Dino Crisis 1";
        String developer = "Capcom";
        float price = (float) 10.99;
        int year = 2003;
        gamesDAO.createGame(id, name, developer, price, year);
        Game createdGame = gamesDAO.findGameById(id);
        System.out.println("AYUDA" + createdGame);
        Assert.assertNotNull(createdGame);
        Assert.assertEquals(name, createdGame.getName());
        createdGame = gamesDAO.updateGame(id, "hola", developer, price, year);
        Assert.assertEquals("hola", createdGame.getName());
        Assert.assertNotEquals(0, createdGame.getId());
    }
    
    @Test
    public void deleteUser() throws Exception {
        int id = 100;
        String name = "Dino Crisis";
        String developer = "Capcom";
        float price = (float) 10.99;
        int year = 2003;
        
        gamesDAO.createGame(id, name, developer, price, year);
        Game createdGame = gamesDAO.findGameById(id);
        Assert.assertNotNull(createdGame);
        Assert.assertEquals(id, createdGame.getId());
        Assert.assertNotEquals(0, createdGame.getId());
        gamesDAO.deleteGame(id);
    }

    
}
