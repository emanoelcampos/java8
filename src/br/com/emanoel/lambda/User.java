package br.com.emanoel.lambda;

public class User {

    private String name;
    private int points;
    private boolean moderator;

    public User(String name, int points) {
        this.name = name;
        this.points = points;
        this.moderator = false;
    }



    public User() {

    }

    public User(String name) {
        this.name = name;
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
