import java.util.*;
import java.io.*;
import java.util.Random;
public class ShutTheBox 
{
	public static void main(String[] args) throws IOException
	{
		@SuppressWarnings({ "resource" })
		Scanner in = new Scanner(System.in);
		int firstdie, seconddie, Total;
		int Tries[] = new int [1];
		Tries[0] = 3;
		boolean run;
		
		
		System.out.println("\t\t\t\t\t\tWelcome to Shut the Box!!!\n");
		System.out.println("Would you like to hear the rules? Type yes or no");
		String YesorNo = in.nextLine();
		if (YesorNo.charAt(0)=='Y' || YesorNo.charAt(0)== 'y')
		{
			HeaderAndRules();
		}
		else
		System.out.println("Type Start to Begin");
		String Start = in.nextLine();
		if (Start.charAt(0) == 'S' || Start.charAt(0) == 's')
		{
			run = true;
		}
		else
		{
			run = false;
			System.out.println("Program terminated: Invalid Input");
		}
		int[] Numbers = new int[9];
		Numbers[0] = 1;
		Numbers[1] = 2;
		Numbers[2] = 3;
		Numbers[3] = 4;
		Numbers[4] = 5;
		Numbers[5] = 6;
		Numbers[6] = 7;
		Numbers[7] = 8;
		Numbers[8] = 9;
		
		while (run)
		{

			firstdie = DieOne();
			seconddie = DieTwo();
			Total = firstdie + seconddie;
			System.out.println("Your total dice roll is: " + Total);
			PickaNumber(Numbers, Total, Tries);
			System.out.println("\nGet ready for the next dice roll!!!\n");
			int numberofzeroes = 0;
			int NumbersTotal= (Numbers[0] + Numbers[1] + Numbers[2] + Numbers[3] + Numbers[4] + Numbers[5] + Numbers[6] + Numbers[7] + Numbers[8]);
			
			for (int count = 0; count<9; count ++)
			{
		
					if (Numbers[count]==0)
					{
						numberofzeroes++;
						if(numberofzeroes==9)
						{
							System.out.println("\nCONGRATS, You managed to knock all of the numbers off the board");
							System.out.println("You have a perfect score of: 0");
							System.out.println("Would you like to play again? Type yes or no");
							YesorNo = in.nextLine();
							if(YesorNo.charAt(0)=='y' || YesorNo.charAt(0)=='Y')
							{
								run = true;
								LoadArray(Numbers);
								
							}
							else
							{
								run = false;
								
							}
						}
					}
			
			}
			
			
			if(Tries[0]==0)
			{
			System.out.println("\nThe game has ended because it is not possible for you to continue");
			System.out.println("You finished the game with a score of: " + NumbersTotal);
			System.out.println("Would you like to play again? Type yes or no");
			YesorNo = in.nextLine();
			if(YesorNo.charAt(0)=='y' || YesorNo.charAt(0)=='Y')
			{
				run = true;
				LoadArray(Numbers);
				Tries[0]=3;
				
				
			}
			else
			{
				run = false;
				
			}
			}
			
			
		}
		
		System.out.println("Game Over...Goodbye hope to see you soon!!!");
		
	}
	public static void AdditionalRuleCheck(int[] numbers, int Pick, int Total, int SavePick, int[] Tries) throws IOException
	{
		
		if(numbers[0]==1 && numbers[1]==2 && numbers[2]==3 && numbers[3]==0 && numbers[4]==0 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==1 && numbers[1]==0 && numbers[2]==0 && numbers[3]==0 && numbers[4]==5 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==1 && numbers[1]==0 && numbers[2]==3 && numbers[3]==0 && numbers[4]==0 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==1 && numbers[1]==2 && numbers[2]==0 && numbers[3]==0 && numbers[4]==0 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==1 && numbers[1]==0 && numbers[2]==0 && numbers[3]==4 && numbers[4]==0 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==0 && numbers[1]==2 && numbers[2]==3 && numbers[3]==0 && numbers[4]==0 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==0 && numbers[1]==2 && numbers[2]==0 && numbers[3]==4 && numbers[4]==0 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==1 && numbers[1]==0 && numbers[2]==0 && numbers[3]==0 && numbers[4]==0 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==0 && numbers[1]==2 && numbers[2]==0 && numbers[3]==0 && numbers[4]==0 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==0 && numbers[1]==0 && numbers[2]==3 && numbers[3]==0 && numbers[4]==0 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==0 && numbers[1]==0 && numbers[2]==0 && numbers[3]==4 && numbers[4]==0 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==0 && numbers[1]==0 && numbers[2]==0 && numbers[3]==0 && numbers[4]==5 && numbers[5]==0 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
		if(numbers[0]==0 && numbers[1]==0 && numbers[2]==0 && numbers[3]==0 && numbers[4]==0 && numbers[5]==6 && numbers[6]==0 && numbers[7]==0 && numbers[8]==0)
		{
			System.out.println("\nThe special rule has been enacted since you cannot roll higher than one die.");
			System.out.println("\nSo only one die will be used throughout the duration");
			SpecialDieRule(numbers,Pick,Total,SavePick,Tries);
		}
	}
	
	public static void HeaderAndRules()
	{
		
		System.out.println("The rules to the game are very simple. You roll two simulated die whose sum represents the target.\n");
		System.out.println("You are given numbers from 1-9, your goal is to take one or two numbers from the 1-9 range that makes it equal to the value of the target.");
		System.out.println("\nFor example, let's say I roll two die: I get a 4 and a 3 which equals 7. Now from my numbers I can either pick just a 7 or I can pick a 4 and 3.");
		System.out.println("Once you have picked a number or numbers they stay down for good and can't be used again.");
		System.out.println("\nAdditional rule: If you only have one number left to pick from in your 1-9 range then only one die is rolled.");
		System.out.println("\nThe goal of the game is to try and get all of the numbers in your range without any left.");
		System.out.println("If there are any numbers left and you cannot proceed then your score is read from left to right depending on the numbers that are left!");
		System.out.println("\nThe LOWER THE SCORE THE BETTER!!! Best Score=0 & Lowest Score=45\n");
		System.out.println("\n\nYou have 3 tries then it's game over...if you cannot proceed any further then just input 3 mistakes and it's game over!!!");
		System.out.println("\nType Start to begin!!!");
	}
	public static void PickaNumber(int[] numbers, int Total, int[] Tries) throws IOException
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int Pick, SavePick=0;
		boolean runit = true;
		String OneorTwo = null;
		
		if(Tries[0]==0)
		{
			runit = false;
		}
		
		while (runit)
		{
		System.out.println("\nHere are the remaining numbers!!!\n");
		System.out.println(numbers[0] + "\t" + numbers[1] + "\t" + numbers[2] + "\t" + numbers[3] + "\t" + numbers[4] + "\t" + numbers[5] + "\t" + numbers[6] + "\t" + numbers[7] + "\t" + numbers[8]);
		System.out.println("\nWould you like to pick one number or two numbers? Type one or two");
		OneorTwo = in.nextLine();
		if (OneorTwo.equals("One") || OneorTwo.equals("one") || OneorTwo.equals("ONE")) //did equals instead of CharAt due to a weird error when attempting charAt
		{
			System.out.println("Now pick a number from the range");
			System.out.println(numbers[0] + "\t" + numbers[1] + "\t" + numbers[2] + "\t" + numbers[3] + "\t" + numbers[4] + "\t" + numbers[5] + "\t" + numbers[6] + "\t" + numbers[7] + "\t" + numbers[8]);
			Pick = in.nextInt();
			Pick = Pick - 1;
			CheckTheNumber(numbers, Pick,Total, Tries);
			AdditionalRuleCheck(numbers,Pick,Total,SavePick,Tries);
			runit = false;
		}
		else
		{
		System.out.println("Now pick a number from the range");
		System.out.println(numbers[0] + "\t" + numbers[1] + "\t" + numbers[2] + "\t" + numbers[3] + "\t" + numbers[4] + "\t" + numbers[5] + "\t" + numbers[6] + "\t" + numbers[7] + "\t" + numbers[8]);
		Pick = in.nextInt();
		Pick = Pick - 1;
		SavePick = Pick;
		System.out.println("Now Pick another number");
		System.out.println(numbers[0] + "\t" + numbers[1] + "\t" + numbers[2] + "\t" + numbers[3] + "\t" + numbers[4] + "\t" + numbers[5] + "\t" + numbers[6] + "\t" + numbers[7] + "\t" + numbers[8]);
		Pick = in.nextInt();
		Pick = Pick - 1;
		CheckTheTwoNumbers(numbers, Pick,Total, SavePick, Tries);
		AdditionalRuleCheck(numbers,Pick,Total,SavePick,Tries);
		runit = false;
		}
		
		}
	}	
	
		

	
	
	
	
	public static int DieOne() throws IOException
	{
		Random Rand = new Random();
		int Die1 = Rand.nextInt(6) + 1;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Press 1 to roll your first die!");
		int Firstroll = in.nextInt();
		if (Firstroll==1)
		System.out.println(Die1);
		else
		{
			System.out.println("Invalid input, please try again!");
			Firstroll = in.nextInt();
			System.out.println(Die1);
		}
		return Die1;
	
	
	
	}	
	public static int DieTwo() throws IOException
	{
		Random Rand = new Random();
		int Die2 = Rand.nextInt(6) + 1;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Press 1 to roll your Second die!");
		int Firstroll = in.nextInt();
		if (Firstroll==1)
		System.out.println(Die2);
		else
		{
			System.out.println("Invalid input, please try again!");
			Firstroll = in.nextInt();
			System.out.println(Die2);
		}
		return Die2;
	}
	public static void CheckTheTwoNumbers(int[] numbers, int Pick, int Total, int SavePick, int[] Tries) throws IOException
	{
		int numTotal = (numbers[Pick] + numbers[SavePick]);
		
		
		if (Total==numTotal)
		{
		
		System.out.println("Nice, the number " + numbers[Pick] + " and the number " + numbers[SavePick] + " are now gone!");
		
		for (int count = 0; count<9; count ++)
		{
				numbers[SavePick] = 0;
				numbers[Pick] = 0;
				if (numbers[count]==1)
				{
					System.out.print( "\t");
				}
		
		}
	  }
		else
		{
			Tries[0]--;
			System.out.println("\nError, the number/numbers you selected do not add up to the total, please try again");
			System.out.println("You have " + Tries[0] + " tries remaining");
			PickaNumber(numbers,Total, Tries);
		}
	}
	public static void SpecialDieRule(int[] numbers, int Pick, int Total, int SavePick, int[] Tries) throws IOException
	{
		boolean rundie=true;
		int DieSP;
		
		String Choose;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		while(rundie)
		{
		
		
		DieSP = DieOne();
		
		System.out.println("Your total roll is: " + DieSP);
		System.out.println("\nHere are the remaining numbers!!!\n");
		System.out.println(numbers[0] + "\t" + numbers[1] + "\t" + numbers[2] + "\t" + numbers[3] + "\t" + numbers[4] + "\t" + numbers[5] + "\t" + numbers[6] + "\t" + numbers[7] + "\t" + numbers[8]);
		System.out.println("\nWould you like to pick one number or two numbers? Type one or two\n");
			
		Choose = in.nextLine();
		
			if (Choose.equals("One") || Choose.equals("one") || Choose.equals("ONE")) //did equals instead of CharAt due to a weird error when attempting charAt
			{
				System.out.println("Now pick a number from the range");
				System.out.println(numbers[0] + "\t" + numbers[1] + "\t" + numbers[2] + "\t" + numbers[3] + "\t" + numbers[4] + "\t" + numbers[5] + "\t" + numbers[6] + "\t" + numbers[7] + "\t" + numbers[8]);
				Pick = in.nextInt();
				Pick = Pick - 1;
				CheckTheNumber(numbers, Pick, Total, Tries);
			}
			else
			{
				System.out.println("Now pick a number from the range");
				System.out.println(numbers[0] + "\t" + numbers[1] + "\t" + numbers[2] + "\t" + numbers[3] + "\t" + numbers[4] + "\t" + numbers[5] + "\t" + numbers[6] + "\t" + numbers[7] + "\t" + numbers[8]);
				Pick = in.nextInt();
				Pick = Pick - 1;
				SavePick = Pick;
				System.out.println("Now Pick another number");
				System.out.println(numbers[0] + "\t" + numbers[1] + "\t" + numbers[2] + "\t" + numbers[3] + "\t" + numbers[4] + "\t" + numbers[5] + "\t" + numbers[6] + "\t" + numbers[7] + "\t" + numbers[8]);
				Pick = in.nextInt();
				Pick = Pick - 1;
				CheckTheTwoNumbers(numbers, Pick, Total, SavePick, Tries);
			
			}
		
		
		
		}
	}
	
	public static void LoadArray(int[] Numbers) throws IOException
	{
		Numbers[0] = 1;
		Numbers[1] = 2;
		Numbers[2] = 3;
		Numbers[3] = 4;
		Numbers[4] = 5;
		Numbers[5] = 6;
		Numbers[6] = 7;
		Numbers[7] = 8;
		Numbers[8] = 9;
	}
	
	public static void CheckTheNumber(int[] numbers, int Pick, int Total, int[] Tries) throws IOException
	{
		if (Total==numbers[Pick])
		{
		
		System.out.println("Nice, the number " + numbers[Pick] + " is now gone!");
		
		for (int count = 0; count<9; count ++)
		{
				
				numbers[Pick] = 0;
				if (numbers[count]==1)
				{
					System.out.print( "\t");
				}
		
		}
	  }
		else
		{
			Tries[0]--;
			System.out.println("\nError, the number/numbers you selected do not add up to the total, please try again");
			System.out.println("You have " + Tries[0] + " tries remaining");
			PickaNumber(numbers,Total, Tries);
		}
	}
}
