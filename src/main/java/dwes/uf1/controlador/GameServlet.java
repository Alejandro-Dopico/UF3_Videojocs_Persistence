/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dwes.uf1.controlador;

import dwes.uf1.modelo.Game;
import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dwes.uf1.modelo.GameServicio;
import javax.servlet.annotation.WebServlet;


/**
 *
 * @author manuc
 */
@WebServlet(name = "GameServlet", urlPatterns = {"/GameServlet"})
public class GameServlet extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private final GameServicio service = new GameServicio();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            String value = request.getParameter("id");
            if (value != null) {
                int id = Integer.parseInt(value);
                request.setAttribute("single_product", service.getGame(id));
            } else {
                request.setAttribute("game_list", service.getGames());
            }
            getServletConfig().getServletContext().getRequestDispatcher("/game.jsp").forward(request,response);
        
        }else {
            if("addform".equals(action)) {
                getServletConfig().getServletContext().getRequestDispatcher("/addform.jsp").forward(request,response);
            } else if ("add".equals(action)){
                String name = request.getParameter("name");
                String developer = request.getParameter("developer");
                float price = Float.parseFloat(request.getParameter("price"));
                int year = Integer.parseInt(request.getParameter("year"));
                service.addGame(name, developer, price, year);
                request.setAttribute("game_list",service.getGames());
                getServletConfig().getServletContext().getRequestDispatcher("/game.jsp").forward(request,response);
            } else if ("delete".equals(action)){  
                int id = Integer.parseInt(request.getParameter("id"));
                service.deleteGame(id);
                request.setAttribute("game_list",service.getGames());
                getServletConfig().getServletContext().getRequestDispatcher("/game.jsp").forward(request,response);
            } else if ("update".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id")); 
                request.setAttribute("single_product", service.getGame(id));
                getServletConfig().getServletContext().getRequestDispatcher("/update.jsp").forward(request,response);
            } else if ("updateform".equals(action)){
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String developer = request.getParameter("developer");
                float price = Float.parseFloat(request.getParameter("price"));
                int year = Integer.parseInt(request.getParameter("year"));
                service.updateGame(id, name, developer, price, year);
                request.setAttribute("game_list",service.getGames());
                getServletConfig().getServletContext().getRequestDispatcher("/game.jsp").forward(request,response);
            }
        }
    }
        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}