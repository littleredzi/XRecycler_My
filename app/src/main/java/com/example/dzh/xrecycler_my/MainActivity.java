package com.example.dzh.xrecycler_my;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XRecyclerView xrecycler;
    private MyAdapter myAdapter;
    List<String>listdata=new ArrayList<>();

    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setAdapter();
        setData();

        xrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xrecycler.refreshComplete();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xrecycler.loadMoreComplete();
                        Toast.makeText(MainActivity.this, "上啦加载", Toast.LENGTH_SHORT).show();
                    }
                },2000);
            }
        });
    }

    private void setData() {
        for (int i = 0; i < 10; i++) {
            listdata.add("原数据"+i);
        }
        myAdapter.notifyDataSetChanged();
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrecycler.setLayoutManager(linearLayoutManager);
        xrecycler.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrecycler.setLoadingMoreProgressStyle(ProgressStyle.BallZigZagDeflect);
        xrecycler.setArrowImageView(R.drawable.iconfont_downgrey);

        myAdapter = new MyAdapter(MainActivity.this,listdata);
        xrecycler.setAdapter(myAdapter);
        xrecycler.refresh();
    }

    private void initView() {
        xrecycler = (XRecyclerView) findViewById(R.id.xrecycler);
        xrecycler.getDefaultFootView().setLoadingHint("自定义加载中提示");
        xrecycler.getDefaultFootView().setNoMoreHint("自定义加载完毕提示");
    }
}
