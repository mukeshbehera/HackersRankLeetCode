package com.dsa.hackersrank;

/*
You are given an array stones representing integers where:

The absolute value of each number represents the size of the stone.
The sign represents the direction (positive for right, negative for left).
When stones collide:
The smaller stone explodes.
If both are the same size, both explode.
You are tasked to determine the state of stones after all collisions.
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StateOfStonesAfterCollisions {

    public static List<Integer> stonesCollision(List<Integer> stones) {
        Stack<Integer> stack = new Stack<>();

        for (int stone : stones) {
            boolean exploded = false;

            while (!stack.isEmpty() && stone < 0 && stack.peek() > 0) {
                if (Math.abs(stack.peek()) > Math.abs(stone)) {
                    exploded = true;
                    break;
                } else if (Math.abs(stack.peek()) == Math.abs(stone)) {
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    stack.pop();
                }
            }

            if (!exploded) {
                stack.push(stone);
            }
        }

        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        List<Integer> stones = new ArrayList<>();
        stones.add(-1);
        stones.add(2);
        stones.add(1);
        stones.add(-2);
        stones.add(3);
        stones.add(1);

        List<Integer> result = stonesCollision(stones);

        for (int stone : result) {
            System.out.println(stone);
        }
    }
}
