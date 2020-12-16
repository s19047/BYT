import java.net.URL;

public class EnglishObserver extends Observer {
    public EnglishObserver(URL url) {
        this.url = url;
    }

    public void update() {
        System.out.print("I observed a change for the following webpage: " + url.getHost());
    }
}
