/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileconcat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Ronaldo
 */
public class StringReaderFromFile{

    private ArrayList<File> listOfFilesTitleAuthorsPageType = new ArrayList<File>();
    private ArrayList<File> listOfFilesKeywordsTopic = new ArrayList<File>();
    private ArrayList<File> listOfFilesAbstract = new ArrayList<File>();
    private FileConcatModel currentLecture=null;
    private int index=-1;
        
    private ArrayList<File> getAllFilesFromDir(String path)
    {
        ArrayList<File> files=new ArrayList<File>();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
            //System.out.println("File " + listOfFiles[i].getName());
            files.add(listOfFiles[i]);
          } 
        }
        return files;
    }
    public StringReaderFromFile(String titleAuthorsPageType,String keywordsTopic,String abstractt) {
               
        ArrayList<File> files1 = getAllFilesFromDir(titleAuthorsPageType);
        ArrayList<File> files2 = getAllFilesFromDir(keywordsTopic);
        ArrayList<File> files3 = getAllFilesFromDir(abstractt);
        
        
        for (File f1:files1)
        {
            File file2ToRemove=null;
                        
            for(File f2:files2)
            {
                String[] nameSplit1=f1.getName().split("_");
                String[] nameSplit2=f2.getName().split("_");
                if(nameSplit1[nameSplit1.length-1].compareTo(nameSplit2[nameSplit2.length-1])==0)
                {
                    File file3ToRemove=null;
                    for(File f3:files3)
                    {
                        String[] nameSplit3=f3.getName().split("_");
                        if(nameSplit2[nameSplit2.length-1].compareTo(nameSplit3[nameSplit3.length-1])==0)
                        {
                        
                            listOfFilesTitleAuthorsPageType.add(f1);
                            listOfFilesKeywordsTopic.add(f2);
                            listOfFilesAbstract.add(f3);
                            
                            file2ToRemove=f2;
                            file3ToRemove=f3;
                        }                       
                    }
                    // cerejem ki a listakat hogy lehgyenek lancolt listak
                    files3.remove(file3ToRemove);
                    
                }
            }
            // cerejem ki a listakat hogy lehgyenek lancolt listak
            files2.remove(file2ToRemove);
        }        
    }
    
    public boolean readNext() {
        index++;
        if(index>=listOfFilesTitleAuthorsPageType.size())
        {
            return false;
        }
        currentLecture=readLectureDetailsFromFiles(listOfFilesTitleAuthorsPageType.get(index), listOfFilesKeywordsTopic.get(index),listOfFilesAbstract.get(index));
        return true;
    }

    public FileConcatModel getCurrent() {
       return currentLecture;
    }

    private FileConcatModel readLectureDetailsFromFiles(File titleAuthorsPageType, File keywordsTopic, File abstractt) {
        
        //roszul neveztem el a fileokat mindehol 
        try {
            BufferedReader br = new BufferedReader(new FileReader(titleAuthorsPageType));
            String line = br.readLine();
            
            BufferedReader br2 = new BufferedReader(new FileReader(keywordsTopic));
            String line2 = br2.readLine();
            
            BufferedReader br3 = new BufferedReader(new FileReader(abstractt));
            String line3 = br3.readLine();
            
            String keyWordsString="";
            String authorsString="";
            String generatedKeyWordsString="";
            String titleString="";
            String topicString="";
            String abstarctString="";          
            String pageNrString="";
            String typeString="";
            while (line != null) {
                           
                titleString=line;
                line = br.readLine();
                
                authorsString=line;
                line = br.readLine();
                
                pageNrString=line;
                line = br.readLine();
                                 
                typeString=line;
                line = br.readLine();  
                
                topicString=line;
                line = br.readLine();
            }
            
            while (line2 != null) {
                
                keyWordsString=line2;
                line2 = br2.readLine();
                
                generatedKeyWordsString=line2;
                line2 = br2.readLine();                                             
            }
            
            while (line3 != null) {
                
                abstarctString=line3;
                line3 = br3.readLine();                                         
            }
           return new FileConcatModel(titleString, authorsString, pageNrString,typeString, keyWordsString,  generatedKeyWordsString,topicString,abstarctString);
        } catch(Exception e) {
           // br.close();
            }
        return null;
       
    }
}
