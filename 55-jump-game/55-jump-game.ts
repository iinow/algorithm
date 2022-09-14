function canJump(nums: number[]): boolean {
  let canReach = 0
  for (let i = 0; i < nums.length; i++) {
    if (canReach < i) {
      return false
    }

    canReach = Math.max(canReach, i + nums[i])
    if (canReach >= nums.length - 1) {
      return true
    }
  }
};