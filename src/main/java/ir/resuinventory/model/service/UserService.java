package ir.resuinventory.model.service;


import ir.resuinventory.model.entity.User;
import ir.resuinventory.model.repository.CRUDRepository;
import ir.resuinventory.model.repository.UserDA;
import ir.resuinventory.model.service.generic.Service;

import java.util.List;

public class UserService extends Service<User, Long> {

    private static UserService userService = new UserService();

    private UserService(){
    }

    public static UserService getUserService() {
        return userService;
    }

    public User insert(User user) throws Exception {
        try(CRUDRepository<User,Long> repository = new CRUDRepository<>()){
            return repository.insert(user);
        }
    }

    public User update(User user) throws Exception {
        try(CRUDRepository<User,Long> repository = new CRUDRepository<>()){
            return repository.update(user);
        }
    }

    public User delete(Long aLong) throws Exception {
        try(CRUDRepository<User,Long> repository = new CRUDRepository<>()){
            return repository.delete(User.class, aLong);
        }
    }

    public List<User> selectAll() throws Exception {
        try(CRUDRepository<User,Long> repository = new CRUDRepository<>()){
            return repository.selectAll(User.class);
        }
    }

    public User selectById(Long aLong) throws Exception {
        try(CRUDRepository<User,Long> repository = new CRUDRepository<>()){
            return repository.selectById(User.class, aLong);
        }
    }

    public User selectByEmail(String email) throws Exception {
        try(UserDA repository = new UserDA()){
            return repository.selectByEmail(email);
        }
    }

    public String userExists(User user) throws Exception {
        try(UserDA repository = new UserDA()){
            return repository.userExists(user);
        }
    }

    public boolean activeUserEmail(String userPassword) throws Exception {
        try(UserDA repository = new UserDA()){
            return repository.activeUserEmail(userPassword);
        }
    }
}
