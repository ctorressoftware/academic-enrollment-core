package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.messaging.rabbitmq.publisher;

import io.github.ctorressoftware.academic.enrollment.enrollment.application.port.out.EnrollmentRequestedPublisher;
import io.github.ctorressoftware.academic.enrollment.enrollment.domain.event.EnrollmentRequestedEvent;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.messaging.rabbitmq.config.EnrollmentRabbitConfig;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.messaging.rabbitmq.message.EnrollmentRequestedMessageMapper;
import io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.messaging.rabbitmq.partition.EnrollmentPartitioner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitEnrollmentRequestedPublisher implements EnrollmentRequestedPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final EnrollmentPartitioner partitioner;

    public RabbitEnrollmentRequestedPublisher(
            RabbitTemplate rabbitTemplate,
            EnrollmentPartitioner partitioner) {
        this.rabbitTemplate = rabbitTemplate;
        this.partitioner = partitioner;
    }

    @Override
    public void publish(EnrollmentRequestedEvent event) {

        int partition = partitioner.partition(event.getCourseOfferingId());

        rabbitTemplate.convertAndSend(
                EnrollmentRabbitConfig.EXCHANGE_NAME,
                EnrollmentRabbitConfig.requestedRoutingKey(partition),
                EnrollmentRequestedMessageMapper.toMessage(event)
        );
    }
}
