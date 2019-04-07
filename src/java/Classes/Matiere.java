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


public class Matiere {
  //ID
  private int id = 0;
  //Nom du professeur
  private String nom = "";

  public Matiere(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public Matiere(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) throws Exception {
      if (nom.length() == 0)
        throw new Exception("Veuillez saisir un nom");
    else
    this.nom = nom;
  }   
}