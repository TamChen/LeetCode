package com.csust.code;
import java.util.ArrayList;
import java.util.List;
public class ReverseWordsInAString {
	    public String reverseWords(String s) {
	 if(s.equals("")){
				return "";
			}else {
				String[] arry=s.split(" ");
				List<String> tempList =new ArrayList<>();
				String temp=null;
				for (int i = 0; i < arry.length; i++) {
					if(!(arry[i].equals(""))){
						arry[i]=arry[i].trim();
						tempList.add(arry[i]);
					}
				}
				String[] arry01 = new String[tempList.size()];
				for (int i = 0; i < tempList.size(); i++) {
					arry01[i]=tempList.get(i);
				}
				for (int i = 0; i < arry01.length/2; i++) {
					temp=arry01[i];
					arry01[i]=arry01[arry01.length-i-1];
					arry01[arry01.length-i-1]=temp;
				}
				temp="";
				for (int i = 0; i < arry01.length; i++) {
					temp=temp+arry01[i]+" ";
				}
				return temp.trim();
			    }
			}
	    
	}
