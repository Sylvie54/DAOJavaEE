/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

/**
 *
 * @author Acer
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Connection;


/**
 *
 * @author Acer
 */
public class ConnectDAO {
    
   private static Connection conn;
   
    private ConnectDAO() throws Exception
            
    {
        File fichier = null;
        
        try
        {
         final Properties prop = new Properties();
         fichier = new File("properties");
         if (!fichier.exists())
         {
           System.out.println("non existe");
           fichier = new File("C:\\Users\\Acer\\Documents\\NetBeansProjects\\DAOJavaEE\\src\\java\\Config\\properties.properties");  
          // fichier = new File("C:\\Users\\Utilisateur\\Documents\\NetBeansProjects\\DAOJavaEE\\src\\java\\Config\\properties.properties");  
         }   
         
        FileInputStream input = new FileInputStream(fichier);
         
        // load a properties file
	prop.load(input);
        
        String driver =(prop.getProperty("sgbd.driver"));        
        String mysqlUser = prop.getProperty("sgbd.login");
        String mysqlPassword = prop.getProperty("sgbd.password");
        String connexionString = prop.getProperty("sgbd.connexionString");   
       
        // Class.forName("com.mysql.jdbc.Driver" );
        
        //  conn = DriverManager.getConnection("jdbc:mysql://localhost/filrouge_active?", "root", "");  
       
      Class.forName(driver);
       conn = DriverManager.getConnection(connexionString, mysqlUser, mysqlPassword);  
              
        }
        
        catch (Exception e)
        {    
         throw new Exception("pb ConnectDAO : " + e);
        
        }
     } 
     //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
   public static Connection getInstance()
   {
       
   if(conn == null){
       try
       {    
      new ConnectDAO();
       }
       catch (Exception e)
               {
                   e.printStackTrace(); 
               }        
    }
       
    return conn;
  }  
}

