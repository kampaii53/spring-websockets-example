package ru.kampaii.websockets.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String content;

}
