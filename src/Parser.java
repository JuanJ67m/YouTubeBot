import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Parser{
	
	public String parseSource(String url) throws IOException{
        String link = null;
		Document document = Jsoup.connect(url).get();
        Elements files = document.select("source[src$=.mp4]");
        for(Element src : files){
        	link=src.attr("abs:src");
        }
        return link;
	}
	
}
