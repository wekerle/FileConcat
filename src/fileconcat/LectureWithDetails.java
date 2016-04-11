/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileconcat;

import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class LectureWithDetails{
    private int pageNr;
    private String title;
    private String topic;
    private String type;
    private ArrayList<String> authors;
    private String abstarct;
    private ArrayList<String> keyWords;
    private ArrayList<KeyWord> generatedKeyWords;


    public int getPageNr() {
        return pageNr;
    }

    public String getTopic() {
        return topic;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public String getAbstarct() {
        return abstarct;
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    public ArrayList<KeyWord> getGeneratedKeyWords() {
        return generatedKeyWords;
    }
    public LectureWithDetails(String title, ArrayList<String> authors, int pageNr, String type, ArrayList<String> keyWords, ArrayList<KeyWord> generatedKeyWords,String topic,String abstarct) {
        this.pageNr = pageNr;
        this.title = title;
        this.authors = authors;
        this.abstarct = abstarct;
        this.keyWords = keyWords;
        this.generatedKeyWords = generatedKeyWords;
        this.type=type;
        this.topic=topic;
    }



    
}
