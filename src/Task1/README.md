You have two sequences A and B consisting of integers, both of length N, and you would like them to be (strictly) increasing, i.e. for each K (0 ≤ K < N − 1), A[K] < A[K + 1] and B[K] < B[K + 1]. Thus, you need to modify the sequences, but the only manipulation you can perform is to swap an arbitrary element in sequence A with the corresponding element in sequence B. That is, both elements to be exchanged must occupy the same index position within each sequence.
For example, given A = [5, 3, 7, 7, 10] and B = [1, 6, 6, 9, 9], you can swap elements at positions 1 and 3, obtaining A = [5, 6, 7, 9, 10], B = [1, 3, 6, 7, 9].
Your goal is make both sequences increasing, using the smallest number of moves.