package com.mycompany.wordscountcallection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileRedar
{
  public static String getFileContent(String filepath) throws FileNotFoundException
  {
      File inputfile=new File(filepath);
      Scanner sc=new Scanner(inputfile);
      
      ArrayList<String> file=new ArrayList();
      String str1= " ";
      while(sc.hasNext())
      {
         str1=str1.concat(sc.next().concat(" "));
          
      }
      return str1;
  }
  
  public static ArrayList<Character> getSymbollist(String symbolfilepath) throws FileNotFoundException
  {
      ArrayList<Character> symbolList=new ArrayList();
      
      File file=new File(symbolfilepath);
      Scanner sc1=new Scanner(file);
      
      while(sc1.hasNextLine())
      {
          symbolList.add(sc1.nextLine().charAt(0));
      }      
      return symbolList;
  }
  
  public static ArrayList<String> getstopwordlist(String filepath) throws FileNotFoundException
  {
      ArrayList<String> stopwordlist=new ArrayList();
      
      File file=new File(filepath);
              
      Scanner sc2=new Scanner(file);
      
      while(sc2.hasNext())
      {
          stopwordlist.add(sc2.next());
      }
      return stopwordlist;
  }


  
  
  
}
