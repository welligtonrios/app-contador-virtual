package com.wrios.contadorvirtual2.helper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ConfiguracaoFirebase {


    private static DatabaseReference referenciaFirebaseDatabase;
    private static FirebaseAuth referenciaFireAutenticacao;
    private static StorageReference referenciaStorage;

    //uid de senha usuario
    public static String getIDUsuario(){
        FirebaseAuth autenticacao = getReferenciaFireAutenticacao();
        return autenticacao.getCurrentUser().getUid();
    }

    //retorna idUsusairo logado
        public static  String getIdUsuario(){
        FirebaseAuth autenticacao = getReferenciaFireAutenticacao();
                return autenticacao.getCurrentUser().getUid();
        }


    //retorna a referencia DatabaseReference
    public static DatabaseReference getReferenciaFirebaseDatabase() {
        if (referenciaFirebaseDatabase == null){
            referenciaFirebaseDatabase = FirebaseDatabase.getInstance().getReference();
        }
        return referenciaFirebaseDatabase;
    }

    //retorna a instancia do FirebaseAuth
    public static FirebaseAuth getReferenciaFireAutenticacao() {
        if (referenciaFireAutenticacao == null){
            referenciaFireAutenticacao = FirebaseAuth.getInstance();
        }
        return referenciaFireAutenticacao;
    }

    //retorna a instancia do StorageReference
    public static StorageReference getReferenciaStorage() {
        if (referenciaStorage == null){
            referenciaStorage = FirebaseStorage.getInstance().getReference();
        }
        return referenciaStorage;
    }


}
