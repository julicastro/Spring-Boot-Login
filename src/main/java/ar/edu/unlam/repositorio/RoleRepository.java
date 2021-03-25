
package ar.edu.unlam.repositorio;

import ar.edu.unlam.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    
    // podemos usar el FindBy(Lo q queramos), Q spring se encarga de buscarlo
    
    
    
    
    
    
}
