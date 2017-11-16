/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AddDeliveryMen_Pb;

import static java.lang.System.in;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author X455LD
 */
public class AddDeliveryMen {
    
  private static final AtomicInteger count = new AtomicInteger(999);
    int id;
    String name;
    String ic;
    String address;
    String phoneNo;
    String email;
    String emergencyCall;
    String status;
    
    ArrayList<AddDeliveryMen> DmList =new ArrayList<AddDeliveryMen>(10); 
    private Scanner scan = new Scanner(System.in);
   
   public void addDetails(){    
       AddDeliveryMen dm = new AddDeliveryMen();
      int ans;
      do{
      
       System.out.print("Name : ");
       dm.name = scan.nextLine();
           
       System.out.print("IC : ");
       dm.ic = scan.nextLine();
     
       System.out.print("Address : ");
       dm.address = scan.nextLine();

       System.out.print("PhoneNo : ");
       dm.phoneNo = scan.nextLine();
       
       System.out.print("Email : ");
       dm.email = scan.nextLine();
       
       System.out.print("Emergency ContactNo : ");
       dm.emergencyCall = scan.nextLine();
       
       System.out.printf("%50s","Added Successful!");
       System.out.println();
      
       
       System.out.print("Would you like to add a new details for delivery man? (Choose 1 to continue, 0 to exit): ");
       ans=scan.nextInt();
       scan.nextLine();
       
      }while(ans==1);
       DmList.add(dm);
   }
   
    public void DisplayDetails(){
        System.out.printf("%20s %20s %20s %20s %20s %20s %20s %15s\n", "ID", "Name ", "IC ", "Address ", "PhoneNo ", "Email ", "    Emergency Call ", "Status ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
         for(AddDeliveryMen dm : DmList ){
            dm.id = count.incrementAndGet(); 
            dm.status = "Available";
            System.out.printf("%20s", dm.id);
            System.out.printf("%15s",dm.name);
            System.out.printf("%25s",dm.ic);
            System.out.printf("%25s",dm.address);
            System.out.printf("%20s",dm.phoneNo);
            System.out.printf("%20s",dm.email);
            System.out.printf("%20s",dm.emergencyCall);
            System.out.printf("%20s", dm.status);
            System.out.println();
            
        }
    }
    public static void main(String[] args) {
      AddDeliveryMen addDm = new AddDeliveryMen();
    
      System.out.printf("%50s\n","New Delivery Man");
      System.out.printf("%65s\n","--------------------------------------------");
      addDm.addDetails();
      
      System.out.println();
      System.out.printf("%80s\n","Latest Added Details of New Delivery Man ");
      System.out.printf("%75s\n","-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
       addDm.DisplayDetails();
    }
    
}
