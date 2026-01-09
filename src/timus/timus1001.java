package timus;

import java.io.*;
import java.util.*;
import java.math.*;

public class timus1001 {
    static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Long> numbers = new ArrayList<>();

        while (sc.hasNextLong()) {
            numbers.add(sc.nextLong());
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            long x = numbers.get(i);
            double sqrt = Math.sqrt(x);
            System.out.printf("%.4f%n", sqrt);
        }
    }
}



