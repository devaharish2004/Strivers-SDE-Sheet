import java.util.*;
//Using two stacks with push operation O(N)
// public class ImplementQueueUsingStack {
//     Stack<Integer> st1;
//     Stack<Integer> st2;

//     public ImplementQueueUsingStack() {
//         st1 = new Stack<>();
//         st2 = new Stack<>();
//     }
    
//     public void push(int x) {
//         //push takes O(N) time
//         while(!st1.isEmpty()){
//             st2.push(st1.peek());
//             st1.pop();
//         }
//         st1.push(x);
//         while(!st2.isEmpty()){
//             st1.push(st2.peek());
//             st2.pop();
//         }
//     }
    
//     public int pop() {
//         return st1.pop();
//     }
    
//     public int peek() {
//         return st1.peek();
//     }
    
//     public boolean empty() {
//         return st1.isEmpty();
//     }
// }

//TC : O(N)
//SC : O(2N)

//Using two stacks with push operation O(1)

public class ImplementQueueUsingStack {
    Stack<Integer> input, output;
    public ImplementQueueUsingStack() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if(output.isEmpty()){
            while(input.isEmpty() == false){
                output.push(input.peek());
                input.pop();
            }
        }
        return output.pop();
    }
    
    public int peek() {
        if(output.isEmpty()){
            while(input.isEmpty() == false){
                output.push(input.peek());
                input.pop();
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
    }
}

// TC : O(1) for push, O(1) amortized for pop() and peek()
// SC : O(2N)



/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */