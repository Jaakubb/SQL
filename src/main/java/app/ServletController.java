package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repo.AutaRepo;
import repo.CennikRepo;
import repo.KlientRepo;

@RestController
public class ServletController {
    @Autowired
    AutaRepo auta;

    @Autowired
    CennikRepo cena;

    @Autowired
    KlientRepo auto;

    @RequestMapping(
            value="/hello",
            method= RequestMethod.GET
    )
    public String hello(){
        return "hello";
    }
    @RequestMapping(
            value="/find",
            method= RequestMethod.GET
    )
    public String find(@RequestParam("n")String nazwa) {
        String b ="";

        for (int i = 0; i < auta.findBynazwa(nazwa).size(); i++) {
            b+=String.valueOf(auta.findBynazwa(nazwa).get(i).getPredkosc());
        }
        return b;
    }
    @RequestMapping(
            value="/idc",
            method= RequestMethod.GET
    )
    public Integer idc(@RequestParam("c") Integer idc){
        return cena.findByidc(idc).get(0).getCena();
    }
    @RequestMapping(
            value="/imie",
            method= RequestMethod.GET
    )
    public String imie(RequestParam("i")String imie){
        return auto.findByimie(imie).get(0).getAuto();

    }

}
