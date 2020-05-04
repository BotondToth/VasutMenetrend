package com.database.szte.service;

import com.database.szte.data.ApplicationUser;

public interface IUserService {

    ApplicationUser getUserById(long id);

    ApplicationUser saveNewUser(ApplicationUser userToSave);

    ApplicationUser getUserByEmail(String email);
}
