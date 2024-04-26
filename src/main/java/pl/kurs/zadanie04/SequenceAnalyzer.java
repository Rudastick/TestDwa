package pl.kurs.zadanie04;

import java.io.*;
import java.util.*;

public class SequenceAnalyzer {
    public static void main(String[] args) {
        String fileName = "liczby.txt"; // lub podaj ścieżke - można teżby było zrobić tu objekt scannera i podstawic filename pod String ze scannera.
        File file = new File(fileName);

        int[][] data = readFromFileToArray(fileName);

        if(data != null){
            SequenceAnalyzerRapport rapport = new SequenceAnalyzerRapport();
            rapport.setData(data);
            rapport.generateRapport();
        }

    }

    public static int[][] readFromFileToArray(String fileNameWithPath) {

        try (FileReader fileReader = new FileReader(fileNameWithPath); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            ArrayList<String> numbersAsString = new ArrayList();

            String line = bufferedReader.readLine();

            while (line != null) {
                numbersAsString.add(line);
                line = bufferedReader.readLine();
            }
            String[] array = numbersAsString.toArray(new String[0]);

            return organiseArray(array);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private static int[][] organiseArray(String[] numbersAsString) {
        ArrayList<int[]> intArrayList = new ArrayList<>();

        for (String str : numbersAsString) {

            String[] parts = str.split("\\s+");
            int[] integers = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                integers[i] = Integer.parseInt(parts[i]);
            }
            intArrayList.add(integers);
        }

        return intArrayList.toArray(new int[0][]);
    }


}
