package me.postaddict.instagram.scraper;

import me.postaddict.instagram.scraper.model.Account;
import me.postaddict.instagram.scraper.model.Comment;
import me.postaddict.instagram.scraper.model.Media;
import me.postaddict.instagram.scraper.model.Tag;

/**
 * Created by vasily on 27.04.17.
 */
public class ContentCheck {
    static final long INSTAGRAM_BORN_YEAR = 1262304000000L;
    static final long THREE_DAYS = 3600000 * 24 *3;
    static boolean checkMedia(Media m) {
        if (m == null) {
            System.out.println("NULL");
            return false;
        }
        if (m.getShortcode() != null
                && m.getShortcode().replace(" ", "").length() > 0 //instead of trim() and isEmpty()
/*
                && m.createdTime > INSTAGRAM_BORN_YEAR
                && m.createdTime < System.currentTimeMillis() + THREE_DAYS
*/
                && m.getOwner()!= null) {
            return true;
        } else {
            System.out.println(m);
            return false;
        }
    }

    static boolean checkComment(Comment c){
        if (c == null) {
            System.out.println("NULL");
            return false;
        }
        if (c.getId() != 0
/*
                && c.createdAt > INSTAGRAM_BORN_YEAR
                && c.createdAt < System.currentTimeMillis() + THREE_DAYS
*/
                && c.getText() != null
                && c.getText().replace(" ", "").length() > 0 //instead of trim() and isEmpty()
                && c.getOwner() != null) {
            return true;
        } else {
            System.out.println(c);
            return false;
        }
    }

    static boolean checkAccount(Account o) {
        if (o == null) {
            return false;
        }
        if (o.getId() > 0
                && o.getUsername() != null
                && o.getUsername().replace(" ", "").length() > 0 //instead of trim() and isEmpty()
                ) {
            return true;
        } else {
            System.out.println(o);
            return false;
        }
    }

    static boolean checkTag(Tag t) {
        if (t == null) {
            return false;
        }
        if (t.getName() != null
                && t.getName().replace(" ", "").length() > 0 //instead of trim() and isEmpty()
                && t.getCount() >= 0
            ) {
            return true;
        } else {
            System.out.println(t);
            return false;
        }
    }
}
