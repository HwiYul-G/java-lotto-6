package lotto.controller;

import java.util.List;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoMatcher;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.view.OutputView;

public class OutputController {

    private final OutputView outputView;

    public OutputController(final OutputView outputView) {
        this.outputView = outputView;
    }

    public List<Lotto> purchaseLottos(final Budget budget) {
        List<Lotto> purchasedLottos = new LottoGenerator().generate(budget);
        outputView.printTicketNumber(budget.calculateLottoCount());
        outputView.printUserLottos(purchasedLottos);
        return purchasedLottos;
    }

    public void printLottoResult(final List<Lotto> purchasedLottos, final WinningLotto winningLotto,
        final Budget budget) {
        LottoResult lottoResult = new LottoMatcher(winningLotto).matchLottos(purchasedLottos);
        outputView.printLottoResult(lottoResult, budget.inputMoney());
    }

}
