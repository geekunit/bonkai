/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
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
public class Document implements Serializable {
    private String name;
    @OneToMany
    private List<EntrySet> entrySets;
    @Id
    private Long id;

    public Document() {
    }

    public Document(String name) {
        this.name = name;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EntrySet> getEntrySets() {
        return entrySets;
    }

    public void setEntrySets(List<EntrySet> entrySets) {
        this.entrySets = entrySets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
    
}
