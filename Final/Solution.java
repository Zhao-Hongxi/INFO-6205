package Final;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        testQ1();
        fibTest(15);
    }
    static public int fib(int n){
//        Time & Space complexity: O(n)
        if (n<0)
            return -1;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    static void fibTest(int n){
        for (int i = 0; i <= n; i++){
            System.out.println("F(" + i + "): " + fib(i));
        }
    }
    static public String getResult(char[][] body, int maxTime){
//        Time & Space complexity: O(n*m)
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int n = body.length;
        int m = body[0].length;
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        int step = 0;
        while (!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] cur = q.poll();
                if (cur[0] == n-1 && cur[1] == m-1){
                    return "can infect";
                }
                for (int[] d: dir){
                    int nextx = cur[0] + d[0];
                    int nexty = cur[1] + d[1];
                    if (nextx >= 0 && nextx < n && nexty >=0 && nexty < m && !visited[nextx][nexty] && body[nextx][nexty] == '0'){
                        q.add(new int[]{nextx, nexty});
                        visited[nextx][nexty] = true;
                    }
                }
            }
            step++;
            if (step > maxTime)
                return "cannot infect";
        }
        return "cannot infect";
    }
    static void testQ1(){
        char[][] testcase1 = {
                {'0','0','X','0'},
                {'X','0','X','X'},
                {'X','0','0','0'}
        };
        System.out.println(getResult(testcase1, 5));
//        when maxTime = 4
        System.out.println(getResult(testcase1, 4));
        char[][] testcase2 = {
                {'0', 'X'},
                {'X', '0'}
        };
        System.out.println(getResult(testcase2, 2));

        char[][] testcase3 = {
                {'0','0'},
                {'0','0'}
        };
        System.out.println(getResult(testcase3, 3));
    }
}
