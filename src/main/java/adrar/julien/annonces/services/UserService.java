package adrar.julien.annonces.services;

import adrar.julien.annonces.entities.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
