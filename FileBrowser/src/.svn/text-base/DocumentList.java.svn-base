import java.util.ArrayList;

@SuppressWarnings("serial")
public class DocumentList extends ArrayList<Document>{
    
    
    public String getAbsolutePath(int fileid) {
        return this.get(fileid).getAbsolutePath();
    }
    
    public void sortByName() {
    	int n = this.size();
    	for(int i = 1; i < n; i++){
    		Document temp = this.get(i);
    	    int j = i;
    	    while(j > 0 && temp.getAbsolutePath().compareToIgnoreCase(
    	    		this.getAbsolutePath(j - 1)) < 0) {
    	    	//compares documents by their absolute pathname and
    	    	//keeps shifting items over until it finds the place for document
    	    	//in arraylist(i) then sets its location after the while loop
    	    	this.set(j, this.get(j - 1));
    	    	j--;
    	    }
    	    this.set(j, temp); 
    	}
  }
    
    public void sortByDate() {
    	int n = this.size();
    	for(int i = 1; i < n; i++){
    		Document temp = this.get(i);
    	    int j = i;
    	    while(j > 0 && temp.lastModified() < this.get(j - 1).lastModified()) {
    	    	//compares documents by (long) lastdatemodified in milliseconds
    	    	//keeps shifting items over until it finds the place for document
    	    	//in arraylist(i) then sets its location after the while loop
    	    	this.set(j, this.get(j - 1));
    	    	j--;
    	    }
    	    this.set(j, temp); 
    	}
  }
    		
    	    
    
    public void printMatches(String pattern) {
    	for(int i = 0; i < this.size(); i++) {
            String file = this.get(i).getName();
            int index = file.indexOf(pattern);
            if(index >= 0) { 
            	//true if pattern is in file name, -1 false otherwise
                System.out.println("[" + (i + 1) + "] " + this.get(i).toString());
            }
        }
    	System.out.println("------------------");
    }
    
    public void printEndsWith(String pattern) {
        for(int i = 0; i < this.size(); i++) {
            String file = this.get(i).getName();
            if(file.length() >= 4) { 
            	//checks to see if filename is valid: at least 4 char
            	file = file.substring(file.length()-4);
            	if(file.equals(pattern)) {
                System.out.println("[" + (i + 1) + "] " + this.get(i).toString());
            	}
            }
        }
        System.out.println("------------------");
    }
    
    public void print() {
        for(int i = 0; i < this.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + this.get(i).toString());
        }
        System.out.println("------------------");
    }
    
    
}