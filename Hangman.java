import java.util.Scanner;

public class Hangman
{
	public static String to_guess = "Jurrasic Park";
	public static String word = "";
	public static int life = 5;

	static
	{
       convert();
	}

	public static void convert()
	 {
       for (int i = 0; i < to_guess.length() ; i++) 
       {
       	 if(to_guess.charAt(i) == ' ')
       	 	word += ' ';
       	 else
       	 	word += '-';
       }
	 		
	 	
	 }

	 public static boolean checkWord()
	 {
       if(to_guess.compareTo(word) == 0)
       	 return true;	 
       else
         return false;   
	 }

	 public static void checkLetter(char c)
	 {
	 	int check = -1;
	 	String tempChar = to_guess.toLowerCase();
	 	for(int i = 0; i < tempChar.length(); i++)
	 	{
	 		if(c == tempChar.charAt(i))
	 		{
              check = 1;
              char[] temp = word.toCharArray();
              temp[i] = to_guess.charAt(i);
              word = String.valueOf(temp);
	 		}
	 	}

	 	if (check == -1)
	 	{
	 		life--;
	 		System.out.println("Wrong Guess");
	 	}
	 }

	 public static void output()
	 {  
	 	System.out.println("");
	 	System.out.println("Lives : " + life);
	 	System.out.println(word);
	 }

	 public static void main(String[] args)
	 {
	 	Scanner input = new Scanner(System.in);
	 	char guess;
	 	while(life != 0)
	 	{
	 		output();
	 		System.out.println("Enter your guess: ");
	 		guess = input.next().charAt(0);
	 		checkLetter(guess);
	 		if(checkWord() == true)
	 		{ 
	 			System.out.println("");
	 			System.out.println(to_guess);
	 			System.out.println("Great job!");
	 			break;
	 		}

	 	}

	 	if(life == 0)
	 	{
	 		System.out.println("");
	 		System.out.println("You lose:/");
	 		System.out.println("The word is " + to_guess);
	 	}

	 }
}