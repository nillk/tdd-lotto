
import java.util.Scanner;

public class LottoGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LottoMachine lottoMachine = new LottoMachine();

        System.out.println("구입금액을 입력해 주세요.");
        int price = scan.nextInt();

        int lottoCount = lottoMachine.buy(price);

        System.out.println(lottoCount + "개를 구매했습니다.");
        System.out.println(lottoMachine.allLottoString());

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = scan.next();

        lottoMachine.setWinningNumber(winningNumber);
    }
}
