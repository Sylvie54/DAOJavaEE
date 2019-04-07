/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Professeur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Acer
 */

//CTRL + SHIFT + O pour générer les imports
public class ProfesseurDAO extends DAO<Professeur> {
  public ProfesseurDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Professeur obj) {
    return false;
  }

  public boolean delete(Professeur obj) {
    return false;
  }

  public boolean update(Professeur obj) {
    return false;
  }
   
  public Professeur find(int id) throws Exception {
    Professeur professeur = new Professeur();            
    try {
      Statement stm = connect.createStatement();
      ResultSet result = stm.executeQuery("SELECT * FROM professeur WHERE prof_id = " + id);
      while (result.next())
        {
        professeur = new Professeur(id, result.getString("prof_nom"), result.getString("prof_prenom"));
     
        MatiereDAO matDao = new MatiereDAO(this.connect);
     
        professeur.addMatiere(matDao.find(result.getInt("mat_id")));
        // pour test .find renvoie 1 seul enregistrement
        professeur.addMatiere(matDao.find(3));
        professeur.addMatiere(matDao.find(2));
        }
    } catch (SQLException e) {
      throw new Exception("pb professeurDAO : " + e);
    }
    return professeur;
  }

  
}
