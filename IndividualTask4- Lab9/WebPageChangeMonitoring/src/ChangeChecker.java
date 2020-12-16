import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class ChangeChecker {
    private List<WebPage> webpages = new ArrayList<>();

    ChangeChecker(String[] urls) throws IOException {
        for(int i =0; i < urls.length; i++){
            WebPage webpage = new WebPage(new URL(urls[i]));
            webpages.add(webpage);
        }
    }
    public List<WebPage> getWebpages(){
        return webpages;
    }

    public void monitor(String language, int seconds) throws IOException, InterruptedException {
        for ( WebPage webpage : webpages) {
            switch (language) {
                case "EN":
                    webpage.addObserver(new EnglishObserver(webpage.getUrl()));
                    webpage.monitor(seconds);
                    break;
                case "PL":
                    webpage.addObserver(new PolishObserver(webpage.getUrl()));
                    webpage.monitor(seconds);
                    break;
                default:
                    webpage.addObserver(new EnglishObserver(webpage.getUrl()));
                    webpage.addObserver(new PolishObserver(webpage.getUrl()));
                    webpage.monitor(seconds);
                    break;
            }
        }

        /** Different implementation:
         public void monitorInEnglish(int seconds) throws IOException, InterruptedException {
         for ( Webpage webpage : webpages) {
         webpage.addObserver(new EnglishObserver(webpage.getUrl()));
         webpage.monitor(seconds);
         }
         }
         public void monitorInPolish(int seconds) throws IOException, InterruptedException {
         for ( Webpage webpage : webpages) {
         webpage.addObserver(new PolishObserver(webpage.getUrl()));
         webpage.monitor(seconds);
         }
         }
         public void monitorInAllLanguages(int seconds) throws IOException, InterruptedException {
         for ( Webpage webpage : webpages) {
         webpage.addObserver(new EnglishObserver(webpage.getUrl()));
         webpage.addObserver(new PolishObserver(webpage.getUrl()));
         webpage.monitor(seconds);
         }
         } **/
    }
}
