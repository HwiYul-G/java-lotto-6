package lotto;

import java.util.List;
import lotto.controller.InputController;
import lotto.controller.OutputController;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        InputController inputController = new InputController(inputView);
        OutputController outputController = new OutputController(outputView);

        Budget budget = inputController.requestBudget();
        List<Lotto> purchasedLottos = outputController.purchaseLottos(budget);

        Lotto winningNumbers = inputController.requestWinningNumbers();
        WinningLotto winningLottoWithBonus = inputController.getValidWinningLotto(winningNumbers);

        outputController.printLottoResult(purchasedLottos, winningLottoWithBonus, budget);
    }
}
