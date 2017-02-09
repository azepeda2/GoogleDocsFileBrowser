import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;


public class DocsUploadSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		/*
		 * For testing, program expects 4 commandline arguments.
		 */
		if(args.length != 4) {
			System.out.println("usage: java DocsUploadSample <username> <password> <filename> <documenttitle>");
			System.exit(1);
		}

		//Create temp variables to store relevant data passed in at commandline
		String username = args[0];
		String password = args[1];
		String filepath = args[2];
		String title = args[3];

		//Create a bew DocsService object to connected to gdata service
		DocsService service = new DocsService("Uploader");
		try {
			//login with username/password provided
			service.setUserCredentials(username, password);
		} catch (AuthenticationException e) {
			//oops, bad username or password
			//exit the program
			e.printStackTrace();
			System.out.println("Invalid username/password");
			System.exit(1);
		}


		//create a new java.io.File object
		File file = new File(filepath);
		//get the mime type of the file provided
		String mimeType = DocumentListEntry.MediaType.fromFileName(file.getName()).getMimeType();

		//Create a new entry
		DocumentListEntry newDocument = new DocumentListEntry();
		//pass in the file and the mime type
		newDocument.setFile(file, mimeType);
		//set the title -- this is the title that will appear in google docs
		newDocument.setTitle(new PlainTextConstruct(title));

		try {
			//upload the document
			newDocument = service.insert(new URL("https://docs.google.com/feeds/default/private/full/"), newDocument);
			//if there are any problems, catch the exception and exit
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Bad URL");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Problem");
			System.exit(1);
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println("Service Problem");
			System.exit(1);
		}
			
		//print a confirmation that the file was uploaded and display the URL of the document
		System.out.println("Document now online @ :" + newDocument.getDocumentLink().getHref());

	}

}
