package com.FileManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FileManagement {

	public static boolean success = false;
	public static String directory = "FileManagementDirectory";
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("Product: FileManagement.com");
		System.out.println("Developer: Subhadip Podder");

		try {
			while (true) {
				System.out.println("Enter either of one option, either 1, 2 or 3");
				System.out.println("Option 1: Sort files in ascending order");
				System.out.println("Option 2: Add, Delete or Search a file");
				System.out.println("Option 3: Exit");

				int choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:
					sortFileName();
					System.out.println("Enter 1 to return to main menu:");
					System.out.println("Enter any other key to exit");
					int i = Integer.parseInt(br.readLine());
					if (i == 1) {
						break;
					} else {
						System.out.println("Existing...");
						System.out.println("Application Stopped");
						System.exit(0);
					}
				case 2:
					System.out.println("Option 1: Add File");
					System.out.println("Option 2: Delete File");
					System.out.println("Option 3: Search File");

					int option = Integer.parseInt(br.readLine());
					if (option == 1) {
						addFile();
						System.out.println("Enter 1 to return to main menu:");
						System.out.println("Enter any other key to exit");
						int k = Integer.parseInt(br.readLine());
						if (k == 1) {
							break;
						} else {
							System.out.println("Existing...");
							System.out.println("Application Stopped");
							System.exit(0);
						}
					} else if (option == 2) {
						deleteFile();
						System.out.println("Enter 1 to return to main menu:");
						System.out.println("Enter any other key to exit");
						int k = Integer.parseInt(br.readLine());
						if (k == 1) {
							break;
						} else {
							System.out.println("Existing...");
							System.out.println("Application Stopped");
							System.exit(0);
						}
					} else if (option == 3) {
						searchFile();
						System.out.println("Enter 1 to return to main menu:");
						System.out.println("Enter any other key to exit");
						int k = Integer.parseInt(br.readLine());
						if (k == 1) {
							break;
						} else {
							System.out.println("Existing...");
							System.out.println("Application Stopped");
							System.exit(0);
						}
					} else {
						System.out.println("Invalid Option");
					}
					break;
				case 3:
					System.out.println("Existing...");
					System.out.println("Application Stopped");
					System.exit(0);
				default:
					System.out.println("Invalid option");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addFile() throws IOException {

		System.out.println("Enter File Name:");
		String fileName = br.readLine().toUpperCase();

		File f1 = new File(directory);
		f1.mkdir();
		File myFile = new File(directory + "/" + fileName + ".txt");

		if (myFile.exists()) {
			System.out.println("File already exist");
		} else {
			success = myFile.createNewFile();
		}

		if (success) {
			System.out.println("File Created Sucessfully.");
		}
	}

	public static void deleteFile() throws IOException {

		System.out.println("Enter File Name:");
		String fileName = br.readLine().toUpperCase();

		File f1 = new File(directory);
		f1.mkdir();
		File myFile = new File(directory + "/" + fileName + ".txt");

		if (myFile.exists()) {
			if (myFile.delete()) {
				System.out.println("Deleted the file: " + myFile.getName());
			} else {
				System.out.println("Unable to delete file");
			}
		} else {
			System.out.println("File Not Found");
		}
	}

	public static void searchFile() throws IOException {

		System.out.println("Enter File Name:");
		String fileName = br.readLine().toUpperCase();

		File f1 = new File(directory);
		f1.mkdir();
		File myFile = new File(directory + "/" + fileName + ".txt");

		if (myFile.exists()) {
			System.out.println("File present");
		} else {
			System.out.println("File Not Found");
		}
	}

	public static void sortFileName() {

		File dir = new File(directory);
		dir.mkdir();

		File[] files = dir.listFiles();
		if (files.length == 0) {
			System.out.println("No file present");
		} else {
			System.out.println("Files in ascending order: ");
			Arrays.sort(files, (f1, f2) -> f1.compareTo(f2));

			for (File file : files) {
				System.out.println(file.getName());
			}
		}
	}
}
