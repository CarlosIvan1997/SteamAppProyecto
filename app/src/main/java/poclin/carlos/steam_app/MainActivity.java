package poclin.carlos.steam_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import poclin.carlos.steam_app.dao.UserDao;
import poclin.carlos.steam_app.model.UserModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.btn_crear)
    Button btnCrear;
    @BindView(R.id.btn_actualizar)
    Button btnActualizar;
    @BindView(R.id.btn_buscar)
    Button btnBuscar;
    @BindView(R.id.btn_eliminar)
    Button btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /*String query = "select sqlite_version() AS sqlite_version";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(":memory:", null);
        Cursor cursor = db.rawQuery(query, null);
        String sqliteVersion = "";
        if (cursor.moveToNext()) {
            sqliteVersion = cursor.getString(0);
        }

        Log.v(TAG, "Version SQLite = " + sqliteVersion);*/
    }

    @OnClick({R.id.btn_crear, R.id.btn_actualizar, R.id.btn_buscar, R.id.btn_eliminar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_crear:
                Intent intent = new Intent(MainActivity.this, CrearActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_actualizar:
                Intent intent1 = new Intent(MainActivity.this, BuscarActualizarActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_buscar:
                Intent intent2 = new Intent(MainActivity.this, BuscarActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_eliminar:
                Intent intent3 = new Intent(MainActivity.this, BuscarEliminarActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
