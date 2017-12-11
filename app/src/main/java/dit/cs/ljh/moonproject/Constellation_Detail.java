package dit.cs.ljh.moonproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Constellation_Detail extends AppCompatActivity {

    private String resultConstellation;
    Handler handler = new Handler();

    TextView myth, season;
    ImageView Cimage;
    String nameData, seasonData, mythData, count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constellation_detail);

        myth = (TextView)findViewById(R.id.myth);
        season = (TextView)findViewById(R.id.season);
        Cimage = (ImageView)findViewById(R.id.CImage);


        Intent intent = getIntent(); //인텐트로 데이터 가져오기
        count = intent.getStringExtra("count");
        nameData = intent.getStringExtra("name");
        seasonData = intent.getStringExtra("season");
        mythData = intent.getStringExtra("myth");

        Log.i("보내진 이름 값 : ", nameData);
        Log.i("보내진 계절 값 : ", seasonData);
        Log.i("보내진 신화 값 : ", mythData);

        season.setText("출몰시기 : " + seasonData);
        myth.setText(mythData);

        int num = Integer.valueOf(count); //int형으로 강제 형변환
        Integer imageID[] = {R.drawable.c0, R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
                    R.drawable.c11, R.drawable.c12, R.drawable.c13, R.drawable.c14, R.drawable.c15, R.drawable.c16, R.drawable.c17, R.drawable.c18, R.drawable.c19, R.drawable.c20, R.drawable.c21,
                    R.drawable.c22, R.drawable.c23, R.drawable.c24, R.drawable.c25, R.drawable.c26, R.drawable.c27, R.drawable.c28, R.drawable.c29, R.drawable.c30, R.drawable.c31, R.drawable.c32,
                    R.drawable.c33, R.drawable.c34, R.drawable.c35, R.drawable.c36, R.drawable.c37, R.drawable.c38, R.drawable.c39, R.drawable.c40, R.drawable.c41, R.drawable.c42, R.drawable.c43,
                    R.drawable.c44, R.drawable.c45, R.drawable.c46, R.drawable.c47, R.drawable.c48, R.drawable.c49
                    , R.drawable.c50, R.drawable.c51};

        //이미지 넣어주기
        if (num == 1){
            Cimage.setImageResource(R.drawable.c0);
        }else  {
            for(int i=0;i<=num-1;i++){
                Cimage.setImageResource(imageID[i]);
            }
        }

    }

    //액션 바 추가
    @Override
    public boolean onCreateOptionsMenu(Menu menu){


        getMenuInflater().inflate(R.menu.menu_constelltaion, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        myth = (TextView)findViewById(R.id.myth);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override

            public boolean onQueryTextSubmit(final String s) { //검색어 입력완료시 동작
                //Toast.makeText(Constellation_Now_Season.this, s, Toast.LENGTH_SHORT).show();

                new Thread() {
                    public void run() {
                        try {
                            String Key = s.toString(); //
                            URL url = new URL("http://121.175.131.102/constellation.php");
                            HttpURLConnection http;
                            http = (HttpURLConnection) url.openConnection();
                            http.setDefaultUseCaches(false);
                            http.setDoInput(true);
                            http.setRequestMethod("POST");
                            http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                            StringBuffer buffer = new StringBuffer();
                            buffer.append("name").append("=").append(Key);

                            OutputStreamWriter outputStream = new OutputStreamWriter(http.getOutputStream(), "utf-8");
                            outputStream.write(buffer.toString());
                            outputStream.flush();

                            InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "utf-8");
                            BufferedReader reader = new BufferedReader(tmp);
                            StringBuilder builder = new StringBuilder();
                            String str;
                            while ((str = reader.readLine()) != null) {
                                builder.append(str);
                            }

                            resultConstellation = builder.toString();
                            final String[] Result = resultConstellation.split("/");
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Log.i("검색값 : ", s);

                                    if (Result[0] == "") {
                                        Toast.makeText(Constellation_Detail.this, "검색 결과가 없습니다.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Log.i("검색된 번호 : ", Result[0]);
                                        Log.i("검색된 이름 : ", Result[1]);
                                        Log.i("검색된 계절 : ", Result[2]);
                                        Log.i("검색된 신화 : ", Result[3]);

                                        season.setText("출몰시기 : " + Result[2]);
                                        myth.setText(Result[3]);

                                        int num = Integer.valueOf(Result[0]); //int형으로 강제 형변환
                                        Integer imageID[] = {R.drawable.c0, R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
                                                R.drawable.c11, R.drawable.c12, R.drawable.c13, R.drawable.c14, R.drawable.c15, R.drawable.c16, R.drawable.c17, R.drawable.c18, R.drawable.c19, R.drawable.c20, R.drawable.c21,
                                                R.drawable.c22, R.drawable.c23, R.drawable.c24, R.drawable.c25, R.drawable.c26, R.drawable.c27, R.drawable.c28, R.drawable.c29, R.drawable.c30, R.drawable.c31, R.drawable.c32,
                                                R.drawable.c33, R.drawable.c34, R.drawable.c35, R.drawable.c36, R.drawable.c37, R.drawable.c38, R.drawable.c39, R.drawable.c40, R.drawable.c41, R.drawable.c42, R.drawable.c43,
                                                R.drawable.c44, R.drawable.c45, R.drawable.c46, R.drawable.c47, R.drawable.c48, R.drawable.c49
                                                , R.drawable.c50, R.drawable.c51};

                                        //이미지 넣어주기
                                        if (num == 1){
                                            Cimage.setImageResource(R.drawable.c0);
                                        }else  {
                                            for(int i=0;i<=num-1;i++){
                                                Cimage.setImageResource(imageID[i]);
                                            }
                                        }
                                    }

                                }
                            });
                        } catch (Exception e) {
                            Log.e("", "검색 Error", e);
                        }
                    }
                }.start();


                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) { //검색어가 바뀔때 마다 동작
                Log.i("검색변경값 : ", s);
                return false;
            }
        });

        return true;

    }


    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = getIntent();
        String num = intent.getStringExtra("num");
        int num2 = Integer.valueOf(num); //int형으로 강제 형변환

        if (id == R.id.home) {
            intent = new Intent(getApplicationContext(), Main.class);
            startActivity(intent);
            finish();
        }

        //전 액티비티 구별
        if (id == R.id.back){
            if(num2 == 0){
                intent = new Intent(getApplicationContext(), Constellation_List.class);
                startActivity(intent);
                finish();
            } else if (num2 == 1) {
                intent = new Intent(getApplicationContext(), Constellation_Now_Season.class);
                startActivity(intent);
                finish();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}

