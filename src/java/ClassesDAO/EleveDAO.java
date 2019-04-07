/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;
import Classes.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Acer
 */

//CTRL + SHIFT + I pour générer les imports
public class EleveDAO extends DAO<Eleve> {
  public EleveDAO(Connection conn) {
    super(conn);
  }

  public boolean create(Eleve obj) {
    return false;
  }

  public boolean delete(Eleve obj) {
    return false;
  }
   
  public boolean update(Eleve obj) {
    return false;
  }
   
  public Eleve find(int id) throws Exception
  {
    Eleve eleve = new Eleve();      
      
    try {
      Statement stm = connect.createStatement();
      ResultSet result = stm.executeQuery("SELECT * FROM eleve WHERE elv_id = " + id);
      while (result.next())
        {
          eleve = new Eleve(
          id,
          result.getString("elv_nom"),
          result.getString("elv_prenom")
        ); 
        }
    } 
      catch (SQLException e) {
      throw new Exception("pb EleveDAO : " + e);
    }
    return eleve;
  }
}
