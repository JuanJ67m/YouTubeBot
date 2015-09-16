import net.dean.jraw.RedditClient;
import net.dean.jraw.http.oauth.Credentials;

public class AuthHelper {
	RedditClient redditClient;
	Credentials credentials;
	public void setRedditClient(RedditClient redditClient) {
		this.redditClient = redditClient;
	}
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	public RedditClient getRedditClient() {
		return redditClient;
	}
	public Credentials getCredentials() {
		return credentials;
	}
	
	
}
