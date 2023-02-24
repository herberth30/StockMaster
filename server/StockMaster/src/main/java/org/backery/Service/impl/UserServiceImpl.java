package org.backery.Service.impl;

import org.backery.Model.Entities.Usuario;
import org.backery.Model.dtos.SignUpDTO;
import org.backery.Repository.UserRepository;
import org.backery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean existsByIdentifier(String identifier) {
        return userRepository.existsByIdentifier(identifier);
    }

    @Override
    public Usuario findOneByUsername(String username) {
        return userRepository.findOneByUsernameOrEmail(username, username);
    }

    @Override
    public Boolean register(SignUpDTO singUp) throws Exception {
        try{
            Boolean exist = existsByIdentifier(singUp.getUsername()) ||
                            existsByIdentifier(singUp.getEmail());
            if(exist) {
                throw new Exception("El usuario ya existe");
            }
            Usuario newUser = new Usuario(
                    singUp.getName(),
                    singUp.getEmail(),
                    singUp.getUsername(),
                    singUp.getPassword()
            );
            userRepository.insertUser(newUser);

            exist = userRepository.existsByIdentifier(newUser.getUsername());
            if (exist) {
                return true;
            } else {
                throw new Exception("No se pudo registrar el usuario");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Usuario findOneById(int id) throws Exception {
        Usuario foundUser = userRepository
                .findById(id)
                .orElse(null);
        return foundUser;
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public Usuario findOneByIdentifer(String identifier) throws Exception {
        System.out.println("identifier: " + identifier);

        Usuario foundUser = userRepository
                .findOneByUsernameOrEmail(identifier, identifier);

        System.out.println("foundUser: " + foundUser);
        return foundUser;
    }

    @Override
    public Usuario findOneByUsernameAndEmail(String username, String email) throws Exception {
        Usuario foundUser = userRepository
                .findOneByUsernameOrEmail(username, email);
        return foundUser;
    }

    @Override
    public Boolean comparePassword(Usuario user, String passToCompare) throws Exception {
       Usuario userFound = findOneById(user.getId());
       return userFound.getPassword().equals(passToCompare);
    }
}
