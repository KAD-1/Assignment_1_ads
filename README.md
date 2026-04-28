A. Project Overview
Basic algorithm-Bubble sort
Advanced algorithm-Quick sort
Searching-Binary searching
The purpose of this experiment is to analyze and compare the performance of different algorithms using execution time.
The program measures how fast each algorithm works on arrays of different sizes and types.
B. Algorithm Descriptions
in bubble sort, you choose 2 pairs of numbers in array, and compare them, if second num is greater than first, we need to swap them, and so on until the end,
time colmplexity in the best case is n, in average n*n
quick sort choose pivot element and if num greater than this pivot, number go to right side, in other case to left, and this algorithm wrote with recursively functions,
and at the end we have nlogn time complexity
and the last is binary searching this algorithm needs sorted array, and divide array into 2, and if num is smaller than choosen number in middle, code deletes all
of right side, and do it until find number and the best case is 1, avg time complexity is logn
C. Experimental Results
| Size | Type   | Bubble Sort | Quick Sort | Faster |
|------|--------|------------|------------|--------|
| 10   | Random | 7700       | 8200       | Bubble |
| 10   | Sorted | 4100       | 5600       | Bubble |
| 100  | Random | 362400     | 51600      | Quick  |
| 100  | Sorted | 249100     | 354100     | Bubble |
| 1000 | Random | 7604000    | 240700     | Quick  |
| 1000 | Sorted | 3385400    | 1301800    | Quick  |
D. Screenshots
<img width="317" height="410" alt="image" src="https://github.com/user-attachments/assets/6b6b161b-09b0-4aa0-a119-7fb229a2bef8" />
<img width="367" height="427" alt="image" src="https://github.com/user-attachments/assets/ee2d457b-8c81-49fa-bd6e-1e3cf901d5ee" />
<img width="356" height="439" alt="image" src="https://github.com/user-attachments/assets/643bb0da-7dce-4aba-88b9-044f59fd896f" />
E. Reflection Section
•	What you learned about algorithm efficiency
I knew about sorting algoritms from school, but about searching algorithm firstly i heared in university, so i reaserched how i need to write searchingm and some 
moments about writing sorting algoriithms in java, and i learned about their time complexity, while i wrote code i didnt have any problems, so it was not difficult.
