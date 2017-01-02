import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.UserStreamListener;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class DFTwitterBot{
	private static TwitterStream twitterStream;
	private static Twitter twitter;
	static UserStreamListener userStreamListener = new UserStreamListener() {
		
		@Override
		public void onException(Exception arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onTrackLimitationNotice(int arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onStatus(Status arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onStallWarning(StallWarning arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onScrubGeo(long arg0, long arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onDeletionNotice(StatusDeletionNotice arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUserSuspension(long arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUserProfileUpdate(User arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUserListUpdate(User arg0, UserList arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUserListUnsubscription(User arg0, User arg1, UserList arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUserListSubscription(User arg0, User arg1, UserList arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUserListMemberDeletion(User arg0, User arg1, UserList arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUserListMemberAddition(User arg0, User arg1, UserList arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUserListDeletion(User arg0, UserList arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUserListCreation(User arg0, UserList arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUserDeletion(long arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUnfollow(User arg0, User arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUnfavorite(User arg0, User arg1, Status arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onUnblock(User arg0, User arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onRetweetedRetweet(User arg0, User arg1, Status arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onQuotedTweet(User arg0, User arg1, Status arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onFriendList(long[] arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onFollow(User arg0, User arg1) {
			// TODO Auto-generated method stub	
			System.out.println(arg0.getName());
			System.out.println(" \n" +arg1.getName());
				
		}
		
		@Override
		public void onFavoritedRetweet(User arg0, User arg1, Status arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onFavorite(User arg0, User arg1, Status arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onDirectMessage(DirectMessage arg0) {
			// TODO Auto-generated method stub
			
			try {
				if(twitter.getScreenName().equals(arg0.getSenderScreenName()))
						return;
			} catch (IllegalStateException | TwitterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("gelen kutusu "+arg0.getText() );
			DirectMessage msg = null;
			try {
				String cevap = cevapla(arg0.getText() , arg0.getSenderScreenName());
				msg = twitter.sendDirectMessage(arg0.getSenderId(), cevap);
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Sent: " +msg.getText() + " to @" + msg.getRecipientScreenName());
			
		}
		
		@Override
		public void onDeletionNotice(long arg0, long arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onBlock(User arg0, User arg1) {
			// TODO Auto-generated method stub
			
		}
	};
	
	

public static void main(String args[]) throws Exception{
	
	twitter = TwitterFactory.getSingleton();
	
	 ConfigurationBuilder cb = new ConfigurationBuilder();
     cb.setDebugEnabled(true)
       .setOAuthConsumerKey("xxxxx")
       .setOAuthConsumerSecret("xxxxx");

     TwitterStreamFactory twitterStreamFactory = new TwitterStreamFactory(cb.build());
     twitterStream = twitterStreamFactory.getInstance(new AccessToken("xxx", "xxxx"));
	
     twitterStream.addListener(userStreamListener);
     twitterStream.user();
	
	}


 	public static String cevapla(String text , String name)
 	{
 		if(text.equals("selam")
 				|| text.equals("merhaba"))
 			return text;
 		else if(text.equals("nasil gidiyor")
 				|| text.equals("naber") || text.equals("nasilsin"))
 			return "iyi haci seni sormali";
 		else if(text.contains("ismin") || text.contains("adýn"))
 			return "ismin serk senin ki " + name + " degil mi ?";
 		else
 			return "soyledigini anlamadim haci.";
 		
 	}
 		
}