package com.starrockbooks.repository;

import com.starrockbooks.model.ApplicationUser;

public interface ApplicationUserRepository {
    ApplicationUser findByUserName(String userName);

    ApplicationUser addUser(ApplicationUser applicationUser);
}
