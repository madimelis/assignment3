import java.util.Arrays;

public class Experiment {
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        int[] copy =  Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();
        if (type.equalsIgnoreCase("Basic")) {
            sorter.bubbleSort(copy);
        }
        else if (type.equalsIgnoreCase("Advanced")) {
            sorter.quickSort(copy, 0, copy.length - 1);
        }
        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        sorter.quickSort(arr, 0, arr.length - 1);
        long start = System.nanoTime();
        searcher.binarySearch(arr, target);
        long end = System.nanoTime();
        return end - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1007};

        for (int size : sizes) {
            int[] random = sorter.generateRandomArray(size);
            int[] sorted = Arrays.copyOf(random, random.length);
            sorter.quickSort(random, 0, random.length - 1);

            System.out.println("Array size: " + size);
            System.out.println("-".repeat(30));
            System.out.println("Random Array");
            System.out.println("-".repeat(30));
            System.out.println("Bubble Sort: " + measureSortTime(random, "Basic" + "ns"));
            System.out.println("Quick Sort: " + measureSortTime(random, "Advanced" + "ns"));
            System.out.println("Binary Search: " + measureSearchTime(random, random[size / 2]) + "ns");

            System.out.println("-".repeat(30));
            System.out.println("Sorted Array");
            System.out.println("-".repeat(30));
            System.out.println("Bubble Sort time: " + measureSortTime(sorted, "Basic" + "ns"));
            System.out.println("Quick Sort time: " + measureSortTime(sorted, "Advanced" + "ns"));
            System.out.println("Binary Search time: " + measureSearchTime(sorted, sorted[size / 2]) + "ns");
            System.out.println();
        }
    }
}
