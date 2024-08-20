import java.util.*;
// Without circular array consideration
class NextGreaterElement_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = nums2.length - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                mp.put(nums2[i], -1);
            }
            else{
                mp.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++){
            nums1[i] = mp.get(nums1[i]);
        }
        return nums1;
    }
}

//TC : O(N) - for running a for loop + O(N) - adding every element atmost once to the stack ~ O(N)
//SC : O(N) - for using the stack data structure, map is an additional data structure required for returning the solution