package com.csust.code;

import java.util.Stack;

//实现stack
class MinStack {
	private Stack<Integer> stack=new Stack<Integer>();
	private Stack<Integer> minStack=new Stack<Integer>();
	public void push(int x) {  
		if(minStack.peek()==null||minStack.peek()>x)
			minStack.push(x);
		stack.push(x);
	}  
	  
	public void pop() {  
		if(minStack.peek().equals(stack.peek()))
			minStack.pop();
		stack.pop();
	}  
	  
	public int top() {  
		return stack.peek();
	}  
	  
	public int getMin() {  
		return minStack.peek();
	} 
}
//利用链表中的指针的思想。
class MinStack01 {  
    Node top = null;  
  
    public void push(int x) {  
        if (top == null) {  
            top = new Node(x);  
            top.min = x;  
        } else {  
            Node temp = new Node(x);  
            temp.next = top;  
            top = temp;  
            top.min = Math.min(top.next.min, x);  
        }  
    }  
  
    public void pop() {  
        top = top.next;  
        return;  
    }  
  
    public int top() {  
        return top == null ? 0 : top.val;  
    }  
  
    public int getMin() {  
        return top == null ? 0 : top.min;  
    }  
}  
  
class Node {  
    int val;  
    int min;  
    Node next;  
  
    public Node(int val) {  
        this.val = val;  
    }  
}  
