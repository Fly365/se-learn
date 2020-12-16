package cn.learn.architect.interview.design_pattern.worker_thread;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/15
 * DESC:
 */
public class TestClient {
    public static void main(String[] args){
        final PackageChannel channel = new PackageChannel(8);
        channel.startWorker();
        //为流水线添加包裹
        for(int i=0; i<100;i++){
            Package packagereq = new Package();
            packagereq.setAddress("test");
            packagereq.setName("test");
            channel.put(packagereq);
        }
    }
}
