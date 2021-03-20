class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n-2&& nums[i]<=0; i++){
            int lo = i+1;
            int hi = n-1;
            int target = -nums[i];
            while(lo<hi){
                if(nums[lo]+nums[hi] == target){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(-target);
                    cur.add(nums[lo]);
                    cur.add(nums[hi]);
                    if(!res.contains(cur))
                        res.add(cur);
                    lo++;
                    hi--;
                }else if(nums[lo]+nums[hi]>target)
                    hi--;
                else
                    lo++;
            }
        }
        return res;
    }
}