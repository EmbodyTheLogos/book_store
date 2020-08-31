package com.starrockbooks.jpa;

import com.starrockbooks.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface JpaApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String userName);
}
