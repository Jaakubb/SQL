package data;

import javax.persistence.*;

@Entity
@Table(name="auta")
public class Auta {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="nazwa")
    private String nazwa;

    @Column(name="predkosc")
    private Integer predkosc;

    public Auta(){
    }

    public Auta(Integer id, String nazwa, Integer predkosc){
        this.id=id;
        this.nazwa=nazwa;
        this.predkosc=predkosc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getPredkosc() {
        return predkosc;
    }

    public void setPredkosc(Integer predkosc) {
        this.predkosc = predkosc;
    }
}
