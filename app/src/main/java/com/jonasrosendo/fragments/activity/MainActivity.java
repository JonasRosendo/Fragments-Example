package com.jonasrosendo.fragments.activity;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jonasrosendo.fragments.Fragment.ContatosFragment;
import com.jonasrosendo.fragments.Fragment.ConversasFragment;
import com.jonasrosendo.fragments.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button btn_conversas, btn_contatos;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setElevation(0);

        btn_conversas = findViewById(R.id.btn_conversas);
        btn_contatos = findViewById(R.id.btn_contatos);

        conversasFragment = new ConversasFragment();
        chamarFragment(conversasFragment);

        btn_conversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversasFragment = new ConversasFragment();
                chamarFragment(conversasFragment);
            }
        });

        btn_contatos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                contatosFragment = new ContatosFragment();
                chamarFragment(contatosFragment);
            }
        });
    }

    public void chamarFragment(Fragment f){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_conteudo, f);
        transaction.commit();

    }
}
