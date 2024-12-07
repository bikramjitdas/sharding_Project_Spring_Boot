package com.example.sharding_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sharding_project.Entity.UserDetails;
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

}
