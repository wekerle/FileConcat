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
public class LectureReaderFromFile{

    private ArrayList<File> listOfFilesTitleAuthorsPageType = new ArrayList<File>();
    private ArrayList<File> listOfFilesKeywordsTopic = new ArrayList<File>();
    private ArrayList<File> listOfFilesAbstract = new ArrayList<File>();
    private LectureWithDetails currentLecture=null;
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
    public LectureReaderFromFile(String titleAuthorsPageType,String keywordsTopic,String abstractt) {
               
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

    public LectureWithDetails getCurrent() {
       return currentLecture;
    }

    private LectureWithDetails readLectureDetailsFromFiles(File titleAuthorsPageType, File keywordsTopic, File abstractt) {
        
        //roszul neveztem el a fileokat mindehol 
        try {
            BufferedReader br = new BufferedReader(new FileReader(titleAuthorsPageType));
            String line = br.readLine();
            
            BufferedReader br2 = new BufferedReader(new FileReader(keywordsTopic));
            String line2 = br2.readLine();
            
            BufferedReader br3 = new BufferedReader(new FileReader(abstractt));
            String line3 = br3.readLine();
            
            ArrayList<String> keyWords=new ArrayList<String>();
            ArrayList<String> authors=new ArrayList<String>();
            ArrayList<String> generatedKeyWords=new ArrayList<String>();
            ArrayList<KeyWord> listOfKeyWords=new ArrayList<KeyWord>();
            String title="";
            String topic="";
            String abstarct="";          
            int pageNr=0;
            String type="";
            while (line != null) {
                           
                title=line;
                line = br.readLine();
                
                authors=new ArrayList<String>(Arrays.asList(line.split(",")));
                line = br.readLine();
                
                pageNr=Integer.parseInt(line);
                line = br.readLine();
                                 
                type=line;
                line = br.readLine();                              
            }
            
            while (line2 != null) {
                
                keyWords=new ArrayList<String>(Arrays.asList(line2.split(",")));
                line2 = br2.readLine();
                
                generatedKeyWords=new ArrayList<String>(Arrays.asList(line2.split(",")));
                for (String s : generatedKeyWords)
                {
                    String[] keywordSplit= s.split("\\s*[\\(\\)]");
                    KeyWord kw=new KeyWord(keywordSplit[0],Integer.parseInt(keywordSplit[1]));
                    listOfKeyWords.add(kw);
                }
                line2 = br2.readLine();
                
                topic=line2;
                line2 = br2.readLine();
                
            }
            
            while (line3 != null) {
                
                abstarct=line3;
                line3 = br3.readLine();                                         
            }
           return new LectureWithDetails(title, authors, pageNr,type, keyWords,  listOfKeyWords,topic,abstarct);
        } catch(Exception e) {
           // br.close();
            }
        return null;
       
    }
}
