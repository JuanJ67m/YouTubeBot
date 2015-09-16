import java.util.TimerTask;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkException;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;

public class Refresher extends TimerTask {
	
	RedditClient redditClient;
	Credentials credentials;
	public Refresher(AuthHelper helper){
		redditClient = helper.getRedditClient();
		credentials = helper.getCredentials();
	}
	
	public void run() {
		OAuthData newAuthData = null;
		try {
			newAuthData = redditClient.getOAuthHelper().refreshToken(credentials);
		} catch (NetworkException e) {
			e.printStackTrace();
		} catch (OAuthException e) {
			e.printStackTrace();
		}
		redditClient.authenticate(newAuthData);
	}
	
}
