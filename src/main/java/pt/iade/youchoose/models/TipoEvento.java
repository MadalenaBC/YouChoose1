package pt.iade.youchoose.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="TipoEvento")
public class TipoEvento {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
    @Column(name="tev_id") 
private int id;
    @Column(name="tev_nome")
private String name;
    @Column(name="tev_data")
private Date date;
    

public TipoEvento() {} // Need empty constructor
// other constructors getters and setters
public int getId() {
    return id;
}
public String getName() {
    return name;
}
public Date getDate() {
    return date;
}
public Iterable<TipoEvento> findAll() {
	return null;
}
}
