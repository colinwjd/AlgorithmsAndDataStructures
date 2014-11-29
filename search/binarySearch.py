def binarySearch(arr,goal):
	low = 0
	high = len(arr) - 1
	while low < high:
		middle = (low + high)/2

		if arr[middle] == goal:
			return middle
		elif arr[middle] > goal:
			high = middle -1
		else:
			low = middle + 1
	return -1