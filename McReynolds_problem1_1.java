/* Name: Mihaela McReynolds
 * Lab 5h
 * Homework 5 (problem 1)
 * Date: 3/25/2018
 * Description: Many applications impose rules for user passwords. Write a 
program that utilizes methods to check a user-entered password and print out 
either "Valid" or "Invalid", based on the following rules:
Password must be at least 5 characters long, but no longer than 8 characters 
(in other words, valid password length is in the range: 5<=len<=8)
Password must consists of only letters (upper or lower case, or some combination
of upper and lower), digits, and special characters from the following set: !@#$%^&*
(note: not every special character and punctuation mark is in this set. 
These characters correspond to Shift+1 through Shift+8 on the keyboard)
Password must contain at least one digit, at least one letter, and at least one 
special character from the set defined in the point above.
*/
package mcreynolds_problem1;
import java.util.Scanner;

public class McReynolds_problem1_1 {
    
    /** Main method */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        //Prompt the user to enter a password
        System.out.print("Please enter a password: ");
        String password = input.nextLine();
        
        // Print "Valid" or "Invalid"
        if (isValid(password))
            System.out.println("Valid");
        else
            System.out.println("Invalid");
        
    }
    
    //Method to check if valid
    public static boolean isValid(String password){
    
        if (longEnough(password) && isAcceptable(password) && one(password)){
            return true;
        }
        return false;
    }
        
    // Method to test length 
    public static boolean longEnough(String password){
        
        // Length between 5 and 8 characters        
        if (password.length() >= 5 && password.length()<= 8){
            return true; 
        }
        return false;
    }
    
    // Method to check if acceptable input
    public static boolean isAcceptable(String password){  
        
        // Check each character
        for (int i = 0; i < password.length(); i++){
        char ch = password.charAt(i);
        
        // Is it a letter?
        if (Character.isLetter(ch)){ 
            return true;
        }
        // Is it a digit?
        else if (Character.isDigit(ch)){
            return true;
        }
        // Is it a special character?
        else if (ch == '!' || ch == '@' || ch == '#' || ch == '$' || 
                    ch == '%' || ch == '^' || ch == '&' || ch == '*'){
            return true;
        }
        // None of the above
        else {
            return false;
        }
      
        }
        return false;
    }
    
    // Method to check for one of each
    public static boolean one(String password){
        
        for (int i = 0; i < password.length(); i++){
        char ch = password.charAt(i);
        
        if (oneLetter(ch, password) && oneDigit(ch, password) 
                && oneDigit(ch, password)){
            return true;
        }
        }
         return false;
    }
    
    // Method to check for at least one letter
    public static boolean oneLetter(char ch, String password){
        
        int countL = 0;
        while (Character.isLetter(ch)){  
            countL++;
        }
        if (countL >=1){
            return true;
        }
        else {
            return false;
        }        
    }
    
    // Method to check for at least one digit
    public static boolean oneDigit(char ch, String password){
        
        int countD = 0;    
        while (Character.isDigit(ch)){
                  countD++; 
        }
        if (countD >=1){
            return true;
        }  
        else {
            return false;
        }
    }
        
    // Method to check for at least one special character
    public static boolean oneChar(char ch){
        
        int countS = 0; 
        while (ch == '!' || ch == '@' || ch == '#' || ch == '$' || 
                    ch == '%' || ch == '^' || ch == '&' || ch == '*'){
            countS++;
        }
        if (countS >=1){
            return true;
        }
        else {
            return false;
        }    
    }
}
   