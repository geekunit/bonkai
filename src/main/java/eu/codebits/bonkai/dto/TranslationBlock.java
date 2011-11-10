/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.dto;

import eu.codebits.bonkai.model.Entry;
import eu.codebits.bonkai.model.Language;
import java.util.List;

/**
 *
 * @author pmcosta
 */
public class TranslationBlock {
    private Entry entryToTranslate;
    private List<Entry> previousContextEntries;
    private List<Entry> nextContextEntries;
    private Language sourceLanguage;
    private Language destinationLanguage;

    public TranslationBlock(Entry entryToTranslate, List<Entry> previousContextEntries, List<Entry> nextContextEntries, Language sourceLanguage, Language destinationLanguage) {
        this.entryToTranslate = entryToTranslate;
        this.previousContextEntries = previousContextEntries;
        this.nextContextEntries = nextContextEntries;
        this.sourceLanguage = sourceLanguage;
        this.destinationLanguage = destinationLanguage;
    }

    public Language getDestinationLanguage() {
        return destinationLanguage;
    }

    public void setDestinationLanguage(Language destinationLanguage) {
        this.destinationLanguage = destinationLanguage;
    }

    public Entry getEntryToTranslate() {
        return entryToTranslate;
    }

    public void setEntryToTranslate(Entry entryToTranslate) {
        this.entryToTranslate = entryToTranslate;
    }

    public List<Entry> getNextContextEntries() {
        return nextContextEntries;
    }

    public void setNextContextEntries(List<Entry> nextContextEntries) {
        this.nextContextEntries = nextContextEntries;
    }

    public List<Entry> getPreviousContextEntries() {
        return previousContextEntries;
    }

    public void setPreviousContextEntries(List<Entry> previousContextEntries) {
        this.previousContextEntries = previousContextEntries;
    }

    public Language getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(Language sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

 
    
   
    
    
}
