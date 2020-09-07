class Simple{
    public static void main(String[] args) {
        int num = 1000;
        int count = 0;
        while(num>0){
            num/=2;
            count++;
        }
        System.out.println("It takes " + count + " times for 1000 to be <= 0");
        num = 1000000;
        while(num>0){
            num/=2;
            count++;
        }
        System.out.println("It takes " + count + " times for 1,000,000 to be <= 0");
    }
}