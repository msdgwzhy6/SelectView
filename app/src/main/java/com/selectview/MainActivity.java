package com.selectview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SelectView selectView1;
    private SelectView selectView2;
    private SelectView selectView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        selectView1 = (SelectView) findViewById(R.id.selectView1);
        selectView2 = (SelectView) findViewById(R.id.selectView2);
        selectView3 = (SelectView) findViewById(R.id.selectView3);

        selectView2.setColor(0,100,0);
        selectView2.setSelect(3,4);

        selectView3.setColor(220,20,60);
    }
}
