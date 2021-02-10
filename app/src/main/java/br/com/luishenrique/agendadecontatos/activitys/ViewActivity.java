package br.com.luishenrique.agendadecontatos.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import br.com.luishenrique.agendadecontatos.AddContactFragment;
import br.com.luishenrique.agendadecontatos.ContactFragment;
import br.com.luishenrique.agendadecontatos.R;

public class ViewActivity extends AppCompatActivity {

    private TextView btn_add_contact;
    private TextView btn_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        btn_add_contact = findViewById(R.id.btn_add_contact);
        btn_contact = findViewById(R.id.btn_contact);

        if (savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_conteiner, new AddContactFragment())
                    .commit();
        }

        btn_add_contact.setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_left_to_right
                            , R.anim.exit_left_to_right
                            , R.anim.enter_right_to_left
                            , R.anim.exit_right_to_left)
                    .replace(R.id.frame_conteiner, new AddContactFragment())
                    .commit();
        });

        btn_contact.setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_right_to_left
                            , R.anim.exit_right_to_left
                            , R.anim.enter_left_to_right
                            , R.anim.exit_left_to_right)
                    .replace(R.id.frame_conteiner, new ContactFragment(this))
                    .commit();
        });
    }
}