package com.sample.activitylifecycledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText _userName;
    @BindView(R.id.full_name)
    EditText _fullName;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.login_link)
    TextView _loginGoButton;
    @BindView(R.id.submit)
    Button _signupButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    finish();
            }
        });

        _loginGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    public void scrollIt(View view) {
        ScrollView sv = (ScrollView) findViewById(R.id.scrollLogin);
        sv.scrollTo(0, sv.getMaxScrollAmount());
    }
}