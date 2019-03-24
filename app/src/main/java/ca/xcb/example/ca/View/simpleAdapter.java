package ca.xcb.example.ca.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.xcb.example.ca.R;

public class simpleAdapter extends Activity{

    private String[] names = new String[]
            {"虎头","弄玉","李清照","李白"};
    private String[] descs = new String[]
            {"可爱的小孩","一个擅长音乐的女孩",
             "一个擅长文学的女性","浪漫主义诗人"};
    private int[] imagesIds = new int[]
            {R.drawable.tiger,
                    R.drawable.nongyu,
             R.drawable.qingzhao,
                    R.drawable.libai};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_adapter_main);

        //创建一个List集合，list集合的元素是Map
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for(int i =0;i<names.length;i++){
            Map<String,Object> listItem = new HashMap<String, Object>();
            listItem.put("header",imagesIds[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }

        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.simple_item,
                new String[]{"personName","header","desc"},
                new int[]{R.id.name,R.id.header,R.id.desc});
        ListView list = (ListView) findViewById(R.id.mylist);

        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);

        //为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position]+"被单击了");
            }
        });

        //为ListView的列表项的选中事件绑定事件监听器
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //第position项被选中时激发该方法
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position]+"被选中了");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
