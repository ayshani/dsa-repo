package com.dp;
/*
546. Remove Boxes

You are given several boxes with different colors represented by different positive numbers.

You may experience several rounds to remove boxes until there is no box left.
Each time you can choose some continuous boxes with the same color (i.e., composed of k boxes, k >= 1),
remove them and get k * k points.

Return the maximum points you can get.



Example 1:

Input: boxes = [1,3,2,2,2,3,4,3,1]
Output: 23
Explanation:
[1, 3, 2, 2, 2, 3, 4, 3, 1]
----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
----> [1, 3, 3, 3, 1] (1*1=1 points)
----> [1, 1] (3*3=9 points)
----> [] (2*2=4 points)

TC : o(n^4)
SC: o(n^3)
 */
public class RemoveBoxes {

    int dp[][][];

    public static void main(String[] args) {
        int[] boxes = new int[]{1,3,2,2,2,3,4,3,1};
        System.out.println(new RemoveBoxes().removeBoxes(boxes));
    }

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp = new int[n+1][n+1][n+1];
        return util(boxes, 0,  n-1,0);
    }

    private int util(int[] boxes, int l, int r, int count){
        // if low is greater, then return 0
        if(l>r)
            return 0;
        // if adjacent elements are same, then we count the occurence and increment index also
        while(l+1<r && boxes[l]== boxes[l+1]){
            l++;
            count++;
        }

        // incase, we have already computed, we just return the value
        if(dp[l][r][count]>0)
            return dp[l][r][count];

        // till this point, we get total ans as count+1^2 and also,
        // we need to consider the rest of the array through recursion from next index i.e. l+1
        int ans = (count+1)*(count+1) + util(boxes,l+1,r,0);

        // also another way we can choose is to choose the inner elements first then the outer
        // similar elements can be combined to get even
        // larger value
        for(int m=l+1;m<=r;m++){

            // we traverse from m (l has moved from 0 to just before the beginning of different elements) and
            // keep searching for same value as in l.
            //after that the middle elements (between l+1 and m-1) are sent to differnt partition and
            // from m to r(ending) we send the updated streak
            if(boxes[m]==boxes[l])
                ans = Math.max(ans, util(boxes,m,r,count+1) + util(boxes,l+1, m-1,0));
        }
        // finally assign nd return
        return dp[l][r][count] = ans;
    }
}
