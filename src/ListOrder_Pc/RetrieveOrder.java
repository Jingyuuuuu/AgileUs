/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetrieveOrder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lim
 */
public class RetrieveOrder {

  
    
    
    public static void main(String[] args) {
     
      Scanner scanner= new Scanner(System.in);
        String Ans;
       ArrayList<String> odList = new ArrayList<String>();
       
       odList.add("Chicken Burger (Rm 5.99)");
       odList.add("Cola (Rm3.00)");
       odList.add("Sundae Ice cream (Rm1.00)");
       odList.add("Total:Rm 8.99");
    
    System.out.printf("View Order Details? (Y/N) : ");
     Ans=scanner.nextLine();
     System.out.println();
     
     if(Ans.equals("Y")|| Ans.equals("y")){
    
    System.out.printf("%20s", "-----------------Order Details---------------------");
    System.out.println();
    
       for (int i = 0; i < odList.size(); i++) {
           
           System.out.println(odList.get(i));
      
}
       System.out.println("---------------------------------------------------");
     
       System.out.println();
       System.out.print("Are you confirm with these order? (Y/N) : ");       
        Ans=scanner.nextLine();
        System.out.println();
        
        if(Ans.equals("Y")|| Ans.equals("y")){
            System.out.print("Succesful! Your Order has been confirmed and being process.");
           
        }else{
            
            System.out.print("Your Order has been cancelled successful.");
        }
        
        System.out.println();
        System.out.println();
        System.out.printf("%50s\n","**Thankyou and have a nice day**");
        
         
        
       
    }
    
     else{
          System.out.printf("%50s\n","**Thankyou and have a nice day**");

     }
}
}
