package com.jababookbacojoon5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Example20241030_q20006 {

    static class Node {
        int level;
        String id;

        public Node(int level, String id) {
            this.level = level;
            this.id = id;
        }
    }

    static class Room {
        int minLevel;
        int maxLevel;
        List<Node> players;

        public Room(int level) {
            this.minLevel = level - 10;
            this.maxLevel = level + 10;
            this.players = new ArrayList<>();
        }

        public boolean canJoin(Node player, int m) {
            return player.level >= minLevel && player.level <= maxLevel && players.size() < m;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int m = sc.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            int level = sc.nextInt();
            String id = sc.next();
            Node player = new Node(level, id);

            boolean matched = false;

            for (Room room : rooms) {
                if (room.canJoin(player, m)) {
                    room.players.add(player);
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                Room newRoom = new Room(level);
                newRoom.players.add(player);
                rooms.add(newRoom);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if (room.players.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            room.players.sort(Comparator.comparing(o -> o.id));

            for (Node player : room.players) {
                sb.append(player.level).append(" ").append(player.id).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

}
