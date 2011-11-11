/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.model;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author pmcosta
 */
@Entity
public class EntrySet implements Serializable {
    private Locale lang;
    @OneToMany
    private List<Entry> entries;
    @Id
    private Long id;

    public EntrySet() {
    }

    public EntrySet(Locale language) {
        this.lang = language;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public Locale getLanguage() {
        return lang;
    }

    public void setLanguage(Locale language) {
        this.lang = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
