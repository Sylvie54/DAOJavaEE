package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controleurs.ICommand;
import Controleurs.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 * @author Acer
 */
@WebServlet(urlPatterns = {"/aiguillage"})
public class ServletDAO extends HttpServlet {

    private Map commands=new HashMap();
    
     public void init()
     { 
         commands.put("page1", new CtrlPageClasse()) ;
         commands.put("page2", new CtrlPageProf()) ;
         commands.put("page3", new CtrlSaisieClasse()) ;
         commands.put("page4", new CtrlSaisieProf()) ;
         commands.put("page5", new CtrlIndex()) ;
                              
 }  
    
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
        
        // Ouverture des sessions
         HttpSession session = request.getSession(true);
        
        // On récupère le paramètre passé par la page précédente ex : "ServletMvc?cmd=page1"
        String cmd=request.getParameter("cmd");
        // On récupère la classe "controleur" qui se trouve en valeur de la clé passée en paramètre et on instencie un objet com de cette classe
        // ex : CtrlPageClasse() pour paramètre égal à 1
        ICommand com=(ICommand)commands.get(cmd);
        // On appelle la méthode "execute" de cette classe et on récupère  dans "urlsuite" l'url de la page à afficher 
        // plus toutes les info nécessaire à la page à afficher dans "resquest"
        String urlSuite=com.execute(request, response);
        
         // récupération de l'id de la session
         session.setAttribute("id",session.getId() );
                
        // On dispatche avec les nouvelles valeurs éventuelles passées par la classe 
        request.getRequestDispatcher(urlSuite).forward(request, response);
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
