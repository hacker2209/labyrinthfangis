package net.ictcampus.fangis;

public class Player {
    private String playerName;
    private int bananaCount;
    private String playerRoll;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setBananaCount(int bananaCount) {
        this.bananaCount = bananaCount;
    }

    public void setPlayerRoll(String playerRoll) {
        this.playerRoll = playerRoll;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getBananaCount() {
        return bananaCount;
    }

    public String getPlayerRoll() {
        return playerRoll;
    }
}
