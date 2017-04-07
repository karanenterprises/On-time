package com.example.max.ontime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    Button b1;
    String a,b,c,d,e;
    EditText name,emailid,password,phoneno,address;
    dbHelper db;
    boolean bb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        b1=(Button)findViewById(R.id.create);
        name=(EditText)findViewById(R.id.name);
        emailid=(EditText)findViewById(R.id.emailid);
        password=(EditText)findViewById(R.id.password);
        phoneno=(EditText)findViewById(R.id.phone);
        address=(EditText)findViewById(R.id.address);
        db=new dbHelper(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().length()!=0 && emailid.getText().length() !=0
                        && password.getText().length() !=0 && phoneno.getText().length() !=11 && address.getText().length() !=0)
                {
                    a = name.getText().toString();
                    b = emailid.getText().toString();
                    c = password.getText().toString();
                    d = phoneno.getText().toString();
                    e = address.getText().toString();

                    bb1 = db.insertinfo(a,b,c,d,e);
                    Log.e("e",b);
                }
                else
                {
                    Toast.makeText(Signup.this,"Please insert values",Toast.LENGTH_SHORT).show();
                }

                if(bb1==true)
                {
                    Toast.makeText(Signup.this,"Sucessfull",Toast.LENGTH_SHORT).show();
                }
//                else
//                {
//                    Toast.makeText(Signup.this,"unSucessfull",Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}
