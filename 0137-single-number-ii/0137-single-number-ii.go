func singleNumber(nums []int) int {
    m := make(map[int]int)
	for _, k := range nums {
		_, ok := m[k]
		if ok {
			m[k] = m[k] + 1
		} else {
			m[k] = 1
		}
	}

	for key := range m {
		if m[key] == 1 {
			return key
		}
	}

	return 0
}