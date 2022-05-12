package com.company;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
		ArrayList<Bowler> bowlers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
	    System.out.println("How many bowlers will you be keeping score for?");
	    System.out.println("Enter a number here: ");
	    int numBowlers = input.nextInt();

	    System.out.println("Are you sure you want to keep track of " + numBowlers + " bowlers?");
	    String trash = input.nextLine();

	    for(int i = 0; i < numBowlers; i++){
	    	System.out.println("What is the name for bowler " + (i+1) + ":");
	    	String bowlerName = input.nextLine();
	    	Bowler newBowler = new Bowler(bowlerName);
	    	bowlers.add(newBowler);
		}
	    System.out.println();
	    //for(int j = 0; j < bowlers.size(); j++){
	    	//System.out.println("Bowler " + (j+1) + " name = " + bowlers.get(j).getName());
		//}
	    for(int a = 0; a < 10; a++){
	    	for (int b = 0; b < bowlers.size(); b++){
	    		System.out.println("Enter the how many pins " + bowlers.get(b).getName() + " got with their first throw: ");
	    		int firstThrow = input.nextInt();

				System.out.println("Enter the how many pins " + bowlers.get(b).getName() + " got with their second throw: ");
				int secondThrow = input.nextInt();


				bowlers.get(b).addFrame(firstThrow, secondThrow);
				if(firstThrow == 10){
					bowlers.get(b).frame.get(a).isStrike = true;
				}
				if ((firstThrow + secondThrow) == 10){
					bowlers.get(b).frame.get(a).isSpare = true;
				}
				System.out.println(bowlers.get(b).getName() + " frame #" + (a+1) + ", 1st throw = " + bowlers.get(b).frame.get(a).getThrow1() + ", 2nd throw = " + bowlers.get(b).frame.get(a).getThrow2());
				//System.out.println("The total score for that frame was " + bowlers.get(b).frame.get(b).getFrame());
				System.out.println();

				if (a == 9){
					if(bowlers.get(b).frame.get(a).isSpare == true){
						System.out.print("You got a spare in your 10th frame.");
						System.out.println("Enter your extra throw here: ");
						int spareThrow = input.nextInt();
						bowlers.get(b).addFrame(spareThrow, 0);
					}
				}
			}
		}
	    for (int tyler = 0; tyler < bowlers.size(); tyler++){
	    	System.out.println(bowlers.get(tyler).getName() + " had a score of: " + bowlers.get(tyler).getTotalScore());
		}
    }
}
