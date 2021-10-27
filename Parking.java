import java.util.Scanner;
public class Parking {
    public static void main(String[] args) {
        Disabled();
        double total = hours();
        double local = local(total);
        double OAP = OAP(local);
        System.out.println("Your parking will cost £" + OAP);
    }
    // Asks the user if they are disables and if they are it quits
    // else it continues
    public static void Disabled() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you disabled?");
        String disabled = scanner.nextLine();
        if ((disabled.equals("Yes") || (disabled.equals("yes")))){
            System.out.println("You are eligible for free parking.");
            System.exit(0);
        }
        else if ((disabled.equals("No") || (disabled.equals("no")))){
            System.out.println("How many hours do you wish to park for (1-8)?");
        }
        else{
            System.out.println("Invalid please try again.");
            Disabled();
        }
    }
    // this method is for hours
    public static double hours() {
        Scanner scanner = new Scanner(System.in);
        double hours = scanner.nextDouble();
        double total = 0;
        if (hours == 1) {
            total = 3;
        }
        else if ((hours >= 2) && (hours <= 4)){
            total = 4;
        }
        else if ((hours == 5) || (hours == 6)){
            total = 4.50;
        }
        else if ((hours == 7) || (hours == 8)){
            total = 5.50;
        }
        return total;
    }
    public static double local(double total){
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you have the I Live Locally badge?");
            String local = scanner.nextLine();
            if ((local.equals("Yes") || (local.equals("yes")))) {
                total = total - 1;
                break;
            } else if ((local.equals("No") || (local.equals("no")))) {
                break;
            } else {
                System.out.println("Invalid please try again.");
            }
        }
        return total;
    }
    public static double OAP(double local){
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Are you an OAP?");
            String OAP = scanner.nextLine();
            if ((OAP.equals("Yes") || (OAP.equals("yes")))) {
                local = local - 2;
                break;
            } else if ((OAP.equals("No") || (OAP.equals("no")))) {
                break;
            } else {
                System.out.println("Invalid please try again.");
            }
        }
        return local;
    }
}