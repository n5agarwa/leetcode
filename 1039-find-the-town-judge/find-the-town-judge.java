class Solution {
    public int findJudge(int n, int[][] trust) {
        int []trustscore = new int[n + 1];

        for(int []t : trust){
            int a = t[0], b = t[1];
            trustscore[a]--;
            trustscore[b]++;
        }

        for(int i = 1; i <=n; i++)
            if(trustscore[i] == n - 1)
                return i;
        
        return -1;
    }
}