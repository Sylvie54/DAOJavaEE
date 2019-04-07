/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;



/**
 *
 * @author Utilisateur
 */

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.Professeur;

import ClassesDAO.*;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class CtrlPageProf extends HttpServlet implements ICommand  {
  // méthode override interface ICommand 
   public String execute(HttpServletRequest request, HttpServletResponse response)
    { 
    
        try
        {
            
           
        ClassesDAO.DAO<Professeur> profDao = DAOFactory.getProfesseurDAO();
            for(int i = 1; i < 2; i++){
                Professeur prof = profDao.find(i);
                request.setAttribute("leprof",prof);         
            }
       }
       catch (Exception e) {
             e.printStackTrace();
       } 
       return ("PageProfesseur.jsp");   
    }
}
