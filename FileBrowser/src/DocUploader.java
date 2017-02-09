import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;


public class DocUploader {

    public boolean uploadDoc (UploadInfo upinfo) {
        
        String username = upinfo.getUsername();
        String password = upinfo.getPassword();
        String filepath = upinfo.getFilepath();

        //Create a new DocsService object to connected to gdata service
        DocsService service = new DocsService("Uploader");
        try {
            //login with username/password provided
            service.setUserCredentials(username, password);
        } catch (AuthenticationException e) {
            //oops, bad username or password
            //exit the program
            //e.printStackTrace();
            System.out.println("File did not upload! Invalid username/password.");
            return false;
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
        //newDocument.setTitle(new PlainTextConstruct(title)); if not used, doc uploaded keeps name

        try {
            //upload the document
            newDocument = service.insert(new URL("https://docs.google.com/feeds/default/private/full/"), newDocument);
            //if there are any problems, catch the exception and exit
        } catch (MalformedURLException e) {
            //e.printStackTrace();
            System.out.println("File did not upload! Bad URL");
            return false;
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("File did not upload! IO Problem");
            return false;
        } catch (ServiceException e) {
            //e.printStackTrace();
            System.out.println("File did not upload! Service Problem");
            return false;
        }
            
        //print a confirmation that the file was uploaded and display the URL of the document
        System.out.println("File uploaded successfully! Document now online @ :" + newDocument.getDocumentLink().getHref());
        return true;
    }

}
