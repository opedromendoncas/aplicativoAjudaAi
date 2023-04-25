package br.com.etecia.ajudaai;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    EditText edtEmail,edtSenha;

    Button btnLogin;

    TextView txtRecuperarSenha;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        edtEmail = view.findViewById(R.id.edtEmail);
        edtSenha = view.findViewById(R.id.edtSenha);
        btnLogin = view.findViewById(R.id.btnlogin);
        txtRecuperarSenha = view.findViewById(R.id.txtRecuperaSenha);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Pegar os valores do email e da senha do usuário
                String email, senha;

                email = edtEmail.getText().toString();
                senha = edtSenha.getText().toString();


                //criando a estrutura de decisão para acesso ao sistema
                if (email.equals("etecia")&&senha.equals("etecia")){
                    //entrar aqui..
                    Intent intent = new Intent(getActivity().getApplicationContext(),
                            MainActivity.class);
                    //passar parâmetros para outras janelas
                    startActivity(intent);


                    Toast.makeText(getActivity().getApplicationContext(),
                            "Bem vindo!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Usuário ou senha inválidos",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });


        txtRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}