package net.ictcampus.fangis;


import net.ictcampus.db.ScoreJDBCDao;

import java.sql.Time;
import java.util.List;

public class dbtest {


    public static void main(String[] args){
        ScoreJDBCDao db= new ScoreJDBCDao();
        db.insertScore("abcdefg", Time.valueOf("01:01:20"),2);
        List<String> max = db.maxScore();
        for (String i : max){
            System.out.println(i);
        }


    }

}
