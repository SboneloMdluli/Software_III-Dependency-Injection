/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaround;

/**
 *
 * @author mylaptop
 */
   // chief 
        class chief{
            Menu chiefMenu = new MenuImpl(); // must inject
             chief(){
                 chiefMenu.addMeal("Ramen", 45, 20);
                 chiefMenu.addMeal("Gyoza",65 , 30);
                 chiefMenu.addMeal("Okonimiyaki", 88, 25);
                 chiefMenu.addMeal("Yakitori", 80, 35);
                 chiefMenu.addMeal("Chidori", 85, 35);

             }
             
             void getMenu(){ 
                 chiefMenu.printMenu();
             }
            
        }