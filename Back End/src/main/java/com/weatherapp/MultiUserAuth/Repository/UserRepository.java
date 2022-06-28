package com.weatherapp.MultiUserAuth.Repository;

import com.weatherapp.MultiUserAuth.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
