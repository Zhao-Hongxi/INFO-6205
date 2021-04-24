package Assignment8;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}, {0,1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        if(n < 2)
            return true;
        int count = 0;
        int[][] adj = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        for(int[] p: prerequisites){
            adj[p[1]][p[0]]++;
            inDegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(inDegree[i] == 0)
                q.offer(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            for(int i = 0;i<numCourses;i++){
                if(adj[cur][i]!=0){
                    inDegree[i]--;
                    if(inDegree[i] == 0)
                        q.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}
