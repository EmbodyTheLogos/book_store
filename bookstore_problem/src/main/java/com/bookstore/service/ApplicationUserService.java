package com.starrockbooks.service;

import com.starrockbooks.model.ApplicationUser;

public interface ApplicationUserService {
    ApplicationUser findByUserName(String username);
}
