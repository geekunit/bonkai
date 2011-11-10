/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.service;

import eu.codebits.bonkai.dto.TranslationBlock;
import eu.codebits.bonkai.model.Document;
import eu.codebits.bonkai.model.Language;
import javax.ejb.Local;

/**
 *
 * @author pmcosta
 */
@Local
public interface EntryService {
    
    
    public TranslationBlock getTranslationBlock(Language sourceLanguage, Language destinationLanguage);
    public TranslationBlock getTranslationBlock(Language sourceLanguage, Language destinationLanguage, Document document);
  
    
}
