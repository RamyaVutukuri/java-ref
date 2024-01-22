package com.techatpark.practices;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.*;

import java.sql.SQLException;
import java.util.List;

public class MyEntityMakerTest
{
    @Test
    void testCreateAndValueList() throws SQLException {
        Envelope box=new Envelope(15,21,16,72);
        MyEntity entity=new MyEntity(3,box);
        MyEntityMaker maker=new MyEntityMaker();
        maker.create(entity);
        List<MyEntity> list=maker.valueList();
        for(MyEntity a : list){
            System.out.println(a.id()+ ","+a.value());
        }
    }
}
