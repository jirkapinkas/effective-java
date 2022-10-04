package com.test.effectivejava.pojo;

import lombok.*;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String firstName;

    private String lastName;

    private boolean alive;

}
