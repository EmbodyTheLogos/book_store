package com.starrockbooks.repository.impl;

import com.google.common.collect.MoreCollectors;
import com.starrockbooks.jpa.JpaApplicationUserRepository;
import com.starrockbooks.model.ApplicationUser;
import com.starrockbooks.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

    //
    //  Instance data

    // PS5
//    List<ApplicationUser> userList = new ArrayList<>();

    // PS6
    @Autowired
    private JpaApplicationUserRepository jpaApplicationUserRepository;

    @Override
    public ApplicationUser findByUserName(String userName) {

        //
        //  Old school
//        for (ApplicationUser user : userList) {
//            if (user.getUsername().equalsIgnoreCase(userName)) {
//                return user;
//            }
//        }

//        return null;

//        //
//        //  JAVA 8
//        List<ApplicationUser> filtered = userList.stream()
//                .filter(u -> u.getUsername().equalsIgnoreCase(userName))
//                .collect(Collectors.toList());
//        return (filtered != null && filtered.size() >0) ? filtered.get(0) : null;

        //
        //  JAVA 8 with Guava

        // PS5
//        return userList.stream()
//                .filter(u -> u.getUsername().equalsIgnoreCase(userName))
//                .collect(MoreCollectors.onlyElement());

        // PS6
        return jpaApplicationUserRepository.findByUsername(userName);

    }

    @Override
    public ApplicationUser addUser(ApplicationUser applicationUser) {

        // PS5
//        userList.add(applicationUser);
//        return applicationUser;

        // PS6
        return jpaApplicationUserRepository.save(applicationUser);
    }
}
