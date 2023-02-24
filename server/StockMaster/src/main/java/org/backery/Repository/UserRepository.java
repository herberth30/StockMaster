package org.backery.Repository;

import org.backery.Model.Entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class UserRepository {
    private static ArrayList<Usuario> usersList = new ArrayList<>();
    static {
        usersList.add(new Usuario(1, "moises", "moises@email.com", "moi123", "1234"));
        usersList.add(new Usuario(2, "alexi", "alexi@email.com", "alx123", "7890"));
        usersList.add(new Usuario(3,"Herberth","herberth@email.com","herberth30","1234"))
    }
    public void insertUser(Usuario user){
         usersList.add(user);
    }
    public Boolean existsByIdentifier(String identifier){ //existe un user con ese username o email?
        return usersList.stream().anyMatch(
                user -> user.getUsername().equals(identifier) ||
                        user.getEmail().equals(identifier));
    }
    public List<Usuario> findAll() {
        return usersList;
    } //SELECT * FROM users

    public Optional<Usuario> findById(int id) {
        return usersList.stream().filter(user -> user.getId() == id).findFirst();
    }

    public Usuario findOneByUsernameOrEmail(String identifier, String identifier2) {
        System.out.println("identifierRepo: " + identifier);
        Usuario userFound = usersList.stream().filter(
                user -> user.getUsername().equals(identifier) || user.getEmail().equals(identifier2)).findFirst().orElse(null);
        return userFound;
    }
}
