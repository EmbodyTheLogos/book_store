package com.starrockbooks.service.impl;

import com.starrockbooks.model.ApplicationUser;
import com.starrockbooks.repository.ApplicationUserRepository;
import com.starrockbooks.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {


    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public ApplicationUser findByUserName(String username) {
        return applicationUserRepository.findByUserName(username);
    }
}
