package com.matrix;

import java.util.Arrays;

/*
661. Image Smoother

An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the
average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother).
If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e.,
the average of the four cells in the red smoother).
Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the
smoother on each cell of it.

Example 1:
Input: img = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[0,0,0],[0,0,0],[0,0,0]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0

TC : o(m*n)
SC: o(m*n)
 */
public class ImageSmoother {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new ImageSmoother().imageSmoother(
                new int[][]{
                        {1,1,1},{1,0,1},{1,1,1}
                }
        )));
    }
    public int[][] imageSmoother(int[][] img) {
        // Save the dimensions of the image.
        int m = img.length;
        int n = img[0].length;

        // Create a new image of the same dimension as the input image.
        int[][] smoothImg = new int[m][n];

        // Iterate over the cells of the image.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize the sum and count
                int sum = 0;
                int count = 0;

                // Iterate over all plausible nine indices.
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        // If the indices form valid neighbor
                        if (0 <= x && x < m && 0 <= y && y < n) {
                            sum += img[x][y];
                            count += 1;
                        }
                    }
                }

                // Store the rounded down value in smoothImg[i][j].
                smoothImg[i][j] = sum / count;
            }
        }

        // Return the smooth image.
        return smoothImg;
    }
}
