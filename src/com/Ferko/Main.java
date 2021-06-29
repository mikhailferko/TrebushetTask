package com.Ferko;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        BufferedReader buf = new BufferedReader(reader);
        Set <String> names = new HashSet<>();
        int count = 0;
        String result = "";
        while (buf.ready()) {
            String str = buf.readLine().trim();
            if (str.startsWith("<modification name=")){
                String [] strings = str.split("\"");
                String [] stroki = strings[1].split(" ");
                int number = 0;
                for (int i = 0; i < stroki.length; i ++) {
                    if (stroki[i].startsWith("(")){
                        number = i;
                    }
                }
                for (int i = number - 2; i < stroki.length; i ++) {
                    result += stroki[i] + " ";
                }
                names.add(result);
                count++;
                result = "";
            }
        }
        System.out.println(names.size());
    }
}
