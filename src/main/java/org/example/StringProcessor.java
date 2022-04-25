package org.example;

public class StringProcessor {

    public static String firstTask(String string, int N) {
        String res = "";
        if (N < 0) throw new IllegalArgumentException("N не может быть отриц");
        while (N > 0) {
            N--;
            res = res + string;
        }
        return res;
    }

    public static int secondTask(String s1, String s2) {
        int quantity = 0;
        if (s2 == null || s2.length() == 0) throw new IllegalArgumentException("Недопустимое значение второй строки");
        for (int i = 0; i <= (s1.length() - s2.length()); i++) {
            String sub_s = s1.substring(i, i + s2.length());
            if (sub_s.equals(s2)) {
                quantity++;
            }
        }
        return quantity;
    }

    public static String thirdTask(String s1) {
        String res = "";
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1') {
                res += "один";
                continue;
            }
            if (s1.charAt(i) == '2') {
                res += "два";
                continue;
            }
            if (s1.charAt(i) == '3') {
                res += "три";
                continue;
            } else {
                res += s1.charAt(i);
            }
        }
        return res;
    }

    public static StringBuilder fourthTask(StringBuilder s) {
        if(s== null || s.length() <2 ) return s;
        int size = s.length();
        for(int i = 1;i<size;i++ ) {
            if(i>=s.length()) return s;
            s.deleteCharAt(i);
        }
        return s;
    }

}
