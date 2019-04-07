/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Classes.Classe;

import ClassesDAO.*;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class CtrlPageClasse extends HttpServlet implements ICommand{
  // méthode override interface ICommand 
   public String execute(HttpServletRequest request, HttpServletResponse response)   
    { 
         //   ClassesDAO.DAO<Classe> classeDao = new ClasseDAO(ConnectDAO.getInstance());
        try
        {
        
           ClassesDAO.DAO<Classe> classeDao = DAOFactory.getClasseDAO();
           Classe classe = classeDao.find(1);
           //On récupère le nombre des élèves
           request.setAttribute("nombre",classe.getListEleve().size() );           
           // on envoie l'objet "classe"
           request.setAttribute("laclasse",classe );
   
    }
    
        catch (Exception e) {
                e.printStackTrace();
    }     
       
        // donne la page à afficher
        return ("PageClasse.jsp");   
    }
}
