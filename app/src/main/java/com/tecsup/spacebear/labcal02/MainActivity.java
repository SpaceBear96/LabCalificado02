package com.tecsup.spacebear.labcal02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tecsup.spacebear.labcal02.models.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText)findViewById(R.id.username_input);
        pass=(EditText)findViewById(R.id.password_input);
    }

    public void call(View view){
      startActivityForResult(new Intent(this,RegisterActivity.class),100 );
    }

    public void v_user(View view){
        String t_user=user.getText().toString();
        String t_pass=pass.getText().toString();

        List<User> listaUser = User.listAll(User.class);

        for (int i = 0 ; i<listaUser.size();i++){
            User user = listaUser.get(i);
            if(t_pass.equalsIgnoreCase(user.getEmail().toString())){
                if(t_user.equals(user.getPassword().toString())){
                    Intent intent = new Intent(MainActivity.this,Inicio.class);
                    startActivity(intent);
                    finish();
                }
            }
        }



    }

}
