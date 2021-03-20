class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i: asteroids){
            if(i>0){
                stack.push(i);
            }else{
                if(stack.isEmpty()||stack.peek()<0)
                    stack.push(i);
                else{
                    while(true){
                        if(stack.isEmpty()){
                            stack.push(i);
                            break;
                        }
                        if(stack.peek()<0){
                            stack.push(i);
                            break;
                        }
                        if(stack.peek() == -i){
                            stack.pop();
                            break;
                        }
                        if(stack.peek()>-i)
                            break;
                        if(stack.peek()<-i){
                            stack.pop();
                        }
                    }
                }
            }
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i<stack.size();i++)
            res[i] = stack.get(i);
        return res;
    }
}