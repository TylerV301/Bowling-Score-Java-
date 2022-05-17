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
	    		int secondThrow = 0;
	    		if (firstThrow == 10){
	    			secondThrow = 0;
					bowlers.get(b).addFrame(firstThrow, secondThrow);
				}
	    		else {
					System.out.println("Enter the how many pins " + bowlers.get(b).getName() + " got with their second throw: ");
					secondThrow = input.nextInt();
					bowlers.get(b).addFrame(firstThrow, secondThrow);
				}
				if(firstThrow == 10){
					bowlers.get(b).frame.get(a).isStrike = true;
				}
				else if ((firstThrow + secondThrow) == 10){
					bowlers.get(b).frame.get(a).isSpare = true;
				}
				else{
					bowlers.get(b).frame.get(a).isStrike = false;
					bowlers.get(b).frame.get(a).isSpare = false;
				}
				System.out.println(bowlers.get(b).getName() + " frame #" + (a+1) + ", 1st throw = " + bowlers.get(b).frame.get(a).getThrow1() + ", 2nd throw = " + bowlers.get(b).frame.get(a).getThrow2());
				//System.out.println("The total score for that frame was " + bowlers.get(b).frame.get(b).getFrame());
				System.out.println();

				if (a == 9){
					if(bowlers.get(b).frame.get(a).isSpare == true){
						System.out.println("You got a spare in your 10th frame.");
						System.out.println("Enter your extra throw here: ");
						int spareThrow = input.nextInt();
						bowlers.get(b).addFrame(spareThrow, 0);
					}
					else if (bowlers.get(b).frame.get(a).isStrike == true){
						System.out.println("You got a strike in your 10th frame.");
						System.out.println("Enter the score of your first additional throw:" );
						int strikeThrow1 = input.nextInt();
						int strikeThrow2 = 0;
						if (strikeThrow1 == 10){
							bowlers.get(b).addFrame(strikeThrow1, 0);
							System.out.println("Enter the score of your first additional throw:" );
							strikeThrow2 = input.nextInt();
							bowlers.get(b).addFrame(strikeThrow2, 0);
						}
						else {
							System.out.println("Enter the score of your second additional throw: ");
							strikeThrow2 = input.nextInt();
							bowlers.get(b).addFrame(strikeThrow1, strikeThrow2);
						}
					}
				}

			}
		}
	    for (int tyler = 0; tyler < bowlers.size(); tyler++){
	    	System.out.println(bowlers.get(tyler).getName() + " had a score of: " + bowlers.get(tyler).getTotalScore());
		}
    }
}
