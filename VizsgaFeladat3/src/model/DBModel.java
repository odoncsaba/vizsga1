/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Csaba Ödön <your.name at your.org>
 */
public class DBModel implements IModel {

    private Connection conn;
    private PreparedStatement getKerdesPstmt;

    public DBModel(Connection conn) throws SQLException {
        this.conn = conn;
        getKerdesPstmt = conn.prepareStatement("select * from kerdes");

    }

    public Vector<Kerdes> getKerdes() throws SQLException {
        ResultSet rs = getKerdesPstmt.executeQuery();
        Vector<Kerdes> kerdesek = new Vector<>();

        while (rs.next()) {

            Kerdes k = new Kerdes(
                    rs.getInt("id"),
                    rs.getString("kerdes"),
                    rs.getString("valasz0"),
                    rs.getString("valasz1"),
                    rs.getString("valasz2"),
                    rs.getString("valasz3"),
                    rs.getInt("helyesValasz"));

            kerdesek.add(k);
        }
        return kerdesek;
    }

    public Map<Integer, Kerdes> getKerdesMap() throws SQLException {
        Map<Integer, Kerdes> kerdesMap = new HashMap<Integer, Kerdes>();
        Vector<Kerdes> kerdesek = new Vector<>();

        ResultSet rs = getKerdesPstmt.executeQuery();
        while (rs.next()) {
            Kerdes kerdes = new Kerdes(
                    rs.getInt("id"),
                    rs.getString("kerdes"),
                    rs.getString("valasz0"),
                    rs.getString("valasz1"),
                    rs.getString("valasz2"),
                    rs.getString("valasz3"),
                    rs.getInt("helyesValasz"));

            kerdesMap.put(rs.getInt("helyesValasz"), kerdes);
        }
        return kerdesMap;
    }

    @Override
    public void close() throws SQLException {
        conn.close();
    }

}
