public class ProblemSet13 {

    public boolean groupSum(int start, int[] numbers, int target) {
        if(start >= numbers.length)
            return target == 0;

        if(groupSum(start+1, numbers, target - numbers[start]))
            return true;

        return groupSum(start + 1, numbers, target);
    }

    public boolean groupSum6(int start, int[] numbers, int target) {
        if(start >= numbers.length)
            return target == 0;

        if(numbers[start] == 6)
            return groupSum6(start+1, numbers, target - 6);

        if(groupSum6(start+1, numbers, target - numbers[start]))
            return true;

        return groupSum6(start + 1, numbers, target);
    }

    public boolean groupNoAdj(int start, int[] numbers, int target) {
        if(start >= numbers.length)
            return target == 0;

        if(groupNoAdj(start+2, numbers, target - numbers[start]))
            return true;

        return groupNoAdj(start + 1, numbers, target);
    }

    public boolean groupSum5(int start, int[] numbers, int target) {
        if(start >= numbers.length)
            return target == 0;

        if(numbers[start] % 5 == 0) {
            if(start <= numbers.length - 2 && numbers[start+1] == 1)
                return groupSum5(start+2, numbers, target - numbers[start]);

            return groupSum5(start+1, numbers, target - numbers[start]);
        }

        if(groupSum5(start+1, numbers, target - numbers[start]))
            return true;

        return groupSum5(start + 1, numbers, target);
    }

    public boolean groupSumClump(int start, int[] numbers, int target) {
        if(start >= numbers.length)
            return target == 0;

        int i = start;
        int sum = 0;

        while(i < numbers.length && numbers[start] == numbers[i]) {
            sum += numbers[i];
            i++;
        }

        if(groupSumClump(i, numbers, target - sum))
            return true;

        return groupSumClump(i, numbers, target);
    }

    public boolean splitArray(int[] numbers) {
        return splitArrayHelper(0, numbers, 0, 0);
    }

    public boolean splitArrayHelper(int start, int[] numbers, int group1,
                                    int group2) {
        if(start >= numbers.length)
            return group1 == group2;

        if(splitArrayHelper(start+1, numbers, group1 + numbers[start], group2))
            return true;

        return splitArrayHelper(start + 1, numbers, group1, group2 + numbers[start]);
    }

    public boolean splitOdd(int[] numbers) {
        return splitOdd10Helper(0, numbers, 0, 0);
    }

    public boolean splitOdd10Helper(int start, int[] numbers, int mult, int odd) {
        if(start >= numbers.length)
            return mult % 10 == 0 && odd % 2 == 1;

        if(splitOdd10Helper(start+1, numbers, mult + numbers[start], odd))
            return true;

        return splitOdd10Helper(start + 1, numbers, mult, odd + numbers[start]);
    }
}
