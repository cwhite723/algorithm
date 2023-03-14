class Solution {
    public int[] solution(String[] wallpaper) {
        int xMin = 51;
        int yMin = 51;
        int xMax = -1;
        int yMax = -1;

        for(int k=0; k< wallpaper.length; k++) {
            for(int i=0; i<wallpaper[k].length(); i++) {
                if(wallpaper[k].charAt(i)=='#') {
                    if(k<xMin) xMin = k;
                    if(k>xMax) xMax = k;
                    if(i<yMin) yMin = i;
                    if(i>yMax) yMax = i;
                }
            }
        }
        
        int[] answer = new int[]{xMin,yMin,xMax+1,yMax+1};
        return answer;
    }
}