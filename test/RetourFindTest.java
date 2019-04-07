/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Classe;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import ClassesDAO.ClasseDAO;
import ClassesDAO.DAOFactory;

/**
 *
 * @author Acer
 */
public class RetourFindTest{
    
    public RetourFindTest() {
    }
    
   
    
    @Test
     public void TestFindClient() {
     System.out.println("TestAccesClient");
     try {
         
       Classe testClasse =  findClasse();
       assertNotNull(testClasse);
     }
     catch (Exception e)
             {
                 System.out.println("Erreur TestFindClient" + e.getMessage());
             }
    }
     public Classe findClasse()
     {
         Classe laClasse = new Classe(); 
         String retour = "Ok";
         try {
         ClassesDAO.DAO<Classe> classeDao = DAOFactory.getClasseDAO();
         laClasse = classeDao.find(1);
         if (laClasse.getNom().length() == 0)
         {
         retour = "Ko";
         }
         
          System.out.println("nom : " + laClasse.getNom());
     }
     catch (Exception e)
             {
                 System.out.println("Erreur TestFindClient" + e.getMessage());
             }    
             
         return laClasse;
     }        

    
}
