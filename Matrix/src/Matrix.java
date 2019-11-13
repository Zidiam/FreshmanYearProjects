/*
 * Matrix.java -- A general nxm matrix class for Java
 */
public class Matrix {
	public Matrix() {
		//does nothing
	}
	
	public double[][] matrixMultiply(double[][] first, double[][] second){
		double[][] temp = new double[3][3];
		double tempint;
		
		//Multiplying Transition Matrix with Rotation Matrix
		for(int row = 0; row < temp.length; row++) {
			for(int col = 0; col < temp[row].length; col++) {
				tempint = 0;
				for(int x = 0; x < 3; x++) {
					tempint += first[row][x] * second[x][col];
				}
				temp[row][col] = tempint;
			}
		}
		return temp;
	}
	
	public double[] vectorMultiply(double[] vectorArray, double[][] transformation) {
		//check this after
		double[] result = new double[3];
		double tempint = 0;
		for(int x = 0; x < 3; x++) {
			tempint = 0;
			for(int col = 0; col < 3; col++) {
				tempint+= transformation[x][col] * vectorArray[col];
			}
			result[x] = tempint;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Matrix test = new Matrix();
		
		TransMatrix t = new TransMatrix(250, 250);
		TransMatrix nt = new TransMatrix(-250, -250);
		RotMatrix rm = new RotMatrix(Math.PI/(200));
		
		double[][] translation = t.getTransMatrix();
		double[][] negtranslation = nt.getTransMatrix();
		double[][] rotation = rm.getRotMatrix();
		
		double[][] transformation = test.matrixMultiply(test.matrixMultiply(translation, rotation), negtranslation); 
		
		
	}
	
	
}
