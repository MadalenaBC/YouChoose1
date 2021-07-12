package pt.iade.youchoose.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilizador")
public class Utilizador {
@Id 
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="ut_id") 
private int id;
    @Column(name="ut_proprio")
private String name;
    @Column(name="ut_apelido")
private String surname;
    @Column(name="ut_datanasc")
private String data_nascimento;
    @Column(name="ut_idade")
private int idade;
    @Column(name="ut_genero")
private String genero;
    @Column(name="ut_total_pontos")
private String TotalPontos;
    @Column(name="esc_id")
private  int escalaoId;
    @Column(name="cp_id")
private int cp_Id;




public Utilizador() {}

public int getId() {
    return id;
}
public String getName() {
    return name;
}
public String getSurname() {
    return surname;
}
public int getIdade() {
    return idade;
}
public String getGenero() {
    return genero;
}
public int getEscalaoId() {
    return escalaoId;
}
public int getCp_Id() {
    return cp_Id;
}
public String getDatanasc() {
    return data_nascimento;
}
public String getTotalPontos() {
    return TotalPontos;
}



}
