package com.yishion.algorithm.A.d2;

import com.yishion.algorithm.Common;

public class Code06_QuickSort extends Common {

	public static void main(String[] args) {
		int[] arr = generationArray(6, 0, 200);
		printArr(arr);
		quickSort(arr, 0, arr.length - 1);
		printArr(arr);
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1);// ��С����
			quickSort(arr, p[1] + 1, r);// �Ŵ�����
		}

	}

	// partition������Ĺ���
	private static int[] partition(int[] arr, int l, int r) {

		int less = l - 1;// С�����ı߽�
		int more = r;// �������ı߽�
		int p = arr[r];// �����һ�������ֵ��Ϊ����ֵ
		int index = l;// ��ǰ���±�

		while (index < more) {
			if (arr[index] > p) {// �����ǰֵ���ڻ���ֵp
				// ��ǰ���ʹ�����ǰһ��������,more����һλ,indexλ�ò���
				swap(arr, index, --more);
			} else if (arr[index] == p) {// �����ǰֵ���ڻ���ֵp
				// ��ǰ��ֱ������һ��
				index++;
			} else {// �����ǰֵС�ڻ���ֵp
				// ��ǰ����С����ǰһ��λ�ý���,less����һλ,index�����ƶ�һλ
				swap(arr, index++, ++less);
			}
		}
		// ���ʱ��������һλû�д��������Ķ������ˣ����һλ�ǻ���ֵ�ʹ�������һ�����������ǵ�����
		swap(arr, more, r);
		// ���صĵ�����[]
		return new int[] { less + 1, more };
	}

}
