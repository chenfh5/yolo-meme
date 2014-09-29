package com.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class qwe {

	private static List<Integer> list = new ArrayList<Integer>();
	private static Set<Integer> set = new HashSet<Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----");
		int[] x1 = { 0,-1,-1 };
		int[] x2 = { 0,0, -1};
		int[] x3 = { 0, -1};
		// ----removeDouble;
		removeDouble(x1);
		removeDouble(x2);
		removeDouble(x3);

		// ----sort list and convert into array;
		int[] s = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i) + "-");
			s[i] = list.get(i);
		}

		System.out.println();

		quick_sort(s, 0, s.length - 1);
		System.out.println();
		for (int i = 0; i < s.length; i++) {
			if (s[i] == s[i + 1] && s[i] == s[i + 2]) {
				System.out.print("result = " + s[i] );
				return;
			}
		}
		System.out.print(-1);

	}

	public static void removeDouble(int[] s) {
		set.clear();
		for (int i = 0; i < s.length; i++) {
			set.add(s[i]);
		}
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}

	}

	public static void quick_sort(int[] s, int L, int R) {
		if (L < R) {
			int i = L;
			int j = R;
			int x = s[L];
			while (i < j) {
				while (i < j && s[j] > x) {
					j--;
				}
				if (i < j) {
					s[i++] = s[j];
				}
				while (i < j && s[i] <= x) {
					i++;
				}
				if (i < j) {
					s[j--] = s[i];
				}
			}
			s[i] = x;
			quick_sort(s, L, i - 1);
			quick_sort(s, i + 1, R);
		}
	}
}
