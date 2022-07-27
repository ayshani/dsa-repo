package com.array;

/*
 * 799. Champagne Tower
 *
 * We stack glasses in a pyramid, where the first row has 1 glass,
 * the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup of champagne.
 *
 * Then, some champagne is poured into the first glass at the top.
 * When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately
 * to the left and right of it.  When those glasses become full, any excess champagne will fall equally
 * to the left and right of those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)
 *
 * For example, after one cup of champagne is poured,
 * the top most glass is full.  After two cups of champagne are poured,
 * the two glasses on the second row are half full.  After three cups of champagne are poured,
 * those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured,
 * the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.
 *
 * Now after pouring some non-negative integer cups of champagne,
 * return how full the jth glass in the ith row is (both i and j are 0-indexed.)
 *
 * Example 1:
 * Input: poured = 1, query_row = 1, query_glass = 1
 * Output: 0.00000
 * Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)).
 * There will be no excess liquid so all the glasses under the top glass will remain empty.
 *
 * Logic
 * -----------------
 * Follows a Pascal's triangle logic
 * add total in (0,0)
 * calculate res = max((0,0)-1.0,0)
 * add res/2.0 to (1,1)  (1,2)
 * repeat this process
 *
 * TC : O(query_row*query_glass)
 * SC : O(query_row*query_glass)
 */
public class ChampagneTower {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ChampagneTower obj = new ChampagneTower();
        System.out.println(obj.champagneTower(2,1,1));
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[query_row+1][query_glass+2];

        tower[0][0] = poured;

        for(int i=0;i<query_row;i++){
            for(int j=0;j<=query_glass;j++){
                double res =  Math.max(tower[i][j] - 1.0,0.0);
                tower[i+1][j] += res/2.0;
                tower[i+1][j+1] += res/2.0;
            }
        }

        return Math.min(tower[query_row][query_glass],1.0);
    }

}

