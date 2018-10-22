package zjl.example.com.stickylistviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import se.emilsjolander.stickylistheaders.ExpandableStickyListHeadersListView;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends AppCompatActivity {

    List<String> listStr=new ArrayList<>();
    StickyListHeadersAdapter stickyListHeadersAdapter;
    Toast toast = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);//要在activity创建完之后才能获取到该activity的Content

        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("122");
        list.add("133");
        list.add("211");
        list.add("222");
        list.add("233");
        list.add("244");
        StickyListHeadersListView stickyList = (StickyListHeadersListView) findViewById(R.id.stickyListHeadersListView);
        MyAdapter adapter = new MyAdapter(this,list);
        stickyList.setAdapter(adapter);
        adapter.setOnMyItemClickListener(new MyAdapter.OnMyItemClickListener() {
            @Override
            public void onMyItemClick(int position, Object object) {
                //1
//                ToastUtil.newToast(MainActivity.this, String.valueOf(position));//该方式不太好，但也能实现效果
                //2
//                Toast.makeText(MainActivity.this, "Click on item" + position, Toast.LENGTH_SHORT).show();
                //3
//                ToastUtil2.showText(MainActivity.this,"Click on item" + position);
                //4
                toast.setText(String.valueOf(position));
                toast.show();
            }

            @Override
            public void onMyItemLongClick(int position, Object object) {
                //1
//                ToastUtil.newToast(MainActivity.this, String.valueOf(position));//该方式不太好，但也能实现效果
                //2
//                Toast.makeText(MainActivity.this, "Long click on item" + position, Toast.LENGTH_SHORT).show();
                //3
//                ToastUtil2.showText(MainActivity.this,"Click on item" + position);
                //4
                toast.setText(String.valueOf(position));
                toast.show();
            }
        });


        String[] countries =getResources().getStringArray(R.array.countries);
        listStr= Arrays.asList(countries);
        //可展开
        final ExpandableStickyListHeadersListView expandableStickyList = (ExpandableStickyListHeadersListView) findViewById(R.id.expandableStickyListHeadersListView);
        stickyListHeadersAdapter = new MyAdapter(this,listStr);
        expandableStickyList.setAdapter(stickyListHeadersAdapter);
        expandableStickyList.setOnHeaderClickListener(new StickyListHeadersListView.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(StickyListHeadersListView l, View header, int itemPosition, long headerId, boolean currentlySticky) {
                if (expandableStickyList.isHeaderCollapsed(headerId)) {
                    expandableStickyList.expand(headerId);
                } else {
                    expandableStickyList.collapse(headerId);
                }
            }
        });

        final MyAdapter myAdapter = (MyAdapter) stickyListHeadersAdapter;
        myAdapter.setOnMyItemClickListener(new MyAdapter.OnMyItemClickListener() {
            @Override
            public void onMyItemClick(int position, Object object) {
                Toast.makeText(MainActivity.this, "Click on item" + position, Toast.LENGTH_SHORT).show();

                myAdapter.addItem();
            }

            @Override
            public void onMyItemLongClick(int position, Object object) {
                Toast.makeText(MainActivity.this, "Click long  on item" + position, Toast.LENGTH_SHORT).show();
                myAdapter.deleteItem(position);
            }
        });


    }
}
