/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.service;

import com.sun.jersey.spi.resource.Singleton;
import eu.codebits.bonkai.dto.TranslationBlock;
import eu.codebits.bonkai.model.Document;
import eu.codebits.bonkai.model.Entry;
import java.util.ArrayList;
import java.util.Locale;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author pmcosta
 */
@Local
@Stateless
public class EntryService {

    public TranslationBlock getTranslationBlock(Locale sourceLanguage, Locale destinationLanguage) {
       
        return new TranslationBlock(new Entry("asdadasd") , new ArrayList<Entry>(), new ArrayList<Entry>(), new Locale("pt","PT"), new Locale("pt","PT")); 
    }

    public TranslationBlock getTranslationBlock(Locale sourceLanguage, Locale destinationLanguage, Document document) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
