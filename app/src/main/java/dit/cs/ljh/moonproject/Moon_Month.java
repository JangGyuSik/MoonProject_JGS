package dit.cs.ljh.moonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Calendar;

public class Moon_Month extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moon_month);

        ImageView moonCalendar = (ImageView)findViewById(R.id.MoonMonthCalendar);

        Calendar m = Calendar.getInstance();
        int month = m.get(Calendar.MONTH)+1;

        //월에 맞게 달력 출력
        if (month==1) {
            moonCalendar.setImageResource(R.drawable.calendar1);
        }else if (month==2) {
            moonCalendar.setImageResource(R.drawable.calendar2);
        }else if (month==3) {
            moonCalendar.setImageResource(R.drawable.calendar3);
        }else if (month==4) {
            moonCalendar.setImageResource(R.drawable.calendar4);
        }else if (month==5) {
            moonCalendar.setImageResource(R.drawable.calendar5);
        }else if (month==6) {
            moonCalendar.setImageResource(R.drawable.calendar6);
        }else if (month==7) {
            moonCalendar.setImageResource(R.drawable.calendar7);
        } else if (month==8) {
            moonCalendar.setImageResource(R.drawable.calendar8);
        } else if (month==9) {
            moonCalendar.setImageResource(R.drawable.calendar9);
        } else if (month==10) {
            moonCalendar.setImageResource(R.drawable.calendar10);
        } else if (month==11) {
            moonCalendar.setImageResource(R.drawable.calendar11);
        } else if (month==12) {
            moonCalendar.setImageResource(R.drawable.calendar12);
        }

    }

    //액션 바 추가
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
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
            Intent intent6 = new Intent(getApplicationContext(), Moon_Today.class);
            startActivity(intent6);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
