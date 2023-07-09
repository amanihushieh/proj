package com.example.project;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    EditText edit2;
    EditText edit3;
    Button button;
    FirebaseAuth rauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        edit3=findViewById(R.id.edit3);
        button=findViewById(R.id.button);
        rauth=FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username,email,password;
                username=String.valueOf(edit1.getText());
                email=String.valueOf(edit2.getText());
                password=String.valueOf(edit3.getText());
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this,"enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this,"enter password ",Toast.LENGTH_SHORT).show();
                    return;
                }

              rauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          Toast.makeText(MainActivity.this,"success ",Toast.LENGTH_SHORT).show();


                      }else{
                          Toast.makeText(MainActivity.this,"failed ",Toast.LENGTH_SHORT).show();


                      }
                  }
              });

            }
        });


    }
}