package ca.xcb.example.ca.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ca.xcb.example.ca.R;

public class easyScamPic extends Activity {

    //定义一个访问图片的数组
    int[] images = new int[]{
            R.drawable.java,
            R.drawable.javaee,
            R.drawable.swift,
            R.drawable.ajax,
            R.drawable.html,};
    int currentImg = 0;
    @BindView(R.id.root)
    LinearLayout mroot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_scam_pic);
        ButterKnife.bind(this);
        //获取LinearLayout布局容器
        //创建ImageView组件
        final ImageView image = new ImageView(this);
        //将ImageView组件添加到LinearLayout布局容器中
        mroot.addView(image);
        //初始化时显示第一张图片
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //改变ImageView的显示图片
                image.setImageResource(images [++currentImg% images.length]);
            }
        });

    }
}
