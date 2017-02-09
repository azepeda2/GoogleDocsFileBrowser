
public class Driver {

	public static void main(String[] args) {
		
		if(args.length != 1) { 
			//if doesn't have a command line input it will exit
			System.out.println("Error: Please enter just one input through " +
					"command line. The absolute path to the directory.");
			System.exit(0);
		}
		FileBrowser f = new FileBrowser();
		String path = args[0];
		if(!f.buildList(path)) {
			System.exit(0);
		}
		f.viewDocs();
	}
	
}
