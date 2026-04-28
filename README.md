# ADS Assignment - Sorting & Searching Performance Analysis

## A. Project Overview

This project analyzes the performance of different algorithms for sorting and searching data. The goal is to compare a basic sorting algorithm (Bubble Sort), an advanced sorting algorithm (Quick Sort), and a searching algorithm (Binary Search) under different conditions.

The experiment evaluates how these algorithms behave with:

* Different input sizes (small, medium, large)
* Different data conditions (random vs sorted arrays)

---

## B. Algorithm Descriptions

### Bubble Sort (Basic Sort)

**How it works:**
Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order. This process continues until the array is fully sorted.

**Time Complexity:**

* Best case: O(n)
* Average case: O(n²)
* Worst case: O(n²)

**Key idea:**
Large values "bubble up" to the end of the array.

---

### Quick Sort (Advanced Sort)

**How it works:**
Quick Sort selects a pivot element and partitions the array into two halves:

* Elements smaller than the pivot
* Elements greater than the pivot

It then recursively sorts both halves.

**Time Complexity:**

* Best case: O(n log n)
* Average case: O(n log n)
* Worst case: O(n²)

**Note:**
Worst-case occurs when poor pivot selection is used (e.g., already sorted arrays with last-element pivot).

---

### Binary Search (Searching Algorithm)

**How it works:**
Binary Search repeatedly divides the sorted array in half to locate the target value.

**Time Complexity:**

* Best case: O(1)
* Average case: O(log n)
* Worst case: O(log n)

**Requirement:**
The array must be sorted before applying Binary Search.

---

## C. Experimental Results

### Execution Time Table

| Size | Type   | Bubble Sort (ns) | Quick Sort (ns) | Binary Search (ns) |
| ---- | ------ | ---------------- | --------------- | ------------------ |
| 10   | Random | 8000             | 6800            | —                  |
| 10   | Sorted | 5100             | 7300            | 3800               |
| 100  | Random | 389200           | 67100           | —                  |
| 100  | Sorted | 275500           | 208500          | 1500               |
| 1007 | Random | 7589900          | 145500          | —                  |
| 1007 | Sorted | 1929900          | 224500          | 1100               |

---

### Observations

#### 1. Which sorting algorithm performed faster? Why?

Quick Sort performed significantly faster than Bubble Sort, especially for larger arrays. This is because Quick Sort has an average time complexity of O(n log n), while Bubble Sort has O(n²), making it much slower as the input size grows.

---

#### 2. How does performance change with input size?

As the array size increases:

* Bubble Sort becomes dramatically slower
* Quick Sort increases in time much more gradually

This confirms that Bubble Sort does not scale well for large datasets, while Quick Sort is more efficient.

---

#### 3. How does sorted vs unsorted data affect performance?

* **Bubble Sort:** Faster on sorted arrays because fewer swaps are required
* **Quick Sort:** Slower on sorted arrays due to poor pivot selection (last element), leading to worst-case behavior

---

#### 4. Do the results match expected Big-O complexity?

Yes, the results align with theoretical expectations:

* Bubble Sort shows quadratic growth (O(n²))
* Quick Sort shows near O(n log n) behavior on random data
* Quick Sort degrades toward O(n²) on sorted data

---

#### 5. Which searching algorithm is more efficient? Why?

Binary Search is highly efficient with O(log n) complexity. It performs very fast even for larger arrays because it eliminates half of the remaining elements in each step.

---

#### 6. Why does Binary Search require a sorted array?

Binary Search relies on order to decide whether to search the left or right half of the array. Without sorting, it cannot correctly eliminate half of the data, making the algorithm invalid.

---

## D. Screenshots

Include:

* Program output showing execution times
* Multiple runs with different array sizes
* Clear visibility of results in console

---

## E. Reflection

This experiment demonstrated how algorithm efficiency significantly impacts performance as data size increases. While Bubble Sort works correctly, it becomes impractical for large datasets due to its quadratic complexity. In contrast, Quick Sort performs much better on average, making it suitable for real-world applications.

An interesting observation was that Quick Sort performed worse on already sorted arrays. This highlighted the importance of pivot selection in recursive algorithms. It showed that even efficient algorithms can degrade under certain conditions.

One challenge during implementation was ensuring accurate timing measurements. Small execution times can vary due to system factors, making it important to interpret results carefully rather than relying on a single run.

Overall, the experiment reinforced the difference between theoretical complexity and practical performance, and showed why choosing the right algorithm is critical in software development.
