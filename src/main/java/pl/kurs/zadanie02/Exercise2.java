package pl.kurs.zadanie02;

public class Exercise2 {
    public static void main(String[] args) {
        int[] arithmeticSequence = {1,2,4,8};
        int[] geometricSequence = {2, 6, 18, 54, 162};
        int[] otherSequence = {1, 2, 4, 5, 16};
        int[] shortSequence = {1, 2};
        int[] zeroDifferenceSequence = {1, 1, 1, 1, 1};
        int[] negativeArithmeticSequence = {-4, -1, 2, 5, 8};
        int[] negativeGeometricSequence = {-2, 6, -18, 54, -162};
        int[] fractionalGeometricSequence = {1, 2, 4, 8, 16, 32};
        int[] alternatingSequence = {1, 3, 0, 4, 1, 5};

        System.out.println(getSequenceName(arithmeticSequence));
        System.out.println(getSequenceName(geometricSequence));
        System.out.println(getSequenceName(otherSequence));
        System.out.println(getSequenceName(shortSequence));
        System.out.println(getSequenceName(zeroDifferenceSequence));
        System.out.println(getSequenceName(negativeArithmeticSequence));
        System.out.println(getSequenceName(negativeGeometricSequence));
        System.out.println(getSequenceName(fractionalGeometricSequence));
        System.out.println(getSequenceName(alternatingSequence));
    }

    public static String getSequenceName(int[] sequence) {
        if (sequence.length > 2) {
            boolean isArithmetic = true;
            boolean isGeometric = true;

            int difference = sequence[1] - sequence[0];
            double ratio = (double) sequence[1] / sequence[0];

            if (difference != 0) {
                for (int i = 2; i < sequence.length; i++) {

                    if (difference != sequence[i] - sequence[i - 1]) {
                        isArithmetic = false;
                    }

                    if (ratio != (double) sequence[i] / sequence[i - 1]) {
                        isGeometric = false;
                    }
                }
            }
            return switch ((isArithmetic ? 1 : 0) + (isGeometric ? 2 : 0)) {
                case 0,3 -> "INNY";
                case 1 -> "ARYTMETYCZNY";
                case 2 -> "GEOMETRYCZNY";

                default ->
                        throw new IllegalStateException("Unexpected value: " + (isArithmetic ? 1 : 0) + (isGeometric ? 2 : 0));
            };

        }
        return "Podany ciąg jest za krótki";
    }
}
