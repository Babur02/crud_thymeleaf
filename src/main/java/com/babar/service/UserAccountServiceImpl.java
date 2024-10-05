package com.babar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babar.entities.UserAccount;
import com.babar.repository.UserAccountRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountRepo userAccountRepo;

    @Override
    public String saveOrUpdateUserAcc(UserAccount userAcc) {

        Integer userId = userAcc.getUserId();

        // Upsert (Insert or Update)
        userAccountRepo.save(userAcc);

        if (userId == null) {
            return "User Record Saved Successfully";
        } else
            return "User Record Updated Successfully";
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userAccountRepo.findAll();
    }

    @Override
    public UserAccount getUserAcc(Integer userId) {
        return userAccountRepo.findById(userId).orElse(null);
    }

    @Override
    public boolean deleteUserAcc(Integer userId) {
        try {
            userAccountRepo.deleteById(userId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean updateUserAccStatus(Integer userId, String status) {
        try {
            userAccountRepo.updateUserAccStatus(userId, status);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
