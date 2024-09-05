package P0874;

// This is not optimal because of String hashing if use a Pair class for obstacles it would be faster.
import java.util.*;   
class Solution {
    
    public int robotSim(int[] commands, int[][] obstacles) {
        int maxDist = 0, directionIndex = 0,x =0, y = 0;
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        Set<String> obstaclesSet = new HashSet<>();
        for(int[] obstacle:obstacles){
            obstaclesSet.add(String.valueOf(obstacle[0]) + "," + String.valueOf(obstacle[1]));
        }
        for(int cmd: commands) {
            if (cmd == -2) directionIndex = (directionIndex + 3) % 4;
            else if (cmd == -1) directionIndex = (directionIndex +1) % 4;
            else {
                while(cmd != 0) {
                    int newX = x+direction[directionIndex][0];
                    int newY = y+direction[directionIndex][1];
                    if(obstaclesSet.contains(String.valueOf(newX) + "," + String.valueOf(newY))) break;
                    x = newX;
                    y = newY;
                    maxDist = Math.max(maxDist,x*x+y*y);
                    cmd--;
                }
            }
        } 
        return maxDist;
    }
}
