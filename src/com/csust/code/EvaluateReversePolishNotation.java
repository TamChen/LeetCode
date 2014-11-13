package com.csust.code;
public class EvaluateReversePolishNotation {
	 public int evalRPN(String[] tokens) {
	       int temp = 0,count=0;
			for (int i = 0; i < tokens.length; i++) {
				if(tokens[i]!=null){
					if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
						int pre=Integer.valueOf(tokens[i-2]);
						int next=Integer.valueOf(tokens[i-1]);
						if(tokens[i].equals("+")){
							temp=pre+next;
						}else if(tokens[i].equals("-")){
							temp=pre-next;
						}else if(tokens[i].equals("*")){
							temp=pre*next;
						}else if(tokens[i].equals("/")){
							temp=pre/next;
						}
						tokens[i-2]=String.valueOf(temp);
					    for (int j = i; j < tokens.length-1; j++) {
					    	tokens[j-1]=tokens[j+1];                                
						}
					    tokens[tokens.length-1-count*2]=null;
					    tokens[tokens.length-2-count*2]=null;
					    i=0;count++;
					}
				}
			}
			return Integer.valueOf(tokens[0]);
	    }
}
