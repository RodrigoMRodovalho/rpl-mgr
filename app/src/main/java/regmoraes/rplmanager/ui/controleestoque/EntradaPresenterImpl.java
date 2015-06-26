package regmoraes.rplmanager.ui.controleestoque;

/**
 * Created by regmoraes on 25/06/15.
 */
public class EntradaPresenterImpl implements EntradaPresenter {

    EntradaView entradaView;

    public EntradaPresenterImpl(EntradaView entradaView) {

        this.entradaView = entradaView;
    }

    @Override
    public void validarCampo(String s) {

        if(s.isEmpty()) {

            entradaView.showMenssagemErro("O campo não pode ficar vazio");
        }
    }
}
