package ca.xcb.example.ca.View;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ca.xcb.example.ca.R;

public class searchActivity extends Activity {
    @BindView(R.id.sv)
    SearchView sv;
    @BindView(R.id.lv)
    ListView lv;

    //自动完成的列表
    private final String[] mStrings = {"aaaaaa", "bbbbbb", "ccccc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view);
        ButterKnife.bind(this);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mStrings));
        //设置ListView启用过滤
        lv.setTextFilterEnabled(true);
        //设置该SearchView默认是否自动缩小为图标
        sv.setIconifiedByDefault(true);
        //设置该SearchView显示搜索按钮
        sv.setSubmitButtonEnabled(true);
        //设置该SearchView内默认显示的提示文本
        sv.setQueryHint("查找");
        //为该SearchView组件设置事件监听器
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //单击搜索按钮时激发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                //实际应用中应该在该方法中执行实际查询
                //此处仅使用Toast显示用户输入的查询内容
                Toast.makeText(searchActivity.this,"您的选择是："+
                query,Toast.LENGTH_SHORT).show();

                return false;
            }
            //用户输入字符时激活该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                //如果newText不是长度为0的字符串
                if(TextUtils.isEmpty(newText)){
                    //清除ListView的过滤
                    lv.clearTextFilter();
                }
                else{
                    //使用用户输入的内容对ListView的列表项进行过滤
                    lv.setFilterText(newText);
                }
                return true;
            }
        });

    }
}
