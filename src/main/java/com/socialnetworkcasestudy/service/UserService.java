package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService   {

    List<User> findAll();



    User findById(long id);

    User save(User User);


    void delete(int id);

}
