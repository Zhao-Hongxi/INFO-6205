package Assignment8;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
    }
    static int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i<grid.length;i++)
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    res ++;
                    dfs(grid,i,j);
                }
            }
        return res;
    }
    static void dfs(char[][] grid, int x, int y){
        if(x<0 || x>= grid.length || y<0 || y>=grid[0].length)
            return;
        if(grid[x][y] == '0') return;
        if(grid[x][y] == '1'){
            grid[x][y] = '0';
            dfs(grid,x+1,y);
            dfs(grid,x-1,y);
            dfs(grid,x,y-1);
            dfs(grid,x,y+1);
        }
    }
}
