package regmoraes.rplmanager.ui.controleestoque;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import regmoraes.rplmanager.R;

/**
 * Created by regmoraes on 25/06/15.
 */
public class FrgDialogEntrada extends android.support.v4.app.DialogFragment implements View.OnClickListener,EntradaView{

    private EditText editTextQtdCx;
    private Button editTextConfirmar;

    EntradaPresenter presenter = new EntradaPresenterImpl(this);

    public FrgDialogEntrada() {

    }

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {

        android.view.View view = inflater.inflate(R.layout.dialog_entrada,container,false);

        getDialog().setTitle("Entrada");

        editTextQtdCx = (EditText) view.findViewById(R.id.editText_qtdCx);
        editTextConfirmar = (Button) view.findViewById(R.id.button_confirmar_entrada);
        editTextConfirmar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        presenter.validarCampo(editTextQtdCx.getText().toString());

    }

    @Override
    public void showMenssagemErro(String mensagem) {

        Context context = getActivity().getApplicationContext();
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
}
