package midterm;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    static Solution s;
    public static void main(String[] args) {
        s = new Solution();
        test1();
        test2();
        test3();
        test4();
    }
    static void test1(){
        ListNode n1 = new ListNode();
        ListNode n2 = new ListNode();
        ListNode p = n1;
        ListNode convergingPoint = new ListNode();
        for (int i = 0; i < 5; i++){
            p.next = new ListNode(i);
            if (i == 2)
                convergingPoint = p;
            p = p.next;
        }
        p = n2;
        for (int i = 3; i > 0; i--){
            p.next = new ListNode(i);
            p = p.next;
        }
        System.out.println("Test result for Q1 (when not converging):");
        System.out.println(s.areConverging(n1, n2));

        p.next = convergingPoint; // make two linked list converge.

        System.out.println("Test result for Q1 (when converging):");
        System.out.println(s.areConverging(n1, n2));
    }
    static void test2(){
//        build tree
//                          1
//                       /      \
//                      2         3
//                    /  \      /   \
//                   4    5    6     7
//                  / \  / \    \   /
//                 8  9 10 11   13 14
        TreeNode root = new TreeNode(1);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if (cur.val == 6)
                cur.right = new TreeNode(13);
            else if (cur.val == 7)
                cur.left = new TreeNode(14);
            else {
                cur.left = new TreeNode(cur.val * 2);
                cur.right = new TreeNode(cur.val * 2 + 1);
                if (cur.val < 4){
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }
        }
        System.out.println("Test result for Q2:");
        s.printPerimeter(root);
    }
    static void test3(){
        int[][] testcase = {{0,1,0,1,1,0,1,1,1,0,0,0}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 0},{1,1,1,0,0,1,1,1,1,0,1,1,1,1,1}};
        System.out.println("Test results for Q3:");
        for (int i = 0; i < testcase.length; i++){
            System.out.println("Test case " + (i+1) + " : " + Arrays.toString(testcase[i]));
            System.out.println("Result :" + s.getMaxConsecutiveOnes(testcase[i]));
        }
    }
    static void test4(){
        int[] testcase = {2,4,4,4,6,7,7,7,8,9,9,9};
        System.out.println("Test results for Q4:");
        System.out.println("Input :" + Arrays.toString(testcase));
        System.out.println("When x = 7, Index: " + s.getIndex(testcase, 7));
        System.out.println("When x = 4, Index: " + s.getIndex(testcase, 4));
        System.out.println("When x = 9, Index: " + s.getIndex(testcase, 9));
        System.out.println("When x = 8, Index: " + s.getIndex(testcase, 8));
        System.out.println("When x = 1, Index: " + s.getIndex(testcase, 1));
    }
}
