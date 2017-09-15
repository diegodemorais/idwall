/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringSplitter;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DM
 */
public class Splitter {
    static final int LIMIT=40;
    
    //Removing the white space from beggining
    public static int getStart(String text){
        if (text.length() > 0)
            return (text.charAt(0) == ' ') ? 1 : 0;
        else
            return -1;
    }
    
    //Getting the right length to the sentence
    public static int getFinal(String text){
        if (text.length()>= LIMIT+1)
            if (text.substring(LIMIT,LIMIT+1).equals(" ")) return LIMIT+1;
                if (text.length()>= LIMIT+2)
            if (text.substring(LIMIT,LIMIT+2).equals("\n")) return LIMIT+2;
        if (text.length() >= LIMIT) return LIMIT;
        return text.length();
    }
    
    //Check if there is a New Line
    public static  int getNewLine(String text){
        int newLine = text.indexOf("\n");
        return newLine;
    }
    
    //Check is there is a Quote
    public static  int getQuote(String text){
        int start = text.indexOf("\"");
        if (start == -1)
            return -1;
        else {
            int end = text.indexOf("\"", start+1);
            return (end == -1) ? (start) : -1;
        }
    }
    
    //Getting the line breaker
    public static  int getDotCommaSpace(String text){
        int result;
        int dot = text.lastIndexOf(".");
        int space = text.lastIndexOf(" ");
        int comma = text.lastIndexOf(",");
        result = (dot > space) ? dot : space;
        result = (result > comma) ? result : comma;
        return result;
    }
    
    //Setting priorities
    public static  int getLineBreaker(String text){
        if (getNewLine(text) != -1)  return getNewLine(text);
        if (getFinal(text) < LIMIT)  return getFinal(text);
        if (getQuote(text) != -1)  return getQuote(text);
        return getDotCommaSpace(text);
    }
    
    //Splitting - the main logic
    public static String splitting(String text, boolean justified){
        List<String> result = new ArrayList<>();
        int pos;
        String part;
        
        while (getFinal(text) != 0) {
            pos = getLineBreaker(text.substring(0,getFinal(text)));
            part = text.substring(getStart(text),pos);
            if (justified) part = justify(part);
            result.add(part+"\n");
            text = text.substring((pos==0 ? 1 : pos)+getStart(text));
        }
        
        String resultStr = "";
        for(String str : result)
            resultStr+= str;
        
        return resultStr;
    }
    
    //Adding spaces to justify 
    public static String justify(String text){
        int size = text.length();
        if (size==LIMIT) return text;
        
        int miss = LIMIT - size;
        List<Integer> spaces = new ArrayList<>();
        char[] textChar = text.toCharArray();
        for(int i=0;i<size;i++)
            if (textChar[i] == ' ')
                spaces.add(i);
        
        if (spaces.isEmpty()) return text;
        
        StringBuilder result = new StringBuilder(text);
        while (miss>0) {
            if (miss>0) {
                result.insert((int) spaces.get(0),' ');
                for(int j=0;j<spaces.size();j++)
                    spaces.set(j, spaces.get(j)+1);
                miss--;
            }
            if (miss>0) {
                result.insert((int) spaces.get(spaces.size()-1),' ');
                spaces.set(spaces.size()-1, spaces.get(spaces.size()-1)+1);
                miss--;
            }        
            for(int i=2;i<spaces.size()-1&&miss>0;i+=2){
                result.insert((int) spaces.get(i),' ');
                for(int j=i;j<spaces.size();j++)
                    spaces.set(j, spaces.get(j)+1);
                miss--;
            }
            for(int i=1;i<spaces.size()-1&&miss>0;i+=2){
                result.insert((int) spaces.get(i),' ');
                for(int j=i;j<spaces.size();j++)
                    spaces.set(j, spaces.get(j)+1);
                miss--;
            }
        }
//        for (int i=0;(miss>0)&&(i<spaces.size());i++){
//            result.insert(spaces.get(i)+count, ' ');
//            miss--;
//            count++;
//            
//            if ((i==spaces.size())&&(miss>0))
//                i= -1;
//        }
        
        text = result.toString();
        return text;
    }
    
//    public static ArrayList splitting(String text){
//        StringBuilder result = new StringBuilder();
//        int pos;
//        
//        while (getFinal(text) != 0) {
//            pos = getLineBreaker(text.substring(0,getFinal(text)));
//            result.append(text.substring(getStart(text),pos)).append("\n");
//            text = text.substring((pos==0 ? 1 : pos)+getStart(text));
//        }
//
//        return result;
//    }

    public static void main(String[] args){
        String in = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\nAnd God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
     
        System.out.println(splitting(in,true));
        
    }
}
