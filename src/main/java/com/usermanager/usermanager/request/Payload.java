package com.usermanager.usermanager.request;

import lombok.Data;

@Data
public class Payload {

    private int userId;
    private String userName;
    private String gender;
    private boolean active;
}
