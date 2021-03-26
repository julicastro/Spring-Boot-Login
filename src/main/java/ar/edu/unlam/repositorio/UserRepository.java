
package ar.edu.unlam.repositorio;

import ar.edu.unlam.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    // podemos usar el FindBy(Lo q queramos), Q spring se encarga de buscarlo
    public Optional<User> findByUsername(String username);
 
    
    
    
    
}
