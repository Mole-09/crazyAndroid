package ca.xcb.example.ca.View;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ca.xcb.example.ca.R;

public class imageBrowser extends Activity {

    //定义一个访问图片的数组
    int[] images = new int[]{
            R.drawable.java,
            R.drawable.javaee,
            R.drawable.swift,
            R.drawable.ajax,
            R.drawable.html,};

    //定义默认显示的图片
    int currentImg = 2;
    @BindView(R.id.plus)
    Button mplus;
    @BindView(R.id.minus)
    Button mminus;
    @BindView(R.id.next)
    Button mnext;
    @BindView(R.id.image1)
    ImageView mimage1;
    @BindView(R.id.image2)
    ImageView mimage2;
    //定义图片的初始透明度
    private int alpha = 255;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_selector);
        ButterKnife.bind(this);

        //定义查看下一张图片的监听器
        mnext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //控制ImageView显示下一张图片
                mimage1.setImageResource(images[++currentImg%images.length]);
            }
        });

        //定义改变图片透明度的方法
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(v == mplus){
                    alpha += 20;
                }
                if(v == mminus){
                    alpha -= 20;
                }
                if(alpha >= 255){
                    alpha = 255;
                }
                if(alpha <=0){
                    alpha = 0;
                }
                //改变图片的透明度
                mimage1.setImageAlpha(alpha);
            }
        };

        //为两个按钮添加监听器
        mplus.setOnClickListener(listener);
        mminus.setOnClickListener(listener);

        mimage1.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){
                BitmapDrawable bitmapDrawable = (BitmapDrawable) mimage1.getDrawable();
                //获取第一个位于显示框中的位图
                Bitmap bitmap = bitmapDrawable.getBitmap();
                //bitmap图片实际大小与第一个ImageView的缩放比例
                double scale = 1.0 * bitmap.getHeight()/mimage1.getHeight();
                //获取需要显示的图片的开始点
                int x = (int) (event.getX()*scale);
                int y = (int) (event.getY()*scale);
                if(x+120>bitmap.getWidth()){
                    x = bitmap.getWidth() - 120 ;
                }
                if(y+120>bitmap.getHeight()){
                    y=bitmap.getHeight() - 120;
                }
                //显示图片的指定区域
                mimage2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                mimage2.setImageAlpha(alpha);
                return false;
            }
        });
    }
}
