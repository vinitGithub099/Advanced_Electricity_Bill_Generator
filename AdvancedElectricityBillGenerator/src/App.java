import java.io.*;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        long costumer_id;
        String costumer_name;
        double unit_consumed;
        int phase;
        String date_unit_taken;
        int contact_no;
        boolean prime_costumer;

        // ElectricityBill ele1 = new ElectricityBill(1L, 123D, 1, "Twinshu", "12/02/2022", 68468, true);
        // e.display_data();
        ArrayList<ElectricityBill> aBills = new ArrayList<>();
        try {
            File f = new File("");
            File f1 = new File(f.getAbsolutePath() + "/data.txt");
            if (f1.exists()) System.out.println(true);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);

            String str = "";

            while ((str = br.readLine()) != null) {

                String ssplit[] = str.split(",");
                // for (String s : ssplit) {
                //     System.out.println(s);
                // }
                costumer_id = Long.parseLong("3878238993");
                // costumer_id = Long.parseLong(ssplit[0]);
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

        for (ElectricityBill e : aBills) {
            e.display_data();
        }

    }
}
