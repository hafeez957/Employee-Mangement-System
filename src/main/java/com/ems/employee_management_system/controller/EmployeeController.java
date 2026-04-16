    package com.ems.employee_management_system.controller;

    import com.ems.employee_management_system.entity.Employee;
    import com.ems.employee_management_system.exceptions.InvalidIdException;
    import com.ems.employee_management_system.exceptions.NameNullException;
    import com.ems.employee_management_system.responseformat.ResponseStructure;
    import com.ems.employee_management_system.service.EmployeeService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.data.domain.Page;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Objects;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/employees")
    @RequiredArgsConstructor
    @CrossOrigin(origins = "http://localhost:5173")
    public class EmployeeController {

        private final EmployeeService employeeService;

        @PostMapping
        public ResponseEntity<ResponseStructure<Employee>> save(@RequestBody Employee employee){
            ResponseStructure<Employee> rs=new ResponseStructure<>();
            if(employee.getName()!=null){
                Employee emp= employeeService.save(employee);
                rs.setStatuscode(HttpStatus.CREATED.value());
                rs.setMessage("Data inserted successfully");
                rs.setData(emp);

                return new ResponseEntity<>(rs,HttpStatus.CREATED);
            }else{
                throw new NameNullException("Name cannot be empty");
            }
        }

        @GetMapping
        public ResponseEntity<Page<Employee>> findAll(@RequestParam int page,@RequestParam int size) {
//            ResponseStructure<List<Employee>> rs = new ResponseStructure<>();

            Page<Employee> emp = employeeService.findAll(page,size);
//            rs.setStatuscode(HttpStatus.OK.value());
//            rs.setMessage("Data found successfully");
//            rs.setData(emp);

            return new ResponseEntity<>(emp, HttpStatus.OK);

        }

        @GetMapping("/{id}")
        public ResponseEntity<ResponseStructure<Employee>> find(@PathVariable Integer id){
            ResponseStructure<Employee> rs = new ResponseStructure<>();

            Optional<Employee> emp = employeeService.findById(id);
            if(emp.isPresent()){
                rs.setStatuscode(HttpStatus.FOUND.value());
                rs.setMessage("Data found successfully");
                rs.setData(emp.get());

                return new ResponseEntity<>(rs, HttpStatus.FOUND);
            }else{
               throw new InvalidIdException("Id not found");
            }
        }

        @PatchMapping
        public ResponseEntity<ResponseStructure<Employee>> update(@RequestBody Employee employee){
            ResponseStructure<Employee> rs = new ResponseStructure<>();

    //        Optional<Employee> id=employeeService.findById(employee.getEmpid());
            Employee emp = employeeService.update(employee);
            if(employee.getEmpid()==null){
                rs.setStatuscode(HttpStatus.CREATED.value());
                rs.setMessage("Data Updated successfully");
                rs.setData(emp);

                return new ResponseEntity<>(rs, HttpStatus.CREATED);
            }else{
                rs.setStatuscode(HttpStatus.CREATED.value());
                rs.setMessage("Data inserted successfully");
                rs.setData(emp);

                return new ResponseEntity<>(rs, HttpStatus.CREATED);
            }
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<ResponseStructure<Employee>> delete(@PathVariable Integer id){
            ResponseStructure<Employee> rs = new ResponseStructure<>();
            System.out.println(id);
            Optional<Employee> emp=employeeService.findById(id);
            String msg= employeeService.delete(id);
            if(emp.isPresent()){
                rs.setStatuscode(HttpStatus.FOUND.value());
                rs.setMessage("Data deleted successfully");
                rs.setData(null);

                return new ResponseEntity<>(rs, HttpStatus.FOUND);
            }else{
               throw new InvalidIdException("Id Not found");
            }
        }


    }
