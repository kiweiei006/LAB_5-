package com.example.lab_5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddNoteActivity extends AppCompatActivity {

    private EditText etUserName, etPassword;
    private Button btnSave;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etUserName = findViewById(R.id.editTextText3);
        etPassword = findViewById(R.id.editTextText4);
        btnSave    = findViewById(R.id.button4);

        btnSave.setOnClickListener(v -> {
            String name = etUserName.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();

            if (name.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ", Toast.LENGTH_SHORT).show();
                return;
            }

            User user = null;
            if (name.equals("admin006") && pass.equals("6789")) {
                user = new User("admin006", "6789");
                user.setEmail("admin006@mail.com");
            } else if (name.equals("kxweiei") && pass.equals("2006")) {
                user = new User("kxweiei", "2006");
                user.setEmail("kxweiei@example.com");
            }

            if (user == null) {
                Toast.makeText(this, "ไม่พบผู้ใช้หรือรหัสผ่านไม่ถูกต้อง", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent result = new Intent();
            result.putExtra("user", user);
            setResult(RESULT_OK, result);
            finish();
        });
    }
}