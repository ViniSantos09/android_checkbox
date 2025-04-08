package br.fecapccp.checkbox;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText editText;
    private RadioGroup radioGroup;
    private RadioButton rbOpcao1, rbOpcao2,rbOpcao3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edtSalario);
        radioGroup = findViewById(R.id.radioGroup);

        String salario = editText.getText().toString();
        Double salarioDouble = Double.parseDouble(salario);
        textResultado = findViewById(R.id.textResultado);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbOpcao1){
                    textResultado.setText(String.format("Aumento: %s", salarioDouble * 1.4));
                } else if (checkedId == R.id.rbOpcao2) {
                    textResultado.setText(String.format("Aumento: %s", salarioDouble * 1.45));
                } else if (checkedId == R.id.rbOpcao3) {
                    textResultado.setText(String.format("Aumento: %s", salarioDouble * 1.5));
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}