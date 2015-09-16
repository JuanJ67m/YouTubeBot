import java.util.ArrayList;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkException;
import net.dean.jraw.http.oauth.OAuthException;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.paginators.Sorting;
import net.dean.jraw.paginators.SubredditPaginator;
import net.dean.jraw.paginators.TimePeriod;

public class Scanner {
	
	static ArrayList<Submission> submissionList = new ArrayList<Submission>();

	public ArrayList<String> scanReddit(AuthHelper helper, ArrayList<String> links) throws NetworkException, OAuthException {
		RedditClient redditClient = helper.getRedditClient();
		SubredditPaginator doto = new SubredditPaginator(redditClient,"dota2");
		doto.setLimit(100);                    
		doto.setTimePeriod(TimePeriod.ALL);
		doto.setSorting(Sorting.NEW); 
		Listing<Submission> submissions = doto.next();
		String linkUrl = null;
		System.out.println("OK2");
		for(Submission s : submissions){
			linkUrl = s.getUrl();
			System.out.println(linkUrl);
			if(linkUrl.contains("oddshot") && !links.contains(linkUrl)){
				Scanner.submissionList.add(s);
				links.add(linkUrl);
			}
		}
		return links;
	}	
	
	
}
