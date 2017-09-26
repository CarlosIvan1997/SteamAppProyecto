package poclin.carlos.steam_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CrearActivity extends AppCompatActivity {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.et_names)
    EditText etNames;
    @BindView(R.id.et_apellidos)
    EditText etApellidos;
    @BindView(R.id.et_correo)
    EditText etCorreo;
    @BindView(R.id.et_usuario)
    EditText etUsuario;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_guardar)
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_guardar) //TODO terminar boton guardar y avanzar las otras interfaces
    public void onViewClicked() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
