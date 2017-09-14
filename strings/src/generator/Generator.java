/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;
import text.Print;

/**
 *
 * @author DM
 */
public class Generator {

    public static void main(String[] args){
        String noArg = "There is no text as parameter to split!";
        
        try {
            if (args.length > 0) 
                Print.print(args[0]); //Considering he text corpus passed as the first parameter;
            else
                System.out.println(noArg);                
            } catch (Exception e) {
                System.out.println(noArg);
            }
    }
}
