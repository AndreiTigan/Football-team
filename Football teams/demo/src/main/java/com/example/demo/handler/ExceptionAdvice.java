package com.example.demo.handler;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice

public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @RequestBody
    @ExceptionHandler(TeamNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody String teamNotFoundHandler(TeamNotFoundException t) {
        return t.getMessage();
    }

    @RequestBody
    @ExceptionHandler(IdTeamAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody String idAlreadyExists(IdTeamAlreadyExists i) {
        return i.getMessage();
    }

    @RequestBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ArenaNotFoundException.class)
    public @ResponseBody String arenaNotFoundHandler(ArenaNotFoundException arenaNotFoundException){return arenaNotFoundException.getMessage();}

    @RequestBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ArenaIdAlreadyExistsExceptions.class)
    public @ResponseBody String arenaIdAlreadyExists(ArenaIdAlreadyExistsExceptions arenaIdAlreadyExistsExceptions){return arenaIdAlreadyExistsExceptions.getMessage();}

    @RequestBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PlayerNotFoundException.class)
    public @ResponseBody String playerNotFoundHandler(PlayerNotFoundException p) { return p.getMessage(); }

    @RequestBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IdPlayerAlreadyExist.class)
    public @ResponseBody String idAlreadyExist(IdPlayerAlreadyExist i) {
        return i.getMessage();
    }



}
