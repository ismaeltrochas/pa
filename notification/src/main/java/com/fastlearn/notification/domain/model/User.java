package com.fastlearn.notification.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private String lastName;
    private String email;

}
