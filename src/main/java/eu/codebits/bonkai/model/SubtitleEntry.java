/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author pmcosta
 */
@Entity
public class SubtitleEntry extends Entry implements Serializable {
    
    
    private String timecode;

    public String getTimecode() {
        return timecode;
    }

    public void setTimecode(String timecode) {
        this.timecode = timecode;
    }
    
    

   
    
    
}
