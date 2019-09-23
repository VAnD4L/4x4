package cube;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//import java.util.Scanner;

public class cubix {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {


		
		
	   
		
	    solve s1 = new solve(); // MAKE TREE OBJ
	    s1.shuffle();
	    MCPrint(s1);
	    
	   // s1.c1.getClass().getDeclaredMethod("Z1ClockWise", s1.param).invoke(s1.c1,s1.parameters);//permute once

	   // System.out.println(" Z3AntiClockWise");
	   // s1.c1.print();//print Z1ClockWise
	    
	    
	   
	    for(int i=0;i<s1.stepMethods.length;i++) {// activate steps
	    	s1.BFS(s1.stepMethods[i],s1.c1.methods);
	    	MCPrint(s1);
    		if(i==24 && !((s1.c1.face1[3][1]==s1.c1.face1[3][2])&&(s1.c1.face6[0][1]==s1.c1.face6[0][2]))) {s1.cheat();}
    		if(i==26 && !((s1.c1.face1[1][0]==s1.c1.face1[2][0])&&(s1.c1.face4[1][3]==s1.c1.face4[2][3]))) {s1.cheat();}
    		if(i==28 && !((s1.c1.face1[0][1]==s1.c1.face1[0][2])&&(s1.c1.face2[3][1]==s1.c1.face2[3][2]))) {s1.cheat();}
    		if(i==30 && !((s1.c1.face1[1][3]==s1.c1.face1[2][3])&&(s1.c1.face3[1][0]==s1.c1.face3[2][0]))) {s1.cheat();MCPrint(s1);}
	    }
	    
	}// end main
	
	
	
	
	
	public static void MCPrint(solve s1) {
		for(Method p : s1.c1.permutetionsDone) {//print cube for each step
		s1.c1.methodPrint(p);
	}
	s1.c1.print();
	}
}
  