package com.algorithm2023.jababookbackjoon1;

import java.util.Scanner;
import java.util.Stack;

public class Sample010 {//백준 4949 균형잡힌 세상
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);

		while(true) {
			
			String a=sc.nextLine();
			
			Stack<Character> stack = new Stack<>();
			
			if(a.equals(".")) {
				break;
			}
			
			for(int i=0; i<a.length(); i++) {
				
				char ch=a.charAt(i);
				
				if(ch=='['||ch=='(') {
					stack.push(ch);
				} else if(ch == ']') {
					
					if(!stack.isEmpty()&&stack.peek()=='[') {
						
						stack.pop();
						
					} else {
						
						stack.push(']');
						break;
					}
				} else if(ch==')') {
					
					if(!stack.isEmpty()&&stack.peek()=='(') {
						stack.pop();
					} else {
						stack.push(')');
						break;
					}
				}
			}
			
			if(stack.isEmpty()) {
				
				System.out.println("yes");
				
			} else {
				
				System.out.println("no");
				
			}
			
		}
		
		sc.close();
	}
}
/*
입력>>
So when I die (the [first] I will see in (heaven) is a score list).
[ first in ] ( first out ).
Half Moon tonight (At least it is better than no Moon at all].
A rope may form )( a trail in a maze.
Help( I[m being held prisoner in a fortune cookie factory)].
([ (([( [ ] ) ( ) (( ))] )) ]).
 .
.

출력>>
yes
yes
no
no
no
yes
yes

*/