package com.tree;
/*
427. Construct Quad Tree

Given a n * n matrix grid of 0's and 1's only. We want to represent the grid with a Quad-Tree.

Return the root of the Quad-Tree representing the grid.

Notice that you can assign the value of a node to True or False when isLeaf is False, and both are accepted in the
answer.

A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides,
each node has two attributes:

val: True if the node represents a grid of 1's or False if the node represents a grid of 0's.
isLeaf: True if the node is leaf node on the tree or False if the node has the four children.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
}
We can construct a Quad-Tree from a two-dimensional area using the following steps:

If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of
the grid and set the four children to Null and stop.
If the current grid has different values, set isLeaf to False and set val to any value and divide the current
grid into four sub-grids as shown in the photo.
Recurse for each of the children with the proper sub-grid.

If you want to know more about the Quad-Tree, you can refer to the wiki.

Quad-Tree format:

The output represents the serialized format of a Quad-Tree using level order traversal, where null signifies
a path terminator where no node exists below.

It is very similar to the serialization of the binary tree. The only difference is that the node is represented
as a list [isLeaf, val].

If the value of isLeaf or val is True we represent it as 1 in the list [isLeaf, val] and if the value of isLeaf
or val is False we represent it as 0.

Example 1:


Input: grid = [[0,1],[1,0]]
Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]
Explanation: The explanation of this example is shown below:
Notice that 0 represnts False and 1 represents True in the photo representing the Quad-Tree.

Intuition
The intuition behind this solution is to recursively divide the input matrix into four quadrants until a quadrant
has only one value or all values are the same. If a quadrant has only one value, we can create a leaf node with
that value and set isLeaf to true. Otherwise, we create a non-leaf node with isLeaf set to false, and val set to
any value (we can set it to true or false, since it does not matter in this case). Then, we recursively construct
each quadrant and assign the resulting nodes to the appropriate child nodes of the non-leaf node.

The algorithm starts with the full matrix as input, and then divides it into four quadrants recursively until we
reach the base case. To divide a quadrant, we calculate the midpoint of each dimension of the current quadrant,
and then we create new matrices for each of the four quadrants by slicing the input matrix along these midpoints.

We then check if each quadrant has only one value or all values are the same. If so, we create a leaf node with
that value and set isLeaf to true. Otherwise, we create a non-leaf node with isLeaf set to false, and val set to
any value. We then recursively construct each quadrant and assign the resulting nodes to the appropriate child
nodes of the non-leaf node.

The algorithm terminates when we reach a quadrant with only one value, in which case we create a leaf node
with that value and set isLeaf to true. The root of the quad-tree is then returned, which is the non-leaf
node created in the first call to the construct() function.

Approach
Define a recursive function build that takes in the current grid as well as the indices row_start, row_end,
col_start, col_end.
Check if the current grid is a leaf node. If yes, create a new node and set its isLeaf and val attributes to true
 or false based on the value of the current grid.
Otherwise, create a new node and set its isLeaf attribute to false and val attribute to true (since it does not
matter).
Divide the current grid into four sub-grids by calculating the midpoints of the current row and column ranges:
mid_row = (row_start + row_end) / 2 and mid_col = (col_start + col_end) / 2.
Recursively build each of the four sub-grids and set the corresponding child node of the current node to the
result.
Return the current node.
Call the build function with the entire grid and return the root node.
Complexity
Time complexity: O(n^2logn)
The reason is that the code iterates through all the elements in each quadrant to check if they are the same.
This takes O(N^2) time. Since the grid is divided into four quadrants in each recursive call, the total number of
recursive calls is O(log N). Therefore, the overall time complexity of the algorithm is O(N^2 log N).

Space complexity: O(N^2)

Because it constructs a quadtree with nodes for each quadrant of the input grid. Since the input grid is N x N,
the maximum number of nodes in the quadtree is also N^2. This means that the space required to store the
quadtree is O(N^2). Additionally, the recursive calls on the stack require O(log N) space due to the maximum
depth of the recursion. Therefore, the overall space complexity of the algorithm is O(N^2 + log N) which can be
simplified to O(N^2) since N^2 dominates log N.
 */
public class ConstructQuadTree {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}
        };
        QuadNode root = new ConstructQuadTree().construct(grid);
        QuadNode.print(root);
    }
    public QuadNode construct(int[][] grid) {
        return
                construct(grid, 0,0, grid.length - 1, grid[0].length - 1);
    }

    private QuadNode construct(int[][] grid, int startRow, int startCol, int endRow, int endCol){
        if(startRow>endRow || startCol>endCol)
            return null;

        boolean isLeaf =true;
        int val = grid[startRow][startCol];
        for(int i = startRow; i<= endRow; i++){
            for(int j= startCol ;j<= endCol; j++){
                if(grid[i][j]!= val){
                    isLeaf = false;
                    break;
                }
            }
            if(!isLeaf){
                break;
            }
        }
        if(isLeaf){
            return new QuadNode(val==1, true);
        }
        int midRow = (startRow+ endRow)/2, midCol = (startCol+ endCol)/2;
        QuadNode topLeft = construct(grid, startRow, startCol, midRow, midCol);
        QuadNode topRight = construct(grid, startRow, midCol+1,midRow, endCol);
        QuadNode bottomLeft = construct(grid, midRow+1, startCol, endRow, midCol);
        QuadNode bottomRight = construct(grid, midRow+1, midCol+1, endRow, endCol);
        return new QuadNode(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
