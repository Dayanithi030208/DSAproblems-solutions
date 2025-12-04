    import java.util.Arrays;
    public class ArrayOperations{
        static int[] nums=new int[10];
        static int last=0;
        public static void main(String[] args) {
            nums[0]=2;
            nums[1]=8;
            last=1;
            System.out.println(Arrays.toString(nums));
            insertion_at_start(nums, 5);
            System.out.println(Arrays.toString(nums));
            insertion_at_end(nums,4);
            System.out.println(Arrays.toString(nums));
            insertion_at_middle(nums,5,6);
            System.out.println(Arrays.toString(nums));
            deletion_at_start(nums);
            System.out.println(Arrays.toString(nums));
            insertion_at_end(nums,12);
            System.out.println(Arrays.toString(nums));
        }
        private static void insertion_at_start(int[] nums,int value){
            if(last+1==nums.length) System.out.println("can't add");
            else{
                for(int i=last+1;i>0;i--){
                    nums[i]=nums[i-1];
                }
                nums[0]=value;
                last=last+1;
            }
        }
        private static void insertion_at_end(int[] nums,int value){
            if(last+1==nums.length) System.out.println("can't add");
            else{
                nums[last+1]=value;
                last=last+1;
            }
        }
        private static void insertion_at_middle(int[] nums,int pos,int value){
            if(pos==1) insertion_at_start(nums, value);
            else if(pos==last) insertion_at_end(nums, value);
            else{
                pos=pos-1;
                for(int i=last+1;i>pos;i--){
                    nums[i]=nums[i-1];
                }
                nums[pos]=value;
                last=last+1;
            }
        }
        private static void deletion_at_start(int[] nums){
            if(last==0) System.out.println("can't delete");
            else{
                for(int i=0;i<=last;i++){
                    nums[i]=nums[i+1];
                }
            }
            last--;
        }
        // vice versa for other 2 operations 
        // for search we can use linear search nothing but a simple for loop to check all the values till finding the result 
    }
