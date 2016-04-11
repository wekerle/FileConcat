/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileconcat;

/**
 *
 * @author Ronaldo
 */
public class FileConcatModel {
    private String lineForTitle;
    private String lineForAuthors;
    private String lineForPageNr;
    private String lineForType;
    
    private String lineForKeyWords;
    private String lineForGeneratedKeyWords;
    private String lineForTopic;
    
    private String lineForAbstract;

    public String getLineForTitle() {
        return lineForTitle;
    }

    public void setLineForTitle(String lineForTitle) {
        this.lineForTitle = lineForTitle;
    }

    public String getLineForAuthors() {
        return lineForAuthors;
    }

    public void setLineForAuthors(String lineForAuthors) {
        this.lineForAuthors = lineForAuthors;
    }

    public String getLineForPageNr() {
        return lineForPageNr;
    }

    public void setLineForPageNr(String lineForPageNr) {
        this.lineForPageNr = lineForPageNr;
    }

    public String getLineForType() {
        return lineForType;
    }

    public void setLineForType(String lineForType) {
        this.lineForType = lineForType;
    }

    public String getLineForKeyWords() {
        return lineForKeyWords;
    }

    public void setLineForKeyWords(String lineForKeyWords) {
        this.lineForKeyWords = lineForKeyWords;
    }

    public String getLineForGeneratedKeyWords() {
        return lineForGeneratedKeyWords;
    }

    public void setLineForGeneratedKeyWords(String lineForGeneratedKeyWords) {
        this.lineForGeneratedKeyWords = lineForGeneratedKeyWords;
    }

    public String getLineForTopic() {
        return lineForTopic;
    }

    public void setLineForTopic(String lineForTopic) {
        this.lineForTopic = lineForTopic;
    }

    public String getLineForAbstract() {
        return lineForAbstract;
    }

    public void setLineForAbstract(String lineForAbstract) {
        this.lineForAbstract = lineForAbstract;
    }

    public FileConcatModel(String lineForTitle, String lineForAuthors, String lineForPageNr, String lineForType, String lineForKeyWords, String lineForGeneratedKeyWords, String lineForTopic, String lineForAbstract) {
        this.lineForTitle = lineForTitle;
        this.lineForAuthors = lineForAuthors;
        this.lineForPageNr = lineForPageNr;
        this.lineForType = lineForType;
        this.lineForKeyWords = lineForKeyWords;
        this.lineForGeneratedKeyWords = lineForGeneratedKeyWords;
        this.lineForTopic = lineForTopic;
        this.lineForAbstract = lineForAbstract;
    }
     
    
}
