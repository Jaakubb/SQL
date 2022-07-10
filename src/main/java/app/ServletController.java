package app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import data.Auta;
import data.Klient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public String imie(@RequestParam("i") String imie){
        return auto.findByimie(imie).get(0).getAuto();

    }

    @RequestMapping(
            value= "/wypisywanie",
            method= RequestMethod.POST)
    public String wypisywanie(@RequestBody String jsondata){
        return jsondata;
    }
    @RequestMapping(
            value= "/usuwanie",
            method= RequestMethod.GET)
    public void usuwanie(@RequestParam String typ,@RequestParam String id){
        if (typ.equals("a")){
            auta.delete(auta.findByid(Integer.parseInt(id)).get(0));

        }
        if (typ.equals("k")){
            System.out.println(id);
            for(Klient klient : auto.findAll()){
                System.out.println(klient.getIdk());
            }
            auto.delete(auto.findByidk(Integer.parseInt(id)).get(0));
        }
        if (typ.equals("c")){
            cena.delete(cena.findByidc(Integer.parseInt(id)).get(0));
        }
    }
    @RequestMapping(
            value= "/dodawanie",
            method= RequestMethod.GET)
    public void dodawanie(@RequestParam Integer id, @RequestParam String nazwa, @RequestParam Integer predkosc){
        auta.save(new Auta(id,nazwa,predkosc));
    }
    @RequestMapping(
            value="/listaaut",
            method= RequestMethod.GET)
    public String listaaut() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String result= "";
        ArrayNode array = mapper.createArrayNode();
        for(Auta cust : auta.findAll()){
            JsonNode samochod = mapper.valueToTree(cust);
            ObjectNode jNode = mapper.createObjectNode();
            jNode.put("id", samochod.get("id"));
            jNode.put("nazwa", samochod.get("nazwa"));
            jNode.put("predkosc",samochod.get("predkosc"));
            array.add(jNode);
        }
        result = "{\"Auta\":" +mapper.writeValueAsString(array) + "}";
        return result;

    }




}
