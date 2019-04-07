/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Acer
 */

public class Eleve {
  //ID
  private int id = 0;
  //Nom de l'élève
  private String nom = "";
  //Prénom de l'élève
  private String prenom = "";
   
  public Eleve(int id, String nom, String prenom) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
  }
  public Eleve(){};
     
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom)throws Exception{
      if (nom.length() == 0)
        throw new Exception("Veuillez saisir un nom");
    else
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) throws Exception {
     if (prenom.length() == 0)
        throw new Exception("Veuillez saisir un prénom");
    else 
    this.prenom = prenom;
  }   
}
