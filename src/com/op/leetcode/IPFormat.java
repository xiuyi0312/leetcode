package com.op.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IPFormat {
    public static void main(String[] args) {
        String input = "010010";
        IPFormat ipFormat = new IPFormat();
        System.out.println(ipFormat.restoreIpAddresses(input));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (s.length() <= i)
                continue;
            String part4 = s.substring(s.length() - i);
            if(!valid(part4))
                continue;
            int value4 = Integer.parseInt(part4);
            String remain3 = s.substring(0, s.length() - part4.length());
            for (int j = 1; j <= 3; j++) {
                if (remain3.length() <= j)
                    continue;
                String part3 = remain3.substring(remain3.length() - j);
                if (!valid(part3))
                    continue;
                int value3 = Integer.parseInt(part3);
                String remain2 = remain3.substring(0, remain3.length() - part3.length());
                for (int k = 1; k <= 3; k++) {
                    if (remain2.length() <= k)
                        continue;
                    String part2 = remain2.substring(remain2.length() - k);
                    if (!valid(part2))
                        continue;
                    int value2 = Integer.parseInt(part2);
                    String part1 = remain2.substring(0, remain2.length() - part2.length());
                    if (part1.length() > 3 || part1.length() < 1 || !valid(part1)) {
                        continue;
                    }
                    int value1 = Integer.parseInt(part1);
                    result.add(value1 + "." + value2 + "." + value3 + "." + value4);
//                        System.out.println(value1 + "." + value2 + "." + value3 + "." + value4);
                }
            }
        }
        return result;
    }

    private boolean valid(String value) {
        if (value.length() > 1 && value.startsWith("0")) {
            return false;
        }
        int v = Integer.parseInt(value);
        return v <= 255 && v >= 0;
    }
}
