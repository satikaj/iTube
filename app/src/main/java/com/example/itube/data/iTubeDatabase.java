package com.example.itube.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Playlist.class}, version = 1, exportSchema = false)
public abstract class iTubeDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract PlaylistDao playlistDao();

    private static volatile iTubeDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static iTubeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (iTubeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    iTubeDatabase.class, "itubedatabase.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
