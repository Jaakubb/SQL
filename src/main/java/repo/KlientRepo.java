package repo;

import data.Klient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KlientRepo extends CrudRepository<Klient, Integer>{
    List<Klient> findByimie (String imie);
    List<Klient> findByidk (Integer idk);

}
