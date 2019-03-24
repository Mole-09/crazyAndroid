package ca.xcb.example.ca.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import ca.xcb.example.ca.R;
import android.view.View;
import android.widget.TableLayout;

public class dialogActivity extends Activity {

    String[] items = new String[]{
            "君不见高堂明镜悲白发",
            "君不见朝如青丝暮成雪",
            "呼儿将出换美酒",
            "与尔同销万古愁"};
    @BindView(R.id.show)
    EditText show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dilog_main);
        ButterKnife.bind(this);
    }

    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder){
        //调用setPositionButton方法添加“确定”按钮
        return  builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了【确定】按钮！");
            }
        });
    }
    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder){
        //调用setNegativeButton方法添加"取消“按钮
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了【取消】按钮！");
            }
        });
    }
    public void simple(View source){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                //设置对话框标题
        .setTitle("简单对话框")
                //设置图标
        .setIcon(R.drawable.tools)
                .setMessage("对话框的测试内容\n第二行内容");
        //为AlertDialog.Builder添加"确定"按钮
        setPositiveButton(builder);
        //为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void simpleList(View source){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                //设置标题对话框
        .setTitle("简单列表对话框")
                //设置图标
        .setIcon(R.drawable.tools)
                //设置简单的列表项的内容
        .setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("你选中了"+items[which]);
            }
        });
        //为AlterDialog.Builder添加确定按钮
        setPositiveButton(builder);
        //为添加取消按钮
        setNegativeButton(builder)
                .create().show();
    }

    public  void singleChoice(View source){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("单选列表项对话框")
                .setIcon(R.drawable.tools)
                //设置单选列表项，默认选中第二项（索引为1）
        .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("你选中了"+items[which]);
            }
        });
        //为AlterDialog.Builder添加确定按钮
        setPositiveButton(builder);
        //为添加取消按钮
        setNegativeButton(builder)
                .create().show();
    }


    public void multiChoice(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // 设置对话框标题
                .setTitle("多选列表项对话框")
                // 设置图标
                .setIcon(R.drawable.tools)
                // 设置多选列表项，设置勾选第2项、第4项
                .setMultiChoiceItems(items
                        , new boolean[]{false , true ,false ,true}, null);
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void customList(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // 设置对话框标题
                .setTitle("自定义列表项对话框")
                // 设置图标
                .setIcon(R.drawable.tools)
                // 设置自定义列表项
                .setAdapter(new ArrayAdapter<String>(this
                        , R.layout.array_item
                        , items), null);
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void customView(View source){
        //装载login布局文件
        TableLayout loginForm = (TableLayout)getLayoutInflater().inflate(R.layout.dilog_login,null);
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.tools)
                .setTitle("自定义View对话框")
                .setView(loginForm)
                .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //此处执行登录处理
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //取消登录，不做任何事情
                    }
                })
                .create()
                .show();
    }



}
