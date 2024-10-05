package com.babar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.babar.entities.UserAccount;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {

    @Modifying
    @Transactional
    @Query("update userAccount set activeSw=:status where userIs=:userId")
    public void updateUserAccStatus(Integer userId, String status);
}
