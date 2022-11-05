    public class Main {

        public static void main(String args[]) {

            System.out.println(1);
            for(int i=2; i<= 10000; i++){
                isSelfNum(i);
            }
            return;
        }
        static void isSelfNum(int num) {
            for(int i=0; i<num; i++){
                if(getEachNumSum(i) + i == num){
                    return;
                }
            }
            System.out.println(num);
            return;
        }

        static int getEachNumSum(int num){
            if(num > 10){
                return num % 10 + getEachNumSum(num / 10);
            }else if(num == 10){
                return 1;
            }else{
                return num;
            }
        }
    }
