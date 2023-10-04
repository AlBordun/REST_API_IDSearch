package first.Kafka;

public class KafkaProducer1 {
//    public static void main(String[] args) {
//        Properties properties = new Properties();
//        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Адрес и порт Kafka брокера
//        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//
//        // Создание Kafka Producer
//        Producer<String, String> producer = new KafkaProducer<>(properties);
//
//        // Отправка сообщения на тему "my-topic"
//        String topic = "my-topic";
//        String key = "key1";
//        String value = "Hello, Kafka!";
//        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
//
//        producer.send(record);
//
//        // Закрытие Kafka Producer
//        producer.close();
//    }
}
