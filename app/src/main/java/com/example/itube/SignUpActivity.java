package com.example.itube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.itube.data.User;
import com.example.itube.data.iTubeRepository;
import com.example.itube.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        iTubeRepository repository = new iTubeRepository(getApplication());

        binding.createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.usernameSignup.getText().toString();
                String password = binding.passwordSignup.getText().toString();
                String confirmPass = binding.confirmPassword.getText().toString();
                String fullname = binding.fullname.getText().toString();

                if (password.equals(confirmPass)) {
                    // Make an account for the new user and log them in
                    repository.insertUser(new User(username, password, fullname));
                    Toast.makeText(SignUpActivity.this, "Account created!", Toast.LENGTH_SHORT).show();

                    Intent signUpIntent = new Intent(SignUpActivity.this, HomeActivity.class);
                    signUpIntent.putExtra("username", username);
                    startActivity(signUpIntent);
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}