package poclin.carlos.steam_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActualizarActivity extends AppCompatActivity {

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
    @BindView(R.id.btn_actualizar)
    Button btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_actualizar)
    public void onViewClicked() {
    }
}
