package isaac.app;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
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
    TextView textViewResultado;
    EditText editTextMin, editTextMax;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editTextMin = findViewById(R.id.editTextMin);
        editTextMax = findViewById(R.id.editTextMax);
        textViewResultado = findViewById(R.id.textResult);

        button.setOnClickListener(v -> {
            int min = Integer.parseInt(editTextMin.getText().toString());
            int max = Integer.parseInt(editTextMax.getText().toString());
            int sorteado = 0;
            sorteado = (int) (Math.random() * (max - min) + min);

            textViewResultado.setText(Integer.toString(sorteado));
        });
        Log.d("ciclo_vida", "onCreate");
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState){
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("sorteado", textViewResultado.getText().toString());
    }
    @Override
    public void onRestoreInstaceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        textViewResultado.setText(savedInstanceState.getString("sorteado"));
    }

}

