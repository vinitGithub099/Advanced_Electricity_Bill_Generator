// package ElectricityBIllGenerator;

public class ElectricityBill {
    private long costumer_id;
    private String costumer_name;
    private double unit_consumed;
    private int phase;
    private String date_unit_taken;
    private int contact_no;
    private boolean prime_costumer;

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
        System.out.println("Phase" + phase);
        System.out.println("Unit Cosumed" + unit_consumed);
        System.out.println("Contact Number" + contact_no);
        System.out.println("Prime Costumer" + prime_costumer);
        System.out.println("Date unit taken" + date_unit_taken);
        System.out.println("====================");

    }

}
