//Using recursion
#include <stack> 
using namespace std;

void insertStack(stack<int> &stack, int pushVal){
	if(stack.empty()){
		stack.push(pushVal);
		return;
	}
	if(!stack.empty() && stack.top() > pushVal){
		int x = stack.top();
		stack.pop();
		insertStack(stack, pushVal);
		stack.push(x);
	}
	else{
		stack.push(pushVal);
	}
	return;
}

void sortStack(stack<int> &stack){	
	// Write your code here
	if(stack.empty()){
		return;
	}
	int top = stack.top();
	stack.pop();
	sortStack(stack);
	insertStack(stack, top);
}

//TC: O(N^2)
//SC: O(N)