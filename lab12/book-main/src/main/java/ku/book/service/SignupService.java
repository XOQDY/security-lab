package ku.book.service;

import ku.book.dto.SignupDto;
import ku.book.model.User;
import ku.book.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class SignupService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username) {
        return repository.findByUsername(username) == null;
    }

    public int createUser(SignupDto user) {
        User newUser = modelMapper.map(user, User.class);
        newUser.setCreatedAt(Instant.now());

        String hashedPassword = passwordEncoder.encode(user.getPassword());

        newUser.setPassword(hashedPassword);

        repository.save(newUser);
        return 1;
    }

    public User getUser(String username) {
        return repository.findByUsername(username);
    }

}
