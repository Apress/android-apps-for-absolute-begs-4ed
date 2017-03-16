package com.example.user.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    Button universeButton;
    Intent universeIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        universeButton = (Button) findViewById(R.id.button_universe);
        universeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                universeIntent = new Intent(MainActivity.this, UniverseActivity.class);
                startActivity(universeIntent);
            }
        });
    }
}