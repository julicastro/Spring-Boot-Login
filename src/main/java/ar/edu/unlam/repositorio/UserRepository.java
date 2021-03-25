
package ar.edu.unlam.repositorio;

import ar.edu.unlam.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    // podemos usar el FindBy(Lo q queramos), Q spring se encarga de buscarlo
    
 
    
    
    
    
}
