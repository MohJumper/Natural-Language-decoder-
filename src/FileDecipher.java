import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDecipher {
	
	private static final int INDEX_ZERO = 0;
	private static final int INDEX_ONE = 1;
	
	private BinaryTree bt;
	private final String  SPACING;

	public static void main(String[] args) {
		FileDecipher fd = new FileDecipher();
		fd.readFileAndPopulateTree("words.txt");
		fd.readEncodedSymbolsAndDisplay("encoded.txt");
	}
	
	public FileDecipher() {
		bt = new BinaryTree();
		SPACING = " ";
	}
	
	/**
	 * Private method that decode the string of signs based of the populated tree of words.
	 * @param file txt of encoded symbols of - and + 
	 */
	private void readEncodedSymbolsAndDisplay(String file) {
		Scanner scnr;
		try {
			scnr = new Scanner(new File(file));
			
			while(scnr.hasNext()) {
				String line = scnr.nextLine();
				String[] expr = line.split(" ");
				for(int i = 0; i < expr.length; i++) {
					String ret_val = bt.decodeExpression(expr[i]);
					System.out.print(ret_val + SPACING);
				}
				System.out.println("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	} // ------------------- end of readFile method
	
	/**
	 * This private method take txt file that contains words with single space and signs in each lines
	 * to pass the strings of word and sign(s) to the method insert that populate the binary tree.
	 * @param file txt of words and signs.
	 */
	private void readFileAndPopulateTree(String file) {
		Scanner scnr;
		
		try {
			scnr = new Scanner(new File(file));
			
			while(scnr.hasNext()) {
				String line = scnr.nextLine();
				String[] expr = line.split(" ");
				String word = expr[INDEX_ZERO];
				String signs = expr[INDEX_ONE];
				bt.insert(word, signs);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	} // ------------------- end of populate tree method method

}
