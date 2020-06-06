package multiThreadTest;

public class Test {

    public static void main(String[] args) {
        Aibo a = new Aibo();
        a.start();
        for (;;){
//            synchronized (a){
                if(a.isFlag()){
                    System.out.println("有点东西");
                    break;
                }
//            }
        }
    }

    static class Aibo extends Thread{
        private volatile boolean flag = false;
        public boolean isFlag(){
            return flag;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag = " + flag);
        }
    }
}
