package com.mycompany.wordscountcallection;

import static com.mycompany.wordscountcallection.FileRedar.getSymbollist;
import static com.mycompany.wordscountcallection.FileRedar.getstopwordlist;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class DataOpration 
{
public static String getFileString(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        String str = "";
        while (sc.hasNext()) {
            str = str.concat(sc.next() + " ");
        }
        return str;
    }

    public static ArrayList<Character> getSymbolList(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        ArrayList<Character> symbolList = new ArrayList();
        while (sc.hasNext()) {
            symbolList.add(sc.next().charAt(0));
        }
        return symbolList;
    }

    public static String removeSymbol(String filePath) throws FileNotFoundException {
        String str = getFileString(filePath);
        char[] charList = str.toCharArray();
        ArrayList<Character> characterList = new ArrayList();
        for (char c : charList) {
            characterList.add(c);
        }
        ArrayList<Character> symbolList = getSymbolList("D:\\Files\\symbol.txt");
        characterList.removeAll(symbolList);
        String str1 = "";
        for (Character character : characterList) {
            str1 = str1.concat(character.toString());
        }
        return str1;
    }

    public static ArrayList<String> getStopWord(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        ArrayList<String> stopWordList = new ArrayList();
        while (sc.hasNext()) {
            stopWordList.add(sc.next());
        }
        return stopWordList;
    }

    public static ArrayList<String> getWordList(String filePath) throws FileNotFoundException {
        String str = removeSymbol(filePath);
        String[] dataList = str.split(" ");
        ArrayList<String> wordList = new ArrayList();
        for (String string : dataList) {
            wordList.add(string);
        }
        return wordList;
    }

    public static ArrayList<String> removeStopWord(String filePath) throws FileNotFoundException {
        ArrayList<String> dataList = getWordList(filePath);
        ArrayList<String> symbolList = new ArrayList();
        symbolList = getStopWord("D:\\Files\\stop_words.txt");
        dataList.removeAll(symbolList);
        ArrayList<String> spaceList = new ArrayList();
        spaceList.add("");
        spaceList.add(" ");
        spaceList.add("  ");
        spaceList.add("   ");
        dataList.removeAll(spaceList);
        return dataList;
    }

    public static TreeSet<String> getUniqeList(String filePath) throws FileNotFoundException {
        ArrayList<String> pureDataList = removeStopWord(filePath);
        TreeSet<String> uniqeWordList = new TreeSet<String>(pureDataList);
        return uniqeWordList;
    }

    public static String[][] getWordCount(String filePath) throws FileNotFoundException {
        TreeSet<String> uniqeWordList = getUniqeList(filePath);
        ArrayList<String> wordList = getWordList(filePath);
        String[][] wordCountList = new String[uniqeWordList.size()][2];
        int row = 0;
        for (String string : uniqeWordList) {
            int count = 0;
            for (int i = 0; i < wordList.size(); i++) {
                if (string.equalsIgnoreCase(wordList.get(i))) {
                    count++;
                }
            }
            wordCountList[row][0] = string;
            wordCountList[row][1] = Integer.toString(count);
            row++;
        }
        return wordCountList;
    }

    public static String[][] getAssendingWordCount(String filePath) throws FileNotFoundException {
        String[][] wordCount = getWordCount(filePath);
        for (int i = 0; i < wordCount.length; i++) {
            for (int j = 0; j < wordCount.length; j++) {
                if (Integer.parseInt(wordCount[i][1]) < Integer.parseInt(wordCount[j][1])) {
                    String temp = wordCount[i][1];
                    wordCount[i][1] = wordCount[j][1];
                    wordCount[j][1] = temp;

                    String temp2 = wordCount[i][0];
                    wordCount[i][0] = wordCount[j][0];
                    wordCount[j][0] = temp2;
                }
            }
        }
        return wordCount;
    }

    public static String[][] getDicendingWordCount(String filePath) throws FileNotFoundException {
        String[][] wordCount = getWordCount(filePath);
        for (int i = 0; i < wordCount.length; i++) {
            for (int j = 0; j < wordCount.length; j++) {
                if (Integer.parseInt(wordCount[i][1]) > Integer.parseInt(wordCount[j][1])) {
                    String temp = wordCount[i][1];
                    wordCount[i][1] = wordCount[j][1];
                    wordCount[j][1] = temp;

                    String temp2 = wordCount[i][0];
                    wordCount[i][0] = wordCount[j][0];
                    wordCount[j][0] = temp2;
                }
            }
        }
        return wordCount;
    }

    public static char[][] getCharacterCount(String filePath) throws FileNotFoundException {
        //Aplfabate list
        char[] charList = new char[26];
        int index = 0;
        for (int i = 97; i < 123; i++) {
            charList[index] = (char) i;
            index++;
        }
        //string concat
        ArrayList<String> wordList = removeStopWord(filePath);
        String str = "";
        for (String string : wordList) {
            str = str.concat(string);
        }
        //strin to charList
        char[][] charCount = new char[charList.length][2];
        int row = 0;
        char[] dataCharList = str.toCharArray();
        //char count
        for (char cs : charList) {
            int count = 0;
            for (int i = 0; i < dataCharList.length; i++) {
                if (cs == dataCharList[i]) {
                    count++;
                }
            }
            charCount[row][0] = cs;
            charCount[row][1] = (char) count;
            row++;
        }
        return charCount;
    }

    public static char[][] getCharacterAssendingCount(String filePath) throws FileNotFoundException {
        char[][] charList = getCharacterCount(filePath);
        for (int i = 0; i < charList.length; i++) {
            for (int j = 0; j < charList.length; j++) {
                if (charList[i][1] < charList[j][1]) {
                    char temp = charList[i][1];
                    charList[i][1] = charList[j][1];
                    charList[j][1] = temp;
                    char temp1 = charList[i][0];
                    charList[i][0] = charList[j][0];
                    charList[j][0] = temp1;
                }
            }
        }
        return charList;
    }
    public static char[][] getCharacterDicendingCount(String filePath) throws FileNotFoundException {
        char[][] charList = getCharacterCount(filePath);
        for (int i = 0; i < charList.length; i++) {
            for (int j = 0; j < charList.length; j++) {
                if (charList[i][1] > charList[j][1]) {
                    char temp = charList[i][1];
                    charList[i][1] = charList[j][1];
                    charList[j][1] = temp;
                    char temp1 = charList[i][0];
                    charList[i][0] = charList[j][0];
                    charList[j][0] = temp1;
                }
            }
        }
        return charList;
    }

}
