package ar.edu.unlam.service;

import ar.edu.unlam.entity.User;
import ar.edu.unlam.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired //Evita el new...
    UserRepository repository; 
    
    @Override
    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }
    
    
    
    
}
