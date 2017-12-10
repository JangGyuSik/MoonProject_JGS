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
import android.widget.ImageView;
import android.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Thread;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;


public class Constellation_Now_Season extends AppCompatActivity {

    String data;
    private String resultConstellation;
    Handler handler = new Handler();
    int mSelect = 0;
    String ConstellationData1 = "";
    String ConstellationData2 = "";
    String ConstellationData3 = "";

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
                                        Toast.makeText(Constellation_Now_Season.this, "검색 결과가 없습니다.", Toast.LENGTH_SHORT).show();
                                    } else {
                            Log.i("이름 : ", Result[0]);
                            Log.i("계절 : ", Result[1]);
                            Log.i("신화 : ", Result[2]);
//
                            ConstellationData1 = Result[0];
                            ConstellationData2 = Result[1];
                            ConstellationData3 = Result[2];


                        Intent intent = new Intent(getApplicationContext(), Constellation_Detail.class);
                                        intent.putExtra("name", ConstellationData1);
                                        intent.putExtra("season", ConstellationData2);
                                        intent.putExtra("myth", ConstellationData3);
                        startActivity(intent);
                        finish();
//                                        Toast.makeText(Constellation_Now_Season.this, ConstellationData1 + "자리", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                        } catch (Exception e) {
                            Log.e("", "쓰레드 Error", e);
                        }
                    }
                }.start();

//                Threads thread = new Threads();
//                thread.start();

                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) { //검색어가 바뀔때 마다 동작
                data = s;
                Log.i("검색변경값 : ", data);
                return false;
            }
        });

        return true;

    }

//    class Threads extends Thread{
//        public void run() {
//            try {
//                String Key = data.toString(); //
//                URL url = new URL("http://121.175.131.102/constellation.php");
//                HttpURLConnection http;
//                http = (HttpURLConnection) url.openConnection();
//                http.setDefaultUseCaches(false);
//                http.setDoInput(true);
//                http.setRequestMethod("POST");
//                http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
//                StringBuffer buffer = new StringBuffer();
//                buffer.append("name").append("=").append(Key);
//
//                OutputStreamWriter outputStream = new OutputStreamWriter(http.getOutputStream(), "utf-8");
//                outputStream.write(buffer.toString());
//                outputStream.flush();
//
//                InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "utf-8");
//                BufferedReader reader = new BufferedReader(tmp);
//                StringBuilder builder = new StringBuilder();
//                String str;
//                while ((str = reader.readLine()) != null) {
//                    builder.append(str);
//                }
//
//                resultConstellation = builder.toString();
//                final String[] Result = resultConstellation.split("/");
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.i("검색값 : ", data);
//
//                        if (Result[0] == "") {
//                            Toast.makeText(Constellation_Now_Season.this, "검색 결과가 없습니다.", Toast.LENGTH_SHORT).show();
//
//                        } else {
//                            Log.i("이름 : ", Result[0]);
//                            Log.i("계절 : ", Result[1]);
//                            Log.i("신화 : ", Result[2]);
//
//                            ConstellationData1 = Result[0];
//                            ConstellationData2 = Result[1];
//                            ConstellationData3 = Result[2];
//
//
//                        Intent intent = new Intent(getApplicationContext(), Constellation_Detail.class);
//                                        intent.putExtra(ConstellationData1, "name");
//                                        intent.putExtra(ConstellationData2, "season");
//                                        intent.putExtra(ConstellationData3, "myth");
//                        startActivity(intent);
//                        finish();
////                                        Toast.makeText(Constellation_Now_Season.this, ConstellationData1 + "자리", Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                });
//            } catch (Exception e) {
//                Log.e("", "쓰레드 Error", e);
//            }
//        }
//    }

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

