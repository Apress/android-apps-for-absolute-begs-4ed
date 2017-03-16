package com.example.user.digitalaudiosequencer;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
public class AmbientAudioService extends Service {
    MediaPlayer ambientAudioPlayer;
    public AmbientAudioService() {}
    @Override
    public void onCreate() {
        super.onCreate();
        ambientAudioPlayer = MediaPlayer.create(this, R.raw.ambient);
        ambientAudioPlayer.setLooping(true);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ambientAudioPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        ambientAudioPlayer.stop();
        ambientAudioPlayer.release();
        super.onDestroy();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
