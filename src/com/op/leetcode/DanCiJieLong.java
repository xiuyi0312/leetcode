package com.op.leetcode;

import java.util.*;

public class DanCiJieLong {
    public static void main(String[] args) {
        DanCiJieLong danCiJieLong = new DanCiJieLong();
        List<String> wordList = Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog"
        );
        long time1 = System.currentTimeMillis();
        System.out.println(danCiJieLong.ladderLength("hit", "dog", wordList));
        System.out.println("cost = " + (System.currentTimeMillis() - time1));

    }

    /**
     * width-first traverse
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> queue = new ArrayList<>();
        queue.add(beginWord);
        queue.add("");
        Set<String> wordSet = new HashSet<>(wordList);
        int length = 1;
        // hit "1" hot "2" dot lot "3" dog log "4" cog "5"
        // hit hot dot dog cog
        while (!queue.isEmpty()) {
            boolean added = false;
            do {
                String a = queue.remove(0);
                if (a.equals("")) {
                    length++;
                    break;
                }
                wordSet.remove(a);
                if (distance(a, endWord) == 0) {
                    return length;
                }
                for (int i = 0; i < a.length(); i++) {
                    char[] b = a.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        b[i] = c;
                        String newB = new String(b);
                        if(wordSet.contains(newB)) {
                            queue.add(newB);
                            added = true;
                        }
                    }
                }
//                for (String s : wordSet) {
//                    if (distance(a, s) == 1) {
//                        queue.add(s);
//                        added = true;
//                    }
//                }
            } while (!queue.isEmpty());
            if (added) {
                queue.add("");
            }
        }
        return 0;
    }

    private int distance(String a, String b) {
        if (a.equals(b)) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        if (count == 1) {
            return 1;
        } else {
            return -1;
        }
    }
}
