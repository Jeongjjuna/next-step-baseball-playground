### 요구사항

Ball.class

* create 생성테스트
    - [x] 1~9사이의 숫자 생성
        - [x] 생성 시 1~9사이의 숫자가 아니라면 예외 반환

* isMatch() 비교테스트
    - [X] Ball끼리 비교하여 같은 num이라면 True, 그렇지 않다면 False반환

Balls.class

* create 생성테스트
    - [x] List<Ball>을 필드로 가지는 Balls생성
        - [x] 생성 시 길이가 3(Balls.SIZE)이 아니라면 예외반환
        - [x] 생성 시 List<Ball>이 전부 서로 다르지 않다면 예외반환

* Judgement.call
    - [x] Balls에 (Ball, position)이 주어지면 스크라이크, 볼, 낫씽을 반환한다.