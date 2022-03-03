package tree;

class SegmentTree {
    public static void main(String[] args){
        int[] nums = new int[]{-2,5,3};
        System.out.println(findRangeSum(nums, 0,1));
    }
    public static int findRangeSum(int[] nums, int lower, int upper) {
        if(lower< 0){
            lower =0;
        }
        if(upper> nums.length -1){
            upper= nums.length -1;
        }
        int nextPowOfTwo = nextPowerOf2(nums.length);
        int seg[] = new int[nextPowOfTwo*2 -1];
        populateSeg(nums, seg, 0, nums.length-1, 0 );
        return findSum(seg, 0, nums.length-1,lower,upper, 0);
    }
    public static void populateSeg(int[] nums, int[]seg, int l , int h, int pos){
        if(l == h){
            seg[pos] = nums[l];
            return;
        }
        int m = (l+h)/2;
        populateSeg(nums,seg,l,m,(2*pos)+1);
        populateSeg(nums,seg,m+1,h,(2*pos)+2);
        seg[pos] = seg[2*pos+1] +seg[2*pos+2] ;
    }

    public static int findSum(int[]seg , int l, int h,int fl, int fh, int pos){
        if(fl <= l && fh >= h){
            return seg[pos];
        }
        if(fl > h || fh< l ){
            return 0;
        }
        int m = (l+h)/2;
        int left = findSum(seg, l, m, fl,  fh, (pos*2) +1);
        int right = findSum(seg, m+1, h,  fl,  fh, (pos*2) +2);
        return left+right;
    }
    public static int nextPowerOf2(int num){
        if(num ==0){
            return 1;
        }
        if(num > 0 && (num & (num-1)) == 0){
            return num;
        }
        while((num & (num-1)) > 0){
            num = num & (num-1);
        }
        return num<<1;
    }
}
