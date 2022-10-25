package cs.upi.edu.mobdevkel2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
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
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);


        bnv = findViewById(R.id.botNav);
        bnv.setSelectedItemId(R.id.mHome);
        bnv.setOnItemSelectedListener(
                new BottomNavigationView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.mHome:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentHome).commit();
                                return true;
                            case R.id.mLansia:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentLansia).commit();
                                return true;
                            case R.id.mGuide:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentGuide).commit();
                                return true;
                        }

                        return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_top_bar, menu);
        return true;
    }

}