package com.suctan.huigangdemo.activity.myself;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.suctan.huigangdemo.R;
import com.suctan.huigangdemo.activity.Popupwindow.my_kitchen_popupwin_release;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B-305 on 2017/4/13.
 */

public class MykitchenActity extends Activity{

    private  ListView lv;

    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.my_kitchen);

            lv = (ListView) findViewById(R.id.list_view_food);/*定义一个动态数组*/
            ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
            for (int i = 0; i < 100; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("ItemImage", R.mipmap.ic_launcher);//加入图片
                map.put("ItemTitle", "第" + i + "行");
                map.put("ItemText", "这是第" + i + "行");
                map.put("ItemMoney","¥"   + i);
                map.put("ItemReturn",R.mipmap.setting_arrow);
                listItem.add(map);
            }
            SimpleAdapter mSimpleAdapter = new SimpleAdapter(this, listItem,//需要绑定的数据
                    R.layout.list_item_food,//每一行的布局//动态数组中的数据源的键对应到定义布局的View中
                    new String[]{"ItemImage", "ItemTitle", "ItemText","ItemMoney","ItemReturn"},
                    new int[]{R.id.ItemImage, R.id.ItemTitle, R.id.ItemText, R.id.ItemMoney, R.id.ItemReturn
                    }
            );

            lv.setAdapter(mSimpleAdapter);//为ListView绑定适配器
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(getApplicationContext(),"你点击了我"+position,Toast.LENGTH_SHORT).show();
                }



            });
        }
     /*这个功能是我的厨房中的发布按钮弹出的popupwindow*/
    public void showPopFormBottom(View view) {
        my_kitchen_popupwin_release my_kitchen_popupwin_release = new my_kitchen_popupwin_release(this, onClickListener);
        my_kitchen_popupwin_release.showAtLocation(findViewById(R.id.main_view), Gravity.CENTER, 0, 0);
}

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_add_today_food:

                    break;
                case R.id.btn_add_new_food:

                    break;
            }
        }
    };


}
