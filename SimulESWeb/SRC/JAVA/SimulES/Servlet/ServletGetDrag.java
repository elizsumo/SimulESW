
package SimulES.Servlet;

import SimulES.Control.IndividualboardController;
import SimulES.Control.PlayerController;
import SimulES.Index;
import java.io.*;

import java.net.URLDecoder;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Elizabeth
 */
public class ServletGetDrag extends HttpServlet {

    /** 
     * Processes requests for HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");

        PrintWriter out = response.getWriter();

        HttpSession sesion = request.getSession();
        boolean error = false;

        String p = request.getParameter("player");
        String player = null;
        try {
            player = URLDecoder.decode(p, "UTF-8");
            if (player.equals("")) {
                error = true;
            }
        } catch (NullPointerException ex) {
            error = true;
        }

        String c = request.getParameter("configuration");
        String configuration = null;
        try {

            configuration = URLDecoder.decode(c, "UTF-8");
            if (configuration.equals("") || configuration.isEmpty() || configuration.equals(null)) {
                error = true;
                //configuration = "clean";
            }
        } catch (NullPointerException ex) {
            error = true;
        }

        String ub = request.getParameter("update_board");
        String update_board = null;
        try {
            update_board = URLDecoder.decode(ub, "UTF-8");
            if (update_board.equals("")) {
                error = true;
            }
        } catch (NullPointerException ex) {
            error = true;
        }

        if (error == false) {

            sesion.setAttribute("player", player);
            sesion.setAttribute("configuration", configuration);
            sesion.setAttribute("update_board", update_board);

            out.println("<respuesta>ok</respuesta>");
        } else {
            out.println("<respuesta>error</respuesta>");
        }

        out.close();
    }

    /**
     * Processes requests for HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");

        PrintWriter out = response.getWriter();

        boolean error = false;

        String p = request.getParameter("player");
        String player = null;
        try {
            player = URLDecoder.decode(p, "UTF-8");
            if (player.equals("")) {
                error = true;
            }
        } catch (NullPointerException ex) {
            error = true;
        }

        //PlayerController to get the player ID sending their username
        PlayerController pc = new PlayerController();
        int playerInt = (int) pc.getPlayerId(player);

        //Go to the DB to obtain the flag for this specific playerID
        IndividualboardController individualboardController = new IndividualboardController();
        int update_board = individualboardController.getPlayerUpdateBoard(playerInt);

        //If the column update_board equals to 1 change to 0
        //The constant "NoUpdateConfig" is used to not change the current value inside the DB
        if (update_board == 1) {
            individualboardController.updateConfigurationByPlayer(playerInt, "NoUpdateConfig", 0);
        }


        // Returns the update_board value
        if (error == false) {
            out.println("<respuesta>" + update_board + "</respuesta>");
        } else {
            out.println("<respuesta>error</respuesta>");
        }
        
        out.close();
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestGet(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
