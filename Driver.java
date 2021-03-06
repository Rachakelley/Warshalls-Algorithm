import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		System.out.println("Warshall's Algorithm\n"
				+ "---------------------");
		System.out.println("Enter the size n of the set\n");
		int n = keyIn.nextInt();

		System.out.println("Enter the nxn matrix");
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; i++)
		    for (int j = 0; j < n; j++)
			graph[i][j] = keyIn.nextInt();

		System.out.println();
		// Displaying the beginning matrix. (unchanged matrix input)
		System.out.println("W0 =");
		display(graph);

		// Warshall's algorithm for finding the transitive closure.
		// Prints all intermediate matrices W1 through Wn.
		for(int count = 0; count < graph.length; count++) {
			for(int row = 0; row < graph.length; row++)
				for(int col = 0; col < graph.length; col++)
					if(graph[row][count] == 1 && graph[count][col] == 1)
						graph[row][col] = 1;

			if(count == graph.length - 1)
				System.out.println("W" + (count + 1) + " = W* =");
			else
				System.out.println("W" + (count + 1) + " =");
			display(graph);
	    	}
	}

	public static void display(int[][] graph) {
		int n = graph.length;
		System.out.print(" ");
	    	for (int col = 0; col < n; col++)
	    		System.out.print("  " + col);
	    	System.out.println();
	    	for (int col = 0; col < n; col++) {
			System.out.print(col + " ");
		for (int row = 0; row < n; row++) {
			if (graph[col][row] != 0) 
				System.out.print(" 1 ");
			else                  
			System.out.print(" 0 ");
		}
		System.out.println();
	    }
	    System.out.println();
	}
}
