package Services;

import Model.UserInfo;
import Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }

    public UserInfo getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserInfo createUser(UserInfo userInfo) {
        if (userRepository.existsByUsername(userInfo.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(userInfo);
    }

    public UserInfo findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
