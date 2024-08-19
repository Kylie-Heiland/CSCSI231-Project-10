/* This program begins by having a user enteringa sentence. For loop purposes, the user MUST end the sentence with a period; it will not actually be counted.
 * After inputting the sentence, the program outputs the length of the sentence EXCLUDING the period at the end (as it is merely used for loop purposes). Then, 
 * the user is instructed to enter a valid index (between 0 - length-1), and the character is outputted. After doing so, the user inputs another sentence and it 
 * is compared with the original sentence. If the sentences have the same case, punctuation, etc., equal is outputted, else it outputs as unequal. Using the first 
 * sentence again, the user is asked to enter two valid indexes and a substring (aka characters are outputted all on the same line) is outputted. Finally the 
 * user inputs an integer and it is converted into MyString and outputted.
 * 
 * Author: Kylie Heiland
 * 
 * Title: Project 10
 * 
 * Date: 4/14/22
 * 
 */

import java.util.Scanner; 
public class MyString
{
    //Private variable
    private char[] data;
    

    public static void main(String[] args)
    {
        //Creates a new scanner for input.
        Scanner input = new Scanner(System.in);
        
        //Welcomes user 
        System.out.println("Welcome to the 10th program!");
        
        //User inputs a sentence. It MUST end with a period. 
        System.out.print("Enter a sentence, and end it with a period (.): ");
        char[] chars = input.nextLine().toCharArray();
        
        //Creates a new object, a, uses the constructor chars array as the parameter.
        MyString a;
        a = new MyString(chars);
    
        //Finds the length of the sentence EXCLUDING the period (.) at the end; it is merely there to control loops.
        System.out.println("The length of the sentence is: " + a.length());
        
        //User inputs an int that will be determine as the index for the object's array.
        System.out.print("Enter an index (int) to see what character it holds: ");
        int b = input.nextInt();
        
        input.nextLine();
        
        //If the index is out of the object's length, the program will end.
        if(b > a.length() - 1)
        {
            System.out.println("You're looking for an index that does not exist.");
            System.exit(1);
        }
        
        //Outputs the character that is located at the particular index (b) in the object's array.
        System.out.println("At char[" + b + "], the character is: '" + a.charAt(b) + "'");
              
        //User inputs a new object for comparison. It MUST end with a period (.). 
        System.out.print("Enter a sentence, and end it with a period (.): ");
        chars = input.nextLine().toCharArray();
        
        //Creates a new object, a, uses the constructor chars array as the parameter.
        MyString testSentence;
        testSentence = new MyString(chars);
        
        //If both objects have the same sentence (meaning exact case and punction and both end with a period), then the if is implemented, else the body of the
        //else is outputted.
        if(a.equals(testSentence))
        {
            System.out.println("The original sentence is equal to the test sentence.");
        }
        else
        {
            System.out.println("These two sentences are NOT equal.");
        }
        
        //User inputs an integer that will be used as the starting index of the substring.
        System.out.println("Now create a substring; enter an index: ");
        int begin = input.nextInt();
        
        //Checks to make sure the index is valid.
        if(begin > a.length() - 1)
        {
            System.out.println("You're looking for an index that does not exist.");
            System.exit(1);
        }
        
        //User inputs an integer that will be used as the ending index of the substring (including the index itself, NOT endingIndex - 1).
        System.out.println("And one more, but this time higher than the previous index: ");
        int end = input.nextInt();
        
        //Checks to make sure the index is valid AND is larger than the starting index.
        if( (end > a.length() - 1) || (end < begin) )
        {
            System.out.println("You're looking for an index that does not exist and/or this index is lower than the previous index.");
            System.exit(1);
        }
        
        //Outputs ths substring.
        System.out.print("The substring from the first sentence is: \"");
        
        //Substring is set to d.
        MyString d = a.substring(begin, end);
        for(int i = 0; d.charAt(i) != '.' ; i++)
        { //Outputs all chars of the substring on the same line.
            System.out.print(d.charAt(i));
        }
        
        System.out.println("\"");
        
        //Makes the substring lowercase.
        d = d.toLowerCase();
        System.out.print("In lowercase the substring is: \"");
        for(int i = 0; d.charAt(i) != '.' ; i++)
        { //Outputs all chars of the substring on the same line, now all lowercase.
            System.out.print(d.charAt(i));
        }
        
        System.out.println("\"");
        
        //Sets the first sentence to lowercase and outputs.
        a = a.toLowerCase();
        System.out.print("In lowercase the first sentence is: \"");
        
        //Outputs all the chars of the first sentence on the same line
        for(int i = 0; a.charAt(i) != '.' ; i++)
        {
            System.out.print(a.charAt(i));
        }
        System.out.println("\"");
        
        //Tests the valueOf method; changes the integer into MyString.
        System.out.println("Finally, enter an integer: ");
        int integer = input.nextInt();
        
        //Used to keep track of how many characters the integer has.
        int c = integer; 
        int count = -1; //Will control the for loop when outputting the integer turned MyString.

        //Sets MyString a to an integer turned MyString using valueOf.
        a = a.valueOf(integer);
        
        System.out.println("Using the valueOf method, the integer is now a MyString: ");
        
        while(c != 0)
        { //Sees how many characters the integer has, increments.
            c = c/10;
            count++;
        } 
        
        //Outputs the characters of the integer all on the same line.
        for(int i = 0; i <= count; i++)
        {
            System.out.print(a.charAt(i));
        }
    }

    
    //Constructor
    public MyString(char[] chars)
    {//Sets data equal to chars
        data = chars;
    }
    public int length()
    {
        int count = 0;
        
        //Loops through each character, stops when there is a period (as that is what usually ends a sentence).
        for(int i = 0; data[i] != '.'; i++)
        {
            count++; //Counts each character (excluding the period)
        }
        return count; //Returns the number of characters in the sentence EXCLUDING the period (.), it is merely used for looping control purposes.
    }
    public char charAt(int i)
    {
        int index = 0;
        while(i != index)
        { //Loops through the indexes until it is the same as the user wanted.
            index++;
        }
        return data[index]; //Returns the char that correlates to the index the user wanted.
    }
    public MyString substring(int begin, int end)
    {
        char[] c = new char[100]; //Will hold a total of 100 characters for the substring.
        int j = 0; //Used as an index for c.
        
        for(int i = 0; data[i] != '.'; i++)
        { //Loops until it is at the end of the sentence (the period (.) is merely there for control purposes; it is not actually considered apart of the string.
            if(i >= begin && i <= end)
            { //When it finally loops to where the user wants to create the substring, the characters are added to c. Keep in mind, that the end index IS counted, 
                //so it's corresponding character is included into the substring. 
                c[j] = data[i];
                j++; //Increments so that c can add a new character to the array.
            }
        }
        c[j] = '.'; //Adds a period for looping purposes. Is NOT included in length().
        MyString a = new MyString(c);
        return a;
    }
    public MyString toLowerCase()
    {
        char[] c = new char[100];
        int j = 0;
        
        for(int i = 0; data[i] != '.'; i++)
        {
            //Manually goes through every letter in the alphabet to see if the character is uppercase and changes it to lowercase (since the toLowerCase method is of
            //the String class, and we are not supposed to use that this assignment.
            if(data[i] == 'A')
            {
                c[j] = 'a';
            }
            else if(data[i] == 'B')
            {
                c[j] = 'b';
            }
            else if(data[i] == 'C')
            {
                c[j] = 'c';
            }
            else if(data[i] == 'D')
            {
                c[j] = 'd';
            }
            else if(data[i] == 'E')
            {
                c[j] = 'e';
            }
            else if(data[i] == 'F')
            {
                c[j] = 'f';
            }
            else if(data[i] == 'G')
            {
                c[j] = 'g';
            }
            else if(data[i] == 'H')
            {
                c[j] = 'h';
            }
            else if(data[i] == 'I')
            {
                c[j] = 'i';
            }
            else if(data[i] == 'J')
            {
                c[j] = 'j';
            }
            else if(data[i] == 'K')
            {
                c[j] = 'k';
            }
            else if(data[i] == 'L')
            {
                c[j] = 'l';
            }
            else if(data[i] == 'M')
            {
                c[j] = 'm';
            }
            else if(data[i] == 'N')
            {
                c[j] = 'n';
            }
            else if(data[i] == 'O')
            {
                c[j] = 'o';
            }
            else if(data[i] == 'P')
            {
                c[j] = 'p';
            }
            else if(data[i] == 'Q')
            {
                c[j] = 'q';
            }
            else if(data[i] == 'R')
            {
                c[j] = 'r';
            }
            else if(data[i] == 'S')
            {
                c[j] = 's';
            }
            else if(data[i] == 'T')
            {
                c[j] = 't';
            }
            else if(data[i] == 'U')
            {
                c[j] = 'u';
            }
            else if(data[i] == 'V')
            {
                c[j] = 'v';
            }
            else if(data[i] == 'W')
            {
                c[j] = 'w';
            }
            else if(data[i] == 'X')
            {
                c[j] = 'x';
            }
            else if(data[i] == 'Y')
            {
                c[j] = 'y';
            }else if(data[i] == 'Z')
            {
                c[j] = 'z';
            }
            else{
                c[j] = data[i];
            }
            j++;
        }
        c[j] = '.';
        MyString a = new MyString(c);
        return a;
    }
    public boolean equals(MyString other)
    {
        for(int i = 0; data[i] != '.'; i++)
        {
            if(data[i] == other.charAt(i))
            {
                //Intentionally empty.
            }
            else
            {
                return false; //If even one of the characters of either sentence is different, this is returned.
            }
        }
        return true; //If all of the characters equal one another in both case and punction, then this is returned.
    }
    public MyString valueOf(int i)
    {
        char[] c = ("" + i).toCharArray(); //Converts the integer to a String, then to char. Sets those values to an array.
        MyString b = new MyString(c); //Uses the MyString constructor.
        return b; //Returns the integer now that is the MyString value.
    }
}
