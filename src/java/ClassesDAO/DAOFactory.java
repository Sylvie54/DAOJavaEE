/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import java.sql.Connection;

/**
 *
 * @author Acer
 */
public class DAOFactory  {
   
    protected static final Connection conn = ConnectDAO.getInstance()  ;   
   
  /**
  * Retourne un objet Classe interagissant avec la BDD
  * @return DAO
  */
  public static DAO getClasseDAO() throws Exception{
    return new ClasseDAO(conn);
  }

  /**
  * Retourne un objet Professeur interagissant avec la BDD
  * @return DAO
  */
 public static DAO getProfesseurDAO() throws Exception{
    return new ProfesseurDAO(conn);
  }

  /**
  * Retourne un objet Eleve interagissant avec la BDD
  * @return DAO
  */
  public static DAO getEleveDAO() throws Exception{
    return new EleveDAO(conn);
  }

  /**
  * Retourne un objet Matiere interagissant avec la BDD
  * @return DAO
  */
  public static DAO getMatiereDAO() throws Exception{
    return new MatiereDAO(conn); 
  }   
}
