package com.mycompany.wordscountcallection;
import java.io.FileNotFoundException;
import java.util.AbstractCollection.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
public class UseCase 
{
 public static void getUniqeWordList(String filePath) throws FileNotFoundException {
        TreeSet<String> UniqeList = DataOpration.getUniqeList(filePath);
        for (String string : UniqeList) {
            System.out.println(string);
        }
    }

    public static void getWordCount(String filePath) throws FileNotFoundException {
        String[][] wordCount = DataOpration.getWordCount(filePath);
        for (int i = 0; i < wordCount.length; i++) {
            System.out.println(wordCount[i][0] + " "+wordCount[i][1]);            
        }
    }

    public static void getTop5Words(String filePath) throws FileNotFoundException {
        String[][] wordCount = DataOpration.getDicendingWordCount(filePath);
        for (int i = 0; i < 5; i++) {
            System.out.println(wordCount[i][0]);
        }
    }

    public static void getbottom5Words(String filePath) throws FileNotFoundException {
        String[][] wordCount = DataOpration.getAssendingWordCount(filePath);
        for (int i = 0; i < 5; i++) {
            System.out.println(wordCount[i][0]);
        }
    }

    public static void getTop10Words(String filePath) throws FileNotFoundException {
        String[][] wordCount = DataOpration.getDicendingWordCount(filePath);
        for (int i = 0; i < 10; i++) {
            System.out.println(wordCount[i][0]);
        }
    }

    public static void getbottom10Words(String filePath) throws FileNotFoundException {
        String[][] wordCount = DataOpration.getAssendingWordCount(filePath);
        for (int i = 0; i < 10; i++) {
            System.out.println(wordCount[i][0]);
        }
    }
    public static void getCharacterCount(String filePath) throws FileNotFoundException
    {
        char[][] charCount=DataOpration.getCharacterCount(filePath);
        for (int i = 0; i < charCount.length; i++) {
            System.out.println(charCount[i][0]+" "+(int)charCount[i][1]);
        }
    }
    public static void getTop5Characters(String filePath) throws FileNotFoundException
    {
        char[][] charCount=DataOpration.getCharacterDicendingCount(filePath);
        for (int i = 0; i < 5; i++) {
            System.out.println(charCount[i][0]);
        }
    }
    public static void getbottom5Characters(String filePath) throws FileNotFoundException
    {
        char[][] charCount=DataOpration.getCharacterAssendingCount(filePath);
        for (int i = 0; i < 5; i++) {
            System.out.println(charCount[i][0]);
        }
    }
    public static void getReversUniqeWordList(String filePath) throws FileNotFoundException
    {
        TreeSet<String> uniqeWord=DataOpration.getUniqeList(filePath);
        ArrayList<String> uniqeWordList=new ArrayList<String>(uniqeWord);
        Collections.reverse(uniqeWordList);
        for (String string : uniqeWordList) {
            System.out.println(string);
        }
    }
}
