package com.algorithm2024.programers07;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// 이동 방향에 따른 Strategy 패턴 적용
interface MoveStrategy {
    int getDx();
    int getDy();
}

class RightMove implements MoveStrategy {
    public int getDx() { return 1; }
    public int getDy() { return 0; }
}

class UpRightMove implements MoveStrategy {
    public int getDx() { return 1; }
    public int getDy() { return 1; }
}

class UpMove implements MoveStrategy {
    public int getDx() { return 0; }
    public int getDy() { return 1; }
}

class UpLeftMove implements MoveStrategy {
    public int getDx() { return -1; }
    public int getDy() { return 1; }
}

class LeftMove implements MoveStrategy {
    public int getDx() { return -1; }
    public int getDy() { return 0; }
}

class DownLeftMove implements MoveStrategy {
    public int getDx() { return -1; }
    public int getDy() { return -1; }
}

class DownMove implements MoveStrategy {
    public int getDx() { return 0; }
    public int getDy() { return -1; }
}

class DownRightMove implements MoveStrategy {
    public int getDx() { return 1; }
    public int getDy() { return -1; }
}

// 이동하는 방향에 따라 적합한 Strategy를 선택하는 컨텍스트
class MoveContext {
    private MoveStrategy strategy;

    public MoveContext(MoveStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(MoveStrategy strategy) {
        this.strategy = strategy;
    }

    public int getDx() {
        return strategy.getDx();
    }

    public int getDy() {
        return strategy.getDy();
    }
}

// 방문 여부를 관리하는 클래스
class VisitManager {
    private Map<Pair, List<Pair>> visit;

    public VisitManager() {
        visit = new HashMap<>();
    }

    public boolean isVisited(Pair next, Pair current) {
        return visit.containsKey(next) && !visit.get(next).contains(current);
    }

    public void addVisit(Pair current, Pair next) {
        visit.putIfAbsent(current, new ArrayList<>());
        visit.putIfAbsent(next, new ArrayList<>());
        visit.get(current).add(next);
        visit.get(next).add(current);
    }

    public void addVisit(Pair current, List<Pair> list) {
        visit.put(current, list);
    }
}

public class Example20241210_q1 {
    public int solution(int[] arrows) {
        int answer = 0;
        VisitManager visitManager = new VisitManager();
        int x = 0, y = 0;
        MoveContext moveContext = new MoveContext(new UpRightMove()); // 초기 상태 설정
        Pair start = new Pair(x, y);
        visitManager.addVisit(start, new ArrayList<>()); // 초기 위치를 visit에 추가

        for (int arrow : arrows) {
            moveContext.setStrategy(getMoveStrategy(arrow));

            for (int i = 0; i < 2; i++) {
                int nx = x + moveContext.getDx();
                int ny = y + moveContext.getDy();
                Pair current = new Pair(x, y);
                Pair next = new Pair(nx, ny);

                if (visitManager.isVisited(next, current)) {
                    answer++;
                    visitManager.addVisit(current, next);
                } else if (!visitManager.contains(next)) {
                    List<Pair> list = new ArrayList<>();
                    list.add(current);
                    visitManager.addVisit(current, list);
                }

                x = nx;
                y = ny;
            }
        }
        return answer;
    }

    private MoveStrategy getMoveStrategy(int arrow) {
        switch (arrow) {
            case 0: return new UpMove();
            case 1: return new UpRightMove();
            case 2: return new RightMove();
            case 3: return new DownRightMove();
            case 4: return new DownMove();
            case 5: return new DownLeftMove();
            case 6: return new LeftMove();
            case 7: return new UpLeftMove();
            default: throw new IllegalArgumentException("Invalid arrow");
        }
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
