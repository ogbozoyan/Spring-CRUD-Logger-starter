package ru.crudger.crudger.crud.controller.string;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.crudger.crudger.crud.dto.AbstractResponseDTO;
import ru.crudger.crudger.crud.dto.specification.request.SearchRequest;
import ru.crudger.crudger.crud.model.entity.AbstractEntityString;


public interface AbstractControllerString<T extends AbstractEntityString> {
    @Operation(summary = "Получить постранично", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ResponseEntity<AbstractResponseDTO> getPage(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size);

    @Operation(summary = "Поиск по фильтрам", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("filter")
    ResponseEntity<AbstractResponseDTO> searchFilter(@RequestBody SearchRequest request);

    @Operation(summary = "Получить по id", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    ResponseEntity<T> getOne(@PathVariable String id);

    @Operation(summary = "Обновить данные", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    ResponseEntity<T> update(@RequestBody T update);

    @Operation(summary = "Создать сущность", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    ResponseEntity<T> create(@RequestBody T create);

    @Operation(summary = "Удалить сущность по id", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    ResponseEntity<T> delete(@PathVariable String id);
}
