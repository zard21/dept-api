package kr.codelab.demo.service;

import kr.codelab.demo.exception.DataException;
import kr.codelab.demo.model.Dept;
import kr.codelab.demo.model.DeptGroup;
import kr.codelab.demo.repository.DeptGroupRepository;
import kr.codelab.demo.repository.DeptRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class DeptService {

    private DeptGroupRepository deptGroupRepository;
    private DeptRepository deptRepository;

//    public DeptService(DeptGroupRepository deptGroupRepository) {
//        this.deptGroupRepository = deptGroupRepository;
//    }

    public List<DeptGroup> getAllDeptGroups() {
        return deptGroupRepository.findAll();
    }

    public DeptGroup getDeptGroup(Long id) {
        DeptGroup deptGroup = deptGroupRepository.findById(id).orElse(null);

        for (int i = 0; i < 100; i++) {
            System.out.println("DeptGroup No." + i);
        }

        if (deptGroup == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DeptGroup Not Found");
        } else {
            return deptGroup;
        }
    }

    public DeptGroup getDeptGroup(String name) {
        DeptGroup deptGroup = deptGroupRepository.findByName(name).orElse(null);

        if (deptGroup == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DeptGroup Not Found");
        } else {
            return deptGroup;
        }
    }

    public DeptGroup createDeptGroup(DeptGroup deptGroup) {
        deptGroup.setCurrentTime();

        return deptGroupRepository.save(deptGroup);
    }

    public DeptGroup updateDeptGroup(Long id, DeptGroup deptGroup) {
        DeptGroup savedDeptGroup = deptGroupRepository.findById(id).orElse(null);

        if (savedDeptGroup == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DeptGroup Not Found");
        } else {
            savedDeptGroup.update(deptGroup);
            return deptGroupRepository.save(savedDeptGroup);
        }
    }

    public void deleteDeptGroup(Long id) {
        if (deptGroupRepository.findById(id).isPresent()) {
            deptGroupRepository.deleteById(id);
        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DeptGroup Not Found");
            throw new DataException("9999", "Error Occurred.");
        }
    }

    public List<Dept> getAllDepts() {
        return deptRepository.findAll();
    }

    public Dept createDept(Dept dept) {
        dept.setCurrentTime();

        return deptRepository.save(dept);
    }

    public Dept updateDept(Long id, Dept dept) {
        Dept savedDept = deptRepository.findById(id).orElse(null);

        if (savedDept == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dept Not Found");
        } else {
            savedDept.update(dept);
            return deptRepository.save(savedDept);
        }
    }

    public void deleteDept(Long id) {
        if (deptRepository.findById(id).isPresent()) {
            deptRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dept Not Found");
        }
    }
}
