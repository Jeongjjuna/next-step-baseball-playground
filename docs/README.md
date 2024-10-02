##  주제 : 숫자 야구 게임

## 개인 학습 내용
개인 목표 : 읽기 쉽도록 개선 작성하고, 객체지향 적용해보자.

- 이름 짓기
   - 단/복수 -> Ball, Balls
   - 이름 줄이지말기
- 메서드 이름으로 의도 전달하기
- 매직 넘버/스트링 사용 x
- 객체 생성시 검증 하기(정적 팩토리 메서드) -> Ball.create(), validateSize(List<Integer> ballNums)
- 캡슐화 -> setter x, getter 가급적 x, 필요한 메서드만 노출


- 단일책임원칙
  - BaseBallGame -> 게임 실행 담당
  - InputHandler, OutputHandler -> 입/출력 담당
  - BallGenerator -> 야구볼 생성 담당
- 개방폐쇄원칙
  - "요구 사항 변경에 대비해보자." -> 추상화 + 다형성으로
  - 난이도에 따라 플레이어 시도 횟수를 지정해보자.
    - GameLevel 인터페이스를 활용하여 여러 구현체를 내부에 주입(Hard, Medium, easy)
- 리스코프 치환 원칙
  - Balls를 추상클래스로 반들고, UserBalls와 AnswerBall로 나누려고 했음.
    - 하지만 크게 중복/구별 되는 기능이 명확하지 않아서 그냥 두기로 함.
- 인터페이스 분리 원칙
  - , GameRunnable 인터페이스로 분리
  - BaseBallGame말고 다른 Game을 구현할 때 초기화부분이 필요한지에 따라 GameInitializable을 추가하거나 없앨 수 있음.
- 의존성 역전 원칙
  - 입/출력, 볼생성 등을 담당하는 구현체(인프라객체)들은, 모두 Application단에서 객체를 생성하여 GameConfig에 넣어주고,
  - 실제 게임 진행을 담당하는 BaseBallGame은 외부에서 생성된 인프라객체들을 주입받아서 사용할 수 있다.
  - 주입 받을 때는 구현체가 아닌, BallGenerator와 같은 인터페이스를 주입받는다.
  - 볼 생성 방식을 랜덤이 아니라 다른 구현체로 바꾸고 싶다면, 외부에서 BallGenerator를 구현하는 구현체를 만들고, GameConfig에 넣어서 주입해주면 된다.

- Value Object
  - Ball -> number, pos 가 모두 같으면 같은 Ball이라고 생각할 수 있다.
- 일급 컬렉션
  - ~ ing
- Enum 다형성 활용
  - ~ ing



## next step 프로그래밍 요구사항
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 Google Java Style Guide을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
