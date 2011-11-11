/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.dao;
import eu.codebits.bonkai.model.Document;
import eu.codebits.bonkai.model.EntrySet;
import eu.codebits.bonkai.subripparser.Caption;
import eu.codebits.bonkai.subripparser.SubRipParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author pmcosta
 */
@Startup
@Singleton

public class EntryDao {
    @PersistenceContext(unitName = "eu.codebits_bonkai_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
  
    
    
    @PostConstruct
    public void init() throws MalformedURLException, IOException, ParseException {
       
       
        
        String srt = "1\n00:00:00,720 --> 00:00:03,765\nOh, God, guys, "
                + "I'm\nstill really hungover.\n\n2\n00:00:03,769 --> "
                + "00:00:05,135\nDid I really\nruin a wedding?\n\n3\n"
                + "00:00:05,137 --> 00:00:07,504\nNo, you didn't ruin\na wedding."; 
        
        
     
        SubRipParser parser = new SubRipParser(new ByteArrayInputStream(srt.getBytes()));
        List<Caption> captions = parser.parse();
        for(Caption c : captions) {
            System.out.println(c.getNumber() + "@" + c.getTimecodes());
            for(String line : c.getText()) {
                System.out.println(line);
            }
           
        }
        
        
    }
    
    
    public EntrySet createEntrySetInDocument(Locale locale, Document document) {
    EntrySet entrySet = new EntrySet(locale);
    
   
    return entrySet;
    }
    
    
    public Document createDocument(String name, Map<String,Object> properties) {
        Document document = new Document(name);
        return document;
    };
    
    
}
