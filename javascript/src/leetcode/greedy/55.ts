const canJump = function (nums: number[]) {
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
}

console.log(canJump([2, 3, 1, 1, 0, 1]))
