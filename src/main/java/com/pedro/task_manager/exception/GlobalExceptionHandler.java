package com.pedro.task_manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Essa classe age como um "para-raios" de erros. Se algo der errado no Controller, cai aqui.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Trata os erros de validação (ex: mandou tarefa sem título)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        
        // Pega todos os campos que deram erro e monta um JSON bonitinho
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nomeCampo = ((FieldError) error).getField();
            String mensagemErro = error.getDefaultMessage();
            erros.put(nomeCampo, mensagemErro);
        });
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }

    // Trata erros genéricos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleErroGenerico(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocorreu um erro interno no servidor. Detalhes: " + ex.getMessage());
    }
}
