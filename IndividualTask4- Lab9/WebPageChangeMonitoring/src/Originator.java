import java.io.IOException;
import java.util.List;

/**
public class Originator {
    private String[] urls;
    public String mode;
    public int seconds;

    public Originator(String[] urls, String mode, int seconds){
        this.urls = urls;
        this.mode = mode;
        this.seconds = seconds;
    }

    public Memento save() throws IOException, InterruptedException {
        ChangeChecker changeChecker = new ChangeChecker(urls);
        changeChecker.monitor(mode,seconds);
        return new Memento(changeChecker.getWebpages());
    }
} **/
