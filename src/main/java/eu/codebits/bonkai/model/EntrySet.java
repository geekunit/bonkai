/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.model;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Locale getLang() {
        return lang;
    }

    public void setLang(Locale lang) {
        this.lang = lang;
    }

    
    
}
