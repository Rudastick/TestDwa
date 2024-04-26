package pl.kurs.zadanie04;

import java.util.Arrays;

public class SequenceAnalyzerRapport {
    private int[][] data;

    public void setData(int[][] data) {
        this.data = data;
    }

    public void generateRapport() {
        if (data == null || data.length == 0) {
            System.out.println("No data available to generate rapport.");
            return;
        }
        boolean[] monotonic = isMonotonic();
        int[][] minAndMax = findMinAndMax();
        boolean[] hasAllNatural = hasAllNaturalNumbersFromMinToMax();
        int[] mostFrequent = findMostFrequentNumber();

        System.out.println("Analysis Rapport:");
        for (int i = 0; i < data.length; i++) {
            System.out.println("Sequence " + (i + 1) + ":");
            System.out.println("  - Monotonic: " + (monotonic[i] ? "Yes" : "No"));
            System.out.println("  - Min: " + minAndMax[0][i] + ", Max: " + minAndMax[1][i]);
            System.out.println("  - Contains all natural numbers from min to max: " + (hasAllNatural[i] ? "Yes" : "No"));
            if (mostFrequent[i] == 0){
                System.out.println(" - Most frequent Number is 0 or there was no repetition numbers in the Sequence");
            } else {
                System.out.println("  - Most Frequent Number: " + mostFrequent[i]);
            }
        }
    }

    private int[][] findMinAndMax() {
        int[][] minAndMaxNumbers = new int[2][data.length];// - w indexie 0 znajdują sie miny, a  indexie 1 maxy;

        for (int i = 0; i < data.length; i++) {
            Arrays.sort(data[i]);
            minAndMaxNumbers[0][i] = data[i][0];
            minAndMaxNumbers[1][i] = data[i][data[i].length - 1];
        }
        return minAndMaxNumbers;
    }


    private int[] findMostFrequentNumber() {
        int[] mostFrequentNumbers = new int[data.length];
        int maxCount = 1, res = data[0][0];
        int currentCount = 1;

        for (int i = 0; i < data.length; i++) {
            Arrays.sort(data[i]);
            for (int j = 1; j < data[i].length; j++) {
                if (data[i][j] == data[i][j - 1]) {
                    currentCount++;
                } else {
                    currentCount = 1;
                }
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    res = data[i][j - 1];
                    mostFrequentNumbers[i] = res;
                }
            }
        }
        return mostFrequentNumbers;
    }


    private boolean[] hasAllNaturalNumbersFromMinToMax() {
        boolean[] res = new boolean[data.length];
        for (int i = 0; i < data.length; i++) {
            boolean hasAllNaturalNumbers = true;

            Arrays.sort(data[i]);
            for (int j = 1; j < data[i].length; j++) {
                if (data[i][j] - data[i][j - 1] == 1 || data[i][j] - data[i][j - 1] == 0) {
                } else {
                    hasAllNaturalNumbers = false;
                }
                res[i] = hasAllNaturalNumbers;

                if (!hasAllNaturalNumbers) {
                    break;
                }
            }
        }
        return res;
    }

    private boolean[] isMonotonic() {
        boolean[] booleans = new boolean[data.length];
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j++) {
                if (data[i][j - 1] >= data[i][j]) {
                    increasing = false;
                } else if (data[i][j - 1] < data[i][j]) {
                    decreasing = false;
                }
                booleans[i] = increasing || decreasing;

                if (!decreasing && !increasing) {
                    break;
                }
            }
        }
        return booleans;
    }
}
