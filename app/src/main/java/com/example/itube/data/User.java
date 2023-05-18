package com.example.itube.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "username")
    public String username;

    @NonNull
    @ColumnInfo(name = "password")
    public String password;

    @NonNull
    @ColumnInfo(name = "fullname")
    public String fullname;

    public User(@NonNull String username, @NonNull String password, @NonNull String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    @NonNull
    public String getFullname() {
        return fullname;
    }
}
