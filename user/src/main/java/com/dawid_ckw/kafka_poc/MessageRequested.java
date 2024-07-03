package com.dawid_ckw.kafka_poc;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageRequested {

        private String name;

        public MessageRequested(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MessageRequested [name=" + this.name + "]";
        }

}
