package dit.cs.ljh.moonproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ScrollingView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Planet_detail extends AppCompatActivity {
    int mSelect = 0;
    String planetText, strName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_detail);
        Intent intentS = getIntent();
        strName = intentS.getStringExtra("planetText");

        play();

    }

    public void play(){
        ImageView planetImgV = (ImageView)findViewById(R.id.planetImg);
        TextView nameTextV, diameterTextV, massTextV, densityTextV, compositionTextV, revolutionTextV, rotationTextV, temperatureTextV, mythTextV;
        nameTextV = (TextView)findViewById(R.id.planetName);
        diameterTextV = (TextView)findViewById(R.id.planetDiameter);
        massTextV = (TextView)findViewById(R.id.planetMass);
        densityTextV = (TextView)findViewById(R.id.planetDensity);
        compositionTextV = (TextView)findViewById(R.id.planetComposition);
        revolutionTextV = (TextView)findViewById(R.id.planetRevolution);
        rotationTextV = (TextView)findViewById(R.id.planetRotation);
        temperatureTextV = (TextView)findViewById(R.id.planetTemperature);
        mythTextV = (TextView)findViewById(R.id.myth);
        //Intent로 받아온 name의 값에 따라서 데이터 출력

        nameTextV.setText(strName);

        if (strName.equals("태양")){
            diameterTextV.setText("139만Km");
            massTextV.setText("1.9891×10^30kg");
            densityTextV.setText("1.408 g/cm^3");
            compositionTextV.setText("수소73.46%, 헬륨24.85%");
            revolutionTextV.setText("-");
            rotationTextV.setText("25.3800일");
            temperatureTextV.setText("6000°C ");
            planetImgV.setImageResource(R.drawable.sun);
            mythTextV.setText("'태양의 소실'은 세계의 태양신화의 공통된 테마이다. 밤이 되면 태양이 모습을 감추는 것, 겨울이 되면 일조시간이 짧아지는 것, 일식등과 같은 태양에 관한 자연현상을 설명하는 역할이었다. \n" +
                    "\n" +
                    "- 일본신화에서는 수사노오(신)의 횡포에 화가 난 아마테라스 오오미카미(대신)가 아마노이와토(동굴)에 깃들어 세계가 어두워진다. \n" +
                    "\n" +
                    "- 이집트신화에 따르면 매일 밤 태양신 라(Ra)는 지옥인 두아토(Duato)를 지나갔다. 그래서 악의 신 아펩(Apep)은 라와 그의 태양의 배가 매일아침 동쪽에서 나타나게 하였다. \n" +
                    "\n" +
                    "- 북유럽신화에서는 마랑 펜릴의 아이들인 스콜, 하티가 각각 태양과 달을 삼켜버려 일식, 월식이 된다고 전해진다. \n" +
                    "\n" +
                    "- 중국신화에서는 다른 많은 문화와 다르게 태양과 달을 신격화하여 숭배하지 않았다. 그 이유는 달을 음, 태양을 양으로 간주하는 도교와 역경의 강한 영향력에 있다고 보인다. 중국신화에 의하면 태초에 10개의 태양이 하늘에 있었다. 세계가 너무나 뜨거워 대지에는 아무것도 살 수 없었다. 그리하여 게이라는 활의 달인이 9개의 태양을 쏘아 떨어뜨려 현재에 이른다고 한다. 다른 이야기로 일식은 하늘의 늑대가 태양을 먹어 생긴다고 하여 중국에서는 일식동안 냄비나 가마를 두드려 이 '늑대'를 쫓는 관습이 있다고 한다. ");
        }else if(strName.equals("수성")){
            diameterTextV.setText("4879.4km");
            massTextV.setText("3.302*10^23kg");
            densityTextV.setText("5.427 g/cm^3");
            compositionTextV.setText("58.6462일");
            revolutionTextV.setText("87.96934일");
            rotationTextV.setText("철64.13%, 니켈3.66%");
            temperatureTextV.setText("166℃");
            planetImgV.setImageResource(R.drawable.mercury);
            mythTextV.setText("수성은 수메르인 시대(기원전 3000년)부터 알려졌으며 ‘Ubu-idim-gud-ud’ 라고 불리고 있었다. 옛 기록에서는 수성이 바빌로니아인에 의한 관측이 이루어졌으며 gu-ad 또는 gu-utu라고 명명되었다.\n" +
                    "\n" +
                    "고대 그리스의 헤라클레이토스는 수성과 금성이 지구가 아닌 태양 주위를 돈다고 생각했다. 그리스에서 수성이 다섯 행성 중 하나라는 인식이 정착된 것은 플라톤 시대부터이다. \n" +
                    "\n" +
                    "고대 그리스인은 수성을 헤르메스에 대응시켰다. 이것은 가장 안쪽에 있는 행성으로 운행이 빠르기 때문에 발이 빠른 신의 이름을 붙인 것이다. 헤르메스는 고대 로마에서 메르쿠리우스와 동일시되어 영어로 머큐리(Mercury, 수성)가 되었다.\n" +
                    "\n" +
                    "1639년에는 이탈리아의 조반니가 망원경을 사용하여 수성을 관측, 수성에도 금성이나 달과 마찬가지로 차고 기운다는 것을 발견했다. 이것으로 수성이 태양을 돌고 있다는 것이 확실해졌다. ");
        }else if(strName.equals("금성")){
            diameterTextV.setText("12,103.7km");
            massTextV.setText("4.869*10^24kg");
            densityTextV.setText("5.204 g/cm^3");
            compositionTextV.setText("243.0185일");
            revolutionTextV.setText("224.70069일");
            rotationTextV.setText("이산화탄소96%, 질소3%");
            temperatureTextV.setText("470℃");
            planetImgV.setImageResource(R.drawable.venus);
            mythTextV.setText("서양에서는 금성을 로마신화의 비너스(Venus)라고 부르고 있다. 메소포타미아에서는 금성의 아름다움(밝기)때문에 미의 여신 이슈타르라 불렸고, 이후 그리스에서는 아프로디테 등 세계 각국에서 금성의 이름을 아름다운 여성의 이름으로 붙인 경우가 많다. \n" +
                    "\n" +
                    "기독교에서는 라틴어로 '빛을 가져오는 자'(루시퍼, Lucifer)라 불렀다. 모든 것을 압도하는 빛과 고고함에서 유일신으로 모시는 가장 고위의 천사(그리고 나중에 지옥으로 떨어지는 타락천사)의 이름으로 주어진 것이다.\n" +
                    "\n" +
                    "그리고 불교에서는 석가모니가 금성이 빛나는 것을 보고 진리를 발견했다고 전해진다. ");
        }else if(strName.equals("지구")){
            diameterTextV.setText("12,756.3km");
            massTextV.setText("5.9736*10^24kg");
            densityTextV.setText("5.515 g/cm^3");
            compositionTextV.setText("0.997258일");
            revolutionTextV.setText("365.25641일");
            rotationTextV.setText("철32.1%, 산소30.1%, 규소15.1%, 마그네슘13.9%");
            temperatureTextV.setText("13℃");
            planetImgV.setImageResource(R.drawable.earth);
            mythTextV.setText("-");
        }else if(strName.equals("화성")){
            diameterTextV.setText("6,779km");
            massTextV.setText("6.4171*10^23kg");
            densityTextV.setText("3.9335 ± 0.0004 g/cm^3");
            compositionTextV.setText("1.025957일");
            revolutionTextV.setText("686.971일");
            rotationTextV.setText("칼슘, 철, 규소, 알루미늄");
            temperatureTextV.setText("-63℃");
            planetImgV.setImageResource(R.drawable.mars);
            mythTextV.setText("화성의 이름 Mars는 로마신화의 신 마르스(그리스 신화의 전쟁의 신 아레스)에서 따온 이름이다. 이는 화성의 모습이 붉게 보여서 전쟁의 불길, 또는 피를 연상하기 때문에 지어진 것이다. 그리고 아레스의 두 아들 포보스와 데이모스는 화성의 두 위성의 이름이다. \n" +
                    "\n" +
                    "동양에서 화성은 오행설에 근거한 초자연적인 명칭으로 학문상(천문사료)에서는 형혹(熒惑) 또는 형혹성이라 하였다. 화성이 전갈자리의 안타레스(황도 근처에 위치하기 때문에)에 접근하는 것을 형혹수심(熒惑守心)(형혹심을 지킨다)이라고 하여 불길한 전조라고 했다. '심'이란 안타레스가 소속한 성관(중국의 별자리)중 심수(이십팔수 중 하나로 동방청룡 칠수의 제5수)를 말한다.");
        }else if(strName.equals("목성")){
            diameterTextV.setText("142,984km (적도), 133,709 km (극)");
            massTextV.setText("1.899*10^27kg");
            densityTextV.setText("1.326 g/cm^3");
            compositionTextV.setText("9.925시간");
            revolutionTextV.setText("4,332.59일");
            rotationTextV.setText("수소89.8%, 헬륨10.2%");
            temperatureTextV.setText("-108℃");
            planetImgV.setImageResource(R.drawable.jupiter);
            mythTextV.setText("주피터(Jupiter)는 로마신화의 최고의 신으로 그리스 신화의 제우스에 해당한다. 유달리 밝고 큰 행성으로 메소포타미아에서 신 마르덕(Marduk)의 이름을 얻은 이후 각지의 신의 이름으로 계승되었다. 그리고 신화에서 많은 아내를 둔 제우스처럼 많은 위성들을 거느리고 있으며, 실제로 이오, 칼리스토, 유로파 등 여러 위성의 이름이 신화에서 제우스 아내의 이름이다.\n" +
                    "\n" +
                    "중국에서는 목성의 공전주기가 약 12년인 것에서 십이지를 담당하는 별로 여기고, '세성(歲星)'이라 불렀다. 또한 도교에서는 대세성군이란 이름으로 신격화되어 흉신의 대표 격으로 가장 두려워하였다.");
        }else if(strName.equals("토성")){
            diameterTextV.setText("108,728km (적도), 108,728km (극)");
            massTextV.setText("5.6846*10^26kg");
            densityTextV.setText("0.6873 g/cm^3");
            compositionTextV.setText("0.444375일");
            revolutionTextV.setText("10,756.1995일");
            rotationTextV.setText("수소97%, 헬륨3%");
            temperatureTextV.setText("-130℃");
            planetImgV.setImageResource(R.drawable.saturn);
            mythTextV.setText("토성의 영어이름인 새턴(Saturn)은 로마 신화의 농경의 신 사투루누스(Saturnus)에서 유래한 것이다. 태양에서 멀고 운행이 느려 늙은 신의 이름이 붙여졌다. 또한 그리스 신화에서는 태초의 신중 하나인 크로노스가 해당한다. 크로노스는 제우스의 아버지이지만 제우스에게 쫓겨났다고 한다.");
        }else if(strName.equals("천왕성")){
            diameterTextV.setText("51,118 km (적도),  49,946 km (극)");
            massTextV.setText("8.6832*10^25 kg");
            densityTextV.setText("1.318 g/cm^3");
            compositionTextV.setText("−0.718 333333일 ");
            revolutionTextV.setText("30,707.4896일");
            rotationTextV.setText("수소83%, 헬륨15%");
            temperatureTextV.setText("-220℃");
            planetImgV.setImageResource(R.drawable.uranus);
            mythTextV.setText("우라노스(Uranus), 천왕성은 고대인이 지은 이름이 아닌 근세 이후에 발견된 행성으로, 사용되지 않은 신화속의 인물의 이름이 붙은 것이다. 즉 천체의 겉모습이나 운행상의 특징으로 붙는 신의 이름과는 거리가 멀다. 또한 우라노스는 그리스 신화에서 유래된 명칭이며 그리스 신화의 주신 제우스의 할아버지에 해당한다. 그리고 크로노스(토성)가 아들인 제우스(목성)에게 쫓겨난 것처럼 우라노스(천왕성) 또한 아들인 크로노스(토성)의 아버지로서 쫓겨났다.");
        }else if(strName.equals("해왕성")){
            diameterTextV.setText("49,528km (적도) 48,681km (극)");
            massTextV.setText("1.0243*10^26kg");
            densityTextV.setText("1.638 g/cm^3");
            compositionTextV.setText("16.11시간");
            revolutionTextV.setText("60,223.3528일");
            rotationTextV.setText("수소80%, 헬륨19%, 메탄1.5%");
            temperatureTextV.setText("-218℃");
            planetImgV.setImageResource(R.drawable.neptune);
            mythTextV.setText("해왕성(Neptune)은 로마신화에서 바다의신 넵투누스(Neptunus)의 이름을 딴 것이다. 그리고 그리스 신화의 포세이돈과 유사하다고 볼 수 있다. 바다의 왕을 그대로 해석해서 우리는 해왕성(海王星)이라고 한다. 해왕성의 곁에는 포세이돈 또는 넵투누스의 아들이며, 바다의 작은 신 트리톤(Triton)이 공전하고 있다. 그리고 바다의 요정인 네레이스의 이름에서 유래한 네레이드(Nereid) 또한 해왕성을 공전하고 있다.");
        }
    }

    //액션 바 추가
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_planet, menu);
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
            Intent intent = new Intent(getApplicationContext(), Solar_System.class);
            startActivity(intent);
            finish();
        }

        if (id == R.id.planet){
            //팝업 출력하여 원하는 행성을 선택
            new AlertDialog.Builder(Planet_detail.this).setTitle("행성을 선택하세요").setSingleChoiceItems(R.array.planet_array, mSelect, new DialogInterface.OnClickListener() {
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
                    for(int i=0;i<=mSelect;i++) {
                        strName = planetText;
                        play();
//                        Intent intent = new Intent(getApplicationContext(), Planet_detail.class);
//                        intent.putExtra("planetText", planetText);
//                        startActivity(intent);
//                        finish();
                    }
                }
            }).setNegativeButton("취소", null).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
