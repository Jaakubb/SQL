package data;

import javax.persistence.*;

@Entity
@Table(name="cennik")
public class Cennik {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_c")
    private Integer idc;

    @Column(name="cena")
    private Integer cena;

    @Column(name="auto")
    private Integer auto;

    public Cennik(){
    }

    public Cennik(Integer idc, Integer cena, Integer auto){
        this.idc=idc;
        this.cena=cena;
        this.auto=auto;
    }

    public Integer getIdc() {
        return idc;
    }

    public void setIdc(Integer idc) {
        this.idc = idc;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public Integer getAuto() {
        return auto;
    }

    public void setAuto(Integer auto) {
        this.auto = auto;
    }
}
