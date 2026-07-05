package com.icn.barleystation.model;

import com.icn.barleystation.model.errors.ErrorTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long idUser;
    private String name;
    private String profileImage;
    private String mail;
    private String phone;
    private String address;
    @Nullable
    private Boolean status;
    private Date createdDate;
    private List<ErrorTO> errors;
}
