// package ElectricityBIllGenerator;
import java.util.ArrayList;
import java.util.Scanner;

public class ElectricityBill {
    private long costumer_id;
    private String costumer_name;
    private double unit_consumed;
    private int phase;
    private String date_unit_taken;
    private int contact_no;
    private boolean prime_costumer;
    private double solar_units;

    // contructor
    public ElectricityBill(long costumer_id, double unit_consumed, int phase, String costumer_name, String unit_taken, int contact_no, boolean prime_costumer) {
        this.costumer_id = costumer_id;
        this.unit_consumed = unit_consumed;
        this.phase = phase;
        this.costumer_name = costumer_name;
        this.date_unit_taken = unit_taken;
        this.contact_no = contact_no;
        this.prime_costumer = prime_costumer;
    }

    void display_data() {
        System.out.println("");
        System.out.println("Data for " + costumer_name + ": ");
        System.out.println("Costumer id: " + costumer_id);
        System.out.println("Phase: " + phase);
        System.out.println("Unit Cosumed: " + unit_consumed);
        System.out.println("Contact Number: " + contact_no);
        System.out.println("Prime Costumer: " + prime_costumer);
        System.out.println("Date unit taken: " + date_unit_taken);
        System.out.println("====================");

    }

    boolean isPrimeCustomer(){
        return this.prime_costumer;
    }

    void setPrimeCustomer(boolean var){
        this.prime_costumer = var;
    }

    String getCostumer_name(){
        return this.costumer_name;
    }

    String getDate(){
        return this.date_unit_taken;
    }

    long getCustomer_id(){
        return this.costumer_id;
    }

    String getStringPhase(){
        return this.phase + " PH";
    }

    double getUnitConsumed(){
        return this.unit_consumed;
    }

    void setSolarUnits(double units){
        this.solar_units = units;
    }
    
    double getSolarUnits(){
        return this.solar_units;
    }

    public void display(ArrayList<ElectricityBill> aBills) {
        System.out.println("Enter Costumer id");
        Scanner sc = new Scanner(System.in);

        long cid = sc.nextLong();
        boolean available_costumer = false;
        for (ElectricityBill ele : aBills) {
            if (cid == ele.getCustomer_id()) {
                ElectricBillPrint obj = new ElectricBillPrint(ele.getStringPhase(), ele.getUnitConsumed(),
                        ele.getDate(), ele.getSolarUnits());
                obj.PrintBill();
            }
        }
    }
}
