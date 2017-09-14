/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.util.ArrayList;

/**
 *
 * @author DM
 */
public class Split {

    public static ArrayList<String> strToPhrase(String text){
        Clause clause = new Clause();        
        ArrayList<String> list = new ArrayList<>();
        String phrase;
        int pos;
      
        boolean lastPhrase = false;
        do {
            if (clause.isFinal(text)) { //Is the last Phrase (or only 1?)
                lastPhrase = true;
                phrase = text;
            } else {
                pos = clause.getCitationPos(text);
                if (pos==-1) pos = clause.getPhrasePos(text);
                if (pos==-1) pos = clause.getWordPos(text);
                if (pos==-1) pos = clause.getFinalPos(text);
                phrase = text.substring(0,pos);
                text = text.substring(pos);
            }
            list.add(phrase);            
        } while (!lastPhrase);
        
        return list;
    }
    
}
