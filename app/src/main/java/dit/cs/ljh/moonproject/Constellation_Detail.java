package dit.cs.ljh.moonproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.app.AlertDialog;
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

    TextView name, myth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constellation_detail);

        name = (TextView) findViewById(R.id.name);
        myth = (TextView)findViewById(R.id.myth);

        Intent intent = getIntent();
        String nameData = intent.getStringExtra("name");
        String seasonData = intent.getStringExtra("season");
        String mythData = intent.getStringExtra("myth");

        Log.i("보내진 이름 값 : ", nameData);
        Log.i("보내진 계절 값 : ", seasonData);
        Log.i("보내진 신화 값 : ", mythData);


        name.setText(nameData + " 자리");
        myth.setText(mythData);
    }

    //액션 바 추가
    @Override
    public boolean onCreateOptionsMenu(Menu menu){


        getMenuInflater().inflate(R.menu.menu_constelltaion, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        name = (TextView) findViewById(R.id.name);
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
                                        Log.i("검색된 이름 : ", Result[0]);
                                        Log.i("검색된 계절 : ", Result[1]);
                                        Log.i("검색된 신화 : ", Result[2]);

                                        name.setText(Result[0] + " 자리");
                                        myth.setText(Result[2]);

                                    }

                                }
                            });
                        } catch (Exception e) {
                            Log.e("", "쓰레드 Error", e);
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

        if (id == R.id.home) {
            Intent intent = new Intent(getApplicationContext(), Main.class);
            startActivity(intent);
            finish();
        }

        if (id == R.id.back){
            Intent intent = new Intent(getApplicationContext(), Constellation_Now_Season.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

