func isIsomorphic(s string, t string) bool {
    ss := strings.Split(s, "")
	ts := strings.Split(t, "")
	for i := range ss {
		sv := strings.Index(s, ss[i])
		tv := strings.Index(t, ts[i])

		if sv != tv {
			return false
		}
	}
	return true
}