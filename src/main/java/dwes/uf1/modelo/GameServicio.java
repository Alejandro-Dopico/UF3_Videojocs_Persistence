package dwes.uf1.modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import dwes.uf1.dao.GameDAO;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuc
 */
public class GameServicio {
    
    List<Game> games = new ArrayList<>();
    int countGames = 0;
    GameDAO gameDAO = new GameDAO();
          
    public List<Game> getGames(){   
        return gameDAO.findAllGames();
    }  

    public Game getGame(int id) {
        Game product = null;
        try {
            product = gameDAO.findGameById(id);
        } catch (Exception ex) {
            Logger.getLogger(GameServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    public void addGame(String name, String developer, float price, int year){        
        try {
            gameDAO.createGame(name, developer, price, year);
        } catch (Exception ex) {
            Logger.getLogger(GameServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /*  Anteriormente pasabamos el objeto entero, ahora como el boton delete ya tiene el id,
        lo he simplificado, le paso a la función directamente el ID. */
    public void deleteGame(int id) {
        try {
            gameDAO.deleteGame(id);
        } catch (Exception ex) {
            Logger.getLogger(GameServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateGame(int id, String name, String developer, float price, int year){       
        try {
            gameDAO.updateGame(id, name, developer, price, year);
        } catch (Exception ex) {
            Logger.getLogger(GameServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
