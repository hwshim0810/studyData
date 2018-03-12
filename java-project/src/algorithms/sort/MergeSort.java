package algorithms.sort;


public class MergeSort {

    private int[] merge(int[] leftSide, int[] rightSide) {
        int leftLen = leftSide.length;
        int rightLen = rightSide.length;

        int i = 0, j = 0, k =0;
        int[] result = new int[leftLen+rightLen];

        while (i < leftLen && j < rightLen) {
            if (leftSide[i] <= rightSide[j]) result[k++] = leftSide[i++];
            else result[k++] = rightSide[j++];
        }

        for (; i < leftLen; i++) result[k++] = leftSide[i];
        for (; j < rightLen; j++) result[k++] = rightSide[j];

        return result;
    }

    public int[] mergeSort(int[] targetArray) {
        int length = targetArray.length;

        if (length > 1) {
            int mid = length/2;

            int[] leftParam = new int[mid];
            System.arraycopy(targetArray, 0, leftParam, 0, mid);
            int[] rightParam = new int[length-mid];
            System.arraycopy(targetArray, mid, rightParam, 0, length-mid);

            int[] leftSide = mergeSort(leftParam);
            int[] rightSide = mergeSort(rightParam);

            targetArray = merge(leftSide, rightSide);
        }

        return targetArray;
    }

}
