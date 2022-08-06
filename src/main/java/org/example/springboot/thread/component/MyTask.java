package org.example.springboot.thread.component;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@Setter
public class MyTask implements Runnable {

    @Autowired
    private ApplicationContext applicationContext;

    private String transactionId;

    @Override
    public void run() {
        Context context = applicationContext.getBean(Context.class);
        context.setAttribute(transactionId);
        printText(String.format("Thread = %d TransactionId = %s", Thread.currentThread().getId(), transactionId));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        printText(String.format("Thread = %d Context property  %s",  Thread.currentThread().getId(), context.getAttribute()));

    }

    private void printText(String format) {
        System.out.println("##############################################");
        System.out.println(format);
        System.out.println("##############################################");
    }

}
