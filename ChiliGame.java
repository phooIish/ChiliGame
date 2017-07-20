import java.util.Scanner;
/*
Algorithm: Compliment the other player's pick to equal four, or keep the amount of chocolates in the jar divisible by four.
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
   
        if(firstPick){ //If p1 goes first, cpu will always take three.
            p1 = 1;
            cpu = 3;
            jar -= p1 + cpu;
            System.out.println("p1 = "+ p1);
            System.out.println("cpu = "+ cpu);
            System.out.println(jar + " chocolate(s) remaining.");
            
            System.out.println("How many chocolates do you want to take? (1, 2, or 3 ONLY)");
            p1 = pick.nextInt();
            while(p1 < 1 || p1 > 3){ //Checks if p1 made a valid move***
                p1 = pick.nextInt();
            }
//          If p1 takes one for their second turn, cpu should also take one. This will set the jar to seven allowing the cpu
//          to continue the algorithm regardless of p1's next move.
            if(p1 == 1){
                cpu = 1;
                jar -= p1 + cpu;
                System.out.println("p1 = "+ p1);
                System.out.println("cpu = "+ cpu);
                System.out.println(jar + " chocolate(s) remaining.");
            }
            else{
                System.out.println("p1 = "+ p1);
                if(p1 < 3){
                    cpu = 3;
                    jar -= p1 + cpu;
                }
                else{
                    cpu = 2;
                    jar -= p1 + cpu;
                }
                System.out.println("cpu = "+ cpu);
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
            System.out.println("p1 = "+ p1);
            cpu = 4 - p1;
            jar -= (p1 + cpu);
            System.out.println("cpu = "+ cpu);
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
            while(p1 < 1 || p1 > 3){ //Checks if p1 made a valid move***
                p1 = pick.nextInt();
            }
            System.out.println("p1 = " + p1);
            jar -= p1;

            
            //Jar check after p1's turn
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

            
            //Jar check after cpu's turn
            if(jar == 0){ //No more leftover so loop breaks, p1 loses.
                System.out.println("There are no more chocolates ;(\nYou lose!");
                break;
            }
            System.out.println(jar + " chocolate(s) remaining.");
        }
    }
}
