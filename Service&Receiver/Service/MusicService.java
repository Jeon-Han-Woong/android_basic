package org.ict.musicplayprj;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    // 음악은 MediaPlayer 타입으로 실행.
    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        android.util.Log.i("서비스 테스트", "onCreate()");
    }

    // 서비스 실행체크 override의 onStartCommand를 구현.

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        android.util.Log.i("서비스 테스트", "onStartCommand()");
        Toast.makeText(getApplicationContext(), "노래 시작", Toast.LENGTH_SHORT).show();
        // 음악 실행시 먼저 .create()로 객체 생성 후
        mp = MediaPlayer.create(this, R.raw.test);
        // 무한 반복 설정
        mp.setLooping(true);
        // 실제로 실행
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }

    // 서비스 종료체크 override의 onDestroy를 구현.

    @Override
    public void onDestroy() {
        android.util.Log.i("서비스 테스트", "onDestroy()");
        Toast.makeText(getApplicationContext(), "노래 종료", Toast.LENGTH_SHORT).show();
        mp.stop();
        super.onDestroy();
    }
}
