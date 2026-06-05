class Solution {
    public int findKthNumber(int m, int n, int k) {
       int low = 0;
       int high = n*m;
       int res =-1;

       while(low<=high){
        int mid = low+(high-low)/2;
        int ans = helper(m,n,mid);

        if(ans < k){
            low = mid+1;
        }else{
            res = mid;
            high = mid-1;
        }
       }
       return res;

    }
    public int helper(int m, int n, int guess){
        int count =0;
        for(int i=1;i<=m;i++){
            count = count + Math.min(guess/i,n);
        }
        return count;
    }

}
    
