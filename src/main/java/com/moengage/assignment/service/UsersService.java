package com.moengage.assignment.service;

import com.moengage.assignment.model.UserModel;
import com.moengage.assignment.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {


    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserModel registerUser(String login, String password, String email)
    {

        if(login!=null&&password!=null)
        {
            if(usersRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Duplicate login");
                return null;
            }
            UserModel userModel=new UserModel();
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setEmail(email);
            return usersRepository.save(userModel);
        }
        else {
            return null;
        }
    }
    public UserModel authenticate(String login, String password){
        return usersRepository.findByLoginAndPassword(login,password).orElse(null);
    }
}
