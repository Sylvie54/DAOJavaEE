/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import Classes.Matiere;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Acer
 */

//CTRL + SHIFT + O pour générer les imports
public class MatiereDAO extends DAO<Matiere> {
  public MatiereDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Matiere obj) {
    return false;
  }

  public boolean delete(Matiere obj) {
    return false;
  }

  public boolean update(Matiere obj) {
    return false;
  }

  public Matiere find(int id) throws Exception{
    Matiere matiere = new Matiere();  

    try {
      Statement stm = connect.createStatement();
      ResultSet result = stm.executeQuery("SELECT * FROM matiere WHERE mat_id = " + id);
      while (result.next())  
      {
              matiere = new Matiere(id, result.getString("mat_nom"));   
      }
    } catch (SQLException e) {
     throw new Exception("pb MatiereDAO : " + e);
    }
    return matiere;
  }
}
