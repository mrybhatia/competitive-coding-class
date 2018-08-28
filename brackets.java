import java.util.*;
import java.lang.*;
import java.io.*;
class main{
	public static void main(String[] argv){
	    Scanner sc = new Scanner(System.in);
	    String bracket = sc.next();
	    char[] a = bracket.toCharArray();
	    int count = 0;
	    for (int i=0;i<a.length-1;i++) {
	    	for (int j=i+1;j<a.length;j++){
	    		if(a[i] == '[' && a[j] ==']'){
	    			count += 1;
	    			a[i] = '0';
	    			a[j] = '0';
	    			break;
	    		}
	    	}
	    }
	    System.out.println(count);
	}
}
