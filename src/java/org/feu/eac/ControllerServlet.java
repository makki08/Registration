/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.feu.eac;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.feu.eac.dto.User;

/**
 *
 * @author makki
 */
public class ControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        //processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (request.getParameter("login").equals("Login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Login login = new Login();
            User user = login.authenticate(username, password);
            
            //boolean valid = login.authenticate(username, password);
            
//            User user = new User();
//            user.setAccount_id(1);
//            user.setFirst_name("makki");
//            user.setLast_name("menzon");
//            user.setEmail("makki@yahoo.com");
//            user.setUsername("makki");
//            user.setPassword("password");
            
            //if (!user.getUsername().equals("")) {
            if (!user.getUsername().equals("")) {
                //request.getSession().setAttribute("makki", "makkivalue");
                request.getSession().setAttribute("user", user);
                response.sendRedirect("success.jsp");
                //request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("errorMessage", "Invalid Username/Password");
                response.sendRedirect("index.jsp");
                //request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        } else if (request.getParameter("login").equals("Register")){
            out.println("Register was pressed");
        }
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
