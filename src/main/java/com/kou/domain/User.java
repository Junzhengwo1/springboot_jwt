package com.kou.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author JIAJUN KOU
 */
@Data
@Accessors(chain = true)
public class User {

    private Integer id;
    private String username;
    private String password;

}
