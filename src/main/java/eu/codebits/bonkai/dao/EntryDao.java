/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.dao;
import eu.codebits.bonkai.model.Document;
import eu.codebits.bonkai.model.Entry;
import eu.codebits.bonkai.model.EntrySet;
import eu.codebits.bonkai.model.Subtitle;
import eu.codebits.bonkai.model.SubtitleEntry;
import eu.codebits.bonkai.subripparser.Caption;
import eu.codebits.bonkai.subripparser.SubRipParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author pmcosta
 */
@Startup
@Singleton
//@TransactionAttribute(TransactionAttributeType.REQUIRED)
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
        
        List<Entry> entries = new ArrayList();
        for(Caption c : captions) {
            
            SubtitleEntry subtitleEntry = new SubtitleEntry();
           
           
            System.out.println(c.getNumber() + "@" + c.getTimecodes());
            String text = "";
            for(String line : c.getText()) {
                text +=line+"/n";
            }
           
             subtitleEntry.setText(text);
             subtitleEntry.setTimecode(c.getTimecodes());
             
             entries.add(subtitleEntry);
             
            
        }
        
        
        insertDocument("30 CARALHO!!!!");
        
       
        
        
    }
    
    
    public EntrySet createEntrySetInDocument(Locale locale, Document document) {
    EntrySet entrySet = new EntrySet(locale);
    
   
    return entrySet;
    }
    
    
    public Document insertDocument(String name) {
        Document document = new Document(name);
        em.persist(document);
        return document;
    };

    public void insertDocument(Document document) {
       em.persist(document);
    }
    
    
}
