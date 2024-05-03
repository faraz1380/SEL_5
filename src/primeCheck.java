import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class primeCheck {

    public static void main(String[] args) throws IOException {
        List<Integer> largeNumbers = Arrays.asList(
                1153723573, 1147563439, 1153723581, 1455723547, 1023456789,
                1153723577, 1153723549, 1136723573, 1153723599, 1234567891,
                1299600121, 1330500443, 1047290001, 1030500067, 1539768569,
                1147107897, 1050300053, 1000000007, 1000000009, 1000000021,
                1000000033, 1000000087, 1000000093, 1000000097, 1000000103,
                1000000123, 1000000181, 1000000207, 1000000223, 1000000241,
                1000000271, 1000000289, 1000000297, 1000000321, 1000000349,
                1000000363, 1000000403, 1000000409, 1000000411, 1000000427,
                1000000433, 1000000439, 1000000447, 1000000453, 1000000459,
                1000000483, 1000000513, 1000000531, 1000000573, 1000000591
        );

        for (int number : largeNumbers) {
//            if (isPrimeInefficient(number)) {
//                System.out.println(number + " is prime (Inefficient).");
//            } else {
//                System.out.println(number + " is not prime (Inefficient).");
//            }

            if (isPrimeOptimized(number)) {
                System.out.println(number + " is prime (Optimized).");
            } else {
                System.out.println(number + " is not prime (Optimized).");
            }
        }
    }

    public static boolean isPrimeInefficient(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeOptimized(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
