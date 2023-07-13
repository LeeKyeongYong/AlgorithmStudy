/**
백준 1000번 A+B
  문제 >>
 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 
 
 입력>>
 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
 
 
 출력 >>
  첫째 줄에 A+B를 출력한다.
  
 풀이 >>
 //readline 모듈과 fs모듈을 불러온다.
 const readline = require('readline');

 
 //인터페이스를 생성하고 사용자로 부터 입력을 받는다.
 const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

 
 //line 이벤트를 사용하여 입력 처리를 받는다.
 rl.on('line', (input) => {
  // 입력된 문자열을 공백으로 분리하고, 각각의 요소를 숫자로 변환하여 변수 a와 b에 할당한다.
  const [a, b] = input.split(' ').map(Number);

  // a와 b의 합을 계산하여 변수 sum에 할당처리한다.
  const sum = a + b;

  // 합을 출력한다.
  console.log(sum);

  // 입력 처리가 끝났으므로 인터페이스를 종료한다.
  rl.close();
});

 //위 코드는 사용자가 한번만 입력만을 처리하고 프로그램종료한다.
 // (*) 만약 여러번 입력 및 수정을 하고싶으면  `rl.on('line', ...) 부분을 수정해야한다.
 
 
 rl.on('line', (input) => {
  const [a, b] = input.split(' ').map(Number);
  const sum = a + b;
  console.log(sum);

  // 입력을 처리한 후에도 계속해서 사용자로부터 입력을 받을 수 있도록 인터페이스를 유지가 된다.
  // 다음 입력을 기다리려면 아래의 코드를 주석 처리한다.
  // rl.close();
});
 */
 
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on('line', (input) => {
  const [a, b] = input.split(' ').map(Number);
  const sum = a + b;
  console.log(sum);
  rl.close();
});