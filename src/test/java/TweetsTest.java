import back.Tweet;
import back.Tweets;

import static org.junit.Assert.*;

public class TweetsTest {
    Tweet t = new Tweet(" ", "", "");

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void create() {
        Tweets array = new Tweets();
        int antes = array.getTweets().size();
        array.create(t);
        assertNotEquals(antes, array.getTweets().size());
        assertNotNull(t);
    }
}