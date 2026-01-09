package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class timus1880 {
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine().trim());
        int[] a1 = new int[n1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n1; i++) {
            a1[i] = Integer.parseInt(st1.nextToken());
        }

        int n2 = Integer.parseInt(br.readLine().trim());
        int[] a2 = new int[n2];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++) {
            a2[i] = Integer.parseInt(st2.nextToken());
        }

        int n3 = Integer.parseInt(br.readLine().trim());
        int[] a3 = new int[n3];
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n3; i++) {
            a3[i] = Integer.parseInt(st3.nextToken());
        }

        int i = 0, j = 0, k = 0;
        int count = 0;

        while (i < n1 && j < n2 && k < n3) {
            int x1 = a1[i];
            int x2 = a2[j];
            int x3 = a3[k];

            if (x1 == x2 && x2 == x3) {
                count++;
                i++;
                j++;
                k++;
            } else {
                if (x1 <= x2 && x1 <= x3) {
                    i++;
                } else if (x2 <= x1 && x2 <= x3) {
                    j++;
                } else {
                    k++;
                }
            }
        }

        System.out.print(count);
    }
}
