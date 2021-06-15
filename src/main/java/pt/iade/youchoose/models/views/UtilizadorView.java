package pt.iade.youchoose.models.views;

import java.sql.Date;

public interface UtilizadorView {
    int getId();
    String getName();
    String getSurname();
    String getGenero();
    Date getDatanasc();
}
