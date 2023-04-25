package br.com.etecia.ajudaai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ServicosFragment extends Fragment {

    List<Servicos> ListaServicos;

    RecyclerView idRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_servicos, container, false);

        idRecyclerView = view.findViewById(R.id.idListaServicos);

        ListaServicos = new ArrayList<>();

        ListaServicos.add(
                new Servicos("Solicite a remoção de árvores caídas e poda de árvores.",
                        R.drawable.arvore));

        ListaServicos.add(
                new Servicos("Solicite o fechamento de buracos em vias públicas",
                        R.drawable.buraco));

        ListaServicos.add(
                new Servicos("Solicite o reparo em postes de luz e semáforos",
                        R.drawable.iluminacao));

        ListaServicos.add(
                new Servicos("Solicite a remoção de lixo e entulhos",
                        R.drawable.lixo));

        MyAdapter adapter = new MyAdapter(getActivity().getApplicationContext(), ListaServicos);

        idRecyclerView.setLayoutManager(new
                GridLayoutManager(
                        getActivity().getApplicationContext(), 2));

        idRecyclerView.setHasFixedSize(true);

        idRecyclerView.setAdapter(adapter);

        return view;
    }
}