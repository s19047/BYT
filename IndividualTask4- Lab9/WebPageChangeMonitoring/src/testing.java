import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URLConnection;
import java.util.Date;
import static org.mockito.Mockito.when;


public class testing {
/*
    class WebObserverTest {
        URLConnection connection;
        WebPage website;
        Observer observer;

        @Test
        void test() throws IOException, InterruptedException {
            connection = Mockito.mock(URLConnection.class);

            String[] urls = {"https://almonds.000webhostapp.com/","http://www.facebook.com","http://www.instagram.com"};
            ChangeChecker changeChecker = new ChangeChecker(urls);
            changeChecker.monitor("all",30);

            website.setModifiedDate(1L);
            Date date = new Date();
            when(connection.getLastModified()).thenReturn(date.getTime());
            website.setModifiedDate(connection.getLastModified());
            Date date1 = new Date();

            Assertions.assertEquals(observer.getModified(),date);
            Assertions.assertNotEquals(observer.getModified(),date1);
        }
    }
**/
}