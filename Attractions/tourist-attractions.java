import java.util.Scanner;

class AttractionRecord {
    String name;
    int openTime;
    int closeTime;
    boolean bank;
}
public class Tourists {
    public static void main(String[] args) {
        AttractionFill();
    }
    public static AttractionRecord newAttraction(String name, int openTime, int closeTime, boolean bank) {
        AttractionRecord x = new AttractionRecord();
        x.name = name;
        x.openTime =  openTime;
        x.closeTime = closeTime;
        x.bank = bank;
        return x;
    }
    public static void AttractionFill(){
        AttractionRecord eden = newAttraction("The Eden Project", 9, 7, true);
        AttractionRecord zoo = newAttraction("London Zoo", 8, 8, false);
        AttractionRecord tate = newAttraction("Tate Modern", 8, 8, false);
        AttractName(eden, zoo, tate);
    }
    public static void AttractName(AttractionRecord eden, AttractionRecord zoo, AttractionRecord tate){
        Scanner count = new Scanner(System.in);
        System.out.println("How many attractions would you like to know about?");
        int numAtt = count.nextInt();
        for (int i = 1; numAtt >= i; i++) {
            Scanner name = new Scanner(System.in);
            System.out.println("Please name attraction " + i +":");
            String AttractName = name.nextLine().toLowerCase();
            if (AttractName.equals("the eden project")){
                output(eden);
            }
            else if (AttractName.equals("london zoo")){
                output(zoo);
            }
            else if (AttractName.equals("tate modern")){
                output(tate);
            }
            else{
                System.out.println("Sorry, there is no information on this attraction.\n");
                i = i - 1;
            }
        }
    }
    public static void output(AttractionRecord x) {
        String bank;
        if (x.bank){
            bank = " is open during bank holidays.";
        }
        else{
            bank = " is closed during the bank holidays.";
        }
        System.out.println(x.name + bank);
        System.out.println("Opens at: " + x.openTime + "am");
        System.out.println("Closes at: " + x.openTime + "pm");
    }
}
