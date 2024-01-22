package com.techatpark.practices;

import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Point;
import org.postgresql.geometric.PGbox;

public record MyEntity(long id, Envelope value) {

}