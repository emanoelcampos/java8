package br.com.emanoel.stream;

public class User {

    private String name;
    private int points;
    private boolean moderator;

    public User(String name, int points, boolean moderator) {
        this.name = name;
        this.points = points;
        this.moderator = moderator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean getModerator() {
        return moderator;
    }

    public void setModerator(boolean moderator) {
        this.moderator = moderator;
    }

    public void setModeratorTrue(){
       setModerator(true);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", moderator=" + moderator +
                '}';
    }

}
