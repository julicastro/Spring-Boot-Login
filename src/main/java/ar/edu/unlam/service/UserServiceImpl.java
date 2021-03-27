package ar.edu.unlam.service;

import ar.edu.unlam.dto.ChangePasswordForm;
import ar.edu.unlam.entity.User;
import ar.edu.unlam.repositorio.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired //Evita el new...
    UserRepository repository;

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    private boolean checkUsernameAvailable(User user) throws Exception {
        Optional<User> userFound = repository.findByUsername(user.getUsername());
        if (userFound.isPresent()) {
            throw new Exception("Username no disponible");
        }
        return true;
    }

    private boolean checkPasswordValid(User user) throws Exception {
        if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
            throw new Exception("Confirm Password es obligatorio");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new Exception("Password y Confirm Password no son iguales");
        }
        return true;
    }

    @Override
    public User createUser(User user) throws Exception {
        if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
            user = repository.save(user);
        }
        return user;
    }

    @Override
    public User getUserById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("El usuario para editar no existe."));
    }

    @Override
    public User updateUser(User fromUser) throws Exception {
        User toUser = getUserById(fromUser.getId());
        mapUser(fromUser, toUser);
        return repository.save(toUser);
    }

    /**
     * Map everythin but the password.
     *
     * @param from
     * @param to
     */
    protected void mapUser(User from, User to) {
        to.setUsername(from.getUsername());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmail(from.getEmail());
        to.setRoles(from.getRoles());
    }

    public void deleteUser(Long id) throws Exception {
        User user = repository.findById(id)
                .orElseThrow(() -> new Exception("UsernotFound in deleteUser -" + this.getClass().getName()));

        repository.delete(user);
    }

    @Override
    public User changePassword(ChangePasswordForm form) throws Exception {
        User user = getUserById(form.getId());

        if (!user.getPassword().equals(form.getCurrentPassword())) {
            throw new Exception("Current Password invalido.");
        }

        if (user.getPassword().equals(form.getNewPassword())) {
            throw new Exception("Nuevo debe ser diferente al password actual.");
        }

        if (!form.getNewPassword().equals(form.getConfirmPassword())) {
            throw new Exception("Nuevo Password y Current Password no coinciden.");
        }

        user.setPassword(form.getNewPassword());
        return repository.save(user);
    }
}

