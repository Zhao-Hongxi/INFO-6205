class Solution {        
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs("", 0,n*2);
        return res;
    }
    public void dfs(String cur, int left, int n){
        if(cur.length() == n){
            if(left == 0)
                res.add(cur);
            return;
        }
        dfs(cur+"(", left+1,n);
        if(left>0)
            dfs(cur+")", left-1,n);
        return;
    }
}