package br.fecapccp.checkbox;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbRefrigerante;
    private Button btnSet;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cbArroz = findViewById(R.id.cbArroz);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbRefrigerante = findViewById(R.id.cbRefrigerante);


        textResultado = findViewById(R.id.textResultado);
        btnSet = findViewById(R.id.btnSet);

        checkBox();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void enviar(View view){
       checkBox();
    }
        public void checkBox () {
            double valor = 0;
            if (cbArroz.isChecked()) {
                valor += 2.69;
            }
            if (cbLeite.isChecked()) {
                valor += 2.70;
            }
            if (cbCarne.isChecked()) {
                valor += 16.70;
            }
            if (cbFeijao.isChecked()) {
                valor += 3.38;
            }
            if (cbRefrigerante.isChecked()) {
                valor += 3.0;
            }

            String texto = String.format("%.2f", valor);

            textResultado.setText(texto);
        }

    }