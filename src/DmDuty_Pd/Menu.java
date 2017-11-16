
package deliverymenduty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Owner-PC
 */
public class Menu {
    
    public static void main(String[] args){
        
        Menu menu = new Menu();
        menu.DisplayMenu();
           
    }
    public void DisplayMenu(){
        
        Menu menu = new Menu();
        
        System.out.println("\n--------------------------------------------");
        System.out.printf("|    Welcome to Staff Duty Management    |\n|    1.Staff Check-In   |\n|    2.Staff Check-Out  |\n|    0.Exit             |\n");
        System.out.println("--------------------------------------------");
        System.out.printf("\nYour Option: ");
        
        Scanner scanner = new Scanner(System.in);
        
        int choose = scanner.nextInt();
        
        if(choose ==1){
            
            menu.Option1(); 
            
        }else if(choose ==2){
            menu.Option2();
        }else if(choose ==0){           
            System.exit(0);
        }else{
            System.out.println("Sorry ! Wrong Option ! Try Again.");
            menu.DisplayMenu();
        }
        
    }
    public void Option1(){
        
        ArrayList<DeliverymenDuty> test = new ArrayList<DeliverymenDuty>();
        ArrayList<CheckinTable> test2 = new ArrayList<CheckinTable>();
        Scanner scanner = new Scanner(System.in);
        Menu menu= new Menu();
        int menuchoose;
            String StaffCheckin="";           
            String StaffCheckin2="";
            String StaffCheckin3=""; 
            test.add(new DeliverymenDuty("Mark","stf001",StaffCheckin));
            test.add(new DeliverymenDuty("Jack","stf002",""));
            test.add(new DeliverymenDuty("Jason","stf003",""));
            System.out.println();
            System.out.println("Staff\tStaffID\tCheckIn");
            for(DeliverymenDuty d: test){
                System.out.printf("%s\n",d);
            }
            System.out.println();
            menu.Option1chk();             
    }
    
    public void Option1chk(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();
        ArrayList<DeliverymenDuty> test = new ArrayList<DeliverymenDuty>();
        ArrayList<CheckinTable> test2 = new ArrayList<CheckinTable>();
        Scanner scanner = new Scanner(System.in);
        String cont = "";
        Menu menu= new Menu();
        int menuchoose;
            String StaffCheckin="";           
            String StaffCheckin2="";
            String StaffCheckin3=""; 
            String Staffpassword="";
            
        for(int i=0; i<4;i++){ 
        System.out.printf("Enter a staff to check in: ");
            String Staffname = scanner.next();
                        
            if(Staffname.equals("Mark")||Staffname.equals("mark")||Staffname.equals("MARK")){
                if(StaffCheckin==""){
                    System.out.printf("Enter Your Password\t : ");
                    Staffpassword = scanner.next();
                    if(Staffpassword.equals("mark123")){                                   
                        //System.out.printf("Enter check-in time\t : ");
                        //StaffCheckin = scanner.next();     
                        StaffCheckin = dateFormat.format(date);
                        test2.add(new CheckinTable("Mark","stf001",StaffCheckin));
                        test2.add(new CheckinTable("Jack","stf002",StaffCheckin2));
                        test2.add(new CheckinTable("Jason","stf003",StaffCheckin3));
                    }else{
                    System.out.printf("Wrong Password ! Please Try Again ! \n");
                    System.out.printf("1 - Try Again \n0 - Exit\n");
                    System.out.printf("Your Option: ");
                    int wrongpss = scanner.nextInt();
                    if(wrongpss==1){
                        menu.Option1chk();
                    }else if(wrongpss==0){
                        menu.DisplayMenu(); 
                    }else{
                        System.out.println("Sorry wrong option");
                        menu.Option1chk();
                    }                    
                }
                }else{
                    System.out.printf("This staff " + Staffname + " already Check in !\n");
                    menu.Option1chk();
                }          
            }else if(Staffname.equals("Jack")||Staffname.equals("jack")||Staffname.equals("JACK")){
                if(StaffCheckin2==""){
                    System.out.printf("Enter Your Password\t : ");
                    Staffpassword = scanner.next();
                    if(Staffpassword.equals("jack123")){                                   
                        //System.out.printf("Enter check-in time\t : ");
                        //StaffCheckin = scanner.next();     
                        StaffCheckin2 = dateFormat.format(date);
                        test2.add(new CheckinTable("Mark","stf001",StaffCheckin));
                        test2.add(new CheckinTable("Jack","stf002",StaffCheckin2));
                        test2.add(new CheckinTable("Jason","stf003",StaffCheckin3));
                    }else{
                        System.out.printf("Wrong Password ! System closed \n");
                        System.exit(0);                 
                }
                }else{
                    System.out.printf("This staff " + Staffname + " already Check in !\n");
                    menu.Option1chk();
                }
            }else if(Staffname.equals("Jason")||Staffname.equals("jason")||Staffname.equals("JASON")){
                if(StaffCheckin3==""){
                    System.out.printf("Enter Your Password\t : ");
                    Staffpassword = scanner.next();
                    if(Staffpassword.equals("mark123")){                                   
                        //System.out.printf("Enter check-in time\t : ");
                        //StaffCheckin = scanner.next();     
                        StaffCheckin3 = dateFormat.format(date);
                        test2.add(new CheckinTable("Mark","stf001",StaffCheckin));
                        test2.add(new CheckinTable("Jack","stf002",StaffCheckin2));
                        test2.add(new CheckinTable("Jason","stf003",StaffCheckin3));
                    }else{
                    System.out.printf("Wrong Password ! System closed \n");
                    System.exit(0);
                }
                }else{
                    System.out.printf("This staff " + Staffname + " already Check in !\n");
                    menu.Option1chk();
                }
                
            }else{
                System.out.println( "Sorry ! " + Staffname+ " is not exist in the system.");
                System.out.println();
                System.out.printf("0 back to CheckIn menu: ");
                menuchoose = scanner.nextInt();
                if(menuchoose == 0){
                    menu.Option1();
                }
        
            }
            System.out.println();
            System.out.println("Staff\tStaffID\tCheckIn");            
                
                for(int a=0; a<test2.size(); a++){
                    System.out.printf("%s\n",test2.get(a));                   
                }
                test2.removeAll(test2);

            System.out.printf("\nEnter another staff to check in ? (y/n):");
            cont = scanner.next();
            if(cont.equals("n")){
                menu.DisplayMenu();
            }
        } 
        
    }
    public void Option2(){
        ArrayList<DeliverymenDuty> test = new ArrayList<DeliverymenDuty>();
        ArrayList<CheckinTable> test2 = new ArrayList<CheckinTable>();
        Scanner scanner = new Scanner(System.in);
        Menu menu= new Menu();
        int menuchoose;
            String StaffCheckin="";           
            String StaffCheckin2="";
            String StaffCheckin3="";            
            test.add(new DeliverymenDuty("Mark","stf001",""));
            test.add(new DeliverymenDuty("Jack","stf002",""));
            test.add(new DeliverymenDuty("Jason","stf003",""));
            System.out.println();
            System.out.println("Staff\tStaffID\tCheckOut");
            for(DeliverymenDuty d: test){
                System.out.printf("%s\n",d);
            }
            System.out.println();
            menu.Option2chk();
    }
    public void Option2chk(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();
        ArrayList<DeliverymenDuty> test = new ArrayList<DeliverymenDuty>();
        ArrayList<CheckinTable> test2 = new ArrayList<CheckinTable>();
        Scanner scanner = new Scanner(System.in);
        String cont = "";
        Menu menu= new Menu();
        int menuchoose;
            String StaffCheckin="";           
            String StaffCheckin2="";
            String StaffCheckin3=""; 
            String Staffpassword="";
            
        for(int i=0; i<4;i++){ 
        System.out.printf("Enter a staff to check out: ");
            String Staffname = scanner.next();
      
            if(Staffname.equals("Mark")||Staffname.equals("mark")||Staffname.equals("MARK")){
                if(StaffCheckin==""){
                    System.out.printf("Enter Your Password\t : ");
                    Staffpassword = scanner.next();
                    if(Staffpassword.equals("mark123")){                                   
                        //System.out.printf("Enter check-in time\t : ");
                        //StaffCheckin = scanner.next();     
                        StaffCheckin = dateFormat.format(date);
                        test2.add(new CheckinTable("Mark","stf001",StaffCheckin));
                        test2.add(new CheckinTable("Jack","stf002",StaffCheckin2));
                        test2.add(new CheckinTable("Jason","stf003",StaffCheckin3));
                    }else{
                    System.out.printf("Wrong Password ! Please Try Again ! \n");
                    System.out.printf("1 - Try Again \n0 - Exit\n");
                    System.out.printf("Your Option: ");
                    int wrongpss = scanner.nextInt();
                        if(wrongpss==1){
                            menu.Option1chk();
                        }else if(wrongpss==0){
                            menu.DisplayMenu(); 
                        }else{
                            System.out.println("Sorry wrong option");
                            menu.Option1chk();
                    }                    
                }
                }else{
                    System.out.printf("This staff " + Staffname + " already Check in !\n");
                    menu.Option1chk();
                }
            }else if(Staffname.equals("Jack")||Staffname.equals("jack")||Staffname.equals("JACK")){
                if(StaffCheckin==""){
                    System.out.printf("Enter Your Password\t : ");
                    Staffpassword = scanner.next();
                    if(Staffpassword.equals("jack123")){                                   
                        //System.out.printf("Enter check-in time\t : ");
                        //StaffCheckin = scanner.next();     
                        StaffCheckin2 = dateFormat.format(date);
                        test2.add(new CheckinTable("Mark","stf001",StaffCheckin));
                        test2.add(new CheckinTable("Jack","stf002",StaffCheckin2));
                        test2.add(new CheckinTable("Jason","stf003",StaffCheckin3));
                    }else{                       
                        System.out.printf("Wrong Password ! System closed \n");
                        System.exit(0);                   
                    }
                }else{
                    System.out.printf("This staff " + Staffname + " already Check in !\n");
                    menu.Option1chk();
                }
            }else if(Staffname.equals("Jason")||Staffname.equals("jason")||Staffname.equals("JASON")){
                if(StaffCheckin==""){
                    System.out.printf("Enter Your Password\t : ");
                    Staffpassword = scanner.next();
                    if(Staffpassword.equals("jason123")){                                   
                        //System.out.printf("Enter check-in time\t : ");
                        //StaffCheckin = scanner.next();     
                        StaffCheckin3 = dateFormat.format(date);
                        test2.add(new CheckinTable("Mark","stf001",StaffCheckin));
                        test2.add(new CheckinTable("Jack","stf002",StaffCheckin2));
                        test2.add(new CheckinTable("Jason","stf003",StaffCheckin3));
                    }else{                       
                        System.out.printf("Wrong Password ! System closed \n");
                        System.exit(0);                   
                    }
                }else{
                    System.out.printf("This staff " + Staffname + " already Check in !\n");
                    menu.Option1chk();
                }  
            }else{
                System.out.println( "Sorry !" + Staffname+ " is not exist in the system.");
                System.out.println();
                System.out.printf("0 back to CheckOut menu: ");
                menuchoose = scanner.nextInt();
                if(menuchoose == 0){
                    menu.Option2();
                }
        
            }
            System.out.println();
            System.out.println("Staff\tStaffID\tCheckOut");            
                
                for(int a=0; a<test2.size(); a++){
                    System.out.printf("%s\n",test2.get(a));                   
                }
                test2.removeAll(test2);

            System.out.printf("\nEnter another staff to check out ? (y/n):");
            cont = scanner.next();
            if(cont.equals("n")){
                menu.DisplayMenu();
            }
        } 
    }
}
