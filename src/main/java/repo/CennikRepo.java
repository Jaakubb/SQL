package repo;

import data.Cennik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CennikRepo extends CrudRepository<Cennik, Integer> {
    List<Cennik> findByidc (Integer idc);
}
