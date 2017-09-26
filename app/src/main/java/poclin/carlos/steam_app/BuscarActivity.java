package poclin.carlos.steam_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuscarActivity extends AppCompatActivity {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.et_usuario)
    EditText etUsuario;
    @BindView(R.id.btn_buscar)
    Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_buscar)
    public void onViewClicked() {
        Intent intent = new Intent(BuscarActivity.this, BuscarDatosActivity.class);
        startActivity(intent);
    }
}
