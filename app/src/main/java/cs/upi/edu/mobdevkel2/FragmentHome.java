package cs.upi.edu.mobdevkel2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentHome extends Fragment{
    BottomNavigationView bnv;

    public FragmentHome(){
        // require a empty public constructor
    }

    public static FragmentHome newInstance() {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_home, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        Toolbar tb = (Toolbar)   getActivity().findViewById(R.id.toolbar);
        tb.setNavigationIcon(null);
        tb.setTitle("Beranda");

        LinearLayout btnLansia = (LinearLayout) getActivity().findViewById(R.id.btnHomePasien);
        btnLansia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bnv = getActivity().findViewById(R.id.botNav);
                bnv.setSelectedItemId(R.id.mLansia);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentLansia.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });

        LinearLayout btnGuide = (LinearLayout) getActivity().findViewById(R.id.btnHomeGuide);
        btnGuide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bnv = getActivity().findViewById(R.id.botNav);
                bnv.setSelectedItemId(R.id.mGuide);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentGuide.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });

        LinearLayout btnHelp = (LinearLayout) getActivity().findViewById(R.id.btnHomeHelp);
        btnHelp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentHomeHelp.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}