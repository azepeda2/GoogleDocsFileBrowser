import java.io.File;
import java.util.Calendar;


public class Document {
    
    private Calendar c;
    private File f;
    private java.util.Date date;
    
    public Document(File f) {
        this.f = f;
        this.c = Calendar.getInstance();
        this.c.setTimeInMillis(f.lastModified());
        this.date = c.getTime();
    }
    
    public long lastModified() {
        return this.c.getTimeInMillis();
    }
    
    public String getName() {
        return this.f.getName();
    }
    
    public String getAbsolutePath() {
        return this.f.getAbsolutePath();
    }
    
    public String toString() {
        return (this.f.toString() + "  " + this.date.toString());
    }
}