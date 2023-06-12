package practica.univalle.basicretrofitadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import practica.univalle.basicretrofitadapter.util.SharedPrefsUtil;

public class MainActivity extends AppCompatActivity {
    private EditText userName;
    private SharedPrefsUtil sharedPrefsUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPrefsUtil = new SharedPrefsUtil(this);
        userName = findViewById(R.id.editTextUserName);
    }


    public void saveUserName(View view) {
        sharedPrefsUtil.saveString("username", userName.getText().toString());
        Toast.makeText(this, "Username saved!", Toast.LENGTH_SHORT).show();
    }

    public void retrieveUserName(View view) {
        String name = sharedPrefsUtil.getString("username");
        Toast.makeText(this, "Username: " + name, Toast.LENGTH_SHORT).show();
    }

}