package pt.iade.youchoose.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="CodigoPostal")
public class CodigoPostal {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
    @Column(name="cp_id") 
private int id;
    @Column(name="cp_concelho")
private String concelho;
    @Column(name="cp_freguesia")
private String freguesia;
    @Column(name="cp_pais")
private String pais;
    @Column(name="cp_4D")
private Integer quatroD;
    @Column(name="cp_3D")
private Integer tresD;

public CodigoPostal() {} // Need empty constructor
// other constructors getters and setters
public int getId() {
    return id;
}
public String getConcelho() {
    return concelho;
}
public String getFreguesia() {
    return freguesia;
}
public String getPais() {
    return pais;
}
public Integer get4D() {
    return quatroD;
}
public Integer get3D() {
    return tresD;
}
}