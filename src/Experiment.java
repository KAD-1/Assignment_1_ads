public class  Experiment {

    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        int[] copy = arr.clone();

        long start = System.nanoTime();

        if (type.equals("bubble")) {
            sorter.bubbleSort(copy);
        } else {
            sorter.quickSort(copy);
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.binarySearch(arr, target);
        long end = System.nanoTime();
        return end - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {

            System.out.println("===== SIZE: " + size + " =====");

            int[] randomArr = sorter.generateRandomArray(size);

            long bubbleRandom = measureSortTime(randomArr, "bubble");
            long quickRandom = measureSortTime(randomArr, "quick");

            System.out.println("Random Array:");
            System.out.println("Bubble Sort: " + bubbleRandom);
            System.out.println("Quick Sort: " + quickRandom);

            if (bubbleRandom < quickRandom) {
                System.out.println("Faster: Bubble Sort");
            } else {
                System.out.println("Faster: Quick Sort");
            }

            int[] sortedArr = randomArr.clone();
            sorter.quickSort(sortedArr);

            long bubbleSorted = measureSortTime(sortedArr, "bubble");
            long quickSorted = measureSortTime(sortedArr, "quick");

            System.out.println("\nSorted Array:");
            System.out.println("Bubble Sort: " + bubbleSorted);
            System.out.println("Quick Sort: " + quickSorted);

            if (bubbleSorted < quickSorted) {
                System.out.println("Faster: Bubble Sort");
            } else {
                System.out.println("Faster: Quick Sort");
            }

            int targetExist = sortedArr[size / 2];
            int targetNotExist = -1;

            long searchExist = measureSearchTime(sortedArr, targetExist);
            long searchNotExist = measureSearchTime(sortedArr, targetNotExist);

            System.out.println("\nBinary Search:");
            System.out.println("Existing element: " + searchExist);
            System.out.println("Non-existing element: " + searchNotExist);

            System.out.println("-----------------------------\n");
        }
    }
}