/**
 * 백준 14215 세 막대
 *
 * 문제 >>
 * 영선이는 길이가 a, b, c인 세 막대를 가지고 있고, 각 막대의 길이를 마음대로 줄일 수 있다.
 *
 * 영선이는 세 막대를 이용해서 아래 조건을 만족하는 삼각형을 만들려고 한다.
 *
 * 각 막대의 길이는 양의 정수이다
 * 세 막대를 이용해서 넓이가 양수인 삼각형을 만들 수 있어야 한다.
 * 삼각형의 둘레를 최대로 해야 한다.
 * a, b, c가 주어졌을 때, 만들 수 있는 가장 큰 둘레를 구하는 프로그램을 작성하시오.
 *
 * 입력>>
 * 첫째 줄에 a, b, c (1 ≤ a, b, c ≤ 100)가 주어진다.
 * 1 2 3
 *
 * 출력>>
 * 5
 */
const readline =require('readline');
const r1=readline.createInterface({
    input:process.stdin,
    output:process.stdout
});

function main(){
    let a=[];
    r1.on('line',(input)=>{
        a=input.split(' ').map(Number); //a란 변수에 1,2,3을 저장한다.
        r1.close();
    }).on('close',()=>{
       a.sort((x,y)=> x-y); //입력받은 정수를 오름차순으로 정렬한다음
       const sum = a[0] + a[1]; //첫번째 정수와 두번째의 정수를 저장한다.
       const result sum > a[2] ?sum+a[2]:sum*2-1; //합계가 두번째 정수보다 클경우 덧셈을 작을 경우 합계에 2를 곱해준다음 1을 빼준다.
       console.log(result); //마지막으로 결과값을 출력한다.
    });
}
main();