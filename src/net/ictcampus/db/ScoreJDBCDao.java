package net.ictcampus.db;

import net.ictcampus.fangis.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreJDBCDao {
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

        String sql = "Select * from Ritter";
        try {
            con = openConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_ritter");
                all.add(new Player(rs.getString("name"), rs.getInt("staerke")));
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
