package P0001;
public class App {
    public static void main(String[] args) throws Exception {
        Solution1 s = new Solution1();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = s.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
