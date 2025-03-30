package examples.consumer.service.sender;

import examples.consumer.model.TransactionInfo;

import java.util.function.Consumer;

@FunctionalInterface
public interface TransactionInfoSender extends Consumer<TransactionInfo> {
}
