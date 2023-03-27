class Twitter {
    Map<Integer, Set<Integer>> follow = new HashMap<>();
    static class Tweet{
        int id;
        int userId;
        Tweet(int id, int userId){
            this.id = id;
            this.userId = userId;
        }
    }
    LinkedList<Tweet> l = new LinkedList<>();
    public Twitter() { 
    }
    public void postTweet(int userId, int tweetId) {
        l.addFirst(new Tweet(tweetId, userId));
    }
    static int FEED_SIZE=10;
    public List<Integer> getNewsFeed(int userId) {
        int k=0;
        Set<Integer> set = follow.get(userId);
        List<Integer> feed = new ArrayList<>();
        for(Tweet tweet : l){
            if(k==FEED_SIZE){
                break;
            }
            if(addToFeed(set,tweet,userId) ){
                feed.add(tweet.id);
                k++;
            }
        }
        return feed;
    }
    boolean addToFeed(Set<Integer> set, Tweet tweet, int userId){
        if(tweet.userId == userId){
            return true;
        }
        if(set==null){
            return false;
        }
        return set.contains(tweet.userId);
    }
    public void follow(int followerId, int followeeId) {
        Set<Integer> s = follow.get(followerId);
        if(s==null){
            s= new HashSet<>();
            follow.put(followerId, s);
        }
        s.add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> s = follow.get(followerId);
        if(s==null){
            return;
        }
        s.remove(followeeId);
    }
}