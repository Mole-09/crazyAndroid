package ca.xcb.example.ca.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import ca.xcb.example.ca.R;

public class chooseDateActivity extends Activity {
    @BindView(R.id.datePicker)
    DatePicker datePicker;
    @BindView(R.id.timePicker)
    TimePicker timePicker;
    @BindView(R.id.show)
    EditText show;
    //定义5个记录当前时间的变量
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    public void onCreate(Bundle savedInsatanceState) {
        super.onCreate(savedInsatanceState);
        setContentView(R.layout.choose_date);
        ButterKnife.bind(this);
        //获取当前的年月日小时分钟
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        //初始化DatePicker组件，初始化时指定监听器
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                chooseDateActivity.this.year = year;
                chooseDateActivity.this.month = month;
                chooseDateActivity.this.day = day;
                //显示当前日期，时间
                showDate(year,month,day,hour,minute);
            }
        });
        timePicker.setEnabled(true);
        //为TimePicker指定监听器
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                chooseDateActivity.this.hour = hourOfDay;
                chooseDateActivity.this.minute = minute;
                //显示当前日期，时间
                showDate(year,month,day,hour,minute);
            }
        });
    }
    //定义在EditText中显示当前日期，时间的方法
    private void showDate(int year,int month,int day,int hour,int minute){
        show.setText("您的购买日期是："+year+"年"+(month+1)+"月"+day+"日"+hour+"时"+minute+"分");
    }
}
