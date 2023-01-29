func runningSum(nums []int) []int {
    ar := make([]int, len(nums))
    sum := 0
    for i, v := range nums {
        sum += v
        ar[i] = sum
    }
    
    return ar
}