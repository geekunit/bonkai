/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author pmcosta
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Document implements Serializable {
    protected String name;
    @OneToMany
    @Cascade({CascadeType.ALL})
    private List<EntrySet> entrySets;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    
    
    
}
