import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

interface display_iface {
    void display(ArrayList<ElectricityBill> a);
}

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long costumer_id;
        String costumer_name;
        double unit_consumed;
        int phase;
        String date_unit_taken;
        int contact_no;
        boolean prime_costumer;
        String c;
        String choice;
        int primeCode;
        double solarUnits = 0;
        long cid;

     
        ArrayList<ElectricityBill> aBills = new ArrayList<>();
        try {
            File f = new File("");
            File f1 = new File(f.getAbsolutePath() + "/data.txt");
       
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);

            String str = "";

            while ((str = br.readLine()) != null) {

                String ssplit[] = str.split(",");

                costumer_id = Long.parseLong(ssplit[0]);
                unit_consumed = Double.parseDouble(ssplit[1]);
                phase = Integer.parseInt(ssplit[2]);
                costumer_name = ssplit[3];
                date_unit_taken = ssplit[4];
                contact_no = Integer.parseInt(ssplit[5]);
                prime_costumer = Boolean.parseBoolean(ssplit[6]);

                ElectricityBill ele = new ElectricityBill(costumer_id, unit_consumed, phase, costumer_name,
                        date_unit_taken, contact_no, prime_costumer);

                aBills.add(ele);

            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter Costumer id: ");

        cid = sc.nextLong();
        boolean available_costumer = false;
        for (ElectricityBill ele : aBills) {
            if (cid == ele.getCustomer_id()) {
                available_costumer = true;
                ElectricBillPrint obj = new ElectricBillPrint(ele.getStringPhase(), ele.getUnitConsumed(),
                        ele.getDate(), ele.getSolarUnits());
                          System.out.println();
                System.out.print("Do you use Solar energy ? [y/n] : ");
                c = sc.next();
                System.out.println();
                if (c.equals("y") || c.equals("Y")) {
                    System.out.print("Enter the unit solar energy consumed: ");
                    solarUnits = sc.nextDouble();
                }

                ele.setSolarUnits(solarUnits);

                
                c = ""; // to reset value of c for further input
                System.out.print("Do you use have coupon code ? [y/n] : ");
                c = sc.next();
                if (c.equals("y") || c.equals("Y")) {
                    System.out.print("Enter Coupen Code: ");
                    String coupenString = sc.next();
                    obj.Coupon(coupenString);
                    System.out.println();
                }
                
                System.out.println();
                System.out.print("Are you a Prime Subscriber ? [y/n] : ");
                choice = sc.next();
                if (c.equals("y") || c.equals("Y")) {
                    System.out.println();
                    System.out.print("Enter your prime subscription code [int]: ");
                    primeCode = sc.nextInt();
                    obj.PrimeSubscription(primeCode);
                } else {
                    System.out.println();
                }
                obj.PrintBill(ele);
            }
            
        }
        if(!available_costumer){
            System.out.println("You entered wrong Costumer id. Enter Again!");
            main(args);
            
        }

        sc.close();

    }

   
}
