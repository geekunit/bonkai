/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.dto;

import eu.codebits.bonkai.model.Entry;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author pmcosta
 */
public class ReviewBlock {
    
    private Entry originalEntry;
    private Entry translatedEntry;
    private List<Entry> previousContextEntries;
    private List<Entry> nextContextEntries;
    private Locale sourceLanguage;
    private Locale destinationLanguage;

    public ReviewBlock(Entry originalEntry,
            Entry translatedEntry,
            List<Entry> previousContextEntries, 
            List<Entry> nextContextEntries, 
            Locale sourceLanguage, 
            Locale destinationLanguage) 
    {
        this.originalEntry = originalEntry;
        this.translatedEntry = translatedEntry;
        this.previousContextEntries = previousContextEntries;
        this.nextContextEntries = nextContextEntries;
        this.sourceLanguage = sourceLanguage;
        this.destinationLanguage = destinationLanguage;
        
    }

    public Entry getOriginalEntry() {
        return originalEntry;
    }

    public void setOriginalEntry(Entry originalEntry) {
        this.originalEntry = originalEntry;
    }

    
    public Entry getTranslatedEntry() {
        return translatedEntry;
    }

    public void setTranslatedEntry(Entry translatedEntry) {
        this.translatedEntry = translatedEntry;
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

    public Locale getDestinationLanguage() {
        return destinationLanguage;
    }

    public void setDestinationLanguage(Locale destinationLanguage) {
        this.destinationLanguage = destinationLanguage;
    }

    public Locale getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(Locale sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }    
}
