package P0001;
public class App {
    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = s.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
