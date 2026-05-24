package io.github.ctorressoftware.academic.enrollment.role.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.role.application.port.in.create.CreateRoleCommand;
import io.github.ctorressoftware.academic.enrollment.role.application.port.in.create.CreateRoleResult;
import io.github.ctorressoftware.academic.enrollment.role.application.port.in.create.CreateRoleUseCase;
import io.github.ctorressoftware.academic.enrollment.role.application.port.in.findall.FindAllRolesResult;
import io.github.ctorressoftware.academic.enrollment.role.application.port.in.findall.FindAllRolesUseCase;
import io.github.ctorressoftware.academic.enrollment.role.application.port.in.findbycode.FindRoleByCodeResult;
import io.github.ctorressoftware.academic.enrollment.role.application.port.in.findbycode.FindRoleByCodeUseCase;
import io.github.ctorressoftware.academic.enrollment.role.infrastructure.web.request.CreateRoleRequest;
import io.github.ctorressoftware.academic.enrollment.role.infrastructure.web.response.CreateRoleResponse;
import io.github.ctorressoftware.academic.enrollment.role.infrastructure.web.response.FindAllRolesResponse;
import io.github.ctorressoftware.academic.enrollment.role.infrastructure.web.response.FindRoleByCodeResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    private final CreateRoleUseCase createRoleUseCase;
    private final FindRoleByCodeUseCase findRoleByCodeUseCase;
    private final FindAllRolesUseCase findAllRolesUseCase;

    public RoleController(
            CreateRoleUseCase createRoleUseCase,
            FindRoleByCodeUseCase findRoleByCodeUseCase,
            FindAllRolesUseCase findAllRolesUseCase) {
        this.createRoleUseCase = createRoleUseCase;
        this.findRoleByCodeUseCase = findRoleByCodeUseCase;
        this.findAllRolesUseCase = findAllRolesUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CreateRoleResponse>> create(
            @RequestBody @Valid CreateRoleRequest request) {

        CreateRoleCommand command = new CreateRoleCommand(
                request.id(),
                request.code(),
                request.description()
        );

        CreateRoleResult result = createRoleUseCase.create(command);

        return ResponseEntity.ok(ApiResponse.success(
                new CreateRoleResponse(result.role())
        ));
    }

    @GetMapping(value = "/findByCode/{code}")
    public ResponseEntity<ApiResponse<FindRoleByCodeResponse>> findByCode(
            @PathVariable String code) {

        FindRoleByCodeResult result = findRoleByCodeUseCase.findByCode(code);

        return ResponseEntity.ok(ApiResponse.success(
                new FindRoleByCodeResponse(result.role())
        ));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<ApiResponse<FindAllRolesResponse>> findAll() {

        FindAllRolesResult result = findAllRolesUseCase.findAll();

        return ResponseEntity.ok(ApiResponse.success(new FindAllRolesResponse(
                result.roles()
        )));
    }
}
