class Solution {
    public int uniquePathsIII(int[][] grid) {
        int stx=0,sty=0,emptysq=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    stx=i;
                    sty=j;
                }
                else if(grid[i][j]==0){
                    emptysq++;
                }
            }
        }
        return dfs(grid,stx,sty,emptysq+1);
    }
    private int dfs(int[][] grid,int r,int c,int remain){
        if(r<0||r>=grid.length||c<0||c>=grid[0].length||grid[r][c]==-1){
            return 0;
        }
        if(grid[r][c]==2){
            return remain==0?1:0;
        }
        int t=grid[r][c];
        grid[r][c]=-1;
        int paths=dfs(grid,r+1,c,remain-1)+dfs(grid,r-1,c,remain-1)+dfs(grid,r,c+1,remain-1)+dfs(grid,r,c-1,remain-1);
        grid[r][c]=t;
        return paths;
    }
}