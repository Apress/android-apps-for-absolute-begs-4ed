package com.example.user.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UniverseActivity extends AppCompatActivity {
    Button worldButton;
    Intent worldIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);
        worldButton = (Button) findViewById(R.id.button);
        worldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                worldIntent = new Intent(UniverseActivity.this, MainActivity.class);
                startActivity(worldIntent);
            }
        });
    }
}