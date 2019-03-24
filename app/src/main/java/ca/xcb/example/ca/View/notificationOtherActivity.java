package ca.xcb.example.ca.View;

import android.app.Activity;
import android.os.Bundle;

import ca.xcb.example.ca.R;

public class notificationOtherActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //设置该Activity显示的页面
        setContentView(R.layout.notification_others);
    }
}
