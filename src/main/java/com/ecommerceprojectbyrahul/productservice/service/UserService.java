package com.ecommerceprojectbyrahul.productservice.service;

import com.ecommerceprojectbyrahul.productservice.dtos.GetInstructorDto;
import com.ecommerceprojectbyrahul.productservice.models.Batch;
import com.ecommerceprojectbyrahul.productservice.models.Instructor;
import com.ecommerceprojectbyrahul.productservice.models.User;
import com.ecommerceprojectbyrahul.productservice.repository.InstructorRepository;
import com.ecommerceprojectbyrahul.productservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final InstructorRepository instructorRepository;

    public UserService(UserRepository userRepository, InstructorRepository instructorRepository) {
        this.userRepository = userRepository;
        this.instructorRepository = instructorRepository;
    }

    public User createUser(String name, String email){

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user;

    }

    public Instructor createInstructor(String name, String email){

        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setEmail(email);
        instructor.setSalary(25000.0);
        instructor.setSkill("Backend");
        instructorRepository.save(instructor);
        return instructor;

    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public List<GetInstructorDto> getInstructorByName(String name) {

        List<Instructor> instructors = instructorRepository.findByName(name);

//        for(Batch batch : instructors.get(0).getBatch()){
//            System.out.println(batch.getName());
//        }

        List<GetInstructorDto> instructorDtos = new ArrayList<>();
        for(Instructor instructor: instructors){
            GetInstructorDto getInstructorDto = new GetInstructorDto();
            getInstructorDto.setId(instructor.getId());
            getInstructorDto.setName(instructor.getName());
            getInstructorDto.setEmail(instructor.getEmail());

            List<String> batchNames = new ArrayList<>();
            List<Long> ids = new ArrayList<>();
            for(Batch batch : instructor.getBatch()){

                batchNames.add(batch.getName());
                ids.add(batch.getId());
            }

            getInstructorDto.setBatchName(batchNames);
            getInstructorDto.setBatchId(ids);

            instructorDtos.add(getInstructorDto);

        }
        return instructorDtos;


//        return instructorRepository.findByName(name);
    }
}
