package pt.iade.youchoose.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="Escalao")
public class Escalao {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
    @Column(name="esc_id") 
private int id;
    @Column(name="esc_nome")
private String name;
    @Column(name="esc_pontos")
private Integer pontos;
    
public Escalao() {} // Need empty constructor
// other constructors getters and setters
public int getId() {
    return id;
}
public String getName() {
    return name;
}
public Integer getPontos() {
    return pontos;
}
}
