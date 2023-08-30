package com.phucnghi.server.model;


import com.phucnghi.server.enumeration.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

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
    private String type;
    private String imgUrl;
    private Status status;


}
