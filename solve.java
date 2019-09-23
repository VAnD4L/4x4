//TODO make methods array static:: probably can't
//TODO add next steps
//TODO ANTI-CHEAT
//TODO start from the end
//TODO add countSolvedEdgeBlocks
// if on front 4 column is lower then 1s then top 4th column edge block must be broken
package cube;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

//2-6  1-5  3-4   1 front 2 top 3 right 4 left 5 back 6 bottom

public class solve  {
	
	public solve() throws  NoSuchMethodException{
		parameterTypes[0] = cube.class;
		stepMethods = new Method[ABC.length];
		
		for (int i=0;i<ABC.length;i++) { //fill stepMethodsarray
			stepMethods[i] =solve.class.getMethod(ABC[i], parameterTypes);
		}
		
	}
	
	 cube c1 = new cube();
	 public Method[] stepMethods;
	 Class<?>[] parameterTypes = new Class<?>[1]; // fake it
	 Class<?>[] param = new Class<?>[0];   // fake it
	 Object[] parameters = new Object[0];// fake it
	 // array of stepMethods names as strings
	 String[] ABC = {"stepCheck0" , "stepCheck1" , "stepCheck2" , "stepCheck3" ,
			 		"stepCheck4" , "stepCheck5" , "stepCheck6", "stepCheck7"
			 		, "stepCheck8", "stepCheck9", "stepCheck10", "stepCheck11"
			 		, "stepCheck12", "stepCheck13", "stepCheck14", "stepCheck15"
			 		, "stepCheck16", "stepCheck17", "stepCheck18", "stepCheck19"
			 		, "stepCheck20", "stepCheck21", "stepCheck22", "stepCheck23"
			 		, "stepCheck24", "stepCheck25", "stepCheck26", "stepCheck27"
			 		, "stepCheck28", "stepCheck29", "stepCheck30", "stepCheck31"
			 		, "stepCheck32", "stepCheck33", "stepCheck34"};
	 
	 
	 void cheat() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException { // ssshhhh
		 c1.methods[15].invoke(c1,parameters); c1.permutetionsDone.add(c1.methods[15]);
		 c1.methods[14].invoke(c1,parameters);c1.permutetionsDone.add(c1.methods[14]);
		 c1.methods[4].invoke(c1,parameters);c1.permutetionsDone.add(c1.methods[4]);
		 c1.methods[8].invoke(c1,parameters);c1.permutetionsDone.add(c1.methods[8]);
		 c1.methods[19].invoke(c1,parameters);c1.permutetionsDone.add(c1.methods[19]);
		 c1.methods[9].invoke(c1,parameters);c1.permutetionsDone.add(c1.methods[9]);
	 }
	 
	 void shuffle () throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		 int[] numbers = new int[25];       
		 //Generates 25 Random Numbers in the range 0 -23
		 for(int i = 0; i < numbers.length; i++) {
			 numbers[i] = (int)(Math.random()*23);
		 }
		 for(int rand : numbers) {
     		c1.methods[rand].invoke(c1,parameters);
     	//	c1.permutetionsDone.add(c1.methods[rand]);
		//	for(Method p : c1.permutetionsDone) {
		//		c1.methodPrint(p);
	    	//}
     		//c1.print();
     	}
		 
	 }
	 
	 void BFS(Method stepCheck,Method[] thisMethods) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException  
	    { 
		 System.out.println(stepCheck.toString());
	        Queue<ArrayList <Method>> queue3 = new LinkedList<ArrayList <Method>>(); // checking queue
	        Queue<ArrayList <Method>> queue4 = new LinkedList<ArrayList <Method>>(); // children adding queue
	        ArrayList <Method> childrenMethods= new ArrayList <Method>();
	        queue3.add(childrenMethods); 
	        int count=0;
	        while (true)  
	        { 
	        	if(!queue3.isEmpty()) {
	        		ArrayList <Method> tempMethodsAL= (ArrayList <Method>) queue3.element().clone();
	        		cube tempCube = new cube(c1);
	        		for(Method m : tempMethodsAL) {
	        			m.invoke(tempCube,parameters);//permute new cube
	        			tempCube.permutetionsDone.add(m); // update permutetionsDone on new cube
	        		}
	        		
		        	Object[] parameters1 = new Object[1];
		        	parameters1[0] = tempCube;// fake it
		        	
		        	count++;
		        	if(count%1000000==0) {
		        		System.out.println("count : "+count/1000000+" M");
		        	}
		        	if((Boolean)stepCheck.invoke(this, parameters1)) { // invoke checking method on the current cube


		        		c1 = new cube(tempCube);
		        		queue3.clear();
		        		queue4.clear();
		        		tempCube = null;

		        		return ;
		        	}
		        	queue4.add(queue3.poll());

	        	}
	        	else {// if queue is empty
	        		
	        		for(Method m : thisMethods) {
	        			ArrayList <Method> tempAL=new ArrayList <Method>();
	        			tempAL= (ArrayList <Method>) queue4.element().clone();
	        			int fatherIndex;
	        			int childIndex;
	        			if(tempAL.isEmpty()) {
	        				if(c1.permutetionsDone.isEmpty()) {
					        	fatherIndex = -1;
					        	childIndex = -2;
	        				}
	        				else {
					        	fatherIndex = getIndexByElement(c1.permutetionsDone.get(c1.permutetionsDone.size()-1));
					        	childIndex = thisMethods.length-1-getIndexByElement(m);
	        				}

	        			}
	        			else {
				        	fatherIndex = getIndexByElement(tempAL.get(tempAL.size()-1));
				        	childIndex = thisMethods.length-1-getIndexByElement(m);
	        			}
	        			if(fatherIndex!=childIndex) {
	        				if(tempAL.isEmpty()) {
	        					tempAL.add(m);                
	        					queue3.add(tempAL);
	        				}else {
		        				if((m!=tempAL.get(tempAL.size()-1))||(getIndexByElement(m) <=11)) {
		        					tempAL.add(m);                
		        					queue3.add(tempAL);
		        				}
	        				}
	        			}
	        		}
	        		queue4.poll();
	        		
	        	}
	        	
	        	
	        }// end while 
	    }//end BFS

	 int getIndexByElement(Method element) {
		 for(int i=0;i<c1.methods.length;i++) {
			 if(c1.methods[i]==element) {
				 return i;
			 }
		 }
		 return -1;
	 }
	  // *****************************************************  STEP CHECK *****************************************************
	 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 // [row][column]
	 public boolean stepCheck0(cube tempCube) {
		 if(tempCube.face3[1][1]==" red  ") {
			 return true;
		 }
		return false;
	 }
	 
	 public boolean stepCheck1(cube tempCube) {
		 if(stepCheck0(tempCube)) {
			 if(tempCube.face3[1][2]==" red  ") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck2(cube tempCube) {
		 if(stepCheck1(tempCube)) {
			 if(tempCube.face3[2][1]==" red  ") {
					 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck3(cube tempCube) { // red square in face 3
		 if(stepCheck2(tempCube)) {
			 if(tempCube.face3[2][2]==" red  ") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck4(cube tempCube) {
		 if(stepCheck3(tempCube)) {
			 if(tempCube.face4[1][1]=="orange") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck5(cube tempCube) {
		 if(stepCheck4(tempCube)) {
			 if(tempCube.face4[1][2]=="orange") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck6(cube tempCube) {
		 if(stepCheck5(tempCube)) {
			 if(tempCube.face4[2][1]=="orange") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck7(cube tempCube) {// orange square in face 4
		 if(stepCheck6(tempCube)) {
			 if(tempCube.face4[2][2]=="orange") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck8(cube tempCube) {
		 if(stepCheck7(tempCube)) {
			 if(tempCube.face1[1][1]=="green ") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck9(cube tempCube) {
		 if(stepCheck8(tempCube)) {
			 if(tempCube.face1[1][2]=="green ") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck10(cube tempCube) {
		 if(stepCheck9(tempCube)) {
			 if(tempCube.face1[2][1]=="green ") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck11(cube tempCube) {
		 if(stepCheck10(tempCube)) {
			 if(tempCube.face1[2][2]=="green ") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck12(cube tempCube) {
		 if(stepCheck11(tempCube)) {
			 if(tempCube.face6[1][1]=="yellow") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck13(cube tempCube) {
		 if(stepCheck12(tempCube)) {
			 if(tempCube.face6[1][2]=="yellow") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck14(cube tempCube) {
		 if(stepCheck13(tempCube)) {
			 if(tempCube.face6[2][1]=="yellow") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck15(cube tempCube) {
		 if(stepCheck14(tempCube)) {
			 if(tempCube.face6[2][2]=="yellow") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck16(cube tempCube) {
		 if(stepCheck15(tempCube)) {
			 if(tempCube.face5[1][1]==" blue ") {
				 return true;
			 }
		 }
		return false;
		 
	 }
	 
	 public boolean stepCheck17(cube tempCube) {
		 if(stepCheck16(tempCube)) {
			 if(tempCube.face5[1][2]==" blue ") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck18(cube tempCube) {
		 if(stepCheck17(tempCube)) {
			 if(tempCube.face5[2][1]==" blue ") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck19(cube tempCube) {
		 if(stepCheck18(tempCube)) {
			 if(tempCube.face5[2][2]==" blue ") {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 //////////////////////// END OF MIDDLE SQUARES STEPS /////////////////////////////

	 public boolean stepCheck20(cube tempCube) {// 1st back block 1st total
		 if(stepCheck19(tempCube)) {
			 if((tempCube.face6[3][1]==tempCube.face6[3][2])&&(tempCube.face5[3][1]==tempCube.face5[3][2])) {
				 return true;
			 } 
		 }
		return false;
	 }
	 
	 public boolean stepCheck21(cube tempCube) {//2nd back block 2nd total
		 if(stepCheck20(tempCube)) {
			 if((tempCube.face2[0][1]==tempCube.face2[0][2])&&(tempCube.face5[0][1]==tempCube.face5[0][2])) {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck22(cube tempCube) {//3rd back block 3rd total
		 if(stepCheck21(tempCube)) {
			 if((tempCube.face3[1][3]==tempCube.face3[2][3])&&(tempCube.face5[1][0]==tempCube.face5[2][0])) {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck23(cube tempCube) {//4th back block 4th total
		 if(stepCheck22(tempCube)) {
			 if((tempCube.face4[1][0]==tempCube.face4[2][0])&&(tempCube.face5[1][3]==tempCube.face5[2][3])) {
				 return true;
			 }
		 }
		return false;
	 }
	 //////////////////////////////////////////////////////////// END OF BACK BLOCKS ///////////////////////////////////////////////////////////////////////////////////////
	 
	 public boolean stepCheck24(cube tempCube) { // prep for 1st front block bottom
		 if(stepCheck23(tempCube)) {
			 if(((tempCube.face6[1][3]==tempCube.face4[3][1])&&(tempCube.face3[3][1]==tempCube.face6[2][0]))) {
				 return true;
			 }
		 }
		return false;
	 }
	  // add cheat
	 public boolean stepCheck25(cube tempCube) { // 1st front block 5th total
		 if(stepCheck23(tempCube)) {
			 if((tempCube.face1[3][1]==tempCube.face1[3][2])&&(tempCube.face6[0][1]==tempCube.face6[0][2])) {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck26(cube tempCube) { //prep for 2nd front block
		 if(stepCheck25(tempCube)) {
			 if(((tempCube.face6[1][3]==tempCube.face4[3][1])&&(tempCube.face3[3][1]==tempCube.face6[2][0]))) {
				 return true;
			 }
		 }
		return false;
	 }
	// add cheat
	 public boolean stepCheck27(cube tempCube) { // 2nd front block 6th total
		 if(stepCheck25(tempCube)) {
			 if((tempCube.face1[1][0]==tempCube.face1[2][0])&&(tempCube.face4[1][3]==tempCube.face4[2][3])) {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck28(cube tempCube) { //prep for 3rd front block
		 if(stepCheck27(tempCube)) {
			 if(((tempCube.face6[1][3]==tempCube.face4[3][1])&&(tempCube.face3[3][1]==tempCube.face6[2][0]))) {
				 return true;
			 }
		 }
		return false;
	 }
	// add cheat
	 public boolean stepCheck29(cube tempCube) { // 3rd front block 7th total
		 if(stepCheck27(tempCube)) {
			 if((tempCube.face1[0][1]==tempCube.face1[0][2])&&(tempCube.face2[3][1]==tempCube.face2[3][2])) {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 public boolean stepCheck30(cube tempCube) { //prep for 4th front block
		 if(stepCheck29(tempCube)) {
			 if(((tempCube.face6[1][3]==tempCube.face4[3][1])&&(tempCube.face3[3][1]==tempCube.face6[2][0]))) {
				 return true;
			 }
		 }
		return false;
	 }
	// add cheat
	 public boolean stepCheck31(cube tempCube) { // 4th front block 8th total
		 if(stepCheck29(tempCube)) {
			 if((tempCube.face1[1][3]==tempCube.face1[2][3])&&(tempCube.face3[1][0]==tempCube.face3[2][0])) {
				 return true;
			 }
		 }
		return false;
	 }
	 
	 
	 public boolean stepCheck32(cube tempCube) {// 1st side block 9th total
		 if(stepCheck31(tempCube)) {
			 if((tempCube.face2[1][3]==tempCube.face2[2][3])&&(tempCube.face3[0][1]==tempCube.face3[0][2])) {
				 return true;
			 }
			 
		 }
		return false;
		 
	 }
	 
	 public boolean stepCheck33(cube tempCube) {//prep for 2nd side block
		 if(stepCheck32(tempCube)) {
			 if(((tempCube.face3[3][1]==tempCube.face3[3][2])&&(tempCube.face6[1][3]==tempCube.face6[2][3]))||((tempCube.face4[0][1]==tempCube.face4[0][2])&&(tempCube.face2[1][0]==tempCube.face2[2][0]))||((tempCube.face6[1][0]==tempCube.face6[1][3])&&(tempCube.face3[3][1]==tempCube.face4[3][2]))||((tempCube.face6[2][0]==tempCube.face6[2][3])&&(tempCube.face3[3][2]==tempCube.face4[3][1]))||((tempCube.face4[0][2]==tempCube.face4[3][2])&&(tempCube.face2[2][0]==tempCube.face6[1][0]))||((tempCube.face4[0][1]==tempCube.face4[3][1])&&(tempCube.face2[1][0]==tempCube.face6[2][0]))) {
				 return true;
			 }
			 
		 }
		return false;
		 
	 }
	 
	  
	 public boolean stepCheck34(cube tempCube) {// 2nd side block 10th total
		 if(stepCheck32(tempCube)) {
			 if(((tempCube.face3[3][1]==tempCube.face3[3][2])&&(tempCube.face6[1][3]==tempCube.face6[2][3]))||((tempCube.face4[0][1]==tempCube.face4[0][2])&&(tempCube.face2[1][0]==tempCube.face2[2][0]))) {
				 return true;
			 }
			 
		 }
		return false;
		 
	 }
	 /*	
	 public boolean stepCheck34(cube tempCube) {// 3rd side block 11th total
		 if(stepCheck33(tempCube)) {
			 if((tempCube.face6[1][0]==tempCube.face6[2][0])&&(tempCube.face4[3][1]==tempCube.face4[3][2])) {
				 return true;
			 }
			 
		 }
		return false;
		 
	 }
	 
	 public boolean stepCheck35(cube tempCube) {// 4th side block 12th total
		 if(stepCheck34(tempCube)) {
			 if((tempCube.face4[0][1]==tempCube.face4[0][2])&&(tempCube.face2[1][0]==tempCube.face2[2][0])) {
				 return true;
			 }
			 
		 }
		return false;
		 
	 }
	    */
}
