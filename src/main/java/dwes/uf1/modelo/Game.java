/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dwes.uf1.modelo;

/**
 *
 * @author manuc
 */
public class Game {
    private int id;
    private String name, developer;
    private float price;
    private int year;
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public String getDeveloper() {
        return developer;
    }
    
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public Game() {
        this.id = -1;
        this.name = "";
        this.developer = "";
        this.price = 0f;
        this.year = 0; 
    }
    
    public Game(int id, String name, String developer, float price, int year) {
        this.id = id;
        this.name = name;
        this.developer = developer;
        this.price = price;
        this.year = year;
    }   
    
    public Game(String name, String developer, float price, int year) {
        this.name = name;
        this.developer = developer;
        this.price = price;
        this.year = year;
    } 
}
