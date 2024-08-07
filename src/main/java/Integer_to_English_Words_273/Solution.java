package main.java.Integer_to_English_Words_273;


/*
 * @author: Abdulhay
 * @project: leetCode
 * @date: 07.08.2024 - 12:29 PM
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(numberToWords(1_000_000));
    }

    static String[] a = new String[]{"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
    static String[] b = new String[]{"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
    static String[] c = new String[]{"", " One Hundred", " Two Hundred", " Three Hundred", " Four Hundred", " Five Hundred", " Six Hundred", " Seven Hundred", " Eight Hundred", " Nine Hundred"};
    static String[] f = new String[]{" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};

    static String[] d = new String[]{"", " Thousand", " Million", " Billion", " Trillion", " Quadrillion", " Quintillion", " Sextillion", " Septillion"};

    static String[][] numbers = new String[][]{a, b, c};


    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        return process(num, 0).trim();
    }

    private static String process(int num, int trio) {
        if (num == 0) return "";
        StringBuilder res = new StringBuilder();

        int tail = num % 1000;
        num = num / 1000;


        int count = 0;
        int r = tail % 100;
        if (r <= 19 && r >= 10) {
            int w = r % 10;
            res.insert(0, f[w]);
            res.insert(0, c[tail / 100]);
        } else {
            do {
                int n = tail % 10;
                tail = tail / 10;
                res.insert(0, numbers[count++][n]);
            } while (tail > 0);
        }
        if (!res.isEmpty()) {
            res.append(d[trio]);
        }

        return res.insert(0, process(num, trio + 1)).toString();

    }


}
