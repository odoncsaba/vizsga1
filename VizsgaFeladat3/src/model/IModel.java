/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Csaba Ödön <your.name at your.org>
 */
public interface IModel {

    Vector<Kerdes> getKerdes() throws SQLException;

    Map<Integer, Kerdes> getKerdesMap() throws SQLException;

    void close() throws SQLException;
}
