//백준9019번 DSLR

const readline=require("readline");

function open_D(num){
	let num2=(2*num)%10000;
	return num2;
}

function open_s(num){
	let num2=(num-1)%10000;
	if(num2<0){
		num2=9999;
	}
	return num2;
}

function open_L(num){
	let front = num%1000;
	let back=Math.floor(num/1000);
	let num2=front*10+back;
	return num2;
}

function open_R(num){
	let front = num%10;
	let back=Math.floor(num/10);
	let num2=front*1000+back;
	return num2;
}

function main(){

	const rl=readline.createInterface({
		input:process.stdin,
		output:process.stdout,
	});
	
	rl.on("",(line)=>{
		
		const [A,B]=line.split(" ").map(Number);
		
		const q = [];
		
		q.push([A,""]);
		
		const visit=new Array(10000).fill(false);
		
		while(q.length>0){
			
			const[num,puth] = q.shift();
			
			visit[num]=true;
			
			if(num === B){
				
				console.log(path);
				
				break;
				
			}
			
			let num2=oper_D(num);
			if(!visit[num2]){
				
				q.push([num2,path+"D"]);
				
				visit[num2]=true;
				
			}
			
			num2=oper_s(num);
			
			if(!visit[num2]){
				
				q.push([num2,path+"S"]);
				
				visit[num2]=true;
				
			}
			
			num2=oper_L(num);
			
			if(!visit[num2]){
				
				q.push([num2,puth+"L"]);
				
				visit[num2]=true;
				
			}
			
			num2=oper_R(num);
			
			if(!visit[num2]){
				
				q.push([num2,path+"R"]);
				
				visit[num2]=true;
				
			}
			
		}
	});
}

main();
/*
입력>>
3
1234 3412
1000 1
1 16

출력>>
LL
L
DDDD
*/