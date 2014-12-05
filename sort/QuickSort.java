package org.colin.sort;

/**
 * 快速排序(分治策略)
 * 
 * @author Colin{wjd.colin@gmail.com}
 * @date Dec 5, 2014
 */
public class QuickSort {

	/**
	 * 对输入的整型数组进行快速排序
	 * 
	 * @param arr
	 *            需要排序的整型数组
	 */
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			// 划分子数组
			int index = partition(arr, low, high);
			// 左边子数组排序（递归）
			quickSort(arr, low, index - 1);
			// 右边子数组排序（递归）
			quickSort(arr, index + 1, high);
		}
	}

	/**
	 * 将数组arr[low...high],划分为arr[low...index-1]、arr[index]和arr[index+1... high]，
	 * 使得arr[index+1...high]中的每一个元素都大于等于arr[index]，
	 * 而arr[low...index-1]中的每一个元素都小于arr[index]， 其中计算下标index也是划分的一部分。
	 * 
	 * @param arr
	 *            需要划分的数组
	 * @param low
	 *            需要划分的数组起始下标
	 * @param high
	 *            需要划分的数组末尾下标
	 * @return
	 */
	private static int partition(int[] arr, int low, int high) {

		// 选取数组末尾位置的元素作为主元，围绕它来划分子数组
		int key = arr[high];
		// 待划分数组指针，首先定位到该数组的起始地址之前
		int i = low - 1;

		// 遍历待划分数组到倒数第二个元素，倒数第一个元素已经作为主元
		for (int j = low; j <= high - 1; j++) {
			// 如果该元素小于或等于主元key
			if (arr[j] <= key) {
				// 将待划分数组指针向后移动一位
				i++;
				// 交换arr[i]和arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// 循环终止时，j = high，此时该数组已经被划分成了三个集合：
		// 所有小于等于key的元素的集合，所有大于key的元素的集合，只有一个元素key的集合
		// 此时arr[i+1]是一个大于key的值，即arr[i+1]>arr[high]
		// 所以交换arr[i+1]和arr[high]，使arr[high]即key处于合适的位置
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		// 返回arr[high]=key所在的新位置
		return i + 1;
	}
}
