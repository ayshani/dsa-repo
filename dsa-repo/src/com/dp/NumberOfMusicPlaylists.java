package com.dp;
/*
920. Number of Music Playlists

Your music player contains n different songs. You want to listen to goal songs (not necessarily different) during
your trip. To avoid boredom, you will create a playlist so that:

Every song is played at least once.
A song can only be played again only if k other songs have been played.
Given n, goal, and k, return the number of possible playlists that you can create. Since the answer can be very
large, return it modulo 109 + 7.



Example 1:

Input: n = 3, goal = 3, k = 1
Output: 6
Explanation: There are 6 possible playlists: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], and [3, 2, 1].

Intuition
We can't simply generate all possible playlists because the problem constraints are too large. Therefore, we need to
approach this problem in a different, more efficient way. That's where dynamic programming comes in.

We're using a dynamic programming (DP) table dp[i][j] to represent the number of possible playlists of length i
containing exactly j unique songs. Our goal is to calculate dp[goal][n], which represents the number of ways we
can make a playlist of length goal using exactly nnn unique songs.

Base cases
To generate the DP table, we need to define the initial conditions:

dp[0][0]=1. This represents that there's exactly one way to create a playlist of length 0 with 0 unique songs,
which is essentially an empty playlist.
For all i<j, dp[i][j]=0. This makes sense because we can't form a playlist of length i with j unique songs
when i<j. There just aren't enough slots in the playlist to accommodate all the unique songs.

Transtions
Now, let's look at the transition rules to fill up the rest of the DP table. Let's say we want to compute the
value dp[i][j].

If we add a song that we haven't played yet to the playlist, the playlist length increases by 1 (from i−1 to i),
and the number of unique songs also increases by 1 (from j−1 to j). Therefore, a playlist of length i with j
unique songs can be formed by adding new songs to each playlist of length i−1 with j−1 unique songs.

In this scenario, how many new songs do we have available to choose from?

At this point, we have j−1 unique songs in the playlist. Since there are nnn unique songs in total, the number
of new songs we can add to the playlist is n−(j−1)=n−j+1.

Since we have n−j+1 choices of the new song, the number of new playlists we can create by adding a new song
is dp[i−1][j−1]⋅(n−j+1). Hence, we add this to dp[i][j].

If we replay an old song, the playlist length increases by 1 (from i−1 to i), but the number of unique songs
remains the same (still j). Therefore, the number of playlists of length i with j unique songs can be increased
by replaying an old song in every playlist of length i−1 with j unique songs.

In this scenario, how many previously played songs can we choose from?

At this point, we have j unique songs in the playlist, so we can choose any of these j songs. However, due to the
constraint that we can't replay a song unless kkk other songs have been played, we can't choose from the last k
played songs.

So, if j>k, the number of old songs we can replay is j−k.

Since we have j−k choices of the old song to replay, the number of new playlists we can create by replaying an
old song is dp[i−1][j]⋅(j−k). Hence, if j>k, we add this to dp[i][j].

These two scenarios encompass all possible transitions for our dynamic programming solution. Each iteration of
our loop considers both of these possibilities and updates dp[i][j] accordingly. Since this problem involves
large numbers, we perform all operations modulo 10^9 + 7 to avoid overflow issues.

In the end, dp[goal][n] will represent the number of possible playlists of length goal using exactly n unique
songs, which is the answer to our problem.

TC : o(goal*n)
SC: o(goal*n)
 */
public class NumberOfMusicPlaylists {

    public static void main(String[] args) {
        System.out.println(new NumberOfMusicPlaylists().numMusicPlaylists(3,3,1));
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        int mod = (int)1e9 +7;
        long[][] dp = new long[goal+1][n+1];
        dp[0][0] =1;
        for(int i=1;i<=goal;i++){
            for(int j=1;j<=Math.min(i,n);j++){
                dp[i][j] = (dp[i-1][j-1]*(n-j+1))%mod;
                if(j>k){
                    dp[i][j] =  (dp[i][j] + dp[i-1][j]*(j-k))%mod;
                }
            }
        }
        return (int)dp[goal][n];
    }
}
