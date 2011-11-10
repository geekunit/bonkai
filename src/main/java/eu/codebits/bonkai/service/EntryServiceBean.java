/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.service;

import com.sun.jersey.spi.resource.Singleton;
import eu.codebits.bonkai.dto.TranslationBlock;
import eu.codebits.bonkai.model.Document;
import eu.codebits.bonkai.model.Entry;
import eu.codebits.bonkai.model.Language;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author pmcosta
 */
@Stateless(name="entryService")
public class EntryServiceBean implements EntryService {

    public TranslationBlock getTranslationBlock(Language sourceLanguage, Language destinationLanguage) {
       
        return new TranslationBlock(new Entry("asdadasd") , new ArrayList<Entry>(), new ArrayList<Entry>(), new Language(), new Language()); 
    }

    public TranslationBlock getTranslationBlock(Language sourceLanguage, Language destinationLanguage, Document document) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
