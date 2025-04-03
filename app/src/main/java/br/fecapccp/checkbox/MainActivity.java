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
    private CheckBox cbVermelho,cbAzul,cbVerde,cbPreto;

    private RadioGroup radioGroup;

    private RadioButton rbOpcao1, rbOpcao2,rbOpcao3,rbOpcao4;
    private Button btnSet;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cbAzul = findViewById(R.id.cbAzul);
        cbPreto = findViewById(R.id.cbPreto);
        cbVerde = findViewById(R.id.cbVerde);
        cbVermelho = findViewById(R.id.cbVermelho);

        radioGroup = findViewById(R.id.radioGroup);

        rbOpcao1 = findViewById(R.id.rbOpcao1);
        rbOpcao2 = findViewById(R.id.rbOpcao2);
        rbOpcao3 = findViewById(R.id.rbOpcao3);
        rbOpcao4 = findViewById(R.id.rbOpcao4);


        textResultado = findViewById(R.id.textResultado);
        btnSet = findViewById(R.id.btnSet);

        radioButton();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void enviar(View view){
       // checkBox();
        radioButton();
    }

    public void radioButton() {

        if (rbOpcao1.isChecked()) {
            textResultado.setText("Opção 1 selecionado");
        }


       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbOpcao1){
                    textResultado.setText("Opção 1 Selecionada");

                } else if (checkedId == R.id.rbOpcao2) {
                    textResultado.setText("Opção 2 Selecionada");
                } else if (checkedId == R.id.rbOpcao3) {
                    textResultado.setText("Opção 3 Selecionada");
                } else if (checkedId == R.id.rbOpcao4) {
                    textResultado.setText("Opção 4 Selecionada");

                }
            }
        });
    }


        //Metodo para tratar o CheckBox:

        public void checkBox () {
            String texto = "";
            if (cbVermelho.isChecked()) {
                // String corSelecionada = "Vermelho";
                String corSelecionada = cbVermelho.getText().toString();
                texto = texto + " " + corSelecionada;
            }
            if (cbVerde.isChecked()) {
                String corSelecionada = cbVerde.getText().toString();
                texto = texto + " " + corSelecionada;
            }

            if (cbAzul.isChecked()) {
                String corSelecionada = cbAzul.getText().toString();
                texto = texto + " " + corSelecionada;
            }
            if (cbPreto.isChecked()) {
                String corSelecionada = cbPreto.getText().toString();
                texto = texto + " " + corSelecionada;
            }

            textResultado.setText(texto);
        }

    }