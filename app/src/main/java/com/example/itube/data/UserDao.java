package com.example.itube.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    public void insertUser(User user);

    @Query("SELECT password FROM user_table WHERE username = :username")
    public String getUserPassword(String username);
}

