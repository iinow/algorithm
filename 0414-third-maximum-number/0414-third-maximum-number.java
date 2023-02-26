class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        Set<Integer>set=new LinkedHashSet<>();
        for(int i : nums){
            set.add(i);
        }
        Object arr[]=set.toArray();
        int len=arr.length;
        if(len<3){
            return (int)arr[len-1];
        }
        return (int)arr[len-3];
    }
}