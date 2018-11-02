package info.goodline.department.learnandroid;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper {

    private static List<User> users;
    private static List<Comment> commentsJon;
    private static List<Comment> commentsLisa;
    public static final int USER_JON = 0;
    public static final int USER_LISA = 1;


    public static void initDatabase() {
        users = new ArrayList<>();
        commentsJon = new ArrayList<>();
        commentsLisa = new ArrayList<>();

        User jon = new User();
        jon.setId(USER_JON);
        jon.setName("Jon");
        jon.setEmail("jon@mail.com");

        User lisa = new User();
        lisa.setId(USER_LISA);
        lisa.setName("Lisa");
        lisa.setEmail("lisa@mail.com");

        users.add(jon);
        users.add(lisa);

        for (int i = 1; i < 4; i++) {
            commentsJon.add(new Comment("Comment #" + i + " from Jon"));
            commentsLisa.add(new Comment("Comment #" + i + " from Lisa"));
        }


    }

    @Nullable
    public static List<Comment> getCommentsByUserId(int userId) {
        switch (userId) {
            case USER_JON:
                return commentsJon;
            case USER_LISA:
                return commentsLisa;
        }

        return null;
    }

    public static List<User> getUsers() {
        return users;
    }
}
