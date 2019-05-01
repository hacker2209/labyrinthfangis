package net.ictcampus.db;

import net.ictcampus.fangis.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;


import static javax.print.attribute.standard.Chromaticity.COLOR;

public class ScoreJDBCDao implements ScoreDao {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    @Override
    public Player findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Player> findAll() {
        List<Player> all = new ArrayList<>();

        String sql = "Select * from Score join Rolle on id_rolle = rolle_id";
        try {
            con = openConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id_rolle");
//                all.add(new Player(200,200,40,40, rs.getString("Username"), rs.getString("rolleName"), Color.BLUE);
//            }
            closeConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return all;

    }

    @Override
    public void insertScore(String username, Time time, int rolleID) {
        try {
            con = openConnection();
            // the mysql insert statement
            String query = " insert into Score ( username, zeit, rolle_id)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.setTime(2, time);
            preparedStmt.setInt(3, rolleID);
            // execute the preparedstatement
            preparedStmt.execute();
            closeConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public List<String> maxScore() {
        List<String> all = new ArrayList<>();

        String sql = "Select  username, rolleName, zeit from Score join Rolle on id_rolle = rolle_id ORDER BY zeit asc LIMIT 10";
        try {
            con = openConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String time = rs.getTime("zeit").toString();
                String score= "Username: "+rs.getString("username")+"\tRolle: "+rs.getString("rolleName")+"\tZeit: "+time;
                all.add(score);
            }



            closeConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return all;
    }

    private Connection openConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    private void closeConnection() {
        try {

            if (rs != null) {
                rs.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            // TODO Replace by logger
            System.err.println("Error in " + getClass().getName() + ": "
                    + e.getMessage());
        }
    }
}
