import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;

import net.dean.jraw.ApiException;
import net.dean.jraw.http.NetworkException;
import net.dean.jraw.models.Submission;

public class YouTubeBot implements Runnable {
	
	static BufferedReader in ;  
	static int quit=0;
	
	public void run(){
		String input = null;
        while(true){
        	try {
        		input = in.readLine();
            } catch(Exception e) {}
            if(input.equals("Q")) {
            	quit = 1;
            	System.exit(0);
            	//break;
            }
        }
    }

	public static void main(String[] args) throws IOException, NetworkException, ApiException {
		in=new BufferedReader(new InputStreamReader(System.in));
		Thread t = new Thread(new YouTubeBot());
        t.start();
        String link;
        String pageSource;
        String youtubeLink;
        Submission sub;
        ArrayList<String> pageSources = new ArrayList<String>();
        ArrayList<String> oldPageSources = new ArrayList<String>();
        ArrayList<Submission> oldSubmissions = new ArrayList<Submission>();
        AuthHelper helper = new AuthHelper();
		Parser P = new Parser();
		Downloader D = new Downloader();
		Scanner S = new Scanner();
		Authenticator A = new Authenticator();
		Uploader U = new Uploader();
		Commenter C = new Commenter();
		helper = A.authenticate();
		Timer timer = new Timer();
		long refreshTime = 350000;
		timer.schedule(new Refresher(helper), refreshTime);
		System.out.println("OK1");
		while(true){
			pageSources = S.scanReddit(helper, pageSources);
			Iterator<String> pageSourcesIterator = pageSources.iterator();
			Iterator<Submission> submissionsIterator = Scanner.submissionList.iterator();
			if(!pageSources.isEmpty()){
				System.out.println("OK3");
				while(pageSourcesIterator.hasNext() && submissionsIterator.hasNext()){
					System.out.println("OK4");
					pageSource = pageSourcesIterator.next();
					sub = submissionsIterator.next();
					if(!oldPageSources.contains(pageSource)){
						oldPageSources.add(pageSource);
						link = P.parseSource(pageSource);
						D.downloadVideo(link);
						youtubeLink=U.upload(sub.getTitle(), sub.getUrl(), link);
						if(!oldSubmissions.contains(sub)){
							oldSubmissions.add(sub);
							C.comment(helper, sub, youtubeLink);	
						}
					}
				}
			}
		}
	}

}
