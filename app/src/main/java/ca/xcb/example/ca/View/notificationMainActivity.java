package ca.xcb.example.ca.View;
import android.content.Intent;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import ca.xcb.example.ca.R;

public class notificationMainActivity extends Activity {
    static  final int NOTIFICATION_ID = 0x123;
    NotificationManager nm;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificatin_show);
        //获取系统的NotifiManager服务
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
    //为发送通知的按钮的点击事件定义事件处理方法
    public void send(View source){
        //创建一个启动其他Activity的Intent
        Intent intent = new Intent(notificationMainActivity.this,notificationOtherActivity.class);
        PendingIntent pi = PendingIntent.getActivity(notificationMainActivity.this,0,intent,0);
        Notification notify = new Notification.Builder(this)
                //设置打开该通知
                .setAutoCancel(true)
                //设置显示在状态栏的通知提示信息
                .setTicker("有新消息")
                //设置通知的图标
                .setSmallIcon(R.drawable.notify)
                //设置通知内容的标题
                .setContentTitle("一条新通知")
                //设置通知内容
                .setContentText("恭喜你，加薪了。")
                //设置使用系统默认的声音，默认LED灯
                //.setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_LIGHTS)
                //设置通知的自定义声音
                //.setSound(Uri.parse("android.resource://org.ca.ui"+R.raw.msg))
                 .setWhen(System.currentTimeMillis())
                //设该通知将要启动程序的Intent
                .setContentIntent(pi)
                .build();
        //发送通知
        nm.notify(NOTIFICATION_ID,notify);

    }

    //为删除通知的按钮点击事件定义事件处理方法
    public void del(View v){
        //取消通知
        nm.cancel(NOTIFICATION_ID);
    }
}
