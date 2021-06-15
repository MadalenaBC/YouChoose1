package pt.iade.youchoose.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="utilizador")
public class Utilizador {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
    @Column(name="ut_id") 
private int id;
    @Column(name="ut_proprio")
private String name;
    @Column(name="ut_apelido")
private String surname;
    @Column(name="ut_datanasc")
private Date data_nascimento;
    @Column(name="ut_genero")
private String genero;
@Column(name="esc_id")
private int escalaoId;


public Utilizador(String genero) {
        this.genero = genero;
    }
public Utilizador() {} // Need empty constructor
// other constructors getters and setters
public int getId() {
    return id;
}
public String getName() {
    return name;
}
public String getSurname() {
    return surname;
}
public String getGenero() {
    return genero;
}
public Date getDatanasc() {
    return data_nascimento;
}
}

