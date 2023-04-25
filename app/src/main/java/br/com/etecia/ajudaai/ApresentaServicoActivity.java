package br.com.etecia.ajudaai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.appbar.MaterialToolbar;

import android.os.Bundle;
import android.widget.Toast;


public class ApresentaServicoActivity extends AppCompatActivity {

    TextView mDescricao;
    ImageView mImagem;
    Button btnSolicitacao;
    MaterialToolbar idToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apresenta_servico_layout);

        mImagem = findViewById(R.id.idImagemServico);
        mDescricao = findViewById(R.id.mDescricaoServico);
        btnSolicitacao = findViewById(R.id.btnSolicitar);

        idToolbar = findViewById(R.id.idToolbarServico);

        idToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HomeMainActivity.class));
            }
        });

        btnSolicitacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Solicitação enviada com Sucesso!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();

        String descricao;
        int imagemServico;

        imagemServico = intent.getExtras().getInt("ImagemServico");
        descricao = intent.getExtras().getString("Descricao");

        mImagem.setImageResource(imagemServico);
        mDescricao.setText(descricao);
    }
}