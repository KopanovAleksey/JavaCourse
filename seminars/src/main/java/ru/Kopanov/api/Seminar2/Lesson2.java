package ru.Kopanov.api.Seminar2;

import ru.Kopanov.api.Homework1.Homework1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class Lesson2 {
    public static void main(String[] args){
        try
        {
            File logfile = new File("log.txt");
            FileWriter fileWriter = new FileWriter(logfile, true);
            for (int i = 0; i < 5; i++) {
                fileWriter.write("Hello" + i + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
            Homework1.simple_calculator();
        }
        catch (IOException ex) {

        }



//        task1();
//        System.out.println(task2());
    }

    public static void task1() {
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());

        String buf = "";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 30000; i++) {
            buf += UUID.randomUUID();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Операция выполнена за " + (endTime-startTime) + "мс");
    }
    public static String task2(){
        String inputStr = "jfhaKDSJF123HarehgfgjnAKJsdffhgrtsgdfgsFDHAFADSKJS.DSAFgfadfgF";
        int[] statistic = new int[26];
        int cA = 'a';
        char c;
        int code;
        for (int i = 0; i < inputStr.length(); i++) {
            c = inputStr.charAt(i);
            code = c;
            if (c >= 'a' && c<='z'){
                statistic[code - cA]++;
            }
        }
        System.out.println("Итог:");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < statistic.length; i++) {
           if (statistic[i] > 0){
            char cc = (char)(i + cA);
            stringBuilder
                    .append(cc)
                    .append(statistic[i])
                    .append('\n');

           }
        }
        return stringBuilder.toString();
    }
}
