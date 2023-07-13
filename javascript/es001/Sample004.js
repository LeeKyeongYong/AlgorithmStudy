//2231번 백준 분해합
/*
입력1>>
216

출력1>>
198

*/
const readline = reqquire('readline');

const rl=readline.createInterface({
	input:process.stdin,
	output:process.stdout
});

rl.on('line',function(line){
	
	const n = parseInt(line);
	
	for(let i=1; i<=n; i++){
		const num = Array.form(string(i),Number).reduce((acc,curr)=>acc+curr,0);
		const numSum = i+num;
		
		if(numSum === n){
			console.log(i);
			break;
		}
		
		if(i === n){
			console.log(0);
		}
	}
	
	rl.close();
	
});