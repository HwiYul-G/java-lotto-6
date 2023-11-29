package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoMatcher;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {

    private final InputView inputView;

    public InputController(final InputView inputView) {
        this.inputView = inputView;
    }

    public Budget requestBudget() {
        do {
            try {
                return inputView.inputBudget();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public Lotto requestWinningNumbers() {
        do {
            try {
                return inputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public WinningLotto getValidWinningLotto(Lotto winningNumbers) {
        do {
            try {
                Bonus bonusNumber = inputView.inputBonusNumbers();
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}
