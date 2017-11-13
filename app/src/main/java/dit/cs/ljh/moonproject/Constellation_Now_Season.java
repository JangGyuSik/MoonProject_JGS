package dit.cs.ljh.moonproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class Constellation_Now_Season extends AppCompatActivity {

    int mSelect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constellation_now_season);
        ImageView ConstellationIV = (ImageView)findViewById(R.id.Constellation);
        TextView date = (TextView)findViewById(R.id.ConstellationDate);

        //현재 날짜 출력
        Calendar m = Calendar.getInstance();
        int year = m.get(Calendar.YEAR);
        int month = m.get(Calendar.MONTH)+1;
        int day = m.get(Calendar.DATE);
        date.setText(year + "년 " + month + "월 " + day + "일 ");

        //현재 계절에 맞는 이미지 출력
        if (month==2) {
            ConstellationIV.setImageResource(R.drawable.spring);
        } else if (month==3) {
            ConstellationIV.setImageResource(R.drawable.spring);
        } else if (month==4) {
            ConstellationIV.setImageResource(R.drawable.spring);
        } else if (month==5) {
            ConstellationIV.setImageResource(R.drawable.summer);
        } else if (month==6) {
            ConstellationIV.setImageResource(R.drawable.summer);
        } else if (month==7) {
            ConstellationIV.setImageResource(R.drawable.summer);
        } else if (month==8) {
            ConstellationIV.setImageResource(R.drawable.autumnal);
        } else if (month==9) {
            ConstellationIV.setImageResource(R.drawable.autumnal);
        } else if (month==10) {
            ConstellationIV.setImageResource(R.drawable.autumnal);
        } else if (month==11) {
            ConstellationIV.setImageResource(R.drawable.winter);
        } else if (month==12) {
            ConstellationIV.setImageResource(R.drawable.winter);
        }  else if (month==1) {
            ConstellationIV.setImageResource(R.drawable.winter);
        }



//        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yy/MM/dd HH:mm");
//        String time = dateFormat.format(new Date(System.currentTimeMillis()));
//        date.setText("현재 시간 : " + time);

        //계절별 별자리 나타내기
//        findViewById(R.id.CMonthBt).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });

        //별자리 이미지 클릭시 별자리 리스트뷰로 이동
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent10 = new Intent(getApplicationContext(), Search.class);
//                startActivity(intent10);
//                finish();
//            }
//        });

    }

    //액션 바 추가
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) { //검색어 입력완료시 동작
                Toast.makeText(Constellation_Now_Season.this, s, Toast.LENGTH_SHORT).show();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) { //검색어가 바뀔때 마다 동작
                return false;
            }
        });
        return true;
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        final ImageView ConstellationIV = (ImageView)findViewById(R.id.Constellation);

        if (id == R.id.home) {
            Intent intent7 = new Intent(getApplicationContext(), Main.class);
            startActivity(intent7);
            finish();
        }

        if (id == R.id.calendar){
            //팝업 출력하여 계절별 별자리 선택후 출력
            new AlertDialog.Builder(Constellation_Now_Season.this).setTitle("원하는 계절을 선택하세요").setSingleChoiceItems(R.array.season, mSelect, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mSelect = which;
                }
            }).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Integer[] season = {R.drawable.spring, R.drawable.summer, R.drawable.autumnal, R.drawable.winter};
                    String[] season2 = getResources().getStringArray(R.array.season);
                    for (int i=0;i<=season2[mSelect].length();i++){
                        ConstellationIV.setImageResource(season[mSelect]);
                    }
                }
            }).setNegativeButton("취소", null).show();
        }

        if (id == R.id.back){
            Intent intent7 = new Intent(getApplicationContext(), Main.class);
            startActivity(intent7);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
