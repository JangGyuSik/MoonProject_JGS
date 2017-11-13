package dit.cs.ljh.moonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Main extends AppCompatActivity {
    private long lastTimeBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton todayBt, ConstellationNowBt, SolarSystemBt;
        todayBt = (ImageButton)findViewById(R.id.todayBt);
        ConstellationNowBt = (ImageButton)findViewById(R.id.ConstellationNowBt);
        SolarSystemBt = (ImageButton)findViewById(R.id.SolarSystemBt);


        //오늘의 달모양화면으로 이동
        todayBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Moon_Today.class);
                startActivity(intent1);

            }
        });

        //이번달의 별자리화면으로 이동
        ConstellationNowBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Constellation_Now_Season.class);
                startActivity(intent2);

            }
        });

        //현재 태양계로 이동
        SolarSystemBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), Solar_System.class);
                startActivity(intent3);

            }
        });


    }

//뒤로가기 버튼 버튼을 터치했을때 앱 종료
@Override
    public void onBackPressed(){
    long currentTime = System.currentTimeMillis();
    //2초 이내에 뒤로가기 버튼을 또 터치하면 앱 종료.
        if(currentTime - lastTimeBackPressed < 2000){
            finish();
        } else {
            lastTimeBackPressed = currentTime;
        }
    Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();

}

    //액션 바 추가
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        return true;
//    }

}
