package com.example.user.digitalaudiosequencer;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
public class ScrollingActivity extends AppCompatActivity {
    SoundPool animalSamples;
    AudioAttributes sampleAttributes;
    int sIdCat, sIdDog, sIdBird, sIdLion, sIdHorse, sIdMonkey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        setupAnimalSamples();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView bird = (ImageView) findViewById(R.id.bird);
        bird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animalSamples.play(sIdBird, 1.0f, 1.0f, 1, 0, 1.0f);
            }
        });
        ImageView horse = (ImageView) findViewById(R.id.horse);
        horse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animalSamples.play(sIdHorse, 1.0f, 1.0f, 1, 0, 1.0f);
            }
        });
        ImageView monkey = (ImageView) findViewById(R.id.monkey);
        monkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animalSamples.play(sIdMonkey, 1.0f, 1.0f, 1, 0, 1.0f);
            }
        });
        ImageView lion = (ImageView) findViewById(R.id.lion);
        lion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animalSamples.play(sIdLion, 1.0f, 1.0f, 1, 0, 1.0f);
            }
        });
        ImageView dog = (ImageView) findViewById(R.id.dog);
        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animalSamples.play(sIdDog, 1.0f, 1.0f, 1, 0, 1.0f);
            }
        });
        ImageView cat = (ImageView) findViewById(R.id.cat);
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animalSamples.play(sIdCat, 1.0f, 1.0f, 1, 0, 1.0f);
            }
        });
        startService(new Intent(this, AmbientAudioService.class));
    }
    public void setupAnimalSamples() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sampleAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
            animalSamples = new SoundPool.Builder().setMaxStreams(6).setAudioAttributes(sampleAttributes).build();
        } else {
            animalSamples = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }
        sIdCat    = animalSamples.load(this, R.raw.cat, 1);
        sIdDog    = animalSamples.load(this, R.raw.dog, 2);
        sIdBird   = animalSamples.load(this, R.raw.bird, 3);
        sIdLion   = animalSamples.load(this, R.raw.lion, 4);
        sIdHorse  = animalSamples.load(this, R.raw.horse, 5);
        sIdMonkey = animalSamples.load(this, R.raw.monkey, 6);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) { return true; }
        return super.onOptionsItemSelected(item);
    }
}
