//백준 2439 별 찍기 2
/*
입력>>
5

출력>>
    *
   **
  ***
 ****
*****
*/

function main(){
	const readline = require('readline');
	const rl=readline.createInterface({
		input:process.stdin,
		output:process.stdout
	});
	
	rl.on('line',(input)=>{
		const N=parseInt(input);
		
		for(let row=1; row<=N; row++){
			for(let i=0; i<N-row; i++){
				process.stdout._write('');
			}
			
			for(let i=0; i<row; i++){
				process.stdout.write('*');
			}
			
			process.stdout._write('\n');
		}
		rl.close();
	});
}

main();