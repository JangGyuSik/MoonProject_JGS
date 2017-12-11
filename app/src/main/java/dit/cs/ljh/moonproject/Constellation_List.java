package dit.cs.ljh.moonproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Constellation_List extends AppCompatActivity {

    ListView list = null;
    ArrayAdapter<String> adapter;
    private String resultConstellation;
    Handler handler = new Handler();
    final String[] data = {"거문고", "게", "고래", "기린", "궁수", "까마귀", "남쪽물고기", "도마뱀", "독수리", "돌고래", "마차부", "머리털", "목동", "물고기", "물병",
            "바다뱀", "염소", "방패", "백조", "뱀", "뱀주인", "왕관", "사냥개", "사자", "살쾡이", "삼각형", "세페우스", "쌍둥이", "안드로메다", "양", "에리다누스",
            "오리온", "외뿔소", "용", "육분의", "작은개", "작은곰", "작은사자", "작은여우", "전갈", "조랑말", "처녀", "천칭", "컵", "큰개", "큰곰", "토끼", "페가수스",
            "페르세우스", "헤라클레스", "화살", "황소"};
    int textCount;
    String Key;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_constellation__list);


        list = (ListView)findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                new Thread() {
                    public void run() {
                        try {
                            if (textCount == 0){
                                Key = data[position].toString();
                            } else if (textCount == 1){
                                str = adapter.getItem(position);
                                Key = str.toString();
                            }
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
                                    Log.i("검색값 : ", data[position]);

                                        Log.i("번호 : ", Result[0]);
                                        Log.i("이름 : ", Result[1]);
                                        Log.i("계절 : ", Result[2]);
                                        Log.i("신화 : ", Result[3]);

                                        Intent intent = new Intent(getApplicationContext(), Constellation_Detail.class);
                                        intent.putExtra("num","0"); //액티비티 구별을 위함
                                        intent.putExtra("count",Result[0]);
                                        intent.putExtra("name", Result[1]);
                                        intent.putExtra("season", Result[2]);
                                        intent.putExtra("myth", Result[3]);
                                        startActivity(intent);
                                        finish();
//                                      Toast.makeText(Constellation_Now_Season.this, ConstellationData1 + "자리", Toast.LENGTH_SHORT).show();

                                }
                            });
                        } catch (Exception e) {
                            Log.e("", "검색 Error", e);
                        }
                    }
                }.start();

            }
        });
    }

    //액션 바 추가
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        list = (ListView)findViewById(R.id.list);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override

            public boolean onQueryTextSubmit(final String s) { //검색어 입력완료시 동작
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) { //검색어가 바뀔때 마다 동작

                adapter.getFilter().filter(s); //리스트뷰에 검색 결과 출력
                if (s == ""){
                    textCount = 0;
                } else {
                    textCount = 1;
                }

//                String filterText = s.toString();
//                    if (filterText.length() > 0){
//                    } else{
//                        adapter.add("검색 결과가 없습니다.");
//                    }

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
