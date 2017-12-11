package dit.cs.ljh.moonproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.TextView;
import java.util.Date;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import android.widget.ImageView;

public class Moon_Today extends AppCompatActivity {

    Handler handler = new Handler();
    private String resultData;
    TextView up, down, date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moon_today);

        up = (TextView) findViewById(R.id.MUp);
        down = (TextView) findViewById(R.id.MDown);
        date = (TextView) findViewById(R.id.MDate);
        ImageView moonImg = (ImageView)findViewById(R.id.MoonImg);

        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(new Date(System.currentTimeMillis()));

        date.setText(time);


        //day에 맞게 달 모양 출력
        Calendar m = Calendar.getInstance();
        int day = m.get(Calendar.DATE);

        if (day==1) {
            moonImg.setImageResource(R.drawable.m1);
        } else if (day==2) {
            moonImg.setImageResource(R.drawable.m2);
        } else if (day==3) {
            moonImg.setImageResource(R.drawable.m3);
        } else if (day==4) {
            moonImg.setImageResource(R.drawable.m4);
        } else if (day==5) {
            moonImg.setImageResource(R.drawable.m5);
        } else if (day==6) {
            moonImg.setImageResource(R.drawable.m6);
        } else if (day==7) {
            moonImg.setImageResource(R.drawable.m7);
        } else if (day==8) {
            moonImg.setImageResource(R.drawable.m8);
        } else if (day==9) {
            moonImg.setImageResource(R.drawable.m9);
        } else if (day==10) {
            moonImg.setImageResource(R.drawable.m10);
        } else if (day==11) {
            moonImg.setImageResource(R.drawable.m11);
        } else if (day==12) {
            moonImg.setImageResource(R.drawable.m12);
        } else if (day==13) {
            moonImg.setImageResource(R.drawable.m13);
        } else if (day==14) {
            moonImg.setImageResource(R.drawable.m14);
        } else if (day==15) {
            moonImg.setImageResource(R.drawable.m15);
        } else if (day==16) {
            moonImg.setImageResource(R.drawable.m16);
        } else if (day==17) {
            moonImg.setImageResource(R.drawable.m17);
        } else if (day==18) {
            moonImg.setImageResource(R.drawable.m18);
        } else if (day==19) {
            moonImg.setImageResource(R.drawable.m19);
        } else if (day==20) {
            moonImg.setImageResource(R.drawable.m20);
        } else if (day==21) {
            moonImg.setImageResource(R.drawable.m21);
        } else if (day==22) {
            moonImg.setImageResource(R.drawable.m22);
        } else if (day==23) {
            moonImg.setImageResource(R.drawable.m23);
        } else if (day==24) {
            moonImg.setImageResource(R.drawable.m24);
        } else if (day==25) {
            moonImg.setImageResource(R.drawable.m25);
        } else if (day==26) {
            moonImg.setImageResource(R.drawable.m26);
        } else if (day==27) {
            moonImg.setImageResource(R.drawable.m27);
        } else if (day==28) {
            moonImg.setImageResource(R.drawable.m28);
        } else if (day==29) {
            moonImg.setImageResource(R.drawable.m29);
        } else if (day==30) {
            moonImg.setImageResource(R.drawable.m30);
        }

        //데이터베이스 연동
        new Thread() {
            public void run() {
                try {
                    String Key = date.getText().toString(); //날짜 별로 데이터 받아오기
                    URL url = new URL("http://121.175.131.102/moon.php");
                    HttpURLConnection http;
                    http = (HttpURLConnection) url.openConnection();
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST");
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("date").append("=").append(Key);

                    OutputStreamWriter outputStream = new OutputStreamWriter(http.getOutputStream(), "utf-8");
                    outputStream.write(buffer.toString());
                    outputStream.flush();

                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "euc-kr");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuilder builder = new StringBuilder();
                    String str;
                    while ((str = reader.readLine()) != null) {
                        builder.append(str);
                    }

                    resultData = builder.toString();
                    final String[] Result = resultData.split("/");
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            up.setText(Result[1]); //월출 출력
                            down.setText(Result[2]); //월몰 출력
                        }
                    });
                } catch (Exception e) {
                    Log.e("", "Error", e);
                }
            }
        }.start();
    }

    //액션 바 추가
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_calendar, menu);
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

        if (id == R.id.calendar){
            Intent intent6 = new Intent(getApplicationContext(), Moon_Month.class);
            startActivity(intent6);
            finish();
        }

        if (id == R.id.back){
            Intent intent6 = new Intent(getApplicationContext(), Main.class);
            startActivity(intent6);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
