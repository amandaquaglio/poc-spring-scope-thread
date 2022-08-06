package org.example.springboot.thread.component;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("thread")
public class Context {

    private String attribute;
}
