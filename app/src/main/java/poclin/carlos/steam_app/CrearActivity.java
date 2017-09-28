package poclin.carlos.steam_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import poclin.carlos.steam_app.dao.UserDao;
import poclin.carlos.steam_app.model.UserModel;

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

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_guardar) //
    public void onViewClicked() {
        boolean correcto = true;

        String mNombres = etNames.getText().toString().trim();
        String mApellidos = etApellidos.getText().toString().trim();
        String mCorreo = etCorreo.getText().toString().trim();
        String mUser = etUsuario.getText().toString().trim();
        String mPassword = etPassword.getText().toString().trim();

        if(mNombres.equals("") || mApellidos.equals("") || mCorreo.equals("")|| mUser.equals("")||mPassword.equals("")){
            correcto=false;
        }

        if(correcto==true){
            UserModel userModel = new UserModel();
            userModel.setNombres(mNombres);
            userModel.setApellidos(mApellidos);
            userModel.setCorreo(mCorreo);
            userModel.setUser(mUser);
            userModel.setPassword(mPassword);

            userDao = new UserDao(this);
            long resultado = userDao.insertarUsuario(userModel);

            if(resultado==-1){
                Toast.makeText(this, R.string.toast_usuario_existe, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, R.string.toast_usuario_creado, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CrearActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }else{
            Toast.makeText(this, R.string.toast_completar_datos, Toast.LENGTH_SHORT).show();
        }
    }
}
