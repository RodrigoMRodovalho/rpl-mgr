package regmoraes.rplmanager.ui.controleestoque;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import regmoraes.rplmanager.R;


/**
 * Created by romulo-eduardo on 9/27/14.
 */
public class CursorAdapterProduto extends CursorAdapter{

    private Context mContext;
    private final LayoutInflater mInflater;

    public CursorAdapterProduto(Context context, Cursor c) {

        super(context, c, 0);

        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView nome =(TextView)view.findViewById(R.id.textView_nome);

        TextView precoCusto =(TextView)view.findViewById(R.id.textView_preco_custo);

        TextView qtdEstoqueCx =(TextView)view.findViewById(R.id.textView_qtd_estoque_cx);

        //TextView qtdEstoquePca =(TextView)view.findViewById(R.id.textView_ficha_item_data_fim);

        nome.setText(cursor.getString(getCursor().getColumnIndex("nome")));

        precoCusto.setText(
                view.getResources().getString(R.string.preco_custo) +
                cursor.getString(getCursor().getColumnIndex("preco_custo")));

        qtdEstoqueCx.setText(
                view.getResources().getString(R.string.qtd_cx) +
                cursor.getString(getCursor().getColumnIndex("qtd_estoque_cx")));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        final View view = mInflater.inflate(R.layout.crsr_adapter_estoque_item,parent,false);

        return view;
    }
}