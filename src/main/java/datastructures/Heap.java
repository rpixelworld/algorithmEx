package datastructures;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    List<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2*index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index-1)/2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        int n = heap.size();
        heap.add(value);

        while (heap.get(n)>heap.get(parent(n))) {
            swap(n, parent(n));
            n = parent(n);
        }
    }

    public void sinkDown(int index) {
        while (true) {
            int maxIndex = index;
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);
            if(leftIndex < heap.size() && heap.get(index)<heap.get(leftIndex)){
                maxIndex = leftIndex;
            }
            if(rightIndex < heap.size() && heap.get(maxIndex) < heap.get(rightIndex)) {
                maxIndex = rightIndex;
            }

            if(maxIndex!=index){
                swap(index, maxIndex);
                index = maxIndex;
            }
            else {
                return;
            }
        }

    }

    //remove the root
    public Integer remove() {
        if(heap.size()==0)
            return null;

        if(heap.size()==1) {
            return heap.remove(0);
        }

        Integer toRemove = heap.get(0);
        swap(0, heap.size()-1);
        heap.remove(heap.size()-1);

        sinkDown(0);
        return toRemove;
    }

    public static Integer findKthSmallest(int[] nums, int k) {

        if (k > nums.length)
            return null;

        Heap heap = new Heap();
        for(int num: nums) {
            heap.insert(num);
        }

        while (heap.getHeap().size()>k){
            heap.remove();
        }

        return heap.remove();
    }

    public static List<Integer> streamMax(int[] nums) {
        List<Integer> result = new ArrayList<>();

        Heap heap = new Heap();
        for(int num: nums) {
            heap.insert(num);
            result.add(heap.getHeap().get(0));
        }

        return result;
    }
}
