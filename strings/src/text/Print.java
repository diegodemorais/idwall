/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.util.ArrayList;

/**
 *
 * @author dm
 */
public class Print {

    private static void listing(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++) {
            String tweet = list.get(i);
            //System.out.println((i+1) + "/" + list.size() + tweet);                        
            System.out.println(tweet);            
        }
    }
    
    public static void print(String text){
        listing(Split.strToPhrase(text));
    }
    
}
