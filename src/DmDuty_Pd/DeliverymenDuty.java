
package deliverymenduty;

/**
 *
 * @author Owner-PC
 */
public class DeliverymenDuty {

    private String Name;
    private String StaffID;
    private String Checkin;
    
    public DeliverymenDuty(String name, String staffID, String checkin){
        this.Name = name;
        this.StaffID = staffID;
        this.Checkin = checkin;
    }
    public String getName(){
        return this.Name;
    }
    public String getName(String newName){
        return (this.Name = newName);
    }
    public String getStaffID(){
        return this.StaffID;
    }
    public void setCheckin(String Checkin){
        this.Checkin = Checkin;
    }
    public String getCheckin(){
        return this.Checkin;
    }
    public String toString(){
        return String.format("%s\t%s\t%s", this.Name, this.StaffID, this.Checkin);
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
