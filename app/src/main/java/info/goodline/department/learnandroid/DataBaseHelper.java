package info.goodline.department.learnandroid;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataBaseHelper {

    private static List<User> users;
    private static List<Comment> commentsJon;
    private static List<Comment> commentsLisa;
    public static final int USER_JON = 0;
    public static final int USER_LISA = 1;

    public static List<ChatItem> chats = Arrays.asList(
            new ChatItem("Birthday gift", R.drawable.userpic, "Sandra Adams ",
                    "                          — It’s the one week of the year in which you get the chance to take…"),

            new ChatItem("Gym and pool time ", R.drawable.userpic1, "Ray Neal ",
                    "                — Healthy, robust, contracting, healthy, robust and contracting like a lung."),

            new ChatItem("Write the report", R.drawable.userpic2, "Carrie Mann ",
                    "                      — A wonderful serenity has taken possession of my entire soul, like…"),

            new ChatItem("Recipe to try", R.drawable.userpic3, "Lelia Colon ",
                    "                    — Speaking of which, Peter really wants you to come in on Friday."),

            new ChatItem("Brunch with friends", R.drawable.userpic4, "to Trevor, Andrew, Sandra ",
                    "                                             — Images span the screen in ribbons, which expand with "),

            new ChatItem("Birthday gift", R.drawable.userpic5, "Sandra Adams  ",
                    "                          — It’s the one week of the year in which you get the chance to take…"),
            new ChatItem("Birthday gift", R.drawable.userpic, "Sandra Adams ",
                    "                          — It’s the one week of the year in which you get the chance to take…"),

            new ChatItem("Gym and pool time ", R.drawable.userpic1, "Ray Neal ",
                    "                — Healthy, robust, contracting, healthy, robust and contracting like a lung."),

            new ChatItem("Write the report", R.drawable.userpic2, "Carrie Mann ",
                    "                      — A wonderful serenity has taken possession of my entire soul, like…"),

            new ChatItem("Recipe to try", R.drawable.userpic3, "Lelia Colon ",
                    "                    — Speaking of which, Peter really wants you to come in on Friday."),

            new ChatItem("Brunch with friends", R.drawable.userpic4, "to Trevor, Andrew, Sandra ",
                    "                                             — Images span the screen in ribbons, which expand with "),

            new ChatItem("Birthday gift", R.drawable.userpic5, "Sandra Adams  ",
                    "                          — It’s the one week of the year in which you get the chance to take…"),
            new ChatItem("Birthday gift", R.drawable.userpic, "Sandra Adams ",
                    "                          — It’s the one week of the year in which you get the chance to take…"),

            new ChatItem("Gym and pool time ", R.drawable.userpic1, "Ray Neal ",
                    "                — Healthy, robust, contracting, healthy, robust and contracting like a lung."),

            new ChatItem("Write the report", R.drawable.userpic2, "Carrie Mann ",
                    "                      — A wonderful serenity has taken possession of my entire soul, like…"),

            new ChatItem("Recipe to try", R.drawable.userpic3, "Lelia Colon ",
                    "                    — Speaking of which, Peter really wants you to come in on Friday."),

            new ChatItem("Brunch with friends", R.drawable.userpic4, "to Trevor, Andrew, Sandra ",
                    "                                             — Images span the screen in ribbons, which expand with "),

            new ChatItem("Birthday gift", R.drawable.userpic5, "Sandra Adams  ",
                    "                          — It’s the one week of the year in which you get the chance to take…")


    );


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

    public static ChatItem createChat() {
        Random r = new Random();
        // Получить случайное значение позиции для нового чата
        int positionNewChat = r.nextInt(chats.size() - 1);
        // Вернуть чат с рандомной позицией
        return chats.get(positionNewChat);
    }
}
