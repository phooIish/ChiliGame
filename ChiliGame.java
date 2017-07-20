import java.util.Scanner;
/*
Algorithm: Compliment the other players pick to equal 4 or keep the amount of chocolates in the jar divisible by 4.
*/


public class ChiliGame {

    public static void main(String[] args) {
        System.out.println("13 chocolates, 1 chilli pepper");
        // 1 | 4 | 4 | 4 | x
        boolean firstPick;
        int p1, cpu, jar = 13, count = 0;
        Scanner pick = new Scanner(System.in);
        System.out.println("Do you want to go first? true or false");
        firstPick = pick.nextBoolean();

        //Settle who picks first
        if(firstPick){ //If p1 goes first, cpu will always take 3 for its first pick.
            p1 = 1;
            cpu = 3;
            jar -= p1 + cpu;
            System.out.println("p1 = "+p1);
            System.out.println("cpu = "+cpu);
            System.out.println(jar + " chocolate(s) remaining.");
            //This will set the jar to seven after the second turn allowing the cpu to continue the algorithm regardless of p1's next move.
            //Initially, p1 would always win with first pick and by only taking one chocolate every turn.
            System.out.println("How many chocolates do you want to take? (1, 2, or 3 ONLY)");
            p1 = pick.nextInt();
            while(p1 < 1 || p1 > 3){ //Checks if p1 made a valid move***
                p1 = pick.nextInt();
            }
//          If p1 takes 1 for their second turn, cpu should take 1. This will set the jar to 7 allowing the cpu
//          to continue the algorithm regardless of p1's next turn.
            if(p1 == 1){
                cpu = 1;
                jar -= p1 + cpu;
                System.out.println("p1 = "+p1);
                System.out.println("cpu = "+cpu);
                System.out.println(jar + " chocolate(s) remaining.");
            }
            else{
                System.out.println("p1 = "+p1);
                if(p1 < 3){
                    cpu = 3;
                    jar -= p1 + cpu;
                }
                else{
                    cpu = 2;
                    jar -= p1 + cpu;
                }
                System.out.println("cpu = "+cpu);
                System.out.println(jar + " chocolate(s) remaining.");
            }
        }
        //If cpu gets first pick
        else{
            jar--;
            System.out.println("cpu = 1");
            System.out.println("How many chocolates do you want to take? (1, 2, or 3 ONLY)");
            p1 = pick.nextInt();
            while(p1 < 1 || p1 > 3){ //Checks if p1 made a valid move***
                p1 = pick.nextInt();
            }
            System.out.println("p1 = "+p1);
            cpu = 4 - p1;
            jar -= (p1 + cpu);
            System.out.println("cpu = "+cpu);
            System.out.println(jar + " chocolate(s) remaining.");
        }




        //Alternate turns until there are no more chocolates left.
        while(jar > 0){
            if(jar < 4){ //If there are 3 chocolates left after cpu's turn, p1 should win.
                System.out.println("\nCongratz!! You took the last set of chocolates!");
                break;
            }

            System.out.println("How many chocolates do you want to take? (1, 2, or 3 ONLY)");
            p1 = pick.nextInt();
            //Checks if p1 made a valid move***
            while(p1 < 1 || p1 > 3){
                p1 = pick.nextInt();
            }
            System.out.println("p1 = " + p1);
            jar -= p1;

            //Jar check after user
            if(jar == 0){
                System.out.println("You took the last chocolate! You win!");
                break;
            }
            else if (jar <= 2) { //Prevents negatives
                System.out.println("cpu took the last chocolate(s)!\nYou lose!");
                break;
            }
            else if(jar % 4 != 0){
//              Reset counter before while loop
                count = 0; //Reset count in case another turn needs it.
//              CPU 's turn will adjust so that the leftover(jar) will be divisible by 4
                while(jar % 4 != 0){
                    jar--;
                    count++;
                    cpu = count;
                    //cpu's algorithm is based on keeping the jar total divisible by four.
                }
                System.out.println("cpu = "+ cpu);
            }
            //Normal cpu turn
            else{
                cpu = 4 - p1;
                jar -= cpu;
                System.out.println("cpu = "+ cpu);
            }

            //Jar check after cpu
            if(jar == 0){ //No more leftover so loop breaks, p1 loses.
                System.out.println("There are no more chocolates ;(\nYou lose!");
                break;
            }
            System.out.println(jar + " chocolate(s) remaining.");
        }
    }
}
