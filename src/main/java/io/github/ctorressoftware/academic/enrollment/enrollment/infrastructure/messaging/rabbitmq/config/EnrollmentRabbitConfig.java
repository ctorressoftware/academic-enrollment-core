package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.messaging.rabbitmq.config;

import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.messaging.rabbitmq.partition.EnrollmentPartitioner;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.messaging.rabbitmq.partition.HashEnrollmentPartitioner;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class EnrollmentRabbitConfig {
    public static final String EXCHANGE_NAME = "academic.enrollment.exchange";
    public static final String REQUESTED_ROUTING_KEY_PREFIX = "academic.enrollment.requested.p";
    public static final String REQUESTED_QUEUE_PREFIX = "academic.enrollment.requested.p";
    public static final String REQUESTED_QUEUE_SUFFIX = ".queue";
    public static final int PARTITIONS = 16;

    @Bean
    public Declarables enrollmentDeclarables(TopicExchange exchange) {

        List<Declarable> declarables = new ArrayList<>();

        for (int i = 0; i < PARTITIONS; i++) {
            String queueName = REQUESTED_QUEUE_PREFIX + i + REQUESTED_QUEUE_SUFFIX;
            String routingKey = REQUESTED_ROUTING_KEY_PREFIX + i;

            Queue queue = QueueBuilder
                    .durable(queueName)
                    .build();

            Binding binding = BindingBuilder
                    .bind(queue)
                    .to(exchange)
                    .with(routingKey);

            declarables.add(queue);
            declarables.add(binding);
        }

        return new Declarables(declarables);
    }

    @Bean
    public TopicExchange exchange() {
        return ExchangeBuilder
                .topicExchange(EXCHANGE_NAME)
                .durable(true)
                .build();
    }

    @Bean
    public EnrollmentPartitioner enrollmentPartitioner() {
        return new HashEnrollmentPartitioner(PARTITIONS);
    }

    public static String requestedRoutingKey(int partition) {
        validatePartition(partition);
        return REQUESTED_ROUTING_KEY_PREFIX + partition;
    }

    public static String requestedQueueName(int partition) {
        validatePartition(partition);
        return REQUESTED_QUEUE_PREFIX + partition + REQUESTED_QUEUE_SUFFIX;
    }

    private static void validatePartition(int partition) {
        if (partition < 0 || partition >= PARTITIONS) {
            throw new IllegalArgumentException("Invalid partition: " + partition);
        }
    }
}
