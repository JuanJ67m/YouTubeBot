import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkException;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;

public class Authenticator {
	
	public AuthHelper authenticate() throws NetworkException, OAuthException{
		AuthHelper helper = new AuthHelper();
		UserAgent myUserAgent = UserAgent.of("desktop", "YouTubeBot", "0.1", "-YouTubeBot-");
		RedditClient redditClient = new RedditClient(myUserAgent);
		Credentials credentials = Credentials.script("-YouTubeBot-", "Ash3win#", "WnBQphrJ2jWY5A", "bJmaYXBDHUNfPGRpSEUPHOtLrIk");
		OAuthData authData = redditClient.getOAuthHelper().easyAuth(credentials);
		redditClient.authenticate(authData);
		helper.setCredentials(credentials);
		helper.setRedditClient(redditClient);
		return(helper);
	}

}
