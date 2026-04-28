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
            int[] arr = sorter.generateRandomArray(size);
            long basicTime = measureSortTime(arr, "Basic");
            long advancedTime = measureSortTime(arr, "Advanced");
            long searchTime = measureSearchTime(arr, arr[size / 2]);
            System.out.println("Array size: " + size);
            System.out.println("Bubble Sort time: " + basicTime + " ns");
            System.out.println("Quick Sort time: " + advancedTime + " ns");
            System.out.println("Binary Search time: " + searchTime + " ns");
        }
    }
}
