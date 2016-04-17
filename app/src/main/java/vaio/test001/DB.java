package vaio.test001;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.view.Display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by user on 2015/10/8.
 */
public class DB extends SQLiteOpenHelper {
    public DB(Context context) {
        super(context, "DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("Create TABLE ADDB(" +
                //"_id INTEGER PRIMARY KEY AUTOINCREMENT" +
                "Account TEXT DEFAULT \"\"," +
                "Password TEXT DEFAULT \"\"," +
                "_id TEXT DEFAULT \"\"," +
                "Sex TEXT DEFAULT \"\"," +
                "City TEXT DEFAULT \"\"," +
                "Position TEXT DEFAULT \"\"," +
                "University TEXT DEFAULT \"\"," +
                "College TEXT DEFAULT \"\"," +
                "Lecture TEXT DEFAULT \"\"," +
                "Preference TEXT DEFAULT \"\")");

        db.execSQL("Create TABLE user(" +

                "Account TEXT DEFAULT \"\"," +
                "Password TEXT DEFAULT \"\"," +
                "Name TEXT DEFAULT \"\"," +
                "Sex TEXT DEFAULT \"\"," +
                "City TEXT DEFAULT \"\"," +
                "University TEXT DEFAULT \"\"," +
                "College TEXT DEFAULT \"\"," +
                "Preference TEXT DEFAULT \"\")");

        db.execSQL("Create TABLE MyAttention(" +

                "Account TEXT DEFAULT \"\"," +
                "_id TEXT DEFAULT \"\"," +
                "Sex TEXT DEFAULT \"\"," +
                "City TEXT DEFAULT \"\"," +
                "Position TEXT DEFAULT \"\"," +
                "University TEXT DEFAULT \"\"," +
                "College TEXT DEFAULT \"\"," +
                "Lecture TEXT DEFAULT \"\"," +
                "Preference TEXT DEFAULT \"\")");

        db.execSQL("Create TABLE LikeMe(" +

                "Account TEXT DEFAULT \"\"," +
                "_id TEXT DEFAULT \"\"," +
                "Sex TEXT DEFAULT \"\"," +
                "City TEXT DEFAULT \"\"," +
                "Position TEXT DEFAULT \"\"," +
                "University TEXT DEFAULT \"\"," +
                "College TEXT DEFAULT \"\"," +
                "Lecture TEXT DEFAULT \"\"," +
                "Preference TEXT DEFAULT \"\")");

        db.execSQL("Create TABLE Recommend(" +

                "Account TEXT DEFAULT \"\"," +
                "_id TEXT DEFAULT \"\"," +
                "Sex TEXT DEFAULT \"\"," +
                "City TEXT DEFAULT \"\"," +
                "Position TEXT DEFAULT \"\"," +
                "University TEXT DEFAULT \"\"," +
                "College TEXT DEFAULT \"\"," +
                "Lecture TEXT DEFAULT \"\"," +
                "Preference TEXT DEFAULT \"\")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
