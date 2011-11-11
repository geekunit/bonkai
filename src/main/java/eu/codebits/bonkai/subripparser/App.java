package eu.codebits.bonkai.subripparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException, ParseException
    {
        File f = new File("/tmp/test.srt");
        SubRipParser parser = new SubRipParser(f);
        List<Caption> captions = parser.parse();
        for(Caption c : captions) {
            System.out.println(c.getNumber() + "@" + c.getTimecodes());
            for(String line : c.getText()) {
                System.out.println(line);
            }
            System.out.println("--------------------------");
        }
    }
}
