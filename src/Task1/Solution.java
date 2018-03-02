package Task1;

public class Solution {
    public int solution(int[] A, int[] B) {
        int amount = 0;
        int temp;

        if (A.length == 2) {
            if (A[0] >= A[1]) {
                temp = A[1];
                A[1] = B[1];
                B[1] = temp;

            } else {
                if (B[0] >= B[1]) {
                    temp = B[1];
                    B[1] = A[1];
                    A[1] = temp;
                    amount++;
                }
            }
        }

        if (A.length > 2) {
            for (int i = 1; i < A.length - 1; i++) {
                if (A[i] < A[i - 1]) {
                    if (A[i - 1] < B[i] && B[i] < A[i + 1]) {
                        temp = A[i];
                        A[i] = B[i];
                        B[i] = temp;
                        amount++;
                    } else {
                        if (A[i - 1] < B[i] && B[i] < B[i + 1]) {
                            temp = A[i - 1];
                            A[i - 1] = B[i - 1];
                            B[i - 1] = temp;
                            amount++;
                        }
                    }
                } else {
                    if (A[i] == A[i - 1]) {
                        if (A[i - 1] < B[i] && B[i] < A[i + 1]) {
                            temp = A[i];
                            A[i] = B[i];
                            B[i] = temp;
                            amount++;
                        } else {
                            if (A[i - 1] < B[i] && B[i] < B[i + 1]) {
                                temp = A[i - 1];
                                A[i - 1] = B[i - 1];
                                B[i - 1] = temp;
                                amount++;
                            }
                        }
                    }
                }

                if (B[i] < B[i - 1]) {
                    if (B[i - 1] < A[i] && A[i] < B[i + 1]) {
                        temp = B[i];
                        B[i] = A[i];
                        A[i] = temp;
                        amount++;
                    } else {
                        if (B[i - 1] < A[i] && A[i] < A[i + 1]) {
                            temp = B[i - 1];
                            B[i - 1] = A[i - 1];
                            A[i - 1] = temp;
                            amount++;
                        }
                    }
                } else {
                    if (B[i] == B[i - 1]) {
                        if (B[i - 1] < A[i] && A[i] < B[i + 1]) {
                            temp = B[i];
                            B[i] = A[i];
                            A[i] = temp;
                            amount++;
                        } else {
                            if (B[i - 1] < A[i] && A[i] < A[i + 1]) {
                                temp = B[i - 1];
                                B[i - 1] = A[i - 1];
                                A[i - 1] = temp;
                                amount++;
                            }
                        }
                    }

                }

            }

            if (A[A.length - 2] >= A[A.length - 1]) {
                temp = A[A.length - 1];
                A[A.length - 1] = B[A.length - 1];
                B[A.length - 1] = temp;
                amount++;
            }
            if (B[A.length - 2] >= B[A.length - 1]) {
                temp = B[A.length - 1];
                B[A.length - 1] = A[A.length - 1];
                A[A.length - 1] = temp;
                amount++;
            }
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                return -1;
            }
        }

        if (amount > A.length / 2) {
            amount = A.length - amount;
        }

        return amount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] A = {5, 3, 7, 7, 10};
        int[] B = {1, 6, 6, 9, 9};
        //int[] A = {0, 3};
        //int[] B = {2, 1};
        int a = s.solution(A, B);
        System.out.println(a);
    }
}
