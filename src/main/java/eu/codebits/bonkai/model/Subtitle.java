/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.model;

import java.io.Serializable;
import java.util.Locale;
import javax.persistence.Entity;

/**
 *
 * @author pmcosta
 */
@Entity
public class Subtitle extends Document implements Serializable {

    public Subtitle() {}
    
    public Subtitle(String name) {
        this.name = name;
    }

    
    
}
