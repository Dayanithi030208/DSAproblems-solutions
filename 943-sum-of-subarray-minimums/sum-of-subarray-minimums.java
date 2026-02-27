class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] pse = findPSE(arr);
        int[] nse = findNSE(arr);
        long sum = 0;
        int n = arr.length;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            sum = (sum + ((long) left * right % mod * arr[i]) % mod) % mod;
        }
        return (int) sum;
    }

    public int[] findNSE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public int[] findPSE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }
}