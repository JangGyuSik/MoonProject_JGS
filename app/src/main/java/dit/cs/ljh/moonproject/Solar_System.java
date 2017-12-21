package dit.cs.ljh.moonproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Solar_System extends AppCompatActivity {

    int mSelect = 0;
    TextView date1, date2;
    ImageView SolarSystem;
    String planetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_system);

        date1 = (TextView)findViewById(R.id.SolarDate);
        date2 = (TextView)findViewById(R.id.SolarDateSelect);
        SolarSystem = (ImageView)findViewById(R.id.SolarSystemImg);

        //현재 날짜 출력
        Calendar m = Calendar.getInstance();
        int year = m.get(Calendar.YEAR);
        int month = m.get(Calendar.MONTH)+1;
        int day = m.get(Calendar.DATE);
        date1.setText("현재날짜 : " + year + "년 " + month + "월 " + day + "일 ");

        //현재 달에 맞는 태양계 이미지 출력
        if (month==2) {
            SolarSystem.setImageResource(R.drawable.solarsystem2);
        } else if (month==3) {
            SolarSystem.setImageResource(R.drawable.solarsystem3);
        } else if (month==4) {
            SolarSystem.setImageResource(R.drawable.solarsystem4);
        } else if (month==5) {
            SolarSystem.setImageResource(R.drawable.solarsystem5);
        } else if (month==6) {
            SolarSystem.setImageResource(R.drawable.solarsystem6);
        } else if (month==7) {
            SolarSystem.setImageResource(R.drawable.solarsystem7);
        } else if (month==8) {
            SolarSystem.setImageResource(R.drawable.solarsystem8);
        } else if (month==9) {
            SolarSystem.setImageResource(R.drawable.solarsystem9);
        } else if (month==10) {
            SolarSystem.setImageResource(R.drawable.solarsystem10);
        } else if (month==11) {
            SolarSystem.setImageResource(R.drawable.solarsystem11);
        } else if (month==12) {
            SolarSystem.setImageResource(R.drawable.solarsystem12);
        }  else if (month==1) {
            SolarSystem.setImageResource(R.drawable.solarsystem1);
        }

        //날짜을 선택하여 태양계 출력
//        selectDatebt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        //드롭박스다운
//        Spinner spinner = (Spinner)findViewById(R.id.planetGo);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//                this, R.array.planet_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
//    }


//    public class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            //행성상세정보 화면으로 넘어가기
//            String[] name = getResources().getStringArray(R.array.planet_array);
//
//            planetText = name[position];
//            for(int i=1;i<=position;i++) {
//                Intent intent = new Intent(getApplicationContext(), Planet_detail.class);
//                intent.putExtra("planetText", planetText);
//                startActivity(intent);
//                finish();
//            }
//        }
//        @Override
//        public void onNothingSelected(AdapterView<?> arg0) {
//            // Do nothing
//        }
    }

    //액션 바 추가
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_solar_system, menu);
        return true;
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent intent7 = new Intent(getApplicationContext(), Main.class);
            startActivity(intent7);
            finish();
        }

        if (id == R.id.back){
            Intent intent6 = new Intent(getApplicationContext(), Main.class);
            startActivity(intent6);
            finish();
        }

        if (id == R.id.calendar){
;                //팝업 출력하여 원하는 닐짜를 선택
            new AlertDialog.Builder(Solar_System.this).setTitle("날짜를 선택하세요").setSingleChoiceItems(R.array.solar_array, mSelect, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mSelect = which;
                }
            }).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Integer[] solarcount2 = {R.drawable.solarsystem1, R.drawable.solarsystem2, R.drawable.solarsystem3, R.drawable.solarsystem4, R.drawable.solarsystem5, R.drawable.solarsystem6, R.drawable.solarsystem7, R.drawable.solarsystem8, R.drawable.solarsystem9, R.drawable.solarsystem10, R.drawable.solarsystem11, R.drawable.solarsystem12};
                    String[] solarcount = getResources().getStringArray(R.array.solar_array);
                    for (int i=0;i<=solarcount[mSelect].length();i++){
                        SolarSystem.setImageResource(solarcount2[mSelect]);
                    }
                    date2.setText("선택날짜 : 2018년 " + solarcount[mSelect]);
                }
            }).setNegativeButton("취소", null).show();
        }

        if (id == R.id.planet){
            //팝업 출력하여 원하는 행성을 선택
            new AlertDialog.Builder(Solar_System.this).setTitle("행성을 선택하세요").setSingleChoiceItems(R.array.planet_array, mSelect, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mSelect = which;
                }
            }).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //행성상세정보 화면으로 넘어가기
                    String[] name = getResources().getStringArray(R.array.planet_array);
                    planetText = name[mSelect];
                    Intent intent = new Intent(getApplicationContext(), Planet_detail.class);
                    intent.putExtra("planetText", planetText);
                    startActivity(intent);
                    finish();
                }
            }).setNegativeButton("취소", null).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
