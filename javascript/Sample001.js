	//백준 14500번 테트로미노
	const readline = require('readline');
	
	const rl=readline.createInterface({
		input:process.stdin,
		output:process.stdout
	});
	
	let n,m;
	
	const graph=[];
	
	const dir=[
		[0,1],
		[0,-1],
		[1,0],
		[-1,0]
	];
	
	const visited=[];
	
	let answer=0;
	
	function isInside(r,c){
		if(r<0||r>=n||c<0||c>=m) return false;
		return true;
	}
	
	function set(){
		for(let i=0; i<n; i++){
			for(let j=0; j<m; j++){
				visited[i][j]=false;
			}
		}
	}
	
	function dfs(r,c,depth,sum){
		if(depth===3){
			answer=Math.max(answer,sum);
			return;
		}
		for(let i=0; i<4; i++){
		const nR= r+dir[i][0];
		const nC=r+dir[i][1];
		if(!isInside(nR,nC))continue;
		if(visited[nR][nC])continue;
		dfs(nR,nC,depth+1,sum+graph[nR][nC]);
		visited[nR][nC]=false;
	  }
	}
	
	function shape1(r,c){
		let sum=0;
		sum = graph[r][c]+graph[r][c+1]+graph[r][c+2]+graph[r-1][c+1];
		answer = Math.max(answer,sum);
	}
	
	function shape2(r,c){
		let sum=0;
		sum = gra[r][c]+graph[r][c+1]+graph[r][c+2]+graph[r+1][c+1];
		answer=Math.max(answer,sum);
	}
	
	function shape3(r,c){
		let sum=0;
		sum=graph[r][c]+graph[r+1][c]+graph[r+2][c]+graph[r+1][c+1];
		answer=Math.max(answer,sum);
	}
	
	function shape4(r,c){
		let sum=0;
		sum=graph[r][c]+graph[r-1][c+1]+graph[r][c+1]+graph[r+1][c+1];
		answer=Math.max(answer,sum);
	}
	
	rl.on('line',(line)=>{
		if(!n){
			const input=line.split(' ');
			n=parseInt(input[0]);
			m=parseInt(input[1]);
			return;
		}
		
		const input = line.split(' ');
		graph.push(input.map(Number));
		if(graph.length===n){
			for(let i=0; i<n; i++){
				visited.push(new Array(m).fill(false));
			}
			
			for(let i=0; i<n; i++){
				for(let j=0; j<m; j++){
					visitied[i][j]=true;
					dfs(i,j,0,graph[i][j]);
					visited[i][j]=false;
					if(i-1>0&&j+2<m)shape1(i,j);
					if(j+2<m&&j+1<n)shape2(i,j);
					if(i+2<n&&j+1<m)shape3(i,j);
					if(i+1<n&&i-1>=0&&j+1<m)shape4(i,j);
				}
			}
			
			console.log(answer);
			rl.close();
		}
	});
	/*
	입력>>
	5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1


출력>>
19
	
	*/
	