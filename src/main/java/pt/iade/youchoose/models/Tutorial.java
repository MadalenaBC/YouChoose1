package pt.iade.youchoose.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="tutorial")
public class Tutorial {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)    
    @Column(name="tut_id") 
private int id;
    @Column(name="tut_nome")
private String name;
    //@Column(name="tut_caract")
//private String caracteristicas;
    @Column(name="tut_data")
private Date data;


public Tutorial() {} // Need empty constructor
// other constructors getters and setters
public int getId() {
    return id;
}
public String getName() {
    return name;
}
public Date getData() {
    return data;
}
}