package ca.xcb.example.ca.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ca.xcb.example.ca.R;

public class fingerBallActivity extends Activity {

    @BindView(R.id.root)
    LinearLayout mroot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_scam_pic);
        ButterKnife.bind(this);

        //创建fingerBall组件
        final fingerBall ball = new fingerBall(this);
        //设置自定义组件的最小宽度，高度
        ball.setMinimumHeight(500);
        ball.setMinimumWidth(300);
        mroot.addView(ball);

    }


}
