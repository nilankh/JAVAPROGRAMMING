//LCS - Problem
//Send Feedback
//Given 2 strings of S1 and S2 with lengths m and n respectively,
//find the length of longest common subsequence.
//A subsequence of a string S whose length is n, is a string containing characters 
//in same relative order as they are present in S, but not necessarily contiguous.
//Subsequences contain all the strings of length varying from 0 to n. For example, 
//subsequences of string "abc" are - "",a,b,c,ab,bc,ac,abc.
//Input Format :
//Line 1 : String S1
//Line 2 : String s2
//Output Format :
//Line 1 : Length of longest common subsequence
//Sample Input :
//adebc
//dcadb
//Sample Output :
//3


package dynamicProgramming;
import java.util.Scanner;
public class LCS {
	
	
	public static int lcs(String s1, String s2) {
		return lcsHelper(s1, s2, 0, 0);
	}
	
	public static int lcsHelper(String str1, String str2, int i, int j) {
		
		if(i == str1.length() || j == str2.length()) {
			return 0;
		}
		
		int myAns;
		if(str1.charAt(i) == str2.charAt(j)) {
			int smallAns = lcsHelper(str1, str2, i + 1, j + 1);
			myAns = 1 + smallAns;
		}else {
			int ans1 = lcsHelper(str1, str2, i + 1, j);
			int ans2 = lcsHelper(str1, str2, i, j + 1);
			myAns = Math.max(ans1, ans2);
		}
		return myAns;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		System.out.println(lcs(str1, str2));
	}

}
