package br.com.luishenrique.agendadecontatos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.com.luishenrique.agendadecontatos.adapters.AdapterContact;

public class ContactFragment extends Fragment {

    private Context context;
    private RecyclerView rv;
    private RecyclerView.Adapter adapterRv;
    private String names[];
    private String telephones[];
    private ImageView add_contact;

    public ContactFragment() {
        // Required empty public constructor
    }

    public ContactFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        initArrays();
        add_contact = view.findViewById(R.id.add_contact);
        rv = view.findViewById(R.id.rv_contacts);

        adapterRv = new AdapterContact(context, names, telephones);
        rv.setAdapter(adapterRv);
        rv.setLayoutManager(new LinearLayoutManager(context));

        return view;
    }

    private void initArrays(){
        names = new String[]{"Luis Henrique", "Cecília Silva"};
        telephones  = new String[]{"99991450705", "99992077288"};
    }
}