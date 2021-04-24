package Assignment8;

import java.util.*;

public class FindShortestPath {
    public static void main(String[] args) {
//        build graph
        int[][] graph = new int[5][5];
        for (int i = 0; i < graph.length; i++){
            for (int j = 0; j< graph.length; j++){
                if (i == j){
                    graph[i][j] = 0;
                }else
                    graph[i][j] = Integer.MAX_VALUE;
            }
        }
        graph[0][1] = 15;
        graph[0][2] = 30;
        graph[0][4] = 95;
        graph[1][0] = 10;
        graph[1][2] = 10;
        graph[1][3] = 20;
        graph[2][4] = 50;
        graph[3][4] = 20;
        graph[2][3] = 15;

        int[][] graph2 = new int[9][9];
        for (int i = 0; i < graph2.length; i++){
            for (int j = 0; j< graph2.length; j++){
                if (i == j){
                    graph2[i][j] = 0;
                }else
                    graph2[i][j] = Integer.MAX_VALUE;
            }
        }
        graph2[0][1] = 4; graph2[1][0] = 4;
        graph2[0][7] = 8; graph2[7][0] = 8;
        graph2[1][7] = 11; graph2[7][1] = 11;
        graph2[1][2] = 8; graph2[2][1] = 8;
        graph2[2][3] = 7; graph2[3][2] = 7;
        graph2[3][4] = 9; graph2[4][3] = 9;
        graph2[3][5] = 14; graph2[5][3] = 14;
        graph2[4][5] = 10; graph2[5][4] = 10;
        graph2[2][5] = 4; graph2[5][2] = 4;
        graph2[2][8] = 2; graph2[8][2] = 2;
        graph2[5][6] = 2; graph2[6][5] = 2;
        graph2[6][8] = 6; graph2[8][6] = 6;
        graph2[7][8] = 7; graph2[8][7] = 7;
        graph2[6][7] = 1; graph2[7][6] = 1;

        findShortestPath(graph, 0);
        System.out.println("-------------");
        findShortestPath(graph2, 0);
    }
    static void findShortestPath(int[][] graph, int src){
        Map<Integer, List<Integer>> path = new HashMap<>();
        int n = graph.length;
        int[] dist = new int[n];
        List<Integer> found = new ArrayList<>();
        found.add(src);
        path.put(src, found);
        for (int i = 0; i<n; i++){
            dist[i] = graph[src][i];
            List<Integer> l = new ArrayList<>();
            l.add(src);
            l.add(i);
            path.put(i, l);
        }
        while (found.size()<n){
            int curMin = Integer.MAX_VALUE;
            int nextSrc = -1;
            for (int i = 0; i < n; i++){
                if (!found.contains(i)){
                    if (graph[src][i] != Integer.MAX_VALUE && dist[src] + graph[src][i] < dist[i]){
                        dist[i] = dist[src] + graph[src][i];
                        List<Integer> l = new ArrayList<>(path.get(src));
                        l.add(i);
                        path.put(i, l);
                    }
                    if (dist[i] < curMin){
                        curMin = dist[i];
                        nextSrc = i;
                    }
                }
            }
            found.add(nextSrc);
            System.out.println("Path to " + nextSrc + ": "+ path.get(nextSrc).toString() + " dist: " + dist[nextSrc]);
            src = nextSrc;
        }
    }
}
