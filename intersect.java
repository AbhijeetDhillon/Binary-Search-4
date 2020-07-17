//Time Complexity: O(log max(n,m)) n and m are the length of the arrays without the sorting otherwise (nlogn + mlogm+ log max(n,m))
//Space Complexity:O(min(m,n))
//LeetCode : Yes

class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        int n1 = nums1.length; int n2 = nums2.length;
        if(n1>n2) return intersect(nums2,nums1);
        int high = n2-1;
        List<Integer> result = new ArrayList<>();   
        Arrays.sort(nums2); Arrays.sort(nums1);
        int idx = 0;
        for(int num : nums1){
            if(binarySearch(num,idx,high,nums2) != -1){
                idx = binarySearch(num,idx,high,nums2) +1;
                result.add(num);
            }
        }
        int[] output = new int[result.size()];
        int j =0;
        for(int num : result){
            output[j] = num;
            j++;
        }
        return output;
        
    }
    
    private int binarySearch(int target, int low, int high, int[] arr){
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                if(mid == low || arr[mid]>arr[mid-1]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if(arr[mid]> target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
        
    }
        
        
    }
