import java.util.*;

class Pair {
    int element;
    int freq;

    Pair(int element, int freq) {
        this.element = element;
        this.freq = freq;
    }
}

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {

        // Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int barcode : barcodes) {
            freqMap.put(barcode, freqMap.getOrDefault(barcode, 0) + 1);
        }

        // Max Heap based on frequency
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int index = 0;

        while (pq.size() > 1) {

            // Pick the two most frequent barcodes
            Pair first = pq.poll();
            Pair second = pq.poll();

            // Place them alternately
            barcodes[index++] = first.element;
            barcodes[index++] = second.element;

            // Decrease their frequencies
            first.freq--;
            second.freq--;

            // Add them back if they still have occurrences left
            if (first.freq > 0)
                pq.offer(first);

            if (second.freq > 0)
                pq.offer(second);
        }

        // If one barcode remains
        if (!pq.isEmpty()) {
            barcodes[index] = pq.poll().element;
        }

        return barcodes;
    }
}