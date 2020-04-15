package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText you, partner;
    TextView calculate;
    Button btn;
    Button btn2;

    char a[], b[], c[] = {'x', 'F', 'L', 'A', 'M', 'E', 'S'};
    int l1, l2, l3, ctr = 0, f;

    void mark(int s, char m) {
        for (int k = 0; k != l2; k++) {
            if (b[k] == m) {
                b[k] = 'x';
                a[s] = 'x';
                return;
            }
            if ((m == ' ') || (m == '.'))
                a[s] = 'x';
            if ((b[k] == ' ') || (b[k] == '.'))
                b[k] = 'x';
        }
    }

    void ret() {
        //Place ptr in initial
        for (int k = 1; k != l3; k++) {
            if (c[k] != 'x') {
                f = k;
                return;
            }
        }
    }

    void nret(int y) {      //Place next
        int hb;
        hb = y + 1;
        while (true) {
            if (hb > 6)
                hb = 1;
            if (c[hb] != 'x') {
                f = hb;
                return;
            }
            hb++;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        you = findViewById(R.id.you);
        partner = findViewById(R.id.partner);
        calculate = findViewById(R.id.calculate);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (you.getText().equals("")||partner.getText().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please give input",Toast.LENGTH_LONG).show();
                }
                else {
                    you.setText(null);
                    partner.setText(null);
                    calculate.setText(null);
            }
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ob = new MainActivity();

                String person1 = you.getText().toString();
                String person2 = partner.getText().toString();

                ob.a = person1.toCharArray();
                ob.l1 = person1.length();
                ob.b = person2.toCharArray();
                ob.l2 = person2.length();

                ob.l3 = 7;

                for (int i = 0; i != ob.l1; i++)
                    ob.mark(i, ob.a[i]);

                for (int i = 0; i != ob.l1; i++)
                    if (ob.a[i] != 'x')
                        ob.ctr++;
                for (int i = 0; i != ob.l2; i++)
                    if (ob.b[i] != 'x')
                        ob.ctr++;

                ob.ret();
                for (int i = 1; i <= 5; i++) {
                    int g = 1, d;
                    for (d = 1; g < ob.ctr; d++) {
                        if (d > 6)
                            d = 1;
                        if (ob.c[d] != 'x') {
                            ob.nret(ob.f);//place f=in next count
                            g++;
                            if (ob.f > 6)
                                ob.ret();
                        }
                    }
                    ob.c[ob.f] = 'x';
                    ob.nret(ob.f);
                }

                char lo = 'F';
                for (int j = 1; j != ob.l3; j++)
                    if (ob.c[j] != 'x')
                        lo = ob.c[j];
                switch (lo) {
                    case 'F':
                        calculate.setText("FRIEND");
                        break;
                    case 'L':
                        calculate.setText("LOVE");
                        break;
                    case 'A':
                        calculate.setText("AFFECTION");
                        break;
                    case 'M':
                        calculate.setText("MARRIAGE");
                        break;
                    case 'E':
                        calculate.setText("ENEMY");
                        break;
                    case 'S':
                        calculate.setText("SIBLING");
                        break;
                }

            }
        });



    }
}
