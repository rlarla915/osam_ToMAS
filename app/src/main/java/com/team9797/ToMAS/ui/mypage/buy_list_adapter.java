package com.team9797.ToMAS.ui.mypage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.team9797.ToMAS.MainActivity;
import com.team9797.ToMAS.R;
import com.team9797.ToMAS.ui.home.group.recruit_register_fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class buy_list_adapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    public ArrayList<buy_list_item> listViewItemList = new ArrayList<buy_list_item>() ;
    MainActivity mainActivity;

    // ListViewAdapter의 생성자
    public buy_list_adapter() {

    }

    public buy_list_adapter(MainActivity tmp_mainActivity) {
        mainActivity = tmp_mainActivity;
    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.buy_list_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView item_title = (TextView) convertView.findViewById(R.id.buy_list_item_title);
        TextView item_date = (TextView) convertView.findViewById(R.id.buy_list_item_date);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        buy_list_item listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        item_title.setText(listViewItem.getTitle());
        item_date.setText(listViewItem.getDate());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String title, String date, String post_id) {
        buy_list_item item = new buy_list_item();

        item.setTitle(title);
        item.setDate(date);
        item.setId(post_id);

        listViewItemList.add(item);
    }
}