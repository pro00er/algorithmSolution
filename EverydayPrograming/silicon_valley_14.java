package com.pro.problem.solver.everydayprograming;

import org.junit.Test;
import static org.junit.Assert.*;

public class PrevCount {
       
       private int solution(String[] words) {
              int minlengthIdx = getMinLengthWordIdx(words);
              int minlength = words[minlengthIdx].length();
              
              char[][] asciis = convertWords(words, minlength);
              return samePrivLength(asciis, minlength);
       }
	   
       private int samePrivLength(char[][] asciis, int minlength) {
              int wordcount = asciis.length;
              
              for (int charIdx = 0; charIdx < minlength; charIdx++) {
                     int pivotAcsii = asciis[0][charIdx];
                     
                     for (int wordIdx = 1; wordIdx < wordcount; wordIdx++) {
                           if( pivotAcsii != asciis[wordIdx][charIdx] )
                                  return charIdx-1;
                     }
              }
              
              return minlength;
       }
	   
       private char[][] convertWords(String[] words, int minWordLength) {
              char[][] asciis = new char[words.length][minWordLength];
              
              for (int idx = 0; idx < words.length ; idx++)
                     asciis[idx] = words[idx].substring(0, minWordLength).toCharArray();
              
              return asciis;
       }
	   
       private int getMinLengthWordIdx(String[] words) {
              int minLength = 0;
              
              for (int idx = 1; idx < words.length ; idx++) {
                     if(words[minLength].length() > words[idx].length())
                           minLength = idx;
              }
              
              return minLength;
       }
	   
       @Test
       public void test() {
              assertEquals(2, solution(new String[]{"apple", "apps", "apply"}));
              assertEquals(3, solution(new String[]{"dogs", "dog", "dogx"}));
       }
}