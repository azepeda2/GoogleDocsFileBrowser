import java.io.File;


public class FileBrowser {
	
	private DocumentList dl;
	private DocUploader du;
	
	public FileBrowser() {
		this.dl = new DocumentList();
		this.du = new DocUploader();
	}
	
	public boolean buildList(String path) {
		// helper method that takes in path and calls buildList 
		// input is a valid path
		File file = new File(path);
		if(!file.isDirectory()) {
			// if path is not a directory, exits program
			System.out.println("Path is not valid. Could not build " +
					"list program now exitting.");
			return false;
		} else {
			buildList(file);
		}
		return true;
	}
	
	private boolean buildList(File path) {
		
		File[] fileList = path.listFiles();
		//creates a array of the items in the current directory
		Document d;
		for(File file: fileList) {
			if(file.isDirectory()) { 
				//if file is a directory, traverses through the directory
				//calling buildList recursively
				buildList(file);
			} else {	
				if(file.isFile()) { 
					//creates document for files and adds all files to DocumentList
					d = new Document(file);
					dl.add(d);	
				}
			}
		}
		return true;
	}

	public void viewDocs() {
		UI ui = new UI(dl);
		int choice = ui.getChoice();
		while(choice != 5) {
			if(choice == 1) {
				dl.sortByDate();
				dl.print();
			} else if(choice == 2) {
				dl.sortByName();
				dl.print();
			} else if(choice == 3) {
				String pattern = ui.getPattern();
				dl.printMatches(pattern);
			} else if(choice == 4) {
				UploadInfo upinfo= ui.getUploadInfo();
				du.uploadDoc(upinfo);
			}
			choice = ui.getChoice();
		}
		System.out.println("Chose exit. Program is now exitting.");
	}

}
