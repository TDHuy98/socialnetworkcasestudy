package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }


    @Override
    public User findById(long id) {
        return  userRepository.findById(id).get();
    }


    @Override
    public User save(User User) {
        return userRepository.save(User);
    }

    @Override
    public void delete(int id) {

    }

//    public List<User> getAllAccountById(Integer id) {
//        return accountRepository.findAllById(id);
//    }
//
//    public <Optinal> User getAccountById(Integer id) {
//        return accountRepository.findById(id).get();
//    }

}
