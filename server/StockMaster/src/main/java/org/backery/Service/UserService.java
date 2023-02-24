package org.backery.Service;

import org.backery.Model.Entities.Usuario;
import org.backery.Model.dtos.SignUpDTO;

import java.util.List;

public interface UserService {
    Usuario findOneByUsername(String username)throws Exception;

    Boolean existsByIdentifier(String identifier) throws Exception;

    Boolean register(SignUpDTO singUp) throws Exception;
    Usuario findOneById(int id) throws Exception;
    List<Usuario> findAll() throws Exception;
    Usuario findOneByIdentifer(String identifier) throws Exception;
    Usuario findOneByUsernameAndEmail(String username, String email) throws Exception;
    Boolean comparePassword(Usuario user, String passToCompare) throws Exception;

//    void insertToken(User user, String token) throws Exception;
//    Boolean isTokenValid(User user, String token) throws Exception;
//    User getUserAuthenticated() throws Exception;

}
