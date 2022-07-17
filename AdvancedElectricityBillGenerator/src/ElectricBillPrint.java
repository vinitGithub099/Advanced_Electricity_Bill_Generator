import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ElectricBillPrint extends ElectricityBill{
    double ElectricUnit;
    // double solarUnits;
    int FixedCharge = 115;
    public Double Price, NetPrice;
    LocalDate DateOfReading;
    LocalDate curr = LocalDate.now();
    DateTimeFormatter fd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static float ElectricDuty = 0.16f, WheelingCharges = 0.04f;
    final float TAX = ElectricDuty + WheelingCharges;
    String Phase, StringDate;


    ElectricBillPrint(String phase, double ElectricUnit, String stringdate, double solarUnits) {
        super();
        this.Phase = phase;
        this.ElectricUnit = ElectricUnit - solarUnits;
        this.StringDate = stringdate;
        // this.solarUnits = solarUnits;
        // this.DateOfReading = dor;
        BillCalculator();
    }

    void BillCalculator() {
        if (ElectricUnit > 100 && Phase.equals("1 PH")) {
            Price = FixedCharge + (3.5 * 100) + (7.5 * (ElectricUnit - 100));
            NetPrice = Price + Price * TAX;
        } else if (ElectricUnit > 100 && Phase.equals("3 PH")) {
            Price = FixedCharge + (5.5 * 100) + (9.5 * (ElectricUnit - 100));
            NetPrice = Price + Price * TAX;
        } else if (ElectricUnit < 100 && Phase.equals("1 PH")) {
            Price = FixedCharge + (3.5 * ElectricUnit);
            NetPrice = Price + Price * TAX;
        } else if (ElectricUnit < 100 && Phase.equals("3 PH")) {
            Price = FixedCharge + (5.5 * ElectricUnit);
            NetPrice = Price + Price * TAX;
        } else {
            Price = (double) FixedCharge;
            NetPrice = Price + Price * TAX;
        }
        DateOfReading = LocalDate.parse(StringDate, fd);
        int days = Period.between(curr, this.DateOfReading).getDays();
        if (days > 10) {
            NetPrice = NetPrice + 500;
        }
        
    }
    // }

    // //For Validation Coupon
    int i = 0;
    void PrimeSubscription(int CodeNo) {
        if (CodeNo > 1000 && CodeNo < 2000 && (CodeNo % 10 == 0)) {
            System.out.println("Prime Code Applied Successfully");
            NetPrice = NetPrice - NetPrice * 0.2;
        } else
            System.out.println("============Invalid Code: You are not a prime subscriber!============");
    }

    // Coupon
    void Coupon(String CouponCode) {
        if (NetPrice >= 10000 && CouponCode.equals("LUCKY20")) {
            i = 1;
            System.out.println("Total Bill Payable: INR" + (NetPrice - (NetPrice * 0.2)));
        } else if (NetPrice >= 5000 && CouponCode.equals("SPECIAL10")) {
            i = 1;
            System.out.println("Total Bill Payable: INR" + (NetPrice - (NetPrice * 0.1)));
        } else {
            System.out.println("Not Eligible for coupon, Your minimum spent to avail coupen is 5000");
        }
    }
    // }

    // class PrintBill{
    void PrintBill(ElectricityBill obj) {
        System.out.println();
        System.out.println();
        System.out.println("*********Electric Bill**********");
        System.out.println("Customer Name: "+ obj.getCostumer_name());
        System.out.println("Customer ID: "+ obj.getCustomer_id());
        System.out.println("Date Of Reading: "+ obj.getDate());
        System.out.println("=================================");
        System.out.println("Total Unit Consumed : " + String.format("%.2f", ElectricUnit) + " units");
        System.out.println("Amount(Before Tax) : INR " + String.format("%.2f", Price));
        System.out.println("Amount(After Tax) : INR " + String.format("%.2f", NetPrice));
        if (i == 1)
            System.out.println("Coupon Applied : YES");
        else
            System.out.println("Coupon Applied : NO");
        System.out.println("Total Payable Amount: INR " + String.format("%.2f", NetPrice));
        System.out.println("=================================");
        System.out.println("Charges & Tax :- ");
        System.out.println("Fixed Charges(FC) : INR " + FixedCharge);
        System.out.println("Electricity Duty(ED) @ 16%");
        System.out.println("Wheeling Charges @ 4%");
        System.out.println("Standard Unit Charges : For Single Phase-> @INR3.5[1-100 Units] & @INR7.5[>100 Units]");
        System.out.println("                        For Three Phase-> @INR5.5[1-100 Units] & @INR9.5[>100 Units]");
        System.out.println("--------------------SAVE TODAY SURVIVE TOMORROW-----------------");
        System.out.println();
        System.out.println();
    }
}