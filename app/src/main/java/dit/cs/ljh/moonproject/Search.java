package dit.cs.ljh.moonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;

import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.ImageView;
import android.widget.ImageButton;

public class Search extends AppCompatActivity {

    String str;

    private Integer[] images={R.drawable.c0, R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10, R.drawable.c11, R.drawable.c12,
            R.drawable.c13, R.drawable.c14, R.drawable.c15, R.drawable.c16, R.drawable.c17, R.drawable.c18, R.drawable.c19, R.drawable.c20, R.drawable.c21, R.drawable.c22, R.drawable.c23, R.drawable.c24, R.drawable.c25, R.drawable.c26,
            R.drawable.c27, R.drawable.c28, R.drawable.c29, R.drawable.c30, R.drawable.c31, R.drawable.c32, R.drawable.c33, R.drawable.c34, R.drawable.c35, R.drawable.c36, R.drawable.c37, R.drawable.c38, R.drawable.c39, R.drawable.c40,
            R.drawable.c41, R.drawable.c42, R.drawable.c43, R.drawable.c44, R.drawable.c45, R.drawable.c46, R.drawable.c47, R.drawable.c48, R.drawable.c49, R.drawable.c50, R.drawable.c51};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ImageButton back = (ImageButton)findViewById(R.id.searchBack);



    }





}

