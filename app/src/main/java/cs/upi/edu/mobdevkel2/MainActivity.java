package cs.upi.edu.mobdevkel2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import cs.upi.edu.mobdevkel2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    FragmentHome fragmentHome = new FragmentHome();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setContentView(R.layout.activity_main);

        bnv = binding.botNav;
        bnv.setSelectedItemId(R.id.home);
        bnv.setOnItemSelectedListener(
                item -> {
                    int id = item.getItemId();
                    switch (id) {
                        case R.id.home:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentHome).commit();
                            return true;
                        case R.id.lansia:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentHome).commit();
                            return true;
                    }

                    return true;
                });
    }

}