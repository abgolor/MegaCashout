package com.dekraftsman.megacashout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.dekraftsman.megacashout.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;



public class AdminLoginActivity extends AppCompatActivity {

    private EditText emailEdt, passwordEdt;

    private Button login;

    private FirebaseAuth firebaseAuth;

    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        emailEdt = findViewById(R.id.admin_email_address);
        passwordEdt = findViewById(R.id.admin_password);
        login = findViewById(R.id.admin_login);

        firebaseAuth = FirebaseAuth.getInstance();

        loadingDialog = showLoadingDialog();

        login.setOnClickListener(v -> {
            showLoadingDialog().show();
            signAdminLogin();
        });
    }

    private void signAdminLogin() {
        String email = emailEdt.getText().toString().toLowerCase(Locale.ROOT);
        String password = passwordEdt.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            loadingDialog.dismiss();
            if(task.isSuccessful()){
                goToAdminDashboard();
            } else {
                AlertDialog.Builder builder = new MaterialAlertDialogBuilder(AdminLoginActivity.this)
                        .setTitle("Login Failed!")
                        .setMessage("Invalid email address or password.");
                builder.show();
            }
        });
    }

    private void goToAdminDashboard() {
        Intent adminDashboardIntent = new Intent(getApplicationContext(), AdminDashboardActivity.class);
        startActivity(adminDashboardIntent);
    }

    public Dialog showLoadingDialog(){

        Dialog dialog = new Dialog(AdminLoginActivity.this);
        dialog.setContentView(R.layout.loading_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        return dialog;
    }
}