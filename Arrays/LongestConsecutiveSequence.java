import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int longest = 1;
        Set<Integer>st = new HashSet<>();
        //insert all the elements in the set
        for(int i = 0; i < n; i++){
            st.add(nums[i]);
        }
        //check if the current element can be a starting element of the sequence
        for(int it: st){
            if(st.contains(it-1) == false){
                int count = 1;
                int val = it;
                while(st.contains(val+1)){
                    count++;
                    val += 1;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }
}