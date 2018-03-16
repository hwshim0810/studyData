package algorithms.sort;

public class QuickSort {

    private void swap(int[] target, int left, int right) {
        int temp = target[left];
        target[left] = target[right];
        target[right] = temp;
    }

    private int partition(int[] target, int begin, int end) {
        int left = begin, right = end;
        int pivot = (left + right) / 2;

        while (left < right) {
            while (target[left] < target[pivot] && left < right) left++;
            while (target[right] >= target[pivot] && left < right) right--;

            if (left < right) swap(target, left, right);
        }
        
        swap(target, pivot, right);

        return left;
    }

    public void quickSort(int[] targetArray, int left, int right) {

        if (left < right) {
            int pivot = partition(targetArray, left, right);
            quickSort(targetArray, left, pivot-1);
            quickSort(targetArray, pivot+1, right);
        }
    }
}
