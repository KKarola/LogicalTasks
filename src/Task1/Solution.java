package Task1;

class Solution {
    private int amount = 0;

    private int solution(int[] arrA, int[] arrB) {

        if (arrA.length == 2) {
            if (arrA[0] >= arrA[1]) {
                exchange(arrA, arrB, 1);
            } else {
                if (arrB[0] >= arrB[1]) {
                    exchange(arrB, arrA, 1);
                }
            }
        }

        if (arrA.length > 2) {
            for (int i = 1; i < arrA.length - 1; i++) {
                // checking first array
                if (arrA[i] < arrA[i - 1] || arrA[i] == arrA[i - 1]) {
                    exchangeElement(arrA, arrB, i);
                }
                // checking second array
                if (arrB[i] < arrB[i - 1] || arrB[i] == arrB[i - 1]) {
                    exchangeElement(arrB, arrA, i);
                }
            }
            // checking last elements
            lastElements(arrA, arrB, arrA.length);
            lastElements(arrB, arrA, arrA.length);
        }
        // checking arrays after exchange
        for (int i = 1; i < arrA.length; i++) {
            if (arrA[i - 1] >= arrA[i] || arrB[i - 1] >= arrB[i]) {
                return -1;
            }
        }

        if (amount > arrA.length / 2) {
            amount = arrA.length - amount;
        }

        return amount;
    }

    private void exchange(int[] arrFirst, int[] arrSecond, int i) {
        int temp = arrFirst[i];
        arrFirst[i] = arrSecond[i];
        arrSecond[i] = temp;
        amount++;
    }

    private void exchangeElement(int[] arrFirst, int[] arrSecond, int i) {
        if (arrFirst[i-1] < arrSecond[i] && arrSecond[i] < arrFirst[i+1]) {
            exchange(arrFirst, arrSecond, i);
        } else {
            if (arrFirst[i-1] < arrSecond[i] && arrSecond[i] < arrSecond[i+1]) {
                exchange(arrFirst, arrSecond, i-1);
            }
        }
    }

    private void lastElements(int[] arrFirst, int[] arrSecond, int len) {
        if (arrFirst[len - 2] >= arrFirst[len - 1]) {
            exchange(arrFirst, arrSecond, len-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arrA = {5, 3, 7, 7, 10};
        int[] arrB = {1, 6, 6, 9, 9};
        System.out.println(s.solution(arrA, arrB));
    }
}