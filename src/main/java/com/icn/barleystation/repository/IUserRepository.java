package com.icn.barleystation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icn.barleystation.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

}
