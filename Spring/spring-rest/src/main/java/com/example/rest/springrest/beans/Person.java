package com.example.rest.springrest.beans;

import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person  {

    private @NonNull String name;
    private @NonNull int age;

}
