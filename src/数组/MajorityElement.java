package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Haokun
 * @date 2020/2/9 15:32
 * <p>
找到数组中的多数元素（出现次数大于n/2的元素）
 */
public class MajorityElement {
//     排序之后 遍历前n/2元素 双指针前后寻找多数元素
    public static int solution1(int[] nums) {
        Arrays.sort(nums);
        int solution=0;
        for (int i=0;i<=nums.length/2;i++){
            if (nums[i]==nums[i+nums.length/2]) {
                solution= nums[i];
                break;
            }
        }
        return solution;
    }
    public static int solution2(int[] nums){
        Map<Integer,Integer> counts=new HashMap<>();
//        将每个元素的个数放入其对应的映射中
        for (int num:nums){
            if (!counts.containsKey(num)){
                counts.put(num,1);
            }else {
                counts.put(num,counts.get(num)+1);
            }
        }

        Map.Entry<Integer,Integer> majorityEntry=null;
        for (Map.Entry<Integer,Integer> entry:counts.entrySet()){
            if (majorityEntry==null||entry.getValue()>majorityEntry.getValue()){
                majorityEntry=entry;
            }
        }

    return majorityEntry.getKey();

    }



}
