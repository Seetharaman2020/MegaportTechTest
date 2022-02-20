import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Megaport{
	public static void main(String[] args) throws IOException{
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
		System.out.print("Enter a filename to be sorted: ");
		String fileName= sc.nextLine(); //reads string.
		Megaport sortingNames = new Megaport();
		sortingNames.sortNames(fileName);
		sc.close();
	}
	
	public ArrayList<String> sortNames(String fileName) throws IOException {
		
		if (fileName!= null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\seeth\\eclipse-workspace\\Megaport-TechTest\\src\\" + fileName));
				ArrayList<String> string = new ArrayList<>();
				String line = "";
				
				//parse through the file and add contents to string
				while((line=reader.readLine())!=null){
					char[] chars = line.toCharArray();
					for (char c : chars) {
						if(! (Character.isAlphabetic(c) || c == ',' || c == ' ')) {
							reader.close();
							throw new IllegalArgumentException("File should contain valid names only.");
						}
					}
					string.add(line);
				}
				reader.close();
				//java collections has functionality to sort
				Collections.sort(string);
					
				//transfer results to a new file.
				FileWriter writer = new FileWriter("names-sorted.txt");
				for(String s: string){
					writer.write(s);
					writer.write("\r\n");
				}
				writer.close();
					
				//Output notification
				System.out.println("Finished. Created names-sorted.txt");

				return string;
				}
			catch (FileNotFoundException ex) {
			    throw new FileNotFoundException("File not found. Invalid input.");
			}
		}
		
		return null;
		
	}
}

