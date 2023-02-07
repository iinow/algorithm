func search(nums []int, target int) int {
    for i, v := range nums {
        if v == target {
            return i
        }
    }
    return -1
}