package assessmentjava1;

import java.util.Scanner;

public class WelcomeOptions {

	public void welcometoproject() {
		FileOperations objnew = new FileOperations();
		objnew.printOptions();
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		try {
			switch (n) {
			case 1:
				System.out.println("Files names:");
				FileOperations obj = new FileOperations();
				obj.getAllFiles();
				System.out.println("Closing the program");
				System.exit(0);
				break;
			case 2:
				System.out.println("Show more options:");
				FileOperations objbusiness = new FileOperations();
				int option = objbusiness.PrintBusinessOptions();
				switch (option) {
				case 1:
					System.out.println("Enter file name:");
					Scanner scr1 = new Scanner(System.in);
					String fileName = scr1.next();
					System.out.println("Enter data to store in file");
					String data = scr1.next();
					FileOperations add = new FileOperations();
					add.addFile(fileName, data);
					break;
				case 2:
					System.out.println("Enter file name with proper extension of file");
					Scanner scr2 = new Scanner(System.in);
					String fileNew = scr2.next();
					FileOperations delete = new FileOperations();
					delete.deleteFile(fileNew);
					break;
				case 3:
					System.out.println("Enter file name with proper extension of file");
					Scanner scr3 = new Scanner(System.in);
					String fileforsearch = scr3.next();
					FileOperations search = new FileOperations();
					search.searchFiles(fileforsearch);
					break;
				case 4:
					WelcomeOptions opt = new WelcomeOptions();
					opt.welcometoproject();
					break;
				}
			case 3:
				System.out.println("Closing the program");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option selected");
				break;

			}
		} catch (Exception e) {
			System.out.printf("Exception while providing input::", e);
		}
	}

}
