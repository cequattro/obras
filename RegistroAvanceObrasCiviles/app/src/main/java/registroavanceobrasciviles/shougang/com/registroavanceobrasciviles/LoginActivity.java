package registroavanceobrasciviles.shougang.com.registroavanceobrasciviles;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnSalir;
    EditText etUsuario;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnSalir = (Button)findViewById(R.id.btnSalir);
        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etPassword = (EditText)findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Salir();
            }
        });
    }

    private  void Login(){

        if(etUsuario.getText().toString().length() == 0){
            Toast.makeText(this, R.string.ingreseUsuario,Toast.LENGTH_LONG).show();
            return;
        }

        if(etPassword.getText().toString().length() == 0){
            Toast.makeText(this, R.string.ingresePassword,Toast.LENGTH_LONG).show();
            return;
        }

        Intent obras = new Intent(LoginActivity.this,ObrasActivity.class);
        startActivity(obras);
    }

    private void Salir(){
        android.os.Process.killProcess(android.os.Process.myPid());
  }
}