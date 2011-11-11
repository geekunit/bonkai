/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.codebits.bonkai.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author pmcosta
 */
@Entity
public class SubtitleEntry extends Entry implements Serializable {
    
    private String timecode;

    public SubtitleEntry() {}

    public SubtitleEntry(Integer entryNumber, String text, String timecode) {
        this.entryNumber = entryNumber;
        this.text = text;
        this.timecode = timecode;
    }

    public String getTimecode() {
        return timecode;
    }

    public void setTimecode(String timecode) {
        this.timecode = timecode;
    }
    
    

   
    
    
}
