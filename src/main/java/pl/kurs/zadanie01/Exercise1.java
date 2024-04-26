package pl.kurs.zadanie01;

public class Exercise1 {
    public static void main(String[] args) {
        int[] arithmeticSequence = {1, 3, 5, 7, 9};
        int[] negativeArithmeticSequence = {-4, -2, 0, 2, 4};
        int[] negativeDifferenceSequence = {10, 7, 4, 1, -2};
        int[] twoElementSequence = {2, 5};
        int[] emptySequence = {};
        int[] randomSequence = {3, 8, 2, 5, 1};
        int[] repeatedSequence = {1, 1, 1, 1, 1};

        System.out.println(isArithmetic(arithmeticSequence));
        System.out.println(isArithmetic(negativeArithmeticSequence));
        System.out.println(isArithmetic(negativeDifferenceSequence));
        System.out.println(isArithmetic(twoElementSequence));
        System.out.println(isArithmetic(emptySequence));
        System.out.println(isArithmetic(randomSequence));
        System.out.println(isArithmetic(repeatedSequence));
    }

    public static boolean isArithmetic(int[] sequence) {
        if (sequence.length <= 2 || sequence[1] == sequence[0]) {
            return false;
        }

        int difference = sequence[1] - sequence[0];
        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != difference) {
                return false;
            }
        }
        return true;
    }
}

