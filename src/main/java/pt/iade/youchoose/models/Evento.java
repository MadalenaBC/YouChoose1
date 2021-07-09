package pt.iade.youchoose.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="Evento")
public class Evento {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
    @Column(name="ev_id") 
private int id;
    @Column(name="ev_nome")
private String name;
    @Column(name="ev_data")
private Date date;
    @Column(name="tev_id") 
private int tevid;
    

public Evento() {} // Need empty constructor
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
public int getTevid() {
	return tevid;
}
}
