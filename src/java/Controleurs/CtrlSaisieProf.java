/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import Classes.Professeur;
import ClassesDAO.DAOFactory;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Acer
 */
public class CtrlSaisieProf extends HttpServlet implements ICommand  {
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    { 
         HttpSession session = request.getSession();
        String message= "";
        String nomProf  = (String) request.getParameter("NomProf");
        String prenomProf  = (String) request.getParameter("PrenomProf");
        try
        {
        if ((prenomProf.length() == 0) && (nomProf.length() == 0))
           {
            message = "Veuillez saisir un nom et un prénom";
           }
            else
            if (nomProf.length() == 0)
            {
                message = "Veuillez saisir un nom";
                request.setAttribute("ancprenom", prenomProf);
            }
                else
                if (prenomProf.length() == 0)
                {
                    message = "Veuillez saisir un prénom";
                    request.setAttribute("ancnom", nomProf);
                }
                else 
                    {
                    Professeur leprof = new Professeur();
                    leprof.setNom(nomProf);
                    leprof.setPrenom(prenomProf);
                    ClassesDAO.DAO<Professeur> profDao = DAOFactory.getProfesseurDAO();
                    Boolean retour = profDao.create(leprof);
                    message = "prof créé : ";
                    request.setAttribute("nom", nomProf);
                    request.setAttribute("prenom", prenomProf);
                    // on alimente la variable de session "nom"
                    session.setAttribute("nom", nomProf);
                    session.setAttribute("prenom", prenomProf);
                    } 
        }
        catch (Exception e) {
                e.printStackTrace();
        }  
        request.setAttribute("message", message);
       
        // donne la page à afficher
        return ("SaisieProf.jsp");   
    }
}
