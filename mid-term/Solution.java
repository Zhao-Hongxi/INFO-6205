package midterm;


import java.util.HashSet;
import java.util.Set;

public class Solution {
//    time complexity: O(N+M)
//    space complexity: O(N)
    public boolean areConverging(ListNode n1, ListNode n2){
        Set<ListNode> set = new HashSet<>();
        while(n1!=null){
            set.add(n1);
            n1 = n1.next;
        }
        while (n2!=null){
            if (set.contains(n2))
                return true;
            n2 = n2.next;
        }
        return false;
    }
//    time complexity: O(N)
//    space complexity: O(log(n))
    public void printPerimeter(TreeNode root){
        if (root == null)
            return;
        System.out.println(root.val);
        printRight(root.right);
        printLeaves(root.right);
        printLeaves(root.left);
        printLeft(root.left);
    }
    void printRight(TreeNode root){
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        System.out.println(root.val);
        if (root.right != null)
            printRight(root.right);
        else
            printRight(root.left);
    }
    void printLeaves(TreeNode root){
        if(root == null)
            return;
        if (root.left == null && root.right == null){
            System.out.println(root.val);
            return;
        }
        printLeaves(root.right);
        printLeaves(root.left);
    }
    void printLeft(TreeNode root){
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        if (root.left != null)
            printLeft(root.left);
        else
            printLeft(root.right);
        System.out.println(root.val);
    }
//      time complexity: O(n)
//      space complexity: O(1)
    public int getMaxConsecutiveOnes(int[] nums){
        if (nums.length == 0)
            return 0;
        int count = 0;
        int res = 0;
        for (int i: nums){
            if (i == 1)
                count++;
            else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        res = Math.max(res, count);
        return res;
    }
//    time complexity: O(log(n))
//    space complexity: O(1);
    public int getIndex(int[] nums, int x){
        if (nums.length == 0)
            return -1;
        int lo = 0, hi = nums.length-1;
        while (lo < hi){
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == x){
                if (mid == lo || nums[mid-1] != x)
                    return mid;
                hi = mid;
            }
            else if (nums[mid] > x){
                hi = mid;
            }else
                lo = mid+1;
        }
        return -1;
    }

}
