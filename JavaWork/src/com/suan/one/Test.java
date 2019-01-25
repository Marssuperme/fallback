package com.suan.one;

public class Test {

    private static final int TABLE[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
    private int wordlength;
    private int dictionarySize;

    public Test(int dictionarySize, int wordlength) {
        this.dictionarySize = dictionarySize;
        this.wordlength = wordlength;
    }

    public void initDictionary(){

        String dictionary[] = new String[dictionarySize];
        int intDictionary[] = new int[dictionarySize];

        for (int i = 0; i < dictionarySize; i++) {

            String word = "";

            for (int j = 0; j < wordlength; j++) {
                int intVal = (int)(Math.random() * 26 + 97);
                word = word + (char) intVal;
            }
            dictionary[i] = word;
            intDictionary[i] = convertToInt(word.toCharArray());
            System.out.println(intDictionary[i]);
        }

    }

    private static int convertToInt(char word[]){
        int bit = 1;
        int intWord = 0;
        for (int i = 0; i < word.length; ++ i){
            int m = TABLE[word[i] - 'a'] ;
            if((intWord >> (word[i]) & 0x01) == 0){
                intWord += bit << m;
            }
        }
        return intWord;
    }

    public static void main(String[] args) {

        Test t = new Test(1000,10);
       // t.initDictionary();

        System.out.println(1<<1);
        System.out.println(1<<2);
        System.out.println(1<<3);



    }

}
