import java.util.Scanner;

public class BalloonRoom {
    public static void main(String[] args) {
        double length = length();
        double width = width();
        double height = height();
        double balloon = balloon();
        double roomVolume = roomVolume(length, width, height);
        numBalloon(roomVolume, balloon);
    }
    // Length user input
    public static double length(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the length of your room in cm?");
        double length = scanner.nextDouble();
        return length;
    }
    // Width user input
    public static double width(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the width of your room in cm?");
        double width = scanner.nextDouble();
        return width;
    }
    // Height user input
    public static double height(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the Height of your room in cm?");
        double height = scanner.nextDouble();
        return height;
    }
    // Balloon volume user input
    public static double balloon(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the Volume of a balloon in m3?");
        double balloon = scanner.nextDouble();
        return balloon;
    }
    // Calculates the roomVolume and then returns it to main
    public static double roomVolume(double length, double width, double height){
        final int million = 1000000;
        double roomVolume = (length * width * height)/million;
        return roomVolume;
    }

    public static void numBalloon(double roomVolume, double balloon){
        double total = roomVolume / balloon;
        System.out.println("You will need " + (int)total + " balloons to fill your room");
    }
}
