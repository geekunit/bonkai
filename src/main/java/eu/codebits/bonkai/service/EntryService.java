/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.service;

import com.sun.jersey.spi.resource.Singleton;
import eu.codebits.bonkai.dto.TranslationBlock;
import eu.codebits.bonkai.dto.ReviewBlock;
import eu.codebits.bonkai.model.Document;
import eu.codebits.bonkai.model.Entry;
import java.util.ArrayList;
import java.util.Locale;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class EntryService {

    public ReviewBlock getReviewBlock(Locale sourceLanguage, Locale destinationLanguage)
    {
        ArrayList<Entry> previousContextEntries = new ArrayList<Entry>();
        previousContextEntries.add(new Entry("What now ? I tell you what now.."));
        previousContextEntries.add(new Entry("I'm a call a coulple of niggas with hardpipes and motherfuckin' blowtorches"));
        ArrayList<Entry> nextContextEntries = new ArrayList<Entry>();
        nextContextEntries.add(new Entry("I'm a get medieval on your ass !"));    
        nextContextEntries.add(new Entry("..erm I was talking about us !"));
        
        return new ReviewBlock(new Entry("You hear that hillbilly boy ?"),
                new Entry("Est‡s a ouvir, menino caipira ?"),
                previousContextEntries, nextContextEntries,
                new Locale("pt", "PT"),
                new Locale("en","US"));
    }
    
    public TranslationBlock getTranslationBlock(Locale sourceLanguage, Locale destinationLanguage) 
    {
        ArrayList<Entry> previousContextEntries = new ArrayList<Entry>();
        previousContextEntries.add(new Entry("What now ? I tell you what now.."));
        previousContextEntries.add(new Entry("I'm a call a coulple of niggas with hardpipes and motherfuckin' blowtorches"));
        ArrayList<Entry> nextContextEntries = new ArrayList<Entry>();
        nextContextEntries.add(new Entry("I'm a get medieval on your ass !"));    
        nextContextEntries.add(new Entry("..erm I was talking about us !"));
        
        return new TranslationBlock(new Entry("You hear that hillbilly boy ?"),
                previousContextEntries, nextContextEntries,
                new Locale("pt", "PT"),
                new Locale("en","US"));
    }

    public TranslationBlock getTranslationBlock(Locale sourceLanguage, Locale destinationLanguage, Document document) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
