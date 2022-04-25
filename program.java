import java.util.Arrays;
import java.util.Scanner;
public class Pro3_150119919 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        char letter ;
        String letter1= input.next();
        if (letter1.length()==1)//Here I am checking that not more than one letter is entered.
            //If entered, I print 9 to the "letter" variable.
        {
            letter = letter1.charAt(0);
        }
        else
        {
            letter='9';
        }
        printDiamond(constructDiamond(letter));
    }
    public static char[][] constructDiamond (char letter)
    {
        char[] letters={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] letters1={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int[] pointNumber={1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49,51};
        Arrays.sort(letters);//To sort the array.
        Arrays.sort(letters1);
        int control=0;
        int whichLetter=0;
        for(int i =0;i<letters.length;i++)//Required operations for uppercase and lowercase letters.
        {
            if(letter==letters[i])
            {
                control =1;
            }
            else if(letter==letters1[i])
            {
                control=2;
            }
        }
        if(control==1)
        {
            whichLetter=Arrays.binarySearch(letters,letter);
        }
        else if(control==2)
        {
            whichLetter=Arrays.binarySearch(letters1,letter);
        }

        char[][] diamonds= new char[pointNumber[whichLetter]][pointNumber[whichLetter]];

        if(control==1 || control==2 && letter!='9')//Here I checked that non-letter characters were not entered.
            //If entered, "Invalid Input!" will print.
        {
            for (int row=0;row<diamonds.length;row++)
            {
                for (int column=0;column< diamonds.length;column++)
                {
                    diamonds[row][column]='.';
                    if(row<diamonds.length/2)//Until the middle.
                    {
                        if(row==0)
                        {
                            diamonds[row][diamonds.length/2]=letters[row];
                        }
                        else
                        {
                            diamonds[row][diamonds.length/2-row]=letters[row];
                            diamonds[row][diamonds.length/2+row]=letters[row];
                        }
                    }
                    else if(row> diamonds.length/2)//After the middle.
                    {
                        if(row== diamonds.length-1)
                        {
                            diamonds[row][diamonds.length/2]=letters[0];
                        }
                        else
                        {
                            diamonds[row][row - diamonds.length/2]=letters[diamonds.length-row-1];
                            diamonds[row][diamonds.length-1-row + diamonds.length/2]=letters[diamonds.length-row-1];
                        }
                    }
                    else//The middle.
                    {
                        diamonds[row][0]=letters[row];
                        diamonds[row][diamonds.length-1]=letters[row];
                    }
                }
            }
        }
        else
        {
            System.out.println("Invalid Input !");
        }
        return diamonds;
    }
    public static void printDiamond (char[][] diamond)
    {
        for (int row=0;row<diamond.length;row++)//To print the data in a multidimensional array to the screen.
        {
            for (int column=0;column<diamond.length;column++)
            {
                System.out.print(diamond[row][column]);
            }
            System.out.println();
        }
    }
}