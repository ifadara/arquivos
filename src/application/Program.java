package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();

		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			String line = br.readLine();
			while(line != null) {
				String[] content = line.split(",");
				String name = content[0];
				double value = Double.parseDouble(content[1]);
				int quantity = Integer.parseInt(content[2]);
				Product product = new Product(name, value, quantity);
				list.add(product);
				System.out.println(product.toString());
				line = br.readLine();
			}
			
			
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){
				for (Product product : list) {
					bw.write(product.toString());
					bw.newLine();
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
