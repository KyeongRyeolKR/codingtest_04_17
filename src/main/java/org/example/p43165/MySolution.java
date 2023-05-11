package org.example.p43165;

class MySolution {

    static int answer;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length) {
            if(target == sum) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, index+1, sum + numbers[index]);
        dfs(numbers, target, index+1, sum - numbers[index]);
    }

    public static void main(String[] args) {
        System.out.println(new MySolution().solution(new int[]{4,1,2,1}, 4));
    }
}