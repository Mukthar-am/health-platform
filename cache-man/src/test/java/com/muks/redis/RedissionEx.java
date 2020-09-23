package com.muks.redis;



// java -cp <.jar> com.caffeine.fleet.examples.RedissionEx
public class RedissionEx {

    public static void main(String[] args) {
        /**
         * Load configs from external yaml or json file
         * Config config = Config.fromJSON(new File("singleNodeConfig.json"));
         * RedissonClient client = Redisson.create(config);
         */
//        Config config = new Config();
//        config.useSingleServer()
//                .setAddress("redis://127.0.0.1:6379");
//
//        RedissonClient redisson = Redisson.create(config);

        Redis redis = Redis.getInstance();
//
//        RedissonClient redissionClient
//                = Redis
//                .getInstance()
//                .getRedissionClient();

//        RMap<Integer, String> deliveryExec = redissionClient.getMap("DeliveryExec");
//        deliveryExec.put(1, "1,(l1,l2),null");
//        deliveryExec.put(2, "1,(l1,l2),null");
//        deliveryExec.put(3, "1,(l1,l2),(l11, l22)");


//        RMap<Integer, String> processQ = redissionClient.getMap("ProcessQ");
//        processQ.put(1, "1,(l1,l2),null");
//        processQ.put(2, "1,(l1,l2),null");


        redis.getUsers().put(1, "1, muks, mukthar.am@gmail.com");
        redis.getUsers().put(1, "2, ahmed, ahmed@gmail.com");

        redis.getMetrices().put(1, "5.6, 72, null");
        redis.getMetrices().put(2, "5.9, 80, male");

        System.out.println("Users: " + redis.getUsers().get(1));
        System.out.println("Metrices: " + redis.getMetrices().get(2));
    }
}
