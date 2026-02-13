package src;

public class Code {

    public static int[] adjacentPairWithMinSum(int nums[]) {
        int min = Integer.MAX_VALUE;
        int ans[] = {0, 0};
        for(int i=0; i<nums.length-1; i++) {
            int currPairSum = nums[i]+nums[i+1];
            if(min > currPairSum) {
                min = currPairSum;
                ans[0] = nums[i];
                ans[1] = nums[i+1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {5, 2, 3, 1};
        int ans[] = adjacentPairWithMinSum(nums);
        System.out.println(ans[0]+ " "+ ans[1]);
    }
}
