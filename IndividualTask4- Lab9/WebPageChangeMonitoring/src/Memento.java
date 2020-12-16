import java.util.List;

public class Memento  {
    private List<WebPage> webpages ;

    public Memento(List<WebPage> webpages){
        this.webpages = webpages;
    }

    public List<WebPage> getWebPages(){
        return webpages;
    }

}
