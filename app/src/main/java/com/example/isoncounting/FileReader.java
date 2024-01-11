package com.example.isoncounting;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class FileReader {
    // Variable Declaration
    private String filePath;
    private ArrayList<String> words;
    private Context mContext;
    private InputStream is = null;

    public InputStream getIs() {
        return is;
    }
    /**
     * turns filePath into an ArrayList of each .next()
     * @return ArrayList of Strings
     */
    private ArrayList<String> separateText() {
        ArrayList<String> wordsT = new ArrayList<>();
//        TestFileReader tfr = new TestFileReader(MainActivity.tContext, filePath);

        mContext = MainActivity.tContext;
        MainActivity.doesFileExist = true;
        try {
            String[] files = mContext.getAssets().list("");
            for (String file : files) {
                System.out.println(file);
            }
            is = mContext.getAssets().open(filePath);
            System.out.println(is.read());
        } catch (IOException e) {
            System.out.println("oh no");
            MainActivity.doesFileExist = false;
        }


        Scanner s = new Scanner(getIs());
        while (s.hasNext()) {
            String str = s.next();
            wordsT.add(str);
        }
        return wordsT;
    }
    public FileReader(String filePath) {
        this.filePath = filePath;
        words = separateText();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> getWords() {
        return words;
    }
}
