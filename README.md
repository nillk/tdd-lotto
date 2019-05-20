# TDD Lotto
TDD를 통해 Lotto game 구현하기

## 기능 요구사항
* [ ] 구입 금액을 입력하면, 금액만큼 로또를 구매할 수 있다.
  * [x] 로또 한 장의 가격은 1000원이다.
  * [x] 입력 금액은 1000원 이상이어야 한다.
  * [x] 1000원 단위가 아닌 금액은 버린다. (1500원 -> 1장만 구매 가능)
  * [x] 각 로또는 6개의 번호로 이루어진다.
  * [x] 6개의 숫자는 1에서 45사이이다.
  * [x] 6개의 숫자는 중복될 수 없다.
* [ ] 지난주 당첨 번호를 입력할 수 있다.
  * [ ] 당첨 번호는 6자리 숫자를 입력해야 한다.
  * [ ] 각 숫자는 1에서 45 사이이다. (재입력 요구)
  * [ ] 각 숫자는 중복될 수 없다. (재입력 요구)
* [ ] 보너스 번호를 입력할 수 있다.
  * [ ] 숫자 하나를 입력해야 한다.
  * [ ] 숫자는 1에서 45사이이다. (재입력 요구)
  * [ ] 당첨 번호에 포함되지 않은 번호여야 한다. (재입력 요구)
* [ ] 당첨 번호와 보너스 번호를 입력하면 구매한 로또 중 당첨된 내역을 계산할 수 있다.
  * [ ] 당첨번호를 입력하면 구매액수 대비 당첨금 수익률을 계산해야 한다.
  * [ ] 로또 당첨 금액은 고정되어 있다.

    |등수|기준|금액|
    |---|---|---|
    |1등|6개숫자 일치|2,000,000,000|
    |2등|5개숫자 일치 + 보너스|30,000,000|
    |3등|5개숫자 일치|1,500,000|
    |4등|4개숫자 일치|50,000|
    |5등|3개숫자 일치|5,000|
