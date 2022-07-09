package data;

import javax.persistence.*;

@Entity
@Table(name="klient")
public class Klient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_k")
    private Integer idk;

    @Column(name="imie")
    private String imie;

    @Column(name="auto")
    private String auto;

    public Klient(){
    }

    public Klient(Integer idk, String imie, String auto){
        this.idk=idk;
        this.imie=imie;
        this.auto=auto;
    }

    public Integer getIdk() {
        return idk;
    }

    public void setIdk(Integer idk) {
        this.idk = idk;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }
}
