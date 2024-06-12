package br.com.ghdpreto.ignite_java_crud_curso.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import br.com.ghdpreto.ignite_java_crud_curso.exceptions.dtos.ErroResponseDTO;
import br.com.ghdpreto.ignite_java_crud_curso.exceptions.dtos.ErroValidacaoResponseDTO;
import br.com.ghdpreto.ignite_java_crud_curso.modules.curso.exceptions.CursoNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // #### VALIDACAO DE CAMPOS ####
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoResponseDTO>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<ErroValidacaoResponseDTO> dto = new ArrayList<ErroValidacaoResponseDTO>();

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            dto.add(new ErroValidacaoResponseDTO(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        return ResponseEntity.badRequest().body(dto);

    }

    // #### TRATAMENTO DE CAMPOS DESCONHECIDOS NO DTO ####
    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<List<ErroValidacaoResponseDTO>> handleUnrecognizedPropertyException(
            UnrecognizedPropertyException exception) {

        List<ErroValidacaoResponseDTO> dto = new ArrayList<ErroValidacaoResponseDTO>();

        dto.add(new ErroValidacaoResponseDTO(exception.getPropertyName(), "Propriedade errada ou desconhecida."));

        return ResponseEntity
                .badRequest()
                .body(dto);
    }

    // #### TRATAMENTO DE ERROS ####
    @ExceptionHandler(CursoNotFoundException.class)
    public ResponseEntity<ErroResponseDTO> handleCursoNotFoundException(CursoNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

}
