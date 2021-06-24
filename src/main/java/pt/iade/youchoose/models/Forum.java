package pt.iade.youchoose.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="forum")
public class Forum {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)    
    @Column(name="forum_id") 
private int id;
    @Column(name="forum_nome")
private String name;
  


public Forum() {} // Need empty constructor
// other constructors getters and setters
public int getId() {
    return id;
}
public String getName() {
    return name;
}

}
