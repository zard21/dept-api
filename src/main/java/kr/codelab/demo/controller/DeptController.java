package kr.codelab.demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.codelab.demo.model.Dept;
import kr.codelab.demo.model.DeptGroup;
import kr.codelab.demo.service.DeptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeptController {

    private DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping("/dept-groups")
    @ApiOperation(value = "전체 부서그룹 조회", notes = "모든 부서그룹을 조회한다.")
    public ResponseEntity<?> getAllDeptGroups() {
        List<DeptGroup> deptGroups = deptService.getAllDeptGroups();

        return ResponseEntity.ok(deptGroups);
    }

    @GetMapping("/dept-groups/{id}")
    @ApiOperation(value = "부서그룹 검색", notes = "ID로 부서그룹을 조회한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "부서그룹 ID", paramType = "path", dataType = "Long")
    })
    public ResponseEntity<?> getDeptGroup(@PathVariable Long id) {
        DeptGroup deptGroup = deptService.getDeptGroup(id);

        return ResponseEntity.ok(deptGroup);
    }

    @GetMapping("/dept-groups/name")
    public ResponseEntity<?> getDeptGroup(@RequestParam String name) {
        DeptGroup deptGroup = deptService.getDeptGroup(name);

        return ResponseEntity.ok(deptGroup);
    }

    @PostMapping("/dept-groups")
    public ResponseEntity<?> createDeptGroup(@RequestBody DeptGroup deptGroup) {
        return new ResponseEntity<>(deptService.createDeptGroup(deptGroup), HttpStatus.CREATED);
    }

    @PutMapping("/dept-groups/{id}")
    public ResponseEntity<?> updateDeptGroup(@PathVariable Long id, @RequestBody DeptGroup deptGroup) {
        return new ResponseEntity<>(deptService.updateDeptGroup(id, deptGroup), HttpStatus.OK);
    }

    @DeleteMapping("/dept-groups/{id}")
    public ResponseEntity<?> deleteDeptGroup(@PathVariable Long id) {
        deptService.deleteDeptGroup(id);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @GetMapping("/depts")
    public ResponseEntity<?> getAllDepts() {
        List<Dept> depts = deptService.getAllDepts();

        return ResponseEntity.ok(depts);
    }

    @PostMapping("/depts")
    public ResponseEntity<?> createDept(@RequestBody Dept dept) {
        return new ResponseEntity<>(deptService.createDept(dept), HttpStatus.CREATED);
    }

    @PutMapping("/depts/{id}")
    public ResponseEntity<?> updateDept(@PathVariable Long id, @RequestBody Dept dept) {
        return new ResponseEntity<>(deptService.updateDept(id, dept), HttpStatus.OK);
    }

    @DeleteMapping("/depts/{id}")
    public ResponseEntity<?> deleteDept(@PathVariable Long id) {
        deptService.deleteDept(id);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
