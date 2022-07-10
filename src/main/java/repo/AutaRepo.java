package repo;

import data.Auta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutaRepo extends CrudRepository<Auta, Integer> {
    List<Auta> findBynazwa(String nazwa);
    List<Auta> findByid(Integer id);
}
