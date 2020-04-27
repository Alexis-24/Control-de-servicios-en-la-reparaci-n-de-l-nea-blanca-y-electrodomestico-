/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import conexion.Database;

/**
 *
 * @author roy_b
 */
public class Servicios {

 public static void menu(){
     Login obj=new Login();
       
        obj.setVisible(true);
        obj.setResizable(false);}

    public static void main(String[] args) {
        new Database("localito");
        menu();
    }
    
}
