package com.phucnghi.server.model;


import com.phucnghi.server.enumeration.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Server {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    @Column(unique = true)
    @NotEmpty(message = "IP Address Cannot Be Null Or Empty")
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imgUrl;
    private Status status;

    public Server(String ipAddress, String name, String memory, String type, String imgUrl, Status status) {
        this.ipAddress = ipAddress;
        this.name = name;
        this.memory = memory;
        this.type = type;
        this.imgUrl = imgUrl;
        this.status = status;
    }
}
