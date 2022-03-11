package assessmentjava1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FileOperations {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sortFiles() {

		File folder = new File("C:\\Users\\JUI\\Desktop\\assess");
		if (folder.isDirectory()) {
			File[] fileList = folder.listFiles();
		
			Arrays.sort(fileList, new Comparator() {

				@Override
				public int compare(Object f1, Object f2) {
					// TODO Auto-generated method stub
					return ((File) f1).getName().compareTo(
							((File) f2).getName());
				}

			});
			for (File file : fileList) {
				System.out.println(file.getName());
			}
		}

	}
	public void getAllFiles() {
		File folder = new File("C:\\Users\\JUI\\Desktop\\assess");
		if (folder.isDirectory()){
			File[] fileList = folder.listFiles();
			for (File file : fileList) {
				System.out.println(file.getName());
			}
		}
	}
	public void printOptions(){
		System.out.println("Welcome to Locker.me");
		System.out.println("Developed By : Jui Ambre");
		System.out.println("Please select below options:");
		System.out.println("Press 1.Retrieve Files");
		System.out.println("2.More business operations");
		System.out.println("3.Close program");
	}
	public int PrintBusinessOptions(){
		Scanner scr=new Scanner(System.in);
		System.out.println("Press 1.Add File");
		System.out.println("2.Delete File");
		System.out.println("3.Search File");
		System.out.println("4.Move to Parent");
		int option=scr.nextInt();
		return option;
	}
	public void addFile(String filename,String data){
		Path d=Paths.get("C:\\Users\\JUI\\Desktop\\assess");
		Path f=Paths.get(filename);
		
		try{
			if(! Files.exists(d)){
				Files.createDirectory(d);
				System.out.println("Directory created");
			}else{
				System.out.println("Directory already exists");
			}
		}catch(Exception e){
			System.out.println(e);
		}
		Path f1=Paths.get(d.toString(),f.toString());
		//System.out.println(f1);
		try{
			if(! Files.exists(f1)){
				Files.createFile(f1);
				System.out.println(f1+" created");
				FileWriter fw = new FileWriter(f1.toString());
				System.out.println(fw.toString());
				BufferedWriter bw = new BufferedWriter(fw);
		        bw.write(data);
		        bw.close();
			    System.out.println("Successfully wrote to the file.");
			}else{
				System.out.println(f1+" already exists");
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	public void deleteFile(String filename){
		Path d=Paths.get("C:\\Users\\JUI\\Desktop\\assess");
		Path f=Paths.get(filename);
		Path pathdelete=Paths.get(d.toString(),f.toString());
		try{
			Files.delete(pathdelete);
			System.out.println("File deleted.");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public void searchFiles(String fileName){
		File folder = new File("C:\\Users\\JUI\\Desktop\\assess");
		boolean flag=true;
		if (folder.isDirectory()){
			File[] fileList = folder.listFiles();
			for (File file : fileList) {
				if(file.getName().equalsIgnoreCase(fileName)){
					System.out.println(fileName+"File found in directory");
					flag=false;
				}
			}
			if(flag){
				System.out.println("File not found in directory.");
			}
		}
	}

}
