package com.scheduler.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailDto {

    private String to;
    @Builder.Default
    private String subject = "This is a scheduled email.";
    @Builder.Default
    private String body = "This is a scheduled email.";
    private String from;
}