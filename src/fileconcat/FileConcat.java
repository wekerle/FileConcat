/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileconcat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author Ronaldo
 */
public class FileConcat {

    /**
     * @param args the command line arguments
     */
    
    private static ArrayList<LectureWithDetails>  getLecturesFromfiles()
    {
        ArrayList<LectureWithDetails> lectures=new ArrayList<LectureWithDetails>();
        //a laptopon
        //LectureReaderFromFile lrff=new LectureReaderFromFile("C:\\Users\\Ronaldo\\Documents\\NetBeansProjects\\FileConcat\\data\\titles","C:\\Users\\Ronaldo\\Documents\\NetBeansProjects\\FileConcat\\data\\keywords","C:\\Users\\Ronaldo\\Documents\\NetBeansProjects\\FileConcat\\data\\abstracts");
        
        //munkaba
         LectureReaderFromFile lrff=new LectureReaderFromFile("C:\\Users\\tibor.wekerle\\Desktop\\licenszeGit\\licensz\\data\\titles","C:\\Users\\tibor.wekerle\\Desktop\\licenszeGit\\licensz\\data\\keywords","C:\\Users\\tibor.wekerle\\Desktop\\licenszeGit\\licensz\\data\\abstracts");

        while(lrff.readNext())                                 
        {
            LectureWithDetails lecture = lrff.getCurrent();
            lectures.add(lecture);
        }
        return lectures;
    }
    
    private static ArrayList<FileConcatModel>  getStringFromfiles()
    {
        ArrayList<FileConcatModel> lectures=new ArrayList<FileConcatModel>();
        //a laptopon
       // StringReaderFromFile srff=new StringReaderFromFile("C:\\Users\\Ronaldo\\Documents\\NetBeansProjects\\FileConcat\\data\\titles","C:\\Users\\Ronaldo\\Documents\\NetBeansProjects\\FileConcat\\data\\keywords","C:\\Users\\Ronaldo\\Documents\\NetBeansProjects\\FileConcat\\data\\abstracts");
        
        //munkaba
        StringReaderFromFile srff=new StringReaderFromFile("C:\\Users\\tibor.wekerle\\Desktop\\licenszeGit\\licensz\\data\\titles","C:\\Users\\tibor.wekerle\\Desktop\\licenszeGit\\licensz\\data\\keywords","C:\\Users\\tibor.wekerle\\Desktop\\licenszeGit\\licensz\\data\\abstracts");
        while(srff.readNext())                                 
        {
            FileConcatModel lecture = srff.getCurrent();
            lectures.add(lecture);
        }
        return lectures;
    }
    
    public static void main(String[] args) {
        // ez feltolti a modelt, nem szukseges de megcsinltam. Azert csinltam mert lehet kesobb haszantveszem
        ArrayList<LectureWithDetails> lectures =getLecturesFromfiles();
        
        // ez azert van hogy olvassam ki tegyem egybe a file-okat    
        ArrayList<FileConcatModel> list=getStringFromfiles();
       
        try 
        {
            int i=1;
            for(FileConcatModel fcm :list)
            {
                File fout =new File("out"+i+".txt");
                FileOutputStream fos=new FileOutputStream(fout);
                
                BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
                
                bw.write(fcm.getLineForTitle());
                bw.newLine();
                bw.write(fcm.getLineForAuthors());
                bw.newLine();
                bw.write(fcm.getLineForPageNr());
                bw.newLine();
                bw.write(fcm.getLineForType());
                bw.newLine();
                bw.write(fcm.getLineForKeyWords());
                bw.newLine();
                bw.write(fcm.getLineForGeneratedKeyWords());
                bw.newLine();
                bw.write(fcm.getLineForTopic());
                bw.newLine();
                bw.write(fcm.getLineForAbstract());
                                
                bw.close();
                i++;
            }
            
        }catch(Exception e){
        }
        
    }
    
}
