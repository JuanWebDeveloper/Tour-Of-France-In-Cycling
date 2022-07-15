package com.cycling.api.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cyclists")
public class Cyclist {
    @Id
    private String id_cyclist;
    private String id_team;
    private String name_cyclist;
    private String number_cyclist;
    private String country_cyclist;
}
