package com.wrios.contadorvirtual2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wrios.contadorvirtual2.R;
import com.wrios.contadorvirtual2.model_domain.SolicitacaoSetorFiscal;

import java.util.List;

public class AdapterSolicitacoesFiscal extends RecyclerView.Adapter<AdapterSolicitacoesFiscal.MyViewHolder> {

    private List<SolicitacaoSetorFiscal> solicitacoesFiscais;
    private Context context;

    public AdapterSolicitacoesFiscal(List<SolicitacaoSetorFiscal> solicitacoesFiscais, Context context) {
        this.solicitacoesFiscais = solicitacoesFiscais;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //crio uma view solicitacao para depois passar ela e recuperar ela no metodo(MyViewHolder) e assim recuperar os valores da view
        View solicitacao = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_solicitacao,parent,false);

        return new MyViewHolder(solicitacao);
    }

    //metodo que vai passar os valores recuperados
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                SolicitacaoSetorFiscal solicitacao = solicitacoesFiscais.get(position);
                holder.texIdsolicitacao.setText(solicitacao.getIdsolicitacao()); // passando para o text ID o id da solicitacao
                holder.nomeCliente.setText(solicitacao.getUsuarioCliente());
    }
    //quandidade de itens
    @Override
    public int getItemCount() {
        return solicitacoesFiscais.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView texIdsolicitacao;
        TextView nomeCliente;
        TextView status;
        ImageView imagem;
        Button abrir, remover;

        public MyViewHolder(View itemView){
            super(itemView); //para mim pegar os itens de outra View eu preciso do itemView "super da classe RecyclerView.ViewHolder"

            texIdsolicitacao = itemView.findViewById(R.id.textIdSolicitacao);
            nomeCliente = itemView.findViewById(R.id.textIDnomeCliente);
            status = itemView.findViewById(R.id.texIdStatus);
            //imagem = itemView.findViewById(R.id.idimageSolicitacao);
           // remover = itemView.findViewById(R.id.idbuttonRemover);



        }


    }






}
