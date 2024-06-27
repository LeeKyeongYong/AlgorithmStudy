function numSubarraysWithSum(nums, goal) {
    let answer = 0;
    let prefix = 0;
    const map = new Map();
    map.set(0, 1); // 초기 값

    for (let num of nums) {
        prefix += num;
        if (map.has(prefix - goal)) {
            answer += map.get(prefix - goal);
        }
        if (map.has(prefix)) {
            map.set(prefix, map.get(prefix) + 1);
        } else {
            map.set(prefix, 1);
        }
    }

    return answer;
}

// 테스트
console.log(numSubarraysWithSum([1, 2, 2, 1, 2], 5)); // 출력: 3

/*

주어진 배열 nums에서 연속된 부분 배열의 합이 goal이 되는 경우의 수를 찾아야 한다. 
예를 들어, 배열 [1, 2, 2, 1, 2]에서 부분 배열의 합이 5가 되는 경우는 총 3가지이다.

 */