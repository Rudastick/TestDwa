package pl.kurs.zadanie03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(superPrimes(112, 379)));
    }

    public static int[] superPrimes(int from, int to) { // sprawdza od liczby podanej from, do liczby podanej to włacznie z nimi, jeżeli chcemy bez liczenia ich poprostu dodajemy do from +1, a warunek while zmieniamy na (from < to)
        ArrayList<Integer> superPrimesArray = new ArrayList<>();
        while (from <= to) {
            if (isSuperPrime(from)) {
                superPrimesArray.add(from);
            }
            from++;
        }
        return superPrimesArray.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean isSuperPrime(int number) {
        int sum = 0;

        if (number <= 10) { // wymagana suma liczb, więc ignorujemy wszystkie liczby poniżej liczby 11 - która jest pierwszą liczbą która spełnia nasze wymagania.
            return false;
        }

        if (isPrime(number)) {
            while (number >= 1) {
                sum += number % 10;
                number /= 10;
            }
            return isPrime(sum);
        }
        return false;
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
