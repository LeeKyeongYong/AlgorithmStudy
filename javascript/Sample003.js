//랜선자르기 백준 1654번
/*
입력>>
4 11
802
743
457
539

출력>>
200
*/
const fs=require('fs');

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [K,N] = input[0].split(' ').map(Number);

let max=0;
const arr=[];
for(let i=1; i<=K; i++){
	const length = Number(input[i]);
	arr.push(length);
	max = Math.max(max,length);
}

let min=0;
let result=0;

while(min<=max){
	
	const mid = Math.floor((min+max)/2);
	let count=0;
	for(let i=0; i<K; i++){
		count+=Math.floor(arr[i]/mid);
	}
	if(count>=N){
		mid=mid+1;
		result=mid;
	} else {
		max=mid=1;
	}
}

console.log(result);