package abctreeapp;

import java.io.*;
import java.util.*;

public class AbcTreeApp {

    public static void main(String[] args) throws IOException {

        int value;

        Scanner cin = new Scanner(System.in);
//             String input = cin.next();  

//             char[] cArray = input.toCharArray(); // split the string into characters  
        AbcTree theTree = new AbcTree();

//          for (int i = 0; i < input.length(); i++ )  
//              theTree.insert( cArray[i],tsheTree.root);  
//         System.out.println("The characters have been inserted.");  
        while (true) {
            System.out.print("Enter first letter of words: show, ");
            System.out.print("insert or traverse: ");
            int choice = getChar();
            switch (choice) {
                case 's':
                    String initString = "ABCDEFG";
                    theTree.ShowTree(initString);
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.println("Type the characters you would like to insert");
                    String in = cin.next();
                    char[] cArray1 = in.toCharArray();

                    //created another character array because there is no telling if   
                    //the first cArray will be large enough to hold the new string  
                    for (int i = 0; i < cArray1.length; i++) {

                        theTree.root = theTree.insert(cArray1[i], theTree.root);
                    }
                    break;
                case 't':
                    System.out.print("Enter type 1, 2, or 3: ");
                    value = getInt();
                    theTree.traverse(value);
                    break;

                default:
                    System.out.print("Invalid entry\n");
            }  // end switch  
        }  // end while  
    }  // end main()  
    // -------------------------------------------------------------  

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // -------------------------------------------------------------  
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------  
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    // -------------------------------------------------------------  
}  // end class TreeApp  
