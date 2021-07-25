import java.time.LocalDateTime;
import java.util.Random;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        String greeting = "Welcome to my Java program.";
        System.out.println(greeting);

        int dogCount = 1;
        System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

        int catCount = 2;
        System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

        int turtleCount = 0;
        System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

        flipNHeads(2);
        clock();

    }

    public static String pluralize(String name, int num) {

        if (num == 0 || num > 1) {
            return name + "s";

        } else {
            return name;

        }
    }

    public static void flipNHeads(int n) {

        int Flips = 0;
        int headsNum = 0;
        while (headsNum != n) {
            Flips = Flips + 1;

            Random rand = new Random(); // instance of random class
            double double_random = rand.nextDouble();
            // System.out.println(double_random);
            if (double_random >= 0.5) {

                System.out.println("heads");
                headsNum = headsNum + 1;

            } else {
                System.out.println("tails ");
                headsNum = 0;

            }

        }
        System.out.println("It took " + Flips + " flips to flip " + headsNum + " heads in a row .");

    }

    public static void clock(){
        while (true) {
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        int sec = now.getSecond();
        if (sec !=LocalDateTime.now().getSecond()) {
            System.out.println(time);
            
        }

    }
    }

}