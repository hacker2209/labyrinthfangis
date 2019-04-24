package net.ictcampus.db;

import net.ictcampus.fangis.Player;

import java.sql.Time;
import java.util.List;

public interface ScoreDao {
    public Player findByName(String name);

    public List<Player> findAll();

    public void insertScore(String username, Time time, String rolle);
}
