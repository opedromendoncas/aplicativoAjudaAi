package br.com.etecia.ajudaai;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContexto;
    private List<Servicos> lstServicos;

    //criando o construtor da classe com parâmetros


    public MyAdapter(Context mContexto, List<Servicos> lstServicos) {
        this.mContexto = mContexto;
        this.lstServicos = lstServicos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        LayoutInflater inflater = LayoutInflater.from(mContexto);
        view = inflater.inflate(R.layout.modelo_servico, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.idImagemServicos.setImageResource(lstServicos.get(position).getImagem());

        holder.idCardServicos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContexto, ApresentaServicoActivity.class);

                intent.putExtra("ImagemServico", lstServicos.get(position).getImagem());
                intent.putExtra("Descricao", lstServicos.get(position).getDescricao());

                mContexto.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

            }
        });

    }

    @Override
    public int getItemCount() {
        return lstServicos.size();
    }

    //criar a classe ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView idImagemServicos;
        CardView idCardServicos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idImagemServicos = itemView.findViewById(R.id.idImagemServico);
            idCardServicos = itemView.findViewById(R.id.idCardServico);
        }
    }
}