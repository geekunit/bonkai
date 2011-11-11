/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 *
 * @author pmcosta
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Entry implements Serializable {
    
    
    private Integer entryNumber; 
    private String text;
    @OneToMany
    private List<Entry> previousEntryVersions;
    
    @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    public Entry(){}

    public Entry(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Entry> getPreviousEntryVersions() {
        return previousEntryVersions;
    }

    public void setPreviousEntryVersions(List<Entry> previousEntryVersions) {
        this.previousEntryVersions = previousEntryVersions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    
    
    
}
