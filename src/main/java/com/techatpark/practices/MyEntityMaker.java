package com.techatpark.practices;

import org.locationtech.jts.geom.*;
import org.postgresql.geometric.PGbox;


import java.sql.*;
import java.util.ArrayList;

import java.util.List;public class MyEntityMaker {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://127.18.0.2:5432/postgres", "postgres", "postgres123"
        );
    }
    public final void create (MyEntity myEntities) throws SQLException {
        Connection conn = getConnection();
        String insertQuery = "INSERT INTO my_entity(value) VALUES(?)";
        PreparedStatement pre = conn.prepareStatement(insertQuery);
        PGbox box = new PGbox(myEntities.value().getMinX(), myEntities.value().getMinY(),
                myEntities.value().getMaxX(), myEntities.value().getMaxY());
        pre.setObject(1, box);
        System.out.println(box);
        pre.execute();
    }
    public List<MyEntity> valueList() throws SQLException {
        Connection conn = getConnection();
        List<MyEntity> myEntities = new ArrayList<>();
        String iQuery = "select * from my_entity";
        PreparedStatement pre = conn.prepareStatement(iQuery);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            PGbox pgbox = (PGbox) rs.getObject("value");
            myEntities.add(new MyEntity(rs.getLong(1), new Envelope(pgbox.point[0].x,pgbox.point[1].x,pgbox.point[0].y,pgbox.point[1].y)));
        }
        return myEntities;
    }
}

