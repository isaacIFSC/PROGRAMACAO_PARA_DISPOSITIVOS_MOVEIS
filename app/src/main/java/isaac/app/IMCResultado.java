package isaac.app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class IMCResultado extends AppCompatActivity {
    TextView tvNome,tvPeso, tvAltura, tvIMC, tvDica;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imcresultado);
        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvIMC = findViewById(R.id.tvIMC);
        tvNome = findViewById(R.id.tvNome);
        imageView = findViewById(R.id.imgPerfil);
        tvDica = findViewById(R.id.tvDica);
        Bundle b = getIntent().getExtras();

        float peso = b.getFloat("peso");
        float altura = b.getFloat("altura");

        float imc = (peso)/(altura * altura);

        tvNome.setText("Nome: " + b.getString("nome"));
        tvPeso.setText("Peso: " + Float.toString(peso));
        tvAltura.setText("Altura: " + Float.toString(altura));
        DecimalFormat nf = new DecimalFormat("#.##");
        tvIMC.setText("Resultado: " + nf.format(imc));

        if(imc < 18.5) {
            imageView.setImageResource(R.drawable.abaixopeso);
        } else if(imc < 24.9) {
            imageView.setImageResource(R.drawable.normal);
        } else if(imc < 29.9) {
            imageView.setImageResource(R.drawable.sobrepeso);
        } else if (imc < 34.9) {
            imageView.setImageResource(R.drawable.obesidade1);
        } else if (imc < 39.9) {
            imageView.setImageResource(R.drawable.obesidade2);
        } else {
            imageView.setImageResource(R.drawable.obesidade3);
        }

        if(imc < 20){
            int ganharPeso = (int) ((altura * altura) * 20);
            int diferenca = (int) (ganharPeso - peso);
            tvDica.setText("Você precisa ganhar no minimo:\n " + Integer.toString(diferenca) + "KG para ficar no IMC saudavel!");
        }
        else if(imc > 25){
            int ganharPeso = (int) ((altura * altura) * 25);
            int diferenca = (int) (peso - ganharPeso);
            tvDica.setText("Você precisa precisa perder no minimo:\n " + Integer.toString(diferenca) + "KG para ficar no IMC saudavel!");
        } else{
            tvDica.setText("Parabéns seu IMC está saudavel!");
        }

    }
}
