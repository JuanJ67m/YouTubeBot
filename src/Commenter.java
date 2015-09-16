import net.dean.jraw.ApiException;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkException;
import net.dean.jraw.managers.AccountManager;
import net.dean.jraw.models.Submission;

public class Commenter {
	
	public void comment(AuthHelper helper, Submission s, String youtubeLink) throws NetworkException, ApiException{
		RedditClient redditClient = helper.getRedditClient();
		AccountManager am = new AccountManager(redditClient);
		am.reply(s,"[View on YouTube]("+youtubeLink+")");
	}

}
