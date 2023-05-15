package org.example.p42583;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class MySolution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        // 다리 위에 있지 않은 트럭 대기열
        Queue<Truck> queue = Arrays.stream(truckWeights)
                .mapToObj(Truck::new)
                .collect(Collectors.toCollection(LinkedList::new));

        // 다리 위에 있는 트럭 대기열
        Queue<Truck> bridge = new LinkedList<>();

        // 총 경과 시간
        int elapsedTime = 0;

        // 모든 대기열이 비어있을 때 까지
        while(!queue.isEmpty() || !bridge.isEmpty()) {
            // 총 경과시간 증가
            elapsedTime++;
            // 다리 위에 있는 모든 트럭들의 경과시간 증가
            bridge.forEach(Truck::increaseTimes);

            if(!bridge.isEmpty()) {
                // 다리 위에 있는 트럭 중 맨 앞
                Truck truck = bridge.peek();
                // 맨 앞 트럭의 다리 위에 있던 시간이 다리 길이보다 크거나 같다면 빠져나옴(다리 대기열에서 삭제)
                if(truck.getElapsedTimesOnBridge() >= bridgeLength) {
                    bridge.poll();
                }
            }

            if(!queue.isEmpty()) {
                // 다리 위에 있지 않은 트럭 중 맨 앞
                Truck truck = queue.peek();
                // 맨 앞 트럭이 다리 위에 올라갈 수 있는지 체크 후 가능하면 트럭 대기열에서 삭제하고 다리 대기열에 추가
                if(canUseBridge(bridgeLength, weight, bridge, truck)) {
                    bridge.add(queue.poll());
                }
            }
        }

        return elapsedTime;
    }

    private boolean canUseBridge(int bridgeLength, int weight, Queue<Truck> bridge, Truck truck) {
        return bridge.stream().mapToInt(Truck::getWeight).sum() + truck.getWeight() <= weight && bridge.size() < bridgeLength;
    }
}

class Truck {
    private final int weight;
    private int elapsedTimesOnBridge;

    public Truck(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getElapsedTimesOnBridge() {
        return elapsedTimesOnBridge;
    }

    public void increaseTimes() {
        elapsedTimesOnBridge++;
    }
}