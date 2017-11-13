package dit.cs.ljh.moonproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.app.AlertDialog;
import android.widget.TextView;

public class Constellation_Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constellation_detail);

        Intent intent = getIntent();
        String str = intent.getStringExtra("str");

        ImageView constellationImg = (ImageView)findViewById(R.id.ConstellationImg);
        TextView mass = (TextView)findViewById(R.id.ConstellationMass);
        ImageButton back = (ImageButton)findViewById(R.id.ConstellationDBack) ;

        mass.setText(str);

        //뒤로가기
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Main.class);
                startActivity(intent1);
                finish();
            }
        });

    }
}
