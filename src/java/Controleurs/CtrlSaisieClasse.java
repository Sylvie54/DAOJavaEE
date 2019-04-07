/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import Classes.Classe;
import ClassesDAO.DAOFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;


/**
 *
 * @author Acer
 */
public class CtrlSaisieClasse extends HttpServlet implements ICommand {
    
    // méthode override interface ICommand 
   public String execute(HttpServletRequest request, HttpServletResponse response) 
    { 
        
        String message = "";
        String nomClasse  = (String) request.getParameter("NomClasse");
        try
        {
            if (nomClasse.length() == 0)
            {
                message = "Veuillez saisir un nom de classe";
            }
            else
                {
                Classe laclasse = new Classe();
                laclasse.setNom(nomClasse);
                ClassesDAO.DAO<Classe> classeDao = DAOFactory.getClasseDAO();
                Boolean retour = classeDao.create(laclasse);
                message = "classe crée";

            } 
        }
        catch (Exception e) {
                e.printStackTrace();
        }     
                    
        // envoie un paramètre en réponse
        request.setAttribute("message", message);
        // donne la page à afficher
        return ("SaisieClasse.jsp");   
    }
    
}
