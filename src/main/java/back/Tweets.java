package back;

import java.util.ArrayList;
import java.util.Iterator;

public class Tweets {

    private ArrayList<Tweet> tweets = new ArrayList<>();  // Creación del array list
    private int num = 0;

    public void create(Tweet t){
            Tweet nuevo = new Tweet(t.getNombre(), t.getMensaje(), t.getFecha());
            tweets.add(nuevo);
            num++;
    }

    public void delete(String p) {
        Iterator<Tweet> it= tweets.iterator();
        while (it.hasNext()) {
            if (it.next().getNombre().equals(p)) {
                it.remove();
                num--;
            }
        }
    }

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
