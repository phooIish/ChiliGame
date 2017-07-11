import java.util.Scanner;

public class ChiliGame {

    public static void main(String[] args) {
        System.out.println("13 chocolates, 1 chilli pepper");
        // 1 | 4 | 4 | 4 | x
        boolean firstPick;
        int p1, cpu, jar = 13, count;
        Scanner pick = new Scanner(System.in);
        System.out.println("Do you want to go first? true or false");
        firstPick = pick.nextBoolean();
        if(firstPick){ //If p1 goes first, cpu will always take 3 for its first pick.
            p1 = 1;
            cpu = 3;
            jar -= 4;
            System.out.println("p1 = "+p1);
            System.out.println("cpu = "+cpu);
            System.out.println("There are " + jar + " chocolates left.");
        }
        else{
            jar--;
            System.out.println("cpu = 1");
            System.out.println("How many chocolates do you want to take? (1, 2, or 3 ONLY");
            p1 = pick.nextInt();
            while(p1 < 1 || p1 > 3){
                p1 = pick.nextInt();
            }
            System.out.println("p1 = "+p1);
            cpu = 4 - p1;
            jar -= (p1 + cpu);
            System.out.println("cpu = "+cpu);
            System.out.println("There are " + jar + " chocolates left.");
        }


        while(jar > 0 && jar > -1){ //While jar != 0, loop continues...
            if(jar < 4){ //If there are 3 chocolates left after cpu's turn, p1 should win.
                System.out.println("\nYou took the last set of chocolates! You win!");
                break;
            }
            System.out.println("How many chocolates do you want to take? (1, 2, or 3 ONLY)");
            p1 = pick.nextInt();
            while(p1 < 1 || p1 > 3){ //Only 1, 2 , and 3 are accepted
                p1 = pick.nextInt();
            }
            System.out.println("p1 = " + p1);
            jar -= p1;


            if(jar == 0){
                System.out.println("You took the last chocolate! You win!");
                break;
            }
            else if (jar <= 2) { //Prevents negatives
                System.out.println("cpu took the last chocolate(s)!\nYou lose!");
                break;
            }
            else if(jar % 4 != 0){
                count = 0; //Reset count in case another turn needs to use it.
                while(jar % 4 != 0){
                    jar--;
                    count++;
                    cpu = count;
                }
                System.out.println("cpu = "+ cpu);
            }
            else{ //Normal turn
                cpu = 4 - p1;
                jar -= cpu;
                System.out.println("cpu = "+ cpu);
            }

            if(jar == 0){ //No more leftover so loop breaks, p1 loses.
                System.out.println("\nThere are no more chocolates ;(\nYou lose!");
                break;
            }
            System.out.println("There are " + jar + " chocolates left.");
        }
    }
}
