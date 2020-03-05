package com.kundan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kundan.demo.model.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
