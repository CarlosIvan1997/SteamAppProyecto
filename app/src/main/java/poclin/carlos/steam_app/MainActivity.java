package poclin.carlos.steam_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

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
    }

    @OnClick({R.id.btn_crear, R.id.btn_actualizar, R.id.btn_buscar, R.id.btn_eliminar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_crear:
                Intent intent = new Intent(MainActivity.this, CrearActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_actualizar:
                break;
            case R.id.btn_buscar:
                break;
            case R.id.btn_eliminar:
                break;
        }
    }
}
