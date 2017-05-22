import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MaxSlidingWindow {

	public static int[] maxWindow(int[] a, int w) {
		Queue<Integer> queue = new LinkedList<>(); // queue should contain only
		int qsize = a.length - w + 1;
		int[] result = new int[qsize];
		int ri = 0;
		for (int i = 0; i < a.length; i++) {
			while (!queue.isEmpty() && queue.peek() < i - w + 1)
				queue.poll();
			while (!queue.isEmpty() && a[queue.peek()] < a[i])
				queue.poll();
			queue.offer(i);
			if (i >= w - 1)
				result[ri++] = a[queue.peek()];
		}
		return result;
	}

	public static int[] slidingWindow(int[] a, int k) {

		Scanner scan = new Scanner(System.in);
		scan.nextInt();
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n - k + 1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}
	
	public static void test(){
		throw new EmptyStackException();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int loop = scan.nextInt();
		int[] a = new int[loop];
		int i = 0;
		while (loop > 0) {
			a[i++] = scan.nextInt();
		}

		int[] c = maxWindow(a, 3);

		for (int j : c) {
			System.out.println(j);
		}
	}

}
