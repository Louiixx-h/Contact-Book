package br.com.luishenrique.agendadecontatos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.luishenrique.agendadecontatos.R;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ViewHolderContact> {

    private final String[] names;
    private final String[] telephones;
    private char[] nameInitial;
    private Context context;

    public AdapterContact(Context context, String[] names, String[] telephones) {
        this.context = context;
        this.names = names;
        this.telephones = telephones;
        nameInitial = new char[this.names.length];
    }

    @NonNull
    @Override
    public ViewHolderContact onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolderContact(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderContact holder, int position) {
        holder.bind(names[position], telephones[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class ViewHolderContact extends RecyclerView.ViewHolder {

        TextView item_name;
        TextView item_telephone;
        TextView name_initial;

        public ViewHolderContact(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_telephone = itemView.findViewById(R.id.item_telephone);
            name_initial = itemView.findViewById(R.id.name_initial);
        }

        public void bind(String name, String telephone){
            //name_initial.setText(init);
            item_name.setText(name);
            item_telephone.setText(telephone);
        }
    }
}
