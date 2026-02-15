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

    // leetcode 67
    public static String binSum(String a, String b) {
        int carry = 0;
        int i = a.length()-1; 
        int j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i >=0 || j>=0 || carry != 0) {
            int sum = 0;
            sum += carry;
            if(i>=0) {
                sum += a.charAt(i)-'0';
                i--;
            }
            if(j>=0) {
                sum += b.charAt(j)-'0';
                j--;
            }
            sb.append(sum%2);
            carry = sum/2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        // int nums[] = {5, 2, 3, 1};
        // int ans[] = adjacentPairWithMinSum(nums);
        // System.out.println(ans[0]+ " "+ ans[1]);
        System.out.println(binSum("11", "1"));
    }
}
