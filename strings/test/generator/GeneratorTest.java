/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dm
 */
public class GeneratorTest {
    
    @Test
    public void testMainSimple() {
        String[] args = {"Test."};
        String expected = "1/1Test.\r\n";
                
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Generator.main(args);
        assertEquals(expected, outContent.toString());
    }
    
    @Test
    public void testMainNoArgs() {
        String[] args = null;
        String expected = "There is no text as parameter to convert in TweetStorm!\r\n";
                
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Generator.main(args);
        assertEquals(expected, outContent.toString());
    }    
    
    @Test
    public void testMainSomeWords() {
        String[] args = {"Test 123 321 asd asd."};
        String expected = "1/1Test 123 321 asd asd.\r\n";
                
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Generator.main(args);
        assertEquals(expected, outContent.toString());
    }  
    
    @Test
    public void testMainSomePhrases() {
        String[] args = {"A common trope in discussions about startups & venture capital is a potential misalignment of incentives between startup team & investors."};
        String expected = "1/2A common trope in discussions about startups & venture capital is a potential misalignment of incentives between startup team & \r\n2/2investors.\r\n";
                
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Generator.main(args);
        assertEquals(expected, outContent.toString());
    }  

    @Test
    public void testMainExample() {
        String[] args = {"A common trope in discussions about startups & venture capital is a potential misalignment of incentives between startup team & investors. I don't think this perceived misalignment actually exists in most, maybe all cases -- and I want to explain why. The argument goes, \"When you take VC, you have to shoot for the moon; smaller outcomes that may be great for the team are precluded. \"First, obvious but important: No startup is forced to take venture capital. In fact, vast majority of successful new businesses do not. The main reason TO TAKE venture capital is in pursuit of a bigger outcome than the startup team believes it could achieve on its own. Hence, taking venture capital ALIGNS interest in a big outcome between the venture investors and the team. Most non-VC investors are more risk averse than VCs; a startup shooting for big outcome that raises money from non-VCs ends up MISALIGNED. The argument cont'd: \"VCs can tolerate higher risk of failure due to portfolio of bets, whereas founders and employees have only one bet. \"In the modern era, that's also untrue. Founders and employees generally make multiple bets as well, in two dimensions: Founders and employees often have running room to try multiple products within a single startup; hence popularity of the term \"pivot\". And, founders and employees often start or join multiple startups throughout their multi-decade careers = a personal portfolio of bets. In fact, some of today's most successful startups are founded by entrepreneurs whose previous ventures didn't work nearly as well. In short: VC is very much not for every company. But for companies that want to do something big, VC = the most aligned capital there is."};
        String expected = "1/15A common trope in discussions about startups & venture capital is a potential misalignment of incentives between startup team & \r\n2/15investors. I don't think this perceived misalignment actually exists in most, maybe all cases -- and I want to explain why.\r\n3/15 The argument goes, \"When you take VC, you have to shoot for the moon; smaller outcomes that may be great for the team are precluded. \"\r\n4/15First, obvious but important: No startup is forced to take venture capital. In fact, vast majority of successful new businesses do not.\r\n5/15 The main reason TO TAKE venture capital is in pursuit of a bigger outcome than the startup team believes it could achieve on its own.\r\n6/15 Hence, taking venture capital ALIGNS interest in a big outcome between the venture investors and the team.\r\n7/15 Most non-VC investors are more risk averse than VCs; a startup shooting for big outcome that raises money from non-VCs ends up \r\n8/15MISALIGNED. The argument cont'd: \"\r\n9/15VCs can tolerate higher risk of failure due to portfolio of bets, whereas founders and employees have only one bet. \"\r\n10/15In the modern era, that's also untrue. Founders and employees generally make multiple bets as well, in two dimensions: Founders and \r\n11/15employees often have running room to try multiple products within a single startup; hence popularity of the term \"pivot\"\r\n12/15. And, founders and employees often start or join multiple startups throughout their multi-decade careers = a personal portfolio of \r\n13/15bets. In fact, some of today's most successful startups are founded by entrepreneurs whose previous ventures didn't work nearly as \r\n14/15well. In short: VC is very much not for every company. But for companies that want to do something big, VC = the most aligned capital \r\n15/15there is.\r\n";
                
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Generator.main(args);
        assertEquals(expected, outContent.toString());
    }      
 
}