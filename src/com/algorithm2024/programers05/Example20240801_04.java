package com.algorithm2024.programers05;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Example20240801_04 { //[PCCP 기출문제] 4번 / 수레 움직이기

    public static int solution(int[][] maze) {
        int answer = 0;
        int rx=0,ry=0,bx=0,by =0;
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                if(maze[i][j]==1){
                    rx = i;
                    ry = j;
                    maze[i][j]=0;
                }else if(maze[i][j] == 2){
                    bx= i ;
                    by = j;
                    maze[i][j]=0;
                }

            }
        }
        int[][] rv = new int[maze.length][maze[0].length];
        int[][] bv = new int[maze.length][maze[0].length];
        rv[rx][ry]=1;
        bv[bx][by]=1;
        dfs(maze,rx,ry,bx,by,rv,1,bv);
        if(min==Integer.MAX_VALUE){
            min = 1;
        }
        return min-1;
    }
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static int min=Integer.MAX_VALUE;

    static boolean check(int[][] maze,int[][] rv,int[][] bv){  // 두 경로가 가능한지 검증
        int rx=0,ry = 0,bx=0,by=0,re=0,be=0;


        PriorityQueue<Node> rq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1,Node o2){
                return o1.cnt-o2.cnt;
            }
        });
        PriorityQueue<Node> bq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1,Node o2){
                return o1.cnt-o2.cnt;
            }
        });
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                if(rv[i][j]!=0){
                    rq.add(new Node(i,j,rv[i][j]));
                }

                if(bv[i][j]!=0){
                    bq.add(new Node(i,j,bv[i][j]));
                }

            }
        }

        int prx=0,pry=0,pbx=0,pby=0;
        int[][] newMaze = new int[maze.length][maze[0].length];
        while(!(rq.isEmpty()&&bq.isEmpty())){
            Node rn = rq.poll();
            Node bn = bq.poll();
            int rnx=0;
            int rny=0;
            int bnx = 0;
            int bny=0;
            if(rn!=null){
                rnx = rn.x;
                rny = rn.y;
            }
            else {
                rnx = prx;
                rny = pry;
            }
            if(bn!=null){
                bnx = bn.x;
                bny = bn.y;
            }else{
                bnx = pbx;
                bny = pby;
            }
            if(newMaze[rnx][rny]!=0){
                if(bnx==pbx&&bny==pby) return false;
                if(rnx==pbx&&rny==pby&& bnx==prx&&bny==pry) return  false;
            }
            if(newMaze[bnx][bny]!=0){
                if(rnx==prx&&rny==pry) return false;
                if(bnx==prx&&bny==pry&& rnx==pbx&&rny==pby) return  false;
            }
            newMaze[prx][pry] = 0;
            newMaze[pbx][pby]=0;


            newMaze[rnx][rny]=1;
            newMaze[bnx][bny]=2;
            prx=rnx;
            pry = rny;
            pbx = bnx;
            pby = bny;

        }




        return true;
    }

    static void findB(int maze[][], int bx,int by,int[][] rv,int cnt,int rcnt,int[][] bv){
        if(maze[bx][by]==4){
            if(!check(maze,rv,bv)){
                return;
            }
            min = Math.min(min,Math.max(cnt,rcnt));

            return;
        }
        for(int c=0;c<4;c++){
            int nx = bx+dx[c];
            int ny = by + dy[c];
            if(nx<0||ny<0||nx>=maze.length||ny>=maze[0].length) continue;
            if(maze[nx][ny]==5) continue;
            if(rv[nx][ny]==cnt+1) continue;
            if(bv[nx][ny]!=0) continue;

            bv[nx][ny] = cnt+1;
            findB(maze,nx,ny,rv,cnt+1,rcnt,bv);
            bv[nx][ny]=0;
        }
    }
    static void dfs(int maze[][], int rx,int ry,int bx,int by,int[][] rv,int cnt,int[][] bv){
        if(maze[rx][ry]==3){

            findB(maze,bx,by,rv,1,cnt,bv);

            return;
        }
        for(int c=0;c<4;c++){
            int nx = rx + dx[c];
            int ny = ry + dy[c];
            if(nx<0||ny<0||nx>=maze.length||ny>=maze[0].length) continue;
            if(rv[nx][ny]!=0) continue;
            if(maze[nx][ny]!=5){
                rv[nx][ny]=cnt+1;
                dfs(maze,nx,ny,bx,by,rv,cnt+1,bv);
                rv[nx][ny]=0;
            }
        }


        return;
    }
    static class Node{
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
        public String toString(){
            return this.x + " "+this.y+" "+this.cnt;
        }
    }

}
