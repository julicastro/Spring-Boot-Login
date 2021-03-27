package ar.edu.unlam.service;

import ar.edu.unlam.entity.User;

public interface UserService {
    
    public Iterable<User> getAllUsers();
    
    public User createUser(User user) throws Exception;
    
    public User getUserById(Long Id) throws Exception;
    
    public User updateUser(User user) throws Exception;
    
    public void deleteUser(Long id) throws Exception;
    
}
