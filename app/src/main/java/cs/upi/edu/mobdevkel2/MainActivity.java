package cs.upi.edu.mobdevkel2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    FragmentHome fragmentHome = new FragmentHome();
    FragmentLansia fragmentLansia = new FragmentLansia();
    FragmentGuide fragmentGuide = new FragmentGuide();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.botNav);
        bnv.setSelectedItemId(R.id.home);
        bnv.setOnItemSelectedListener(
                new BottomNavigationView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.home:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentHome).commit();
                                return true;
                            case R.id.lansia:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentLansia).commit();
                                return true;
                            case R.id.guide:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentGuide).commit();
                                return true;
                        }

                        return true;
                    }
                });
    }
}