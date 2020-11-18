package com.op.leetcode;

public class CheapestFlightWithinKStops {
    public static void main(String[] args) {
        CheapestFlightWithinKStops cheapestFlightWithinKStops = new CheapestFlightWithinKStops();
//        int[][] edges = {
//                {0, 1, 100},
//                {1, 2, 100},
//                {0, 2, 500}
//        };
        int[][] edges = {
                {0, 1, 1},
                {0, 2, 5},
                {1, 2, 1},
                {2, 3 ,1}
        };
        // [[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
        int n = 4;
        int src = 0;
        int dst = 3;
        int k = 1;//1;
        System.out.println(cheapestFlightWithinKStops.findCheapestPrice(n, edges, src, dst, k));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] values = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                values[j][k] = Integer.MAX_VALUE / 2;
            }
        }
        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            int value = flight[2];
            values[start][end] = value;
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(values[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println("===============================");

        for (int c = 1; c <= K; c++) {//中转数
            // 必须复制一份上一个当前中转数量的结果，然后计算当前中转数量的结果，否则会导致一些先计算出来的当前中转数据的结果用于
            // 后计算出来的当前中转数据的结果，导致实际上的中转数量超过当前中转数量
            int[][] copy = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    copy[j][k] = values[j][k];
                }
            }

            for (int[] flight : flights) {
                int start = flight[0];
                int end = flight[1];
                int value = flight[2];

                for (int j = 0; j < n; j++) {
//                    System.out.print(j + " , " + end + ": " + values[j][end] + " ==>");
                    values[j][end] = Math.min(values[j][end], copy[j][start] + value);
//                    System.out.println(values[j][end]);
                }
            }

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(values[i][j] + "\t");
//                }
//                System.out.println();
//            }
//            System.out.println("===============================");
        }
        if (values[src][dst] >= Integer.MAX_VALUE / 2) {
            return -1;
        }
        return values[src][dst];
    }


//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//        int[] dpP = new int[n];
//        for (int i = 0; i < n; i++) {
//            dpP[i] = Integer.MAX_VALUE / 2;
//        }
//        // 表示从src -> dst的价值
//        dpP[src] = 0;
//        for (int i = 0; i <= K; i++) {
//            int[] dpT = dpP.clone();   // 记得每次需要用上次的数据因为如果继续用本次的数据会形成环
//            for (int[] flight : flights) {
//                int srcN = flight[0];
//                int dstN = flight[1];
//                int value = flight[2];
//                dpP[dstN] = Math.min(dpP[dstN], dpT[srcN] + value);
//            }
//        }
//        return dpP[dst] == Integer.MAX_VALUE / 2 ? -1 : dpP[dst];
//    }
}
