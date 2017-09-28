package poclin.carlos.steam_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import poclin.carlos.steam_app.model.UserModel;

/**
 * Created by CARLOSIVÁN on 27/09/2017.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String NOMBRE_DB = "mydb.db";
    public static final Integer VERSION_DB = 2;

    private static StringBuilder sbCreateTableUserSQL = new StringBuilder()
            .append("CREATE TABLE " + UserModel.TABLE_NAME+ " ( ")
            .append(UserModel.NOMBRES_FIELD + " TEXT PRIMARY KEY, ")
            .append(UserModel.APELLIDOS_FIELD + " TEXT, ")
            .append(UserModel.CORREO_FIELD + " TEXT, ")
            .append(UserModel.USER_FIELD + " TEXT, ")
            .append(UserModel.PASSWORD_FIELD + " TEXT ) ");

    public MySQLiteOpenHelper(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( sbCreateTableUserSQL.toString() );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
