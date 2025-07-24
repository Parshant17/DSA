class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currentColor = image[sr][sc];
        if(currentColor == color){
            return image;
        }
        dfs(image, sr, sc, color, currentColor);
        return image;
    }
    void dfs(int[][] image, int sr, int sc, int newColor, int orgColor){
        if(sr<0 || sr>= image.length || sc<0 || sc>=image[0].length || image[sr][sc] != orgColor){
            return;
        }
        image[sr][sc]= newColor;
        dfs(image, sr + 1, sc, newColor, orgColor);
        dfs(image, sr - 1, sc, newColor, orgColor);
        dfs(image, sr, sc+1, newColor, orgColor);
        dfs(image, sr, sc-1, newColor, orgColor);
    }
}