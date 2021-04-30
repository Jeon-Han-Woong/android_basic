package org.ict.checkbatteryprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtBattery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtBattery = (EditText)findViewById(R.id.edtBattery);
    }

    // 배터리 체크를 위한 브로드캐스트객체 생성
    BroadcastReceiver br = new BroadcastReceiver() {
        // onReceive메서드는 배터리 잔량표기가 변할때마다 호출.
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                edtBattery.setText("현재 충전량: " + remain + "%\n");

                if(remain >= 90) {
                    edtBattery.setText("잔량이 90이상입니다.");
                } else if(remain >= 70) {
                    edtBattery.setText("잔량이 70이상입니다.");
                } else if(remain >= 50) {
                    edtBattery.setText("잔량이 50이상입니다.");
                } else if(remain >= 10) {
                    edtBattery.setText("잔량이 10이상입니다. 충전이 필요합니다.");
                }
                // 충전 중 여부를 intent에서 얻어올 수 있음.
                int plus = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
                switch (plus) {
                    case 0:
                        edtBattery.append("전원 연결 : X");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        edtBattery.append("전원 연결 : 어댑터 연결됨");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        edtBattery.append("전원 연결 : USB로 연결됨");
                        break;
                }
            }
        }
    };

    // onPause() 오버라이딩
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }

    // onPostResume() 오버라이딩
    // 상태 변화를 휴대폰이 감지할 수 있도록 등록.
    @Override
    protected void onPostResume() {
        super.onPostResume();
        IntentFilter iFilter = new IntentFilter();
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, iFilter);
    }
}