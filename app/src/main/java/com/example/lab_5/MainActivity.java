package com.example.lab_5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAddNote, btnBrowseNote;
    ProgressBar progressBar2;
    ImageView logo;

    private final ActivityResultLauncher<Intent> addNoteLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    User user = (User) result.getData().getSerializableExtra("user");
                    if (user != null) {
                        Intent show = new Intent(this, UserDetailActivity.class);
                        show.putExtra("user", user);
                        startActivity(show);


                    } else {
                        Toast.makeText(this, "No user returned", Toast.LENGTH_SHORT).show();
                    }
                }
            });

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        logo = findViewById(R.id.imageView);
        btnAddNote = findViewById(R.id.button);
        btnBrowseNote = findViewById(R.id.button2);
        progressBar2 = findViewById(R.id.progressBar);

        logo.setImageResource(R.drawable.kiw006);
        progressBar2.setVisibility(android.view.View.GONE);

        btnAddNote.setOnClickListener(v -> {
            Intent addNote = new Intent(MainActivity.this, AddNoteActivity.class);
            addNoteLauncher.launch(addNote);
        });

        btnBrowseNote.setOnClickListener(v -> {
            progressBar2.setVisibility(android.view.View.VISIBLE);
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {
                }
                runOnUiThread(() -> {
                    progressBar2.setVisibility(android.view.View.GONE);
                    startActivity(new Intent(getApplicationContext(), BrowseNote.class));
                });
            }).start();
        });
    }
}
/*public static void main(String[] args) {
        /*Note note1 = new Note();

        note1.title = "Homework";
        //note1.content = "Homework to do";
        note1.createdDate = "17/07/2025";
        note1.getSummary();*/

    // super class
    /*TextNote textNote1 = new TextNote();
    textNote1.title = "";
    //textNote1.content = "";
    textNote1.createdDate = "";

    textNote1.getSummary();

    User user1 = new User();
    user1.Email = "Thanapon@gmail.com";
    user1.Username = "Thanaphon";
    user1.Birthdate = "11/02/2006";
    user1.update_profile();
}*/


