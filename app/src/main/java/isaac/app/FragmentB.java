package isaac.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    TextView tv;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        tv = v.findViewById(R.id.textView);

        if (getArguments() != null && getArguments().containsKey("valor")) {
            int valor = getArguments().getInt("valor");
            tv.setText(String.valueOf(valor));
        } else {
            tv.setText("No fragmento A digite os números e some");
        }
    }
}