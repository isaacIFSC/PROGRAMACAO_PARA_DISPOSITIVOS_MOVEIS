package isaac.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText edNome,edPeso, edAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNome = findViewById(R.id.editNome);
        button = findViewById(R.id.button);
        edPeso = findViewById(R.id.editPeso);
        edAltura = findViewById(R.id.editAltura);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, IMCResultado.class);
            float peso = Float.parseFloat(edPeso.getText().toString());
            float altura = Float.parseFloat(edAltura.getText().toString());
            String nome = edNome.getText().toString();
            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("nome", nome);
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        Log.d("ciclo_vida", "onCreate");
//    }
//    @Override
//    protected void onStart(){
//        super.onStart();
//        Log.d("ciclo_vida", "onStart");
//    }
//    @Override
//    protected void onResume(){
//        super.onResume();
//        Log.d("ciclo_vida", "onResume");
//    }
//    @Override
//    protected void onPause(){
//        super.onPause();
//        Log.d("ciclo_vida", "onPause");
//    }
//
//    @Override
//    protected void onRestart(){
//        super.onRestart();
//        Log.d("ciclo_vida", "onRestart");
//    }
//
//    @Override
//    protected void onStop(){
//        super.onStop();
//        Log.d("ciclo_vida", "onStop");
//    }
//
//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        Log.d("ciclo_vida", "onDestroy");
//    }
}

