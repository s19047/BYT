import java.io.IOException;
import java.util.Date;


public class Main {
    public static void main( String[] args ) throws IOException, InterruptedException {
        String[] urls = {"https://almonds.000webhostapp.com/","http://www.facebook.com","http://www.instagram.com"};
        ChangeChecker changeChecker = new ChangeChecker(urls);
        changeChecker.monitor("all",30);

        //
        Date date = new Date();
        changeChecker.getWebpages().get(0).setLastModified(date);
        System.out.println(changeChecker.getWebpages().get(0).getLastModified());
        System.out.println(date);
        
        //Saving
        MemorySaver memorySaver = new MemorySaver();
        memorySaver.saveToFile(changeChecker.getWebpages());

    }
}