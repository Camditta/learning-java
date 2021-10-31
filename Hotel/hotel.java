import java.util.Scanner;

public class hotels {
    // main body which calls the methods
    public static void main(String[] args) {
        double users = users();
        double[] hotels = hotelName(users);
        percent(hotels);
    }
    public static double users(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many visitors are expected altogether?");
        return scanner.nextDouble();

    }
    // will ask for hotel name and return an array of all its variables
    public static double[] hotelName(double users) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double seaview = 0;
        double grand = 0;
        double majestic = 0;
        while (count != users + 1) {
            if (count != 0) {
                System.out.println("Next please:");
            }
            System.out.println("What hotel will you be staying at? Seaview, Grand or Majestic Hotel?");
            String hotelName = scanner.nextLine();
            if (hotelName.equals("Seaview") || hotelName.equals("seaview")) {
                System.out.println("Please join queue 1");
                seaview = seaview + 1;
            }
            else if (hotelName.equals("Grand") || hotelName.equals("grand")) {
                System.out.println(("Please join queue 7"));
                grand = grand + 1;
            }
            else if (hotelName.equals("Majestic") || hotelName.equals("majestic")) {
                System.out.println(("Please join queue 4"));
                majestic = majestic + 1;
            }
            else{
                System.out.println("Invalid please try again");
                if (count > 0){
                    count = count - 1;
                    System.out.println(count);
                }
            }
            count = count + 1;
        }
        return new double[]{count, seaview, grand, majestic};
    }
    // Calculates the percentages and outputs them to the user
    public static void percent(double[] hotels){
        double seaview = ((hotels[1]*100) / hotels[0]);
        double grand = ((hotels[2]*100) / hotels[0]);
        double majestic = ((hotels[3]*100) / hotels[0]);
        System.out.println("--------------------------------------------------------");
        System.out.println(seaview+"% of travellers are staying in the Seaview hotel");
        System.out.println(grand+"% of travellers are staying in the Grand hotel");
        System.out.println(majestic+"% of travellers are staying in the Majestic hotel");
    }
}

