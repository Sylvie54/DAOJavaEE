/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Classe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Acer
 */

//CTRL + SHIFT + O pour générer les imports
public class ClasseDAO extends DAO<Classe> {
    // constructeur, paramètre : la connexion
  public ClasseDAO(Connection conn) {
    super(conn);
  }

  // méthodes d'instance (CRUD)
  public boolean create(Classe obj) {
    return false;
  }

  public boolean delete(Classe obj) {
    return false;
  }
   
  public boolean update(Classe obj) {
    return false;
  }
  // retourne un objet Classe
  public Classe find(int id) throws Exception {
    Classe classe = null;            
    try 
    {
      Statement stm = connect.createStatement();
      ResultSet result = stm.executeQuery("SELECT * FROM classe WHERE cls_id = " + id);
      while (result.next())
        {
        classe = new Classe(id, result.getString("cls_nom"));
        }
          // on récupère le prof de la classe  
          ResultSet resultat = stm.executeQuery(
          "SELECT prof_id, prof_nom, prof_prenom from professeur where class_id = " + id);
         
        ProfesseurDAO profDao = new ProfesseurDAO(this.connect);

        while(resultat.next())  
        {
          classe.addProfesseur(profDao.find(resultat.getInt("prof_id")));
        }    
        
          ResultSet resultat2 = stm.executeQuery(
          "SELECT elv_id from eleve where classe_id = " + id);
         
        EleveDAO eleveDao = new EleveDAO(this.connect);
        while(resultat2.next())
         {
          classe.addEleve(eleveDao.find(resultat2.getInt("elv_id"))); 
         } 
       
    } catch (SQLException e) {
      throw new Exception("pb ClasseDAO : " + e);
    }
    return classe;
  }
}

