import java.net.URL;

public class PolishObserver extends Observer {
    public PolishObserver(URL url) {
        this.url = url;
    }

    public void update() {
        System.out.print("Zauważyłem zmianę w tej witrynie: " + url.getHost());
    }
}
