package com.icn.barleystation.commons;

import com.icn.barleystation.model.errors.ErrorTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ErrorHandler {
    public static List<ErrorTO> retrieveErrors(Exception e) {
        log.error(e.getMessage());
        ErrorTO error = new ErrorTO();
        error.setMessage(e.getLocalizedMessage());
        List<ErrorTO> listError = new ArrayList<>();
        listError.add(error);

        return listError;
    }
}
