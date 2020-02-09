package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Haokun
 * @date 2020/2/8 22:19
 * <p>
 * Algorithm
 */
public class ThreeSum {
    public static List<List<Integer>> solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int upzero = 0;

        for (int z = 0; z < nums.length; z++) {
            if (nums[z] >=0) {
                upzero = z;
                break;
            }
        }
        int count = 0;
        for (int a : nums) {
            if (a == 0) {
                count++;
                if (count >= 3) {
                    break;
                }
            }
        }
        if (upzero == 0) {
            if (nums.length >= 3) {
                List<Integer> integers = new ArrayList<>();

                if (count >= 3) {
                    integers.add(0);
                    integers.add(0);
                    integers.add(0);
                    lists.add(integers);
                    return lists;
                } else {
                    return new ArrayList<List<Integer>>();
                }
            } else {
                return new ArrayList<List<Integer>>();
            }

        } else {
            for (int i = 0; i < upzero; i++) {
                for (int j = upzero; j < nums.length; j++) {
                    for (int k = i + 1; k < j; k++) {
                        if ((nums[i] + nums[j] + nums[k]) == 0) {
                            List<Integer> integers = new ArrayList<>();
                            integers.add(nums[i]);
                            integers.add(nums[k]);
                            integers.add(nums[j]);
                            if (!lists.contains(integers)) {
                                lists.add(integers);
                            }
                        }
                    }
                }
            }
        }
        if (count>=3){
            List<Integer> integers=new ArrayList<>();
            integers.add(0);
            integers.add(0);
            integers.add(0);
            lists.add(integers);
        }
        return lists;

    }
}
