package poclin.carlos.steam_app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import poclin.carlos.steam_app.MySQLiteOpenHelper;
import poclin.carlos.steam_app.model.UserModel;

/**
 * Created by CARLOSIVÁN on 27/09/2017.
 */

public class UserDao {

    private MySQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public UserDao(Context context){
        this.sqLiteOpenHelper = new MySQLiteOpenHelper(context);
        this.sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public long insertarUsuario(UserModel user){

        ContentValues valores = new ContentValues();
        valores.put(UserModel.NOMBRES_FIELD, user.getNombres());
        valores.put(UserModel.APELLIDOS_FIELD, user.getApellidos());
        valores.put(UserModel.CORREO_FIELD, user.getCorreo());
        valores.put(UserModel.USER_FIELD, user.getUser());
        valores.put(UserModel.PASSWORD_FIELD, user.getPassword());

        //me retornará el numero de filas insertadas o -1 si es error
        long result = sqLiteDatabase.insert(UserModel.TABLE_NAME, null, valores);

        return result;
    }

    public int actualizarUsuario(UserModel user){

        ContentValues valores = new ContentValues();
        valores.put(UserModel.NOMBRES_FIELD, user.getNombres());
        valores.put(UserModel.APELLIDOS_FIELD, user.getApellidos());
        valores.put(UserModel.CORREO_FIELD, user.getCorreo());
        valores.put(UserModel.USER_FIELD, user.getUser());
        valores.put(UserModel.PASSWORD_FIELD, user.getPassword());

        String whereClause = UserModel.USER_FIELD + "=?";
        String [] whereArgs = { user.getUser() };

        //Retorna la cantidad de filas actualizadas, 0 si no actualiza nada
        int result = sqLiteDatabase.update(UserModel.TABLE_NAME, valores, whereClause, whereArgs);

        return result;
    }

    public int eliminarUsuario(String user){

        String whereClause = UserModel.USER_FIELD + "=?";
        String [] whereArgs = { user };
        int result = sqLiteDatabase.delete(UserModel.TABLE_NAME,whereClause,whereArgs);

        return result;
    }

    public List<UserModel> obtenerUsuarios(){

        String [] fields = {UserModel.NOMBRES_FIELD,
                            UserModel.APELLIDOS_FIELD,
                            UserModel.CORREO_FIELD,
                            UserModel.USER_FIELD,
                            UserModel.PASSWORD_FIELD};

        Cursor cursor = sqLiteDatabase.query(UserModel.TABLE_NAME, fields, null, null, null, null, null);

        return convertCursorToList(cursor);
    }

    private List<UserModel> convertCursorToList (Cursor mCursor){

        List<UserModel> arrList = new ArrayList<>();

        if(mCursor.moveToFirst()){
            do{
                UserModel model = new UserModel();

                model.setNombres(mCursor.getString((mCursor.getColumnIndex(UserModel.NOMBRES_FIELD))));
                model.setApellidos(mCursor.getString((mCursor.getColumnIndex(UserModel.APELLIDOS_FIELD))));
                model.setCorreo(mCursor.getString((mCursor.getColumnIndex(UserModel.CORREO_FIELD))));
                model.setUser(mCursor.getString((mCursor.getColumnIndex(UserModel.USER_FIELD))));
                model.setPassword(mCursor.getString((mCursor.getColumnIndex(UserModel.PASSWORD_FIELD))));

                arrList.add(model);
            }while (mCursor.moveToNext());
        }
        return arrList;
    }

}
