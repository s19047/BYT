import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WebPage implements Serializable {
    private List<Observer> observers = new ArrayList<>();
    private URL url;
    private Date lastModified;

    WebPage(URL url) throws IOException {
        this.url = url;
        URLConnection connect = this.url.openConnection();
        long time = connect.getLastModified();
        lastModified = new Date(time);
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public URL getUrl() {
        return url;
    }

    public void monitor(int seconds) throws IOException, InterruptedException {
        while (true) {
            if(checkModified())
                execute();
            Thread.sleep(seconds * 1000);
        }
    }

    private boolean checkModified() throws IOException {
        URLConnection connect = this.url.openConnection();
        long time = connect.getLastModified();
        if( (new Date(time)).after(this.lastModified)) return true;
        return false;
    }

    private void execute() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    //mainly for testing
    public void setLastModified(Date lastModified){
        this.lastModified = lastModified;
    }
    public Date getLastModified(){
        return  lastModified;
    }
}
