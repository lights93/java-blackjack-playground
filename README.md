## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```


## 기능 요구사항
- [X] 게임에 참여할 사람 입력 기능
- [X] 플레이어는 게임을 시작할 때 배팅 금액 입력 기능
- [X] 숫자 계산 기능
  - [X] Ace는 1 또는 11로 계산
  - [X] King, Queen, Jack은 각각 10
- [X] 카드 지급 기능
- [X] 딜러와 플레이어들에게 초기에 2장씩 지급
- [X] 카드 상태 출력 기능
- [ ] 카드 추가 뽑기 기능
- [ ] 처음 두장의 카드 합이 21일 경우 블랙잭이 되면 베팅 금액의 1.5배를 받는 기능
- [ ] 딜러와 플레이어가 모두 동시에 블랙잭인 경우 플레이어는 베팅한 금액을 돌려받는 기능
- [ ] 딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받는 기능
- [ ] 딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리 기능
- [ ] 최종 수익 계산 기능
- [ ] 결과 계산 기능
- [ ] 결과 출력 기능
