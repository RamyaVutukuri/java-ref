module my.module {
    requires java.base;
    requires java.sql;
    opens com.techatpark.practices;
    requires org.locationtech.jts;
    requires org.postgresql.jdbc;
}