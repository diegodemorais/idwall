/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

/**
 *
 * @author DM
 */
public class Clause {
    //private final int MAX_INDEX = 0; //Used to make an index
    private final int LIMIT = 40;// - MAX_INDEX; //The length of a phrase
  
      public int getCitationPos(String text){ //Complete text
        int pos = text.lastIndexOf("\"");
        if (pos >=0){
            int pos2 = text.lastIndexOf("\"",pos); //Need to find 2 quotes: the complete citation
            if (pos2 == -1)
                return -1;
        } else
            return -1;
        return (pos+1);
    }  
    
    public int getPhrasePos(String text){ //Complete Phrase
        int pos = text.lastIndexOf(". ");
        if (pos <= LIMIT) //The clause must be long enough.
            return -1;
        return (pos+1);
    }    
    
    public int getFinalPos(String text){ //Complete Word
        if (text.length() <= LIMIT)
            return text.length();
        else
            return -1;
    }
    
    public boolean isFinal(String text){
        if (text.length() <= LIMIT)
            return true;
        else
            return false;
    }

    public int getWordPos(String text){ //String final
        int pos = text.lastIndexOf(" ");
        if (pos <= LIMIT) //The clause must be long enough.
            return -1;
        return (pos+1);
    }
    
    
}
