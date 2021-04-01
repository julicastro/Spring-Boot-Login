package ar.edu.unlam.service;

import ar.edu.unlam.Exception.UsernameOrIdNotFound;
import ar.edu.unlam.dto.ChangePasswordForm;
import ar.edu.unlam.entity.User;
import javax.validation.Valid;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws UsernameOrIdNotFound;
	
	public User changePassword(ChangePasswordForm form) throws Exception;

}
