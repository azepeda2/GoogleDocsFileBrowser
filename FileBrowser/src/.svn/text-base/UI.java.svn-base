import java.util.Scanner;


public class UI {
	
	private DocumentList list;
	
	public UI(DocumentList list) {
		this.list = list;
	}
	
	public int getChoice() {
		//prompts and scans for choice
		Scanner scan = new Scanner(System.in);
		int choice;
		System.out.println("Enter a choice: ");
		System.out.println("[1] List all sorted by date");
		System.out.println("[2] List all sorted by file name");
		System.out.println("[3] List all containing pattern");
		System.out.println("[4] Upload to google docs (only txt upload supported)");
		System.out.println("[5] Exit");
		choice = scan.nextInt();
		while(choice < 1 || choice > 5) {
			//ensures the choice entered is a valid choice (1-5)
			System.out.println("Please enter a choice from 1-5!");
			choice = scan.nextInt();
		}
		return choice;
	}
	
	public String getPattern() {
		//prompts and scans for a pattern to look for
		Scanner scan = new Scanner(System.in);
		String pattern;
		System.out.println("Enter a pattern to look for: ");
		pattern = scan.next();
		System.out.println(pattern);
		return pattern;
	}
	
	public UploadInfo getUploadInfo() {
		//prompts and scans for username, password, and fileid
		Scanner scan = new Scanner(System.in);
		String username, password, filepath;
		int fileid;
		System.out.println("Enter username: ");
		username = scan.next();
		System.out.println("Enter password: ");
		password = scan.next();
		this.list.printEndsWith(".txt"); 
		//displays only txt files
		System.out.println("Enter number for the file you want: ");
		fileid = scan.nextInt(); 
		filepath = list.get(fileid - 1).getAbsolutePath(); 
		// fileid-1 to adjust for document list starting at 0  
		UploadInfo upinfo = new UploadInfo(username, password, filepath);
		return upinfo;
	}

}
