package com.mycompany.wordscountcallection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WordsCountCallection {

    public static void main(String[] args) throws FileNotFoundException
    {
       
       DataOpration.getFileString("D:\\Files\\input.txt");
        //DataOpration.getSymbolList("\"D:\\Files\\symbol.txt\"");
        //DataOpration.getStopWord("D:\\Files\\stop_word.txt");
       String filepath="D:\\Files\\input.txt";
        System.out.println("=====Uniqe Word List=====");
        UseCase.getUniqeWordList(filepath);
        System.out.println("==============================");
        System.out.println("=====Word Count=====");
        UseCase.getWordCount(filepath);
        System.out.println("==============================");
        System.out.println("=====Top 5 Word=====");
        UseCase.getTop5Words(filepath);
        System.out.println("==============================");
        System.out.println("=====Bottom 5 word=====");
        UseCase.getbottom5Words(filepath);
        System.out.println("==============================");
        System.out.println("=====Top 10 Word=====");
        UseCase.getTop10Words(filepath);
        System.out.println("==============================");
        System.out.println("=====Bottom 10 Word=====");
        UseCase.getbottom10Words(filepath);
        System.out.println("==============================");
        System.out.println("=====Character Count=====");
        UseCase.getCharacterCount(filepath);
        System.out.println("==============================");
        System.out.println("=====Top 5 Characters=====");
        UseCase.getTop5Characters(filepath);
        System.out.println("==============================");
        System.out.println("=====Bottom 5 characters=====");
        UseCase.getbottom5Characters(filepath);
        System.out.println("==============================");
        System.out.println("=====Revers Uniqe Word List=====");
        UseCase.getReversUniqeWordList(filepath);
    }
}
