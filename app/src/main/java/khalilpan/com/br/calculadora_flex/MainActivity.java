package khalilpan.com.br.calculadora_flex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText_alcool;
    private EditText editText_gasolina;
    private Button button_calcular;
    private EditText editText_resultado;
    private boolean statusNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_alcool = findViewById(R.id.editText_alcool);
        editText_gasolina = findViewById(R.id.editText_gasolina);
        button_calcular = findViewById(R.id.button_calcular);
        editText_resultado = findViewById(R.id.editText_resultado);

        editText_alcool.setText(null);
        editText_gasolina.setText(null);

        button_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                statusNull = false;
                double alcool = 0.00;
                double gasolina = 0.00;

                //checking for that if the price's box is empty or not(alcool box)
                if (!(editText_alcool.getText().toString().isEmpty())) {
                    alcool = Double.valueOf(editText_alcool.getText().toString());
                } else {
                    editText_resultado.setText("Álcool Preço tá Vazio");
                    statusNull = true;
                }

                //checking for that if the price's box is empty or not(gasolina box)
                if (!(editText_gasolina.getText().toString().isEmpty())) {
                    gasolina = Double.valueOf(editText_gasolina.getText().toString());
                } else {
                    editText_resultado.setText("Gasolina Preço tá Vazio");
                    statusNull=true;
                }

                //checking the prices to not be zero
                if ((alcool > 0) && (gasolina > 0)) {

                    double result = alcool / gasolina;

                    if (result > 0.7) {
                        editText_resultado.setText("Abasteça Gasolina");
                    } else if (result < 0.7) {
                        editText_resultado.setText("Abasteça Álcool");
                    } else {
                        editText_resultado.setText("Qualquer");
                    }
                } else if (statusNull==false){
                    editText_resultado.setText("Digite Preço Verdadeira");
                }

            }
        });

    }
}
