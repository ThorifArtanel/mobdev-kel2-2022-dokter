package cs.upi.edu.mobdevkel2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentLansiaRmAdd extends Fragment {
    public FragmentLansiaRmAdd() {
        // Required empty public constructor
    }

    public static FragmentLansiaRmAdd newInstance() {
        FragmentLansiaRmAdd fragment = new FragmentLansiaRmAdd();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lansia_rm_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        Toolbar tb = (Toolbar)   getActivity().findViewById(R.id.toolbar);
        tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        tb.setTitle("Pasien - Rekam Medis");
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, FragmentLansiaRm.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });
    }
}