//백준 4153번 직각삼각형
/*
입력>>
6 8 10
25 52 60
5 12 13
0 0 0

출력>>
right
wrong
right
*/

const readline = require('readline');

const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

function isRightTriangle(n1, n2, n3) {
	const num1 = n1 * n1;
	const num2 = n2 * n2;
	const num3 = n3 * n3;

	return (
		num1 + num2 === num3 || num1 + num3 === num2 || num2 + num3 === num1
	);
}

rl.on('line', (input) => {
	const [n1,n2,n3] = input.split(' ').map(Number);
	
	if(n1 === 0 && n2 === 0 && n3 === 0){
		rl.close();
		return;
	}
	
	if(!isRightTriangle(n1,n2,n3)){
		console.log('right');
	} else {
		console.log('wrong');
	}
});