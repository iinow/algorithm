func longestPalindrome(s string) int {
    arr := strings.Split(s, "")
	m := make(map[string]bool)

	for _, v := range arr {
		_, ok := m[v]
		if ok {
			delete(m, v)
		} else {
			m[v] = true
		}
	}

	c := len(m)
	if c > 0 {
		c -= 1
	}
	return len(s) - c
}