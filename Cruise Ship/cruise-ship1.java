import java.io.*;
import java.util.*; //import all java utility//

public class cruise {

    public static void main(String[] args) throws FileNotFoundException { //main method where it runs each procedure keeping it organised//
        // Created an array in which creates 12 rooms
        String[] cabins = new String[13];
        emptyRooms(cabins);
        menu(cabins);
        }


    public static void emptyRooms(String[] cabins) {
        // As the program starts, all rooms are declared "empty" unless a save file says otherwise or a user is entered
        for (int i = 0; i < 13; i++) cabins[i] = "empty";
    }

    public static void menu(String[] cabins) throws FileNotFoundException {
        int x = 0;
        while (x == 0){
            Scanner input = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("A: ADD CUSTOMER TO A CABIN");
            System.out.println("V: VIEW ALL CABINS");
            System.out.println("E: DISPLAY EMPTY CABINS");
            System.out.println("D: DELETE CUSTOMER FROM CABIN");
            System.out.println("F: FIND THE CABIN FROM CUSTOMER NAME");
            System.out.println("S: STORE PROGRAM DATA INTO FILE");
            System.out.println("L: LOAD PROGRAM DATA FROM FILE");
            System.out.println("O: VIEW PASSENGERS ORDERED ALPHABETICALLY BY NAME");
            System.out.println("Q: QUIT MENU");

            // asks for user input and then converts it to uppercase to keep it all the same when looking for passengers
            String option = input.nextLine();
            String optionCap = option.toUpperCase();


            // used switch instead of lots of if statements as it was more simple in this situation
            switch (optionCap) {
                case "A" -> add(cabins);
                case "V" -> view(cabins);
                case "E" -> emptyCabins(cabins);
                case "D" -> delete(cabins);
                case "F" -> location(cabins);
                case "S" -> save(cabins);
                case "L" -> load(cabins);
                case "O" -> ordered(cabins);
                case "Q" -> x = x + 1;
                default -> System.out.println("Invalid response please try again");
            }
        }
    }
    // add method to add a customer to the string array cabins[]
    public static void add(String[] cabins) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = input.nextLine();
        String nameCap = name.toUpperCase();
        // if the array contains the string "empty" then it will continue to the for loop to add
        if (Arrays.asList(cabins).contains("empty")){
            for (int i = 1; i < 13; i++) {
                // loops for the word empty, stops and replaces it with the given name nameCap
                if (cabins[i].equals("empty")) {
                    cabins[i] = nameCap;
                    // breaks the for loop as it will keep adding the name to empty slots
                    break;
                }
            }
        }
        // if the array does not contain the string "empty" it will print this message
        else {
            System.out.println("NO AVAILABLE SPACES LEFT. PLEASE DELETE PASSENGERS OR WAIT");
        }
    }
    // method to view ALL cabins even if empty
    public static void view(String[] cabins) {
        for (int i = 1; i < 13; i++){
            if (cabins[i].equals("empty")){
                System.out.println("- Cabin " + i + " is empty");
            }
            else {
                System.out.println("- Cabin " + i + " is occupied by " + cabins[i]);
            }
        }
    }

    // method to view which cabins are empty
    public static void emptyCabins(String[] cabins) {
        for (int i = 1; i < 13; i++){
            if (cabins[i].equals("empty")){
                System.out.println("- Cabin " + i + " is empty");
            }
        }
    }

    // method to delete a passenger from the system
    public static void delete(String[] cabins) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name / the name you want to remove? (non-caps sensitive):");
        String name = input.nextLine();
        String nameCap = name.toUpperCase();
        // boolean found is false unless the user's name is found in which it becomes true
        boolean found = false;
        for (int i = 1; i < 13; i++) {
            if (cabins[i].equals(nameCap)) {
                // changes the found name in the array to empty
                cabins[i] = ("empty");
                found = true;
                System.out.println("SUCCESSFULLY REMOVED " + nameCap + " FROM CABIN " + i);
            }
        }
        if (!found){
            System.out.println("NAME WAS NOT FOUND ON THE SYSTEM PLEASE TRY AGAIN");
        }
    }

    // method location searches the array to find a customers name and then will output their cabin number
    public static void location(String[] cabins) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please search a customers name to find their current room location:");
        String name = input.nextLine();
        String nameCap = name.toUpperCase();
        boolean found = false;
        for (int i = 1; i < 13; i++){
            if (cabins[i].equals(nameCap)){
                System.out.println(nameCap + " IS LOCATED IN CABIN " + i);
                found = true;
            }
        }
        if (!found){
            System.out.println("COULD NOT FIND THIS CUSTOMER ON THE SYSTEM");
        }
    }

    // save the array to a file in which the name of the file is chosen by the user
    // this allows for multiple files e.g. different days hold different information
    public static void save(String[] cabins) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the new file (do not include .txt):");
        String filename = input.nextLine();
        PrintWriter datafile = new PrintWriter(filename + ".txt");
        for (int i = 1; i < cabins.length; i++){
            // this for loop goes throw the array and writes element as one line in the text file
            datafile.println(cabins[i]);
        }
        datafile.close();
    }

    // this method loads a chosen file by the user, which would contain a 12 element array
    public static void load(String[] cabins){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the file you wish to open (do not include .txt):");
        String filename = input.nextLine();
        try{
            // create a buffered reader variable
            BufferedReader br = new BufferedReader(new FileReader(filename + ".txt"));
            String string;
            int i = 1;
            // while our string is not equal to null we make the string into the array
            // the while loop goes through the text file and loads the line onto the program
            while((string = br.readLine()) !=null) {
                cabins[i] = string;
                // we add one to i here so the next cabin[] index is increased
                // if the slot is "empty" the string "empty" is added and put into the array at that index
                i++;
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // method which removes all empty slots then arranges the names in alphabetical order
    // I make a new array called arrayName, so we do not need to remove from cabins[]
    public static void ordered(String[] cabins) {
        int y = 0;
        String passenger;
        String[] arrayName = new String[13];
        // for loop to go through cabins[]
        for (int x = 1; x < 13; x++){
            // if cabins index contains a name and is not empty it will add one to the y value
            // the y value is used in arrayName, so we know the index number of the slot that is not empty
            // for example we have found the 4th name in cabin[6] so there for arrayName[4] = cabins[6] and so on
            if (!cabins[x].equals("empty")) {
                y = y + 1;
                arrayName[y] = cabins[x];
            }
        }
        // here we focus on arrayName[] as cabins[] is no longer needed
        for (int j = 1; j < y + 1; j++){
            for (int i = j + 1; i < y; i++){
                // compares two indexes in the array using different index numbers j and i
                //j will be the first index and i will be the second
                if (arrayName[j].compareTo(arrayName[i])>0){
                    //if the 1st index j is larger than 2nd i,
                    // assign j index to string passenger
                    passenger = arrayName[j];
                    // we switch the two values with one another
                    arrayName[j] = arrayName[i];
                    arrayName[i] = passenger;
                }
            }

            System.out.println(arrayName[j]);
        }

    }
}
    
