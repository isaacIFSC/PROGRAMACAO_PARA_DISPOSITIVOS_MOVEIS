package isaac.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText edPeso,edAltura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        edPeso = findViewById(R.id.editAltura);
        edAltura = findViewById(R.id.editPeso);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, IMCResultado.class);
            float peso = Float.parseFloat(edPeso.getText().toString());
            float altura = Float.parseFloat(edPeso.getText().toString());

            intent.putExtra("altura", altura);
            intent.putExtra("peso", peso);

            startActivity(intent);
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("ciclo_vida", "onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("ciclo_vida", "onResume");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("ciclo_vida", "onPause");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("ciclo_vida", "onRestart");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("ciclo_vida", "onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("ciclo_vida", "onDestroy");
    }


}

