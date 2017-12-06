package b2ctest1.com.b2ctest1.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amanda on 05/12/2017.
 */

public class UserDAO extends SQLiteOpenHelper {

    public UserDAO(Context context) {
        super(context, "c0719157DB", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE User (id INTEGER PRIMARY KEY, email TEXT NOT NULL, password TEXT NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS User";
        db.execSQL(sql);
        onCreate(db);
    }

    public void dbinsert(User user) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues userData = new ContentValues();
        userData.put("email", user.getEmail());
        userData.put("password", user.getPassword());

        db.insert("User", null, userData);
    }

    public boolean checkEmailNPass (String email, String password) {
        SQLiteDatabase db = getWritableDatabase();

        String sql = "SELECT email, password FROM User"; // WHERE email = " + email + " AND password = " + password;

        Cursor c = db.rawQuery(sql, null);

        boolean returnBool = false;

        while (c.moveToNext()) {
            String emailDb = c.getString(0);
            String passwordDb = c.getString(1);

            System.out.println("emailDB:  "+emailDb);
            System.out.println("pasDB:  "+passwordDb);
            System.out.println("email:  "+email);
            System.out.println("pas:  "+password);

            if (emailDb.equals(email)) {
                if (passwordDb.equals(password)) {
                    returnBool = true;
                    break;
                } else {
                    returnBool = false;
                }
            } else {
                returnBool = false;
            }
        }
        /*if (!(c.moveToFirst()) || c.getCount() == 0){
            return false;
        } else {
            return true;
        }*/
        return returnBool;
    }
}
