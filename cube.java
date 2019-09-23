
package cube;
import java.lang.reflect.Method;
import java.util.ArrayList;

//front green , top white , left orange , right red , back blue , bottom yellow

public class cube {
	public  cube() { // c'tor
	    for(int i=0;i<numberOfPanels;i++) {
		       for(int j =0;j<numberOfPanels;j++) { // 2-6  1-5  3-4   1 front 2 top 3 right 4 left 5 back 6 bottom
		    	   
		    	   this.face3[i][j] = this.red;
		    	   this.face4[i][j] = this.orange;
		    	   this.face2[i][j] = this.white;
		    	   this.face1[i][j] = this.green;
		    	   this.face6[i][j] = this.yellow;
		    	   this.face5[i][j] = this.blue;
		    	   
		                	   
		       }
		    }
	    
	    Class<? extends cube> c = this.getClass();
	    try {
	    	Class<?>[] param = new Class<?>[0];                        // array of template classes zero size
	    	Method m = c.getDeclaredMethod("Root", param);
	    	this.permutetionsDone.add(m);                              // add root as first permute done
	    	methods = new Method[methodsStrings.length];               // fill methods array by order
			for (int i=0;i<methodsStrings.length;i++) { 
				methods[i] =cube.class.getMethod(methodsStrings[i], param);
			}
	    	methodsSmall = new Method[methodsSmallStrings.length];               // fill methods array by order
			for (int i=0;i<methodsSmallStrings.length;i++) { 
				methodsSmall[i] =cube.class.getMethod(methodsSmallStrings[i], param);
			}
	    }catch(NoSuchMethodException e) {
	         System.out.println(e.toString());
	      }
	    
	    
	}
	public  cube(cube c) {//copy c'tor
		
 	   
	    for(int i=0;i<numberOfPanels;i++) {
		       for(int j =0;j<numberOfPanels;j++) { 
		     	   this.face3[i][j] = c.face3[i][j];
		     	   this.face4[i][j] = c.face4[i][j];
		     	   this.face2[i][j] = c.face2[i][j];
		     	   this.face1[i][j] = c.face1[i][j];
		     	   this.face6[i][j] = c.face6[i][j];
		     	   this.face5[i][j] = c.face5[i][j];
		       }
		    }
	    for(Method p : c.permutetionsDone) {
	    	this.permutetionsDone.add(p);
    	}
	    this.methods = new Method[c.methods.length];
		for (int i=0;i<c.methods.length;i++) { 
			this.methods[i] =c.methods[i];
		}
		
	    this.methodsSmall = new Method[c.methodsSmall.length];
		for (int i=0;i<c.methodsSmall.length;i++) { 
			this.methodsSmall[i] =c.methodsSmall[i];
		}
	    
	}
	
	String white = "white ";	
	String red =  " red  ";		
	String green = "green ";
	String orange = "orange";	
	String yellow = "yellow";			
	String blue = " blue ";		
	
	int numberOfPanels = 4;  // means 4x4
	ArrayList <Method> permutetionsDone = new ArrayList<Method>(); // contains all the methods done on this cube by order ,since initial cube
	public String [][] face1 = new String [numberOfPanels][numberOfPanels];//green
	public String [][] face2 = new String [numberOfPanels][numberOfPanels];//white
	public String [][] face3 = new String [numberOfPanels][numberOfPanels];//red
	public String [][] face4 = new String [numberOfPanels][numberOfPanels];//orange
	public String [][] face5 = new String [numberOfPanels][numberOfPanels];//blue
	public String [][] face6 = new String [numberOfPanels][numberOfPanels];//yellow
	public Method[] methods ;// an array of all the methods
	String[] methodsStrings= {		"Row1AntiClockWise" , "Row2AntiClockWise" ,"Row3AntiClockWise" , "Row4AntiClockWise" ,
									"Column1AntiClockWise" ,"Column2AntiClockWise" ,"Column3AntiClockWise" ,"Column4AntiClockWise" ,
									"Z1AntiClockWise" ,"Z2AntiClockWise" ,"Z3AntiClockWise" ,"Z4AntiClockWise" ,
									"Z4ClockWise" ,"Z3ClockWise" ,"Z2ClockWise" ,"Z1ClockWise" ,
									"Column4ClockWise" ,"Column3ClockWise" ,"Column2ClockWise" ,"Column1ClockWise" ,
									"Row4ClockWise" , "Row3ClockWise" ,"Row2ClockWise" , "Row1ClockWise"};
	public Method[] methodsSmall ;// an array of some methods
	String[] methodsSmallStrings= {"Row1AntiClockWise" , "Row4AntiClockWise" ,
									"Column1AntiClockWise" ,"Column4AntiClockWise" ,
									"Z1AntiClockWise" ,"Z4AntiClockWise" ,
									"Z4ClockWise" ,"Z1ClockWise" ,
									"Column4ClockWise" ,"Column1ClockWise" ,
									"Row4ClockWise" , "Row1ClockWise"};
	
	
 	public void print() {// print cube by face order
		
		for(int i=0;i<numberOfPanels;i++) { 
			System.out.print("                                 ");
			for(int j=0;j<numberOfPanels;j++) {
				System.out.print(" "+this.face2[i][j]);
			    
			}
		  System.out.println(" ");
		}System.out.println(" ");
		
		for(int i=0;i<numberOfPanels;i++) { 
			for(int j=0;j<numberOfPanels;j++) {
				System.out.print(" "+this.face4[i][j]);
			    
			}
			System.out.print("     ");
			for(int j=0;j<numberOfPanels;j++) {
				System.out.print(" "+this.face1[i][j]);
			    
			}
			System.out.print("     ");
			for(int j=0;j<numberOfPanels;j++) {
				System.out.print(" "+this.face3[i][j] );
			    
			}
			System.out.print("     ");
			for(int j=0;j<numberOfPanels;j++) {
				System.out.print(" "+this.face5[i][j]);
			    
			}
		  System.out.println(" ");
		}System.out.println(" ");
				
		for(int i=0;i<numberOfPanels;i++) {
			System.out.print("                                 ");
			for(int j=0;j<numberOfPanels;j++) {
				System.out.print(" "+this.face6[i][j]);
			    
			}
		  System.out.println(" ");
		}System.out.println(" ");
		


	}
	
	public void methodPrint(Method p){ // print the method's name only
		String tempString =p.toString();
		int secondDotIndex=0;
		for(int i=0;i<tempString.length();i++) {
			if (tempString.charAt(i)=='.') secondDotIndex = i;
		}
		tempString=tempString.substring(secondDotIndex+1,tempString.length()-2);
		System.out.println(" "+tempString);
		
	}

	
	public void Root() {
		
	}
	
	//Movement Row 1-4 : up-down , Column 1-4 : left-right , Z 1-4 : front-back

	
	public void rotate90Clockwise(String [][]face) //An In place function to rotate a N x N matrix by 90 degrees in clockwise direction 
	{ 
	  
	    // Traverse each cycle 
	    for (int i = 0; i < face.length/ 2; i++) 
	    { 
	        for (int j = i; j < face.length - i - 1; j++) 
	        { 
	  
	            // Swap elements of each cycle 
	            // in clockwise direction 
	              String temp = face[i][j]; 
	            face[i][j] = face[face.length - 1 - j][i]; 
	            face[face.length - 1 - j][i] = face[face.length - 1 - i][face.length - 1 - j]; 
	            face[face.length - 1 - i][face.length - 1 - j] = face[j][face.length - 1 - i]; 
	            face[j][face.length - 1 - i] = temp; 
	        } 
	    } 
	}
	
	public void rotate90AntiClockwise( String [][] mat) 
	{ 
	    // Consider all squares one by one 
	    for (int x = 0; x < mat.length / 2; x++) 
	    { 
	        // Consider elements in group of 4 in  
	        // current square 
	        for (int y = x; y < mat.length-x-1; y++) 
	        { 
	            // store current cell in temp variable 
	            String temp = mat[x][y]; 
	   
	            // move values from right to top 
	            mat[x][y] = mat[y][mat.length-1-x]; 
	   
	            // move values from bottom to right 
	            mat[y][mat.length-1-x] = mat[mat.length-1-x][mat.length-1-y]; 
	   
	            // move values from left to bottom 
	            mat[mat.length-1-x][mat.length-1-y] = mat[mat.length-1-y][x]; 
	   
	            // assign temp to left 
	            mat[mat.length-1-y][x] = temp; 
	        } 
	    } 
	}
		
	public void Row1AntiClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[0][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[0][j];
			  }
			if(counter==2) {
				middleman[2][j] = face5[0][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[0][j];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face5[0][i] = middleman[3][i];
		    face3[0][i] = middleman[0][i];
		    face1[0][i] = middleman[1][i];
		    face4[0][i] = middleman[2][i];
		}
		rotate90AntiClockwise(face2);//rotate the upper face Anti clockwise
	   }
		
	public void Row2AntiClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[1][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[1][j];
			  }
			if(counter==2) {
				middleman[2][j] = face5[1][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[1][j];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face5[1][i] = middleman[3][i];
		    face3[1][i] = middleman[0][i];
		    face1[1][i] = middleman[1][i];
		    face4[1][i] = middleman[2][i];
		}
		
	   }
		
	public void Row3AntiClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[2][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[2][j];
			  }
			if(counter==2) {
				middleman[2][j] = face5[2][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[2][j];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face5[2][i] = middleman[3][i];
		    face3[2][i] = middleman[0][i];
		    face1[2][i] = middleman[1][i];
		    face4[2][i] = middleman[2][i];
		}
		
	   }
		
	public void Row4AntiClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[3][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[3][j];
			  }
			if(counter==2) {
				middleman[2][j] = face5[3][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[3][j];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face5[3][i] = middleman[3][i];
		    face3[3][i] = middleman[0][i];
		    face1[3][i] = middleman[1][i];
		    face4[3][i] = middleman[2][i];
		}
		rotate90Clockwise(face6);
	   }
		
	public void Row1ClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[0][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[0][j];
			  }
			if(counter==2) {
				middleman[2][j] = face5[0][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[0][j];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face1[0][i] = middleman[3][i];
		    face4[0][i] = middleman[0][i];
		    face5[0][i] = middleman[1][i];
		    face3[0][i] = middleman[2][i];
		}
		rotate90Clockwise(face2);
	   }

	public void Row2ClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[1][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[1][j];
			  }
			if(counter==2) {
				middleman[2][j] = face5[1][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[1][j];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face1[1][i] = middleman[3][i];
		    face4[1][i] = middleman[0][i];
		    face5[1][i] = middleman[1][i];
		    face3[1][i] = middleman[2][i];
		}
		
	   }

	public void Row3ClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[2][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[2][j];
			  }
			if(counter==2) {
				middleman[2][j] = face5[2][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[2][j];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face1[2][i] = middleman[3][i];
		    face4[2][i] = middleman[0][i];
		    face5[2][i] = middleman[1][i];
		    face3[2][i] = middleman[2][i];
		}
		
	   }

	public void Row4ClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[3][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[3][j];
			  }
			if(counter==2) {
				middleman[2][j] = face5[3][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[3][j];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face1[3][i] = middleman[3][i];
		    face4[3][i] = middleman[0][i];
		    face5[3][i] = middleman[1][i];
		    face3[3][i] = middleman[2][i];
		}
		rotate90AntiClockwise(face6);
	   }

	public void Column1AntiClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[j][0];
			  }
			if(counter==1) {
				middleman[1][j] = face6[j][0];
			  }
			if(counter==2) {
				middleman[2][j] = face5[j][3];
			  }
			if(counter==3) {
				middleman[3][j] = face2[j][0];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face6[numberOfPanels-i-1][0] = middleman[2][i];
		    face5[numberOfPanels-i-1][3] = middleman[3][i];
		    face2[i][0] = middleman[0][i];
		    face1[i][0] = middleman[1][i];
		}
		rotate90AntiClockwise(face4);
	   }

	public void Column2AntiClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[j][1];
			  }
			if(counter==1) {
				middleman[1][j] = face6[j][1];
			  }
			if(counter==2) {
				middleman[2][j] = face5[j][2];
			  }
			if(counter==3) {
				middleman[3][j] = face2[j][1];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face6[numberOfPanels-i-1][1] = middleman[2][i];
		    face5[numberOfPanels-i-1][2] = middleman[3][i];
		    face2[i][1] = middleman[0][i];
		    face1[i][1] = middleman[1][i];
		}
	
	   }

	public void Column3AntiClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[j][2];
			  }
			if(counter==1) {
				middleman[1][j] = face6[j][2];
			  }
			if(counter==2) {
				middleman[2][j] = face5[j][1];
			  }
			if(counter==3) {
				middleman[3][j] = face2[j][2];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face6[numberOfPanels-i-1][2] = middleman[2][i];
		    face5[numberOfPanels-i-1][1] = middleman[3][i];
		    face2[i][2] = middleman[0][i];
		    face1[i][2] = middleman[1][i];
		}
	
	  }

	public void Column4AntiClockWise() { 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[j][3];
			  }
			if(counter==1) {
				middleman[1][j] = face6[j][3];
			  }
			if(counter==2) {
				middleman[2][j] = face5[j][0];
			  }
			if(counter==3) {
				middleman[3][j] = face2[j][3];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face6[numberOfPanels-i-1][3] = middleman[2][i];
		    face5[numberOfPanels-i-1][0] = middleman[3][i];
		    face2[i][3] = middleman[0][i];
		    face1[i][3] = middleman[1][i];
		}
		rotate90Clockwise(face3); 
	   }

	public void Column1ClockWise() {
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face1[j][0];
			  }
			if(counter==1) {
				middleman[1][j] = face6[j][0];
			  }
			if(counter==2) {
				middleman[2][j] = face5[j][3];
			  }
			if(counter==3) {
				middleman[3][j] = face2[j][0];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face6[i][0] = middleman[0][i];
		    face5[numberOfPanels-i-1][3] = middleman[1][i];
		    face2[numberOfPanels-i-1][0] = middleman[2][i];
		    face1[i][0] = middleman[3][i];
		}
		rotate90Clockwise(face4); 
	   }

	public void Column2ClockWise() { 
	
	int counter = 0;
	String[][] middleman = new String[numberOfPanels][numberOfPanels];
	
	for(int i=0;i<numberOfPanels;i++) {
		for(int j=0;j<numberOfPanels;j++) {
		if(counter==0) {
			middleman[0][j] = face1[j][1];
		  }
		if(counter==1) {
			middleman[1][j] = face6[j][1];
		  }
		if(counter==2) {
			middleman[2][j] = face5[j][2];
		  }
		if(counter==3) {
			middleman[3][j] = face2[j][1];
		  }
		}
		counter++;
	}
	for(int i=0;i<numberOfPanels;i++) {
	    face6[i][1] = middleman[0][i];
	    face5[numberOfPanels-i-1][2] = middleman[1][i];
	    face2[numberOfPanels-i-1][1] = middleman[2][i];
	    face1[i][1] = middleman[3][i];
	}
	
   }

	public void Column3ClockWise() { 
		
	int counter = 0;
	String[][] middleman = new String[numberOfPanels][numberOfPanels];
	
	for(int i=0;i<numberOfPanels;i++) {
		for(int j=0;j<numberOfPanels;j++) {
		if(counter==0) {
			middleman[0][j] = face1[j][2];
		  }
		if(counter==1) {
			middleman[1][j] = face6[j][2];
		  }
		if(counter==2) {
			middleman[2][j] = face5[j][1];
		  }
		if(counter==3) {
			middleman[3][j] = face2[j][2];
		  }
		}
		counter++;
	}
	for(int i=0;i<numberOfPanels;i++) {
	    face6[i][2] = middleman[0][i];
	    face5[numberOfPanels-i-1][1] = middleman[1][i];
	    face2[numberOfPanels-i-1][2] = middleman[2][i];
	    face1[i][2] = middleman[3][i];
	}
	
   }

	public void Column4ClockWise() { 
		
	int counter = 0;
	String[][] middleman = new String[numberOfPanels][numberOfPanels];
	
	for(int i=0;i<numberOfPanels;i++) {
		for(int j=0;j<numberOfPanels;j++) {
		if(counter==0) {
			middleman[0][j] = face1[j][3];
		  }
		if(counter==1) {
			middleman[1][j] = face6[j][3];
		  }
		if(counter==2) {
			middleman[2][j] = face5[j][0];
		  }
		if(counter==3) {
			middleman[3][j] = face2[j][3];
		  }
		}
		counter++;
	}
	for(int i=0;i<numberOfPanels;i++) {
	    face6[i][3] = middleman[0][i];
	    face5[numberOfPanels-i-1][0] = middleman[1][i];
	    face2[numberOfPanels-i-1][3] = middleman[2][i];
	    face1[i][3] = middleman[3][i];
	}
	rotate90AntiClockwise(face3);
   }

	public void Z1ClockWise() { //done
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face2[3][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[j][3];
			  }
			if(counter==2) {
				middleman[2][j] = face6[0][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[j][0];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face6[0][numberOfPanels-i-1] = middleman[3][i];
		    face3[i][0]                  = middleman[0][i];
		    face2[3][numberOfPanels-i-1] = middleman[1][i];
		    face4[i][3]                  = middleman[2][i];
		}
		rotate90Clockwise(face1);//rotate the front face clockwise
	   }     

	public void Z2ClockWise() { //done
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face2[2][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[j][2];
			  }
			if(counter==2) {
				middleman[2][j] = face6[1][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[j][1];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face6[1][numberOfPanels-i-1] = middleman[3][i];
		    face3[i][1]                  = middleman[0][i];
		    face2[2][numberOfPanels-i-1] = middleman[1][i];
		    face4[i][2]                  = middleman[2][i];
		}
	   }

	public void Z3ClockWise() { //done
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face2[1][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[j][1];
			  }
			if(counter==2) {
				middleman[2][j] = face6[2][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[j][2];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face6[2][numberOfPanels-i-1] = middleman[3][i];
		    face3[i][2]                  = middleman[0][i];
		    face2[1][numberOfPanels-i-1] = middleman[1][i];
		    face4[i][1]                  = middleman[2][i];
		}
	   }	

	public void Z4ClockWise() { //done
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face2[0][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[j][0];
			  }
			if(counter==2) {
				middleman[2][j] = face6[3][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[j][3];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face6[3][numberOfPanels-i-1] = middleman[3][i];
		    face3[i][3]                  = middleman[0][i];
		    face2[0][numberOfPanels-i-1] = middleman[1][i];
		    face4[i][0]                  = middleman[2][i];
		}
		rotate90AntiClockwise(face5);//rotate the back face anti clockwise
	   }

	public void Z1AntiClockWise() { //done
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face2[3][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[j][3];
			  }
			if(counter==2) {
				middleman[2][j] = face6[0][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[j][0];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face2[3][i]                  = middleman[3][i];
		    face4[numberOfPanels-i-1][3] = middleman[0][i];
		    face6[0][i]                  = middleman[1][i];
		    face3[numberOfPanels-i-1][0] = middleman[2][i];
		}
		rotate90AntiClockwise(face1);//rotate the front face anti clockwise
	   }	

	public void Z2AntiClockWise() {//done 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face2[2][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[j][2];
			  }
			if(counter==2) {
				middleman[2][j] = face6[1][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[j][1];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face2[2][i]                  = middleman[3][i];
		    face4[numberOfPanels-i-1][2] = middleman[0][i];
		    face6[1][i]                  = middleman[1][i];
		    face3[numberOfPanels-i-1][1] = middleman[2][i];
		}
	   }

	public void Z3AntiClockWise() {//done 
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face2[1][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[j][1];
			  }
			if(counter==2) {
				middleman[2][j] = face6[2][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[j][2];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face2[1][i]                  = middleman[3][i];
		    face4[numberOfPanels-i-1][1] = middleman[0][i];
		    face6[2][i]                  = middleman[1][i];
		    face3[numberOfPanels-i-1][2] = middleman[2][i];
		}
	   }

	public void Z4AntiClockWise() { //done
		
		int counter = 0;
		String[][] middleman = new String[numberOfPanels][numberOfPanels];
		
		for(int i=0;i<numberOfPanels;i++) {
			for(int j=0;j<numberOfPanels;j++) {
			if(counter==0) {
				middleman[0][j] = face2[0][j];
			  }
			if(counter==1) {
				middleman[1][j] = face4[j][0];
			  }
			if(counter==2) {
				middleman[2][j] = face6[3][j];
			  }
			if(counter==3) {
				middleman[3][j] = face3[j][3];
			  }
			}
			counter++;
		}
		for(int i=0;i<numberOfPanels;i++) {
		    face2[0][i]                  = middleman[3][i];
		    face4[numberOfPanels-i-1][0] = middleman[0][i];
		    face6[3][i]                  = middleman[1][i];
		    face3[numberOfPanels-i-1][3] = middleman[2][i];
		}
		rotate90Clockwise(face5);//rotate the back face clockwise
	   }
	   

}
